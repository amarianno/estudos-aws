package br.com.estudos.aws.dao;

import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log
public class Conexao {

    private static Connection conexao = null;

    private Conexao() {

    }

    public static Connection getConexao() throws Exception {
        if (conexao == null) {
            conexao = getConn();
        }

        return conexao;
    }

    private static Connection getConn() throws Exception {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://meubebe.cjtbdq5yulk8.us-east-2.rds.amazonaws.com:5432/meubebe", "user_meubebe", "Bu$carta5")) {

            if (conn != null) {
                //log.info("Connected to the database!");
                return conn;
            } else {
                //log.warn("Failed to make connection!");
                throw new Exception("deu erro");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
