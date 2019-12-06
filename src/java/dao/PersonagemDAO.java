/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;

/**
 *
 * @author danil
 */
public class PersonagemDAO implements GenericDAO{
    
    private DataSource dataSource;
    
    public PersonagemDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        
        try {
            Personagem pe = (Personagem)o;
            String SQL = "INSERT INTO tb_personagem VALUES (null, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pe.getNick());
            stm.setInt(2, pe.getForca());
            stm.setInt(3, pe.getAgilidade());
            stm.setInt(4, pe.getUsuario().getId());
            int res = stm.executeUpdate();
            if(res == 0){
                throw new RuntimeException("Não foi possivel criar personagem");
                
            }
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                pe.setId(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar personagem - " + ex.getMessage());
        }
    
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read(Object o) {
        try {
            String SQL = "SELECT * FROM tb_personagem WHERE idUsuario = ?";
            Integer idUser = (Integer)o;
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1, idUser);
            
            
            ResultSet rs = stm.executeQuery();
            ArrayList<Object> list = new ArrayList<>();
            while(rs.next()){
                
                System.out.println(idUser);
                Personagem pe = new Personagem();
                pe.setId(rs.getInt("idPersonagem"));
                pe.setNick(rs.getString("nick")); 
                pe.setAgilidade(rs.getInt("agilidade"));
                pe.setForca(rs.getInt("forca"));
                list.add(pe);
            }
            rs.close();
            stm.close();
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar personagens - " + ex);
        }
        return null;    
    }
    
}
