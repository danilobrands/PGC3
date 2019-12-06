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
import java.util.List;
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
public class LoginServlet extends HttpServlet {



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
        //System.out.println("Recebido: "+request.getParameter("txtEmail"));
        //System.out.println("Recebido: "+request.getParameter("txtSenha"));
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        
        Usuario incompleto = new Usuario();
        incompleto.setEmail(email);
        incompleto.setSenha(senha);
        
        String pagina = "/error.jsp";
        
        DataSource ds;
        
        try {
            ds = new DataSource();
            UsuarioDAO userDAO = new UsuarioDAO(ds);
            List<Object> res = userDAO.read(incompleto);
            
            if(res != null && res.size()>0){
                pagina = "/myaccount.jsp";
                request.getSession().setAttribute("Usuario", res.get(0));
            }
            else{
                request.setAttribute("erroSTR", "Usuario / Senha Invalidos");
            }
            ds.getConnection().close();
             
        } catch (Exception ex) {
            request.setAttribute("erroSTR", "Erro ao recuperar");
        } /*finally{
            if(ds != null){
                ds.getConnection().close();
            }
        }*/
        
        /*
        
        //Simular acesso ao banco
        List<Object> res;
        //UsuarioDAO userDAO = new UsuarioDAO();
        //res = userDAO.read(null);
        
        if(email.equals("dan@a.c") && senha.equals("1234")){
            
            
            request.getSession().setAttribute("Usuario", res.get(0));
            
            
            pagina = "/myaccount.jsp";
        }
        else{
            request.setAttribute("erroSTR", "E-mail / Senha não encontrados");
            pagina = "/error.jsp";
        }
        */
        
        
        RequestDispatcher dispacher  = getServletContext().getRequestDispatcher(pagina);
        dispacher.forward(request, response);
        
    }

}
