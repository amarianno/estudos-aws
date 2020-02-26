package br.com.estudos.aws;

import br.com.estudos.aws.buscarcrianca.BuscarCriancaDao;

import java.time.LocalDate;
import java.time.Month;

public class VacinaService {

    public Vacina calcularProximaVacina(LocalDate dataNascimento) {
        return Vacina.builder().nome("Sarampo").quandoTomar(LocalDate.of(2020, Month.NOVEMBER, 1)).build();
    }

}
