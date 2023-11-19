/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class LojaInformaticaDAO {

    static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    static String login = "LojaInformatica";
    static String senha = "ADO@2*";

    public static boolean salvar(Computador novoComputador) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            //carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //preparar comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("INSERT INTO Computador (HD, processador) VALUES(?, ?)");
            comandoSQL.setString(1, novoComputador.getHD());
            comandoSQL.setString(2, novoComputador.getProcessador());

            //executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LojaInformaticaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;
    }

    public static ArrayList<Computador> listar() {

        ArrayList<Computador> lista = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //preparar comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("SELECT * FROM Computador ");

            //executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Computador item = new Computador();
                    item.setIdComputador(rs.getInt("idComputador"));
                    item.setHD(rs.getString("HD"));
                    item.setProcessador(rs.getString("processador"));

                    lista.add(item);
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaInformaticaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LojaInformaticaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LojaInformaticaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

    public static boolean alterar (Computador computadorAlterar) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            //carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //preparar comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("UPDATE Computador SET HD = ?, processador = ? WHERE idComputador = ?");
            comandoSQL.setString(1, computadorAlterar.getHD());
            comandoSQL.setString(2, computadorAlterar.getProcessador());
            comandoSQL.setInt(3, computadorAlterar.getIdComputador());

            //executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LojaInformaticaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;
    }
}
