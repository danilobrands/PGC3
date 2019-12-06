/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;
import model.Skin;
import model.Usuario;

/**
 *
 * @author danil
 */
public class UsuarioDAO implements GenericDAO{
    
    private DataSource dataSoucer;
    
    public UsuarioDAO(DataSource dataSoucer){
        this.dataSoucer = dataSoucer;
    }
    
    public void create(Object o){
        try {
            if(o instanceof Usuario){
                Usuario usuario = (Usuario)o;
                String SQL = "INSERT INTO tb_usuario VALUES (null, ?, ?, ?)";
                PreparedStatement stm = dataSoucer.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEmail());
                stm.setString(3, usuario.getSenha());
                int res = stm.executeUpdate();
                if(res != 0){
                    ResultSet rs = stm.getGeneratedKeys();
                    if(rs.next()){
                        usuario.setId(rs.getInt(1));
                    }
                    rs.close();
                }
                stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object");
            }
        } catch (Exception e) {
            
        }
        
        
        
    }
    public List<Object> read(Object o){
        
        try {
            if(o instanceof Usuario){
                Usuario incompleto = (Usuario)o;
                String SQL = "SELECT * FROM tb_usuario WHERE email = ? AND  senha = ?";
                PreparedStatement stm = dataSoucer.getConnection().prepareStatement(SQL);
                stm.setString(1, incompleto.getEmail());
                stm.setString(2, incompleto.getSenha());
                ResultSet rs = stm.executeQuery();
                
                ArrayList<Object> result = new ArrayList<>();
                if(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    result.add(usuario);
                }
                stm.close();
                rs.close();
                return result;
            }
            else{
                throw new RuntimeException("Invalid Object");
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar usuario - "+ex.getMessage());
        }
        return null;
        
        /*
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Danilo");
        usuario.setEmail("danilobrands@hotmail.com");
        usuario.setSenha("1234");
        
        ArrayList<Personagem> personagens = new ArrayList<>();
        Personagem personagem1 = new Personagem();
        personagem1.setId(1);
        personagem1.setNick("danlkill");
        ArrayList<Skin> skinP1 = new ArrayList<>();
        Skin s1 = new Skin();
        s1.setId(1);
        s1.setImage("url");
        skinP1.add(s1);
        personagem1.setSkins(skinP1);
        personagens.add(personagem1);
        usuario.setPersonagens(personagens);
        
        ArrayList<Object> resultado = new ArrayList<>();
        resultado.add(usuario);
        return resultado;
        */
    }
    public void update(Object o){
        
    }
    public void delete(Object o){
        
    }
}
