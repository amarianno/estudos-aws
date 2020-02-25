package br.com.estudos.aws.dao;

import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Log
public class Conexao {

    private static Connection conexao = null;

    private Conexao() {}

    public static Connection getConexao() throws Exception {

        if (conexao == null || conexao.isClosed()) {
            conexao = getCon();
        }
        return conexao;
    }

    private static Connection getCon() throws Exception {
        try {
            String url = "jdbc:postgresql://meubebe.cjtbdq5yulk8.us-east-2.rds.amazonaws.com:5432/meubebe";
            Properties props = new Properties();
            props.setProperty("user","user_meubebe");
            props.setProperty("password","Bu$carta5");
            props.setProperty("ssl","false");
            return DriverManager.getConnection(url, props);
        } catch (Exception e ){
            throw e;
        }
    }

}
