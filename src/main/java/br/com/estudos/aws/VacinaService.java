package br.com.estudos.aws;

import br.com.estudos.aws.dao.VacinaDao;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VacinaService {

    VacinaDao vacinaDao = new VacinaDao();

    public List<Vacina> calcularProximaVacina(LocalDate dataNascimento) {

//        long quantidadeMeses = ChronoUnit.MONTHS.between(
//                dataNascimento.withDayOfMonth(1),
//                LocalDate.now().withDayOfMonth(1));
//
//        List<Vacina> vacinas = vacinaDao.buscarProximaVacina(quantidadeMeses);
//
//        List<Vacina> proximas = new ArrayList<>();
//        int contador = 0;
//
//        //colocar um limitador nessa procura
//        //uns 50 meses
//        while (proximas.isEmpty() || contador <= 50) {
//
//            for (Vacina vacina : vacinas) {
//                if (vacina.getMeses() == quantidadeMeses) {
//                    proximas.add(vacina);
//                }
//            }
//
//            quantidadeMeses++;
//            contador++;
//        }

        //return vacinas;
        return Stream.of(
                Vacina.builder().nome("Sarampo").quandoTomar(LocalDate.of(2020, Month.NOVEMBER, 1)).build()
        ).collect(Collectors.toList());
    }

}
