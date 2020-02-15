/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Loja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno 04
 */
public class ProdutoDAO {

    public static int novoProduto(Produto p) {
        try (Connection conexao = Conexao.abrirConexao();
                PreparedStatement stmt = conexao.prepareStatement("INSERT INTO controle.produto (nome,IDLoja) VALUES (?,?)");) {

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIDLoja());

            int up = stmt.executeUpdate();
            return up;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }

    public static ArrayList verProdutos(Loja L) {
        try (Connection conexao = Conexao.abrirConexao();
                PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM controle.produto WHERE IDLoja =?");) {

            ArrayList<Produto> produtos = new ArrayList();

            stmt.setInt(1, L.getIDLoja());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setID(rs.getInt("ID"));
                p.setLoja(rs.getInt("IDLoja"));
                p.setNome(rs.getString("nome"));
                p.setQuantidade(rs.getInt("quantidade"));
                produtos.add(p);
            } else {
                return null;
            }
            while (rs.next()) {
                Produto p = new Produto();
                p.setID(rs.getInt("ID"));
                p.setLoja(rs.getInt("IDLoja"));
                p.setNome(rs.getString("nome"));
                p.setQuantidade(rs.getInt("quantidade"));
                produtos.add(p);
            }
            return produtos;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int alterarQuantidade(Produto p, int q) {
        try (Connection conexao = Conexao.abrirConexao();
                PreparedStatement stmt = conexao.prepareStatement("Update controle.produto SET quantidade =? WHERE ID=?");) {

            if (p.getQuantidade() >= q) {
                stmt.setInt(1, (q - p.getQuantidade()));
                stmt.setInt(2, p.getID());
            } else {
                return -1;
            }

            return q - p.getQuantidade();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;//caso de erro
    }

    public static int deletarProduto(Produto p) {
        
        try (Connection conexao = Conexao.abrirConexao();
                PreparedStatement stmt = conexao.prepareStatement("DELETE FROM controle.produto WHERE ID=?");) {
            stmt.setInt(1, p.getID());

            int up = stmt.executeUpdate();
            return up;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
