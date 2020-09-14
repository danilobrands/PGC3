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
public class SkinDAO implements GenericDAO {

    private DataSource dataSource;

    public SkinDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {

        try {

            if (o instanceof Skin) {

            }

            Skin skin = (Skin) o;
            String SQL = "INSERT INTO tb_skin VALUES (null, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, skin.getNome());
            stm.setString(2, skin.getImage());
            stm.executeUpdate();
            stm.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar skin - " + ex.getMessage());
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

    public Skin readIdSkin(Integer id) {
        try {

            String SQL = "SELECT * FROM tb_skin WHERE idskin LIKE ? ;";
            //System.out.println("SkinDAO 1");
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            //System.out.println("SkinDAO 2");
            stm.setString(1, id.toString());
            //System.out.println("SkinDAO 3");
            ResultSet rs = stm.executeQuery();
            //System.out.println("SkinDAO 4");
            Skin skin = new Skin();

            if (rs.next()) {
                skin.setId(rs.getInt("idSkin"));
                skin.setNome(rs.getString("nome"));
                skin.setImage(rs.getString("imagem"));
                System.out.println(skin.ToString());
            }
            
            stm.close();
            rs.close();
            return skin;

        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar skin - " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Object> read(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
