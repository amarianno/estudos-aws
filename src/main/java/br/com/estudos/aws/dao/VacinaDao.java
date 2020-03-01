package br.com.estudos.aws.dao;

import br.com.estudos.aws.Vacina;

import java.util.ArrayList;
import java.util.List;

public class VacinaDao {



    public List<Vacina> buscarProximaVacina(long meses) {

        List<Vacina> vacinas = new ArrayList<>();
        vacinas.add(Vacina.builder().nome("Sarampo").build());
        return vacinas;
    }
}
