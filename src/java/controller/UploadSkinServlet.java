/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataSource;
import dao.PersonagemDAO;
import dao.SkinDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Personagem;
import model.Skin;
import model.Usuario;

/**
 *
 * @author danil
 */
@WebServlet(name = "UploadSkinServlet", urlPatterns = {"/uploadskin"})
public class UploadSkinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/error.jsp";
        
        if(request.getSession().getAttribute("Usuario") != null){
            
            try {
                Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
                String nome = request.getParameter("txtNome");
                String forca = request.getParameter("txtForca");
                String agilidade = request.getParameter("txtAgilidade");
                String resistencia = request.getParameter("txtResistencia");
                
                System.out.println(nome);
                System.out.println(forca);
                System.out.println(agilidade);
                System.out.println(resistencia);
                
                InputStream arqOriginal = request.getPart("fileIMG").getInputStream();
                String nomeArquivoOriginal = request.getPart("fileIMG").getSubmittedFileName();
                String nomeArquivo = getServletContext().getRealPath("/")+"\\skins\\"+request.getPart("fileIMG").getSubmittedFileName();
                
                //nomeArquivo = "C:\\Users\\danil\\Documents\\NetBeansProjects\\PGCII\\web\\skins" + "\\oie.jpg";
                
                System.out.println("Nome do arq: " + nomeArquivo);
                //System.out.println("C:\\Users\\danil\\Documents\\NetBeansProjects\\PGCII\\web\\skins\" + \"\\oie.jpg");
                
                FileOutputStream arquivoIMG = new FileOutputStream(nomeArquivo);
                
                byte b[] = new byte[1024];
                
                while(arqOriginal.available()>0){
                    arqOriginal.read(b);
                    
                    arquivoIMG.write(b);
                    //System.out.println("gravando");
                    //System.out.println(Arrays.toString(b));
                }
                arqOriginal.close();
                arquivoIMG.close();
                
                Personagem personagem = new Personagem();
                personagem.setNick(nome);
                personagem.setForca(Integer.parseInt(forca));
                personagem.setAgilidade(Integer.parseInt(agilidade));
                personagem.setResistencia(Integer.parseInt(resistencia));
                personagem.setUsuario(usuario);
                
                personagem.setSkin("skins/"+request.getPart("fileIMG").getSubmittedFileName());
                System.out.println(request.getPart("fileIMG").getName());
                
                
                DataSource dataSource = new DataSource();
                PersonagemDAO personagemDao = new PersonagemDAO(dataSource);
                personagemDao.create(personagem);
                dataSource.getConnection().close();
              
                
                paginaDestino = "/myaccount.jsp";
                
                
            } catch (Exception ex) {
                System.out.println("Oiee falhou");
                System.out.println(ex);
                request.setAttribute("erroSTR", "Erro: Upload falhou!");
            }
            
            
        }
        else{
            request.setAttribute("erroSTR", "Erro: usuário não conectado");
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
        
    }


}
