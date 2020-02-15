/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Loja;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno 04
 */
public class LojaDAO {
    
    public static int novaLoja(Loja L){
        try(Connection conexao = Conexao.abrirConexao();
                PreparedStatement stmt = conexao.prepareStatement("INSERT INTO controle.loja (nome) VALUES(?)");){
            
            stmt.setString(1, L.getNome());
            int up = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public static Loja checarLoja(String nome){
        try(Connection conexao = Conexao.abrirConexao();
                
                PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM controle.loja WHERE nome =?")){
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
               Loja L = new Loja();
               L.setNome(rs.getString("nome"));
               L.setIDLoja(rs.getInt("IDLoja"));
               return L;
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
