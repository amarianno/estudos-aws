package br.com.estudos.aws.dao;

import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log
public class Conexao {

    private static Connection conexao = null;

    private Conexao() {}

    public static Connection getConexao() throws Exception {

        if (conexao == null) {
            conexao = getConn();
        }
        return conexao;
    }

    private static Connection getConn() throws Exception {

//        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
//        source.setDataSourceName("A Data Source");
//        source.setServerName("localhost");
//        source.setDatabaseName("test");
//        source.setUser("testuser");
//        source.setPassword("testpassword");
//        source.setMaxConnections(10);


        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://meubebe.cjtbdq5yulk8.us-east-2.rds.amazonaws.com:5432/meubebe", "user_meubebe", "Bu$carta5")) {

            if (conn != null) {
                log.info("Connected to the database!");
                return conn;
            } else {
                log.warning("Failed to make connection!");
                throw new Exception("deu erro");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
