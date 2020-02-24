package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.dao.Conexao;

import java.sql.*;
import java.time.LocalDateTime;

public class BuscarCriancaDao {

    public void salvar(Crianca crianca) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.getConexao();
            stmt = conn.prepareStatement("INSERT INTO crianca VALUES (nextval('sq_crianca'), ?, ?)");

            stmt.setString(1, crianca.getNome());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
               if (stmt != null) {
                   conn.close();
               }
               if (conn != null) {
                   conn.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
    }

    /**
     * @param nome
     * @return
     * @throws Exception
     */
    public Crianca buscarPorNome(String nome) throws Exception {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = Conexao.getConexao();
            preparedStatement = conn.prepareStatement("SELECT * FROM crianca where nome = ?");

            preparedStatement.setString(1, nome);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return Crianca
                        .builder()
                        .id(resultSet.getLong("id"))
                        .nome(resultSet.getString("nome"))
                        .build();
            }

            throw new Exception("Não há registros");


        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    /**
     *
     */
    public void deletarTudo() {
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM crianca WHERE nome LIKE 'Teste%'");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
