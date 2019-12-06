/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataSource;
import dao.PersonagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personagem;
import model.Usuario;

/**
 *
 * @author danil
 */
public class PersonagensServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pagindaDestino = "/index.html";
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            if (usuario != null) {
                //Ta logado
                if (usuario.getPersonagens() == null) {
                    //Não tem personagens
                    
                    

                    //Recupero do banco
                    DataSource dataSource = new DataSource();
                    PersonagemDAO peDAO = new PersonagemDAO(dataSource);
                    List<Object> lista = peDAO.read(usuario.getId());
                    dataSource.getConnection().close();

                    //passar por cada elemento que veio do banco e vou referências o usuário
                    if (lista != null) {
                        ArrayList<Personagem> meusPersonagens = new ArrayList<>();
                        for (Object o : lista) {
                            Personagem novoPe = (Personagem) o;
                            novoPe.setUsuario(usuario);
                            meusPersonagens.add(novoPe);
                            
                        }
                        usuario.setPersonagens(meusPersonagens);
                    }

                }
                request.getSession().setAttribute("Usuario", usuario);
                pagindaDestino = "/mycharacters.jsp";
            }

        } catch (Exception ex) {
            System.out.println("Erro ao recuperar personagens - " + ex.getMessage());
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagindaDestino);
        dispatcher.forward(request, response);

    }

}
