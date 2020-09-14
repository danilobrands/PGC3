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
public class ExcluirPersonagemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        
        System.out.println("Tentativa deletar personagens: ExcluirPersonagemServlet - Método POST");
        System.out.println("Excluindo Personagem de ID = " + id);

         
        try {
            //Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            if (id != null) {
                //System.out.println("Personagens do usuário: " + id);
                DataSource dataSource = new DataSource();
                PersonagemDAO peDAO = new PersonagemDAO(dataSource);
                peDAO.delete(Integer.parseInt(id));
                dataSource.getConnection().close();
            }
            System.out.println("Personagem Excluído");

        } catch (Exception ex) {
            System.out.println("Erro ao recuperar personagens - GamePersonagensServlet - " + ex.getMessage());
        }

    }
}
