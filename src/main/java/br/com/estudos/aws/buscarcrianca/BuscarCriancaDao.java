package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BuscarCriancaDao {

    public void insert(Crianca crianca) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.getConexao();
            stmt = conn.prepareStatement("INSERT INTO crianca VALUES (?, ?, ?)");

            stmt.setLong(1, 1L);
            stmt.setString(2, crianca.getNome());
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

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
            preparedStatement = conn.prepareStatement("SELECT * FROM vacinas where id = 1");
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

//                long id = resultSet.getLong("ID");
//                String name = resultSet.getString("NAME");
//                BigDecimal salary = resultSet.getBigDecimal("SALARY");
//                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");


//                Employee obj = new Employee();
//                obj.setId(id);
//                obj.setName(name);
//                obj.setSalary(salary);
//                // Timestamp -> LocalDateTime
//                obj.setCreatedDate(createdDate.toLocalDateTime());
//
//                result.add(obj);

//            }
////            result.forEach(x -> System.out.println(x));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }


}
