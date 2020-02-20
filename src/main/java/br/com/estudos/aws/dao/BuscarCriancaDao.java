package br.com.estudos.aws.dao;

import br.com.estudos.aws.Crianca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscarCriancaDao {


    public Crianca buscarPorNome(String nome) {

        try (Connection conn = Conexao.getConexao()) {;
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM vacinas where nome = " + nome)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

//                long id = resultSet.getLong("ID");
//                String name = resultSet.getString("NAME");
//                BigDecimal salary = resultSet.getBigDecimal("SALARY");
//                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

               return  Crianca
                        .builder()
                        .id(resultSet.getLong("ID"))
                        .nome(resultSet.getString("NAME"))
                        .build();

//                Employee obj = new Employee();
//                obj.setId(id);
//                obj.setName(name);
//                obj.setSalary(salary);
//                // Timestamp -> LocalDateTime
//                obj.setCreatedDate(createdDate.toLocalDateTime());
//
//                result.add(obj);

            }
//            result.forEach(x -> System.out.println(x));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


}
