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
        
        System.out.println("\nEntrou no PersonagensServlet\n");
        String pagindaDestino = "/index.html";
        //System.out.printf("\nOi2");
        try {
            //System.out.printf("\nOi3");
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            //System.out.printf("usuariook");
            if (usuario != null) {
                //Ta logado
                //if (usuario.getPersonagens() == null) {
                    //Não tem personagens
                    //Recupero do banco
                    DataSource dataSource = new DataSource();
                    PersonagemDAO peDAO = new PersonagemDAO(dataSource);
                    Integer userID = usuario.getId();
                    List<Object> lista = peDAO.read(userID.toString());
                    
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
                //}
                System.out.println("\nPersonagens Recuperados com Sucesso\n");
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
