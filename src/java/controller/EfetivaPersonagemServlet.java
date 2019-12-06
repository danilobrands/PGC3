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
public class EfetivaPersonagemServlet extends HttpServlet {

   

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String paginaDestino = "/index.html";
        
        try {
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            
            if(usuario != null){
                String nick = request.getParameter("txtNick");
                String forca = request.getParameter("txtForca");
                String agilidade = request.getParameter("txtAgilidade");
                
                Personagem p = new Personagem();
                p.setNick(nick);
                p.setForca(Integer.parseInt(forca));
                p.setAgilidade(Integer.parseInt(agilidade));
                p.setUsuario(usuario);
                
                DataSource dataSource = new DataSource();
                PersonagemDAO peDAO = new PersonagemDAO(dataSource);
                peDAO.create(p);
                
                if(usuario.getPersonagens() == null){
                    usuario.setPersonagens(new ArrayList<>());
                }
                usuario.getPersonagens().add(p);
                request.getSession().setAttribute("Usuario", usuario);
                paginaDestino = "/mycharacters.jsp";
                
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar personagem - " + ex.getMessage());
            request.setAttribute("erroSTR", "Erro ao criar personagem");
            paginaDestino = "/error.jsp";
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
        
    }


}
