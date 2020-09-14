/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author danil
 */
public class Personagem implements java.io.Serializable{
    
    private int id;
    private String nick;
    private int forca;
    private int agilidade;
    private Usuario usuario;
    private String skin;
    private int resistencia;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * @param forca the forca to set
     */
    public void setForca(Integer forca) {
        this.forca = forca;
    }

    /**
     * @return the agilidade
     */
    public int getAgilidade() {
        return agilidade;
    }

    /**
     * @param agilidade the agilidade to set
     */
    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    /**
     * @return the skins
     */
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the resistencia
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * @param resistencia the resistencia to set
     */
    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }
    
}
