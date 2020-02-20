package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscarCriancaDao {

    /**
     *
     * @param nome
     * @return
     * @throws Exception
     */
    public Crianca buscarPorNome(String nome) throws Exception {

        try {
            Connection conn = Conexao.getConexao();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM vacinas where nome = " + nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return  Crianca
                        .builder()
                        .id(resultSet.getLong("ID"))
                        .nome(resultSet.getString("NAME"))
                        .build();
            }

            throw new Exception("Não há registros");


        } catch (Exception e) {
            throw e;
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
