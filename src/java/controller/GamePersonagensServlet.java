/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataSource;
import dao.PersonagemDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personagem;

/**
 *
 * @author danil
 */
public class GamePersonagensServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        System.out.println("Tentativa recuperar personagens: GamePersonagensServlet - Método POST");
        System.out.println("User Id: " + id);
        
        String resposta = "";
        
        try {
            //Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            if (id != null) {
                System.out.println("Personagens do usuário: "+ id);
                resposta += "1;";
                //Ta logado
                //if (usuario.getPersonagens() == null) {
                    //Não tem personagens
                    //Recupero do banco
                    DataSource dataSource = new DataSource();
                    PersonagemDAO peDAO = new PersonagemDAO(dataSource);
                    //System.out.println("Oieeeeeeee 1\n");
                    List<Object> lista = peDAO.read(id);
                    //System.out.println("Oieeeeeeee 2\n");
                    dataSource.getConnection().close();
                    
                    
                    for(Object personagem:lista){
                        Personagem temp = (Personagem) personagem;
                        resposta += temp.getNick();
                        resposta += ";";
                        resposta += temp.getSkin();
                        resposta += ";";
                        resposta += temp.getForca();
                        resposta += ";";
                        resposta += temp.getAgilidade();
                        resposta += ";";
                        resposta += temp.getResistencia();
                        resposta += ";";
                    }
                    
            }

        } catch (Exception ex) {
            System.out.println("Erro ao recuperar personagens - GamePersonagensServlet - " + ex.getMessage());
        }

        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagindaDestino);
        //dispatcher.forward(request, response);
        
        response.getWriter().write(resposta);
        
    }

}
