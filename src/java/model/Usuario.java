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
public class Usuario implements java.io.Serializable{
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private List<Personagem> personagens;
    
    public void addPersonagem(Personagem p){
        personagens.add(p);
    }

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the personagens
     */
    public List<Personagem> getPersonagens() {
        return personagens;
    }

    /**
     * @param personagens the personagens to set
     */
    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }
    
    public String ToString(){
        return id + " - " + nome + " - " + email;
    }
    
    public String getLinkPersonagens(){
        String resposta = "";
        for (Personagem personagem : this.personagens){
            resposta += personagem.getSkin();
        }
        return resposta;
    }
    
    
}
