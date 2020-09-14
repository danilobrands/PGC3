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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author danil
 */
public class GameLoginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Tentativa de login realizada: GameLoginServlet - Método POST");
        
        //System.out.println("Recebido: "+request.getParameter("txtEmail"));
        //System.out.println("Recebido: "+request.getParameter("txtSenha"));
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        
        Usuario incompleto = new Usuario();
        incompleto.setEmail(email);
        incompleto.setSenha(senha);
        
        DataSource ds;
        
        String resposta = "";
        
        try {
            ds = new DataSource();
            UsuarioDAO userDAO = new UsuarioDAO(ds);
            List<Object> res = userDAO.read(incompleto);
            
            if(res != null && res.size()>0){
                incompleto = (Usuario) res.get(0);
                System.out.println("Login realizado: LoginServlet - Método POST");
                request.getSession().setAttribute("Usuario", res.get(0));
                resposta += "1\n";
                resposta += "Conectado;";
                resposta += (incompleto.getId()+ ";");
                resposta += (incompleto.getNome() + ";");
                resposta += (incompleto.getSenha()+ ";");
            }
            else{
                resposta += "2\n";
                resposta += "Usuario / Senha Invalidos";
                System.out.println("Usuário ou senha inválidos: LoginServlet - Método POST");
            }
            ds.getConnection().close();
             
        } catch (Exception ex) {
            resposta += "Erro ao recuperar\n";
            resposta += ex;
        } 
        
        //RequestDispatcher dispacher  = getServletContext().getRequestDispatcher(pagina);
        //dispacher.forward(request, response);
        
        response.getWriter().write(resposta);
        
        
    }
        
    

}
