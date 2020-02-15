/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Aluno 04
 */
public class Loja {
    private int IDLoja;
    private String nome;
    
    ArrayList<Produto> produtosDaLoja = new ArrayList();

    public int getIDLoja() {
        return IDLoja;
    }

    public void setIDLoja(int ID) {
        this.IDLoja = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
