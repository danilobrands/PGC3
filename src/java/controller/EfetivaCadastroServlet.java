/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataSource;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author danil
 */
public class EfetivaCadastroServlet extends HttpServlet {


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
        //receber dados do formulário
        //cirar um objeto usuario com estes dados (que ainda não tem id)
        //isntanciar o datasource e o dao

        String pagina = "/myaccount.jsp";
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        
        Usuario usuario = new Usuario();
        
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        
        //gravar
        
        DataSource datasource = new DataSource();
        UsuarioDAO usuarioDAO = new UsuarioDAO(datasource);
        usuarioDAO.create(usuario);
        try {
            datasource.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão - " + ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao criar novo usuario");
            pagina = "/error.jsp";
        }
        
        if(usuario.getId() != 0){
            request.getSession().setAttribute("Usuario", usuario);
        }
        
        //dependendo resultado retornar uma página
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
        
        
        
        
    }

    

}
