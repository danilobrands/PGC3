/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DataSource;
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
import model.Skin;

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
                String nome = request.getParameter("txtNome");
                
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
                
                Skin skin = new Skin();
                skin.setNome(nome);
                skin.setImage("skins/"+request.getPart("fileIMG").getSubmittedFileName());
                
                DataSource dataSource = new DataSource();
                SkinDAO skinDao = new SkinDAO(dataSource);
                skinDao.create(skin);
                dataSource.getConnection().close();
                
                paginaDestino = "/myaccount.jsp";
                
                
            } catch (Exception ex) {
                System.out.println("Oiee**************************************");
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
