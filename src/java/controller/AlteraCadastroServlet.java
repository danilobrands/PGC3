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
public class AlteraCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        
        System.out.println("Alterando cadastro do usuario: " + usuario.getId());

        String pagina = "/myaccount.jsp";
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        
        
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        
        //gravar
        
        DataSource datasource = new DataSource();
        UsuarioDAO usuarioDAO = new UsuarioDAO(datasource);
        usuarioDAO.update(usuario);
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
