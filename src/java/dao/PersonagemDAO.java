/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.io.IOException;
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
            System.out.println("Criado novo Personagem");
            String SQL = "INSERT INTO tb_personagem VALUES (null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pe.getNick());
            stm.setInt(2, pe.getForca());
            stm.setInt(3, pe.getAgilidade());
            stm.setInt(4, pe.getUsuario().getId());
            stm.setString(5, pe.getSkin());
            stm.setString(5, pe.getSkin());
            stm.setInt(6, pe.getResistencia());
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
        try{
            int codigo = (int) o;
            String SQL = "DELETE FROM tb_personagem WHERE idPersonagem = ?;";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, codigo);
            int res = stm.executeUpdate();
            if(res == 0){
                throw new RuntimeException("Não foi possivel deletar o personagem");
            }else{
                System.out.println("Personagem deletado!");
            }
            
        }catch(SQLException ex){
            System.out.println("Erro ao dletar personagem - "+ ex.getMessage());
        }
    }

    @Override
    public List<Object> read(Object o) {
        try {
            String SQL = "SELECT * FROM tb_personagem WHERE idUsuario = ?";
            System.out.print(o);
            Integer idUser;
            String o_str = (String) o;
            idUser = Integer.parseInt(o_str);
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1, idUser);
            ResultSet rs = stm.executeQuery();
            ArrayList<Object> list = new ArrayList<>();
            //System.out.println("Oieeeeeeee");
            while(rs.next()){
                System.out.println(idUser);
                Personagem pe = new Personagem();
                pe.setId(rs.getInt("idPersonagem"));
                pe.setNick(rs.getString("nick")); 
                pe.setAgilidade(rs.getInt("agilidade"));
                pe.setForca(rs.getInt("forca"));
                pe.setSkin(rs.getString("skin"));
                pe.setResistencia(rs.getInt("resistencia"));
                //Vai ser necessário puxar a skin do banco
                //DataSource dataSource = new DataSource();
                //SkinDAO skinDAO = new SkinDAO(dataSource);
                //pe.setSkin(skinDAO.readIdSkin(rs.getInt("idSkin")));
                list.add(pe);
            }
            rs.close();
            stm.close();
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar personagens - PersonagemDAO - " + ex);
        }
        return null;    
    }
    
}
