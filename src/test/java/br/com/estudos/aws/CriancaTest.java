package br.com.estudos.aws;


import br.com.estudos.aws.proximavacina.ProximaVacina;
import br.com.estudos.aws.proximavacina.ProximaVacinaRequest;
import br.com.estudos.aws.proximavacina.ProximaVacinaResponse;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class CriancaTest {

    static CriancaService criancaService = new CriancaService();

    String nomeCrianca = "Teste Guilherme";

    @Test
    public void deve_cadastrar_crianca() throws Exception {
        LocalDate hoje = LocalDate.now();

        Crianca crianca = Crianca.builder().nome(nomeCrianca).dataNascimento(LocalDate.of(2008, Month.MARCH, 24)).build();
        criancaService.salvar(crianca);

        Crianca criancaDaBase = criancaService.buscarPorNome(nomeCrianca);
        Assert.assertEquals(nomeCrianca, criancaDaBase.getNome());
        Assert.assertEquals(24, criancaDaBase.getDataNascimento().getDayOfMonth());
        Assert.assertEquals(3, criancaDaBase.getDataNascimento().getMonthValue());
        Assert.assertEquals(2008, criancaDaBase.getDataNascimento().getYear());
    }

//    @Test
//    public void deve_cadastrar_crianca_2() throws Exception {
//        String nomeCrianca = "Marianna";
//
//        Crianca criancaDaBase = criancaService.buscarPorNome(nomeCrianca);
//        Assert.assertEquals(nomeCrianca, criancaDaBase.getNome());
//    }

    @Test(expected = Exception.class)
    public void deve_retornar_erro_ao_buscar_crianca() throws Exception {
        Crianca crianca = criancaService.buscarPorNome("Artur");
    }

//    @Test
//    public void eee() throws Exception {
//        ProximaVacina proximaVacina = new ProximaVacina();
//
//        APIGatewayProxyResponseEvent response = proximaVacina.handleRequest(ProximaVacinaRequest
//                .builder().nomeCrianca(nomeCrianca).build(), null);
//
//        ProximaVacinaResponse proximaResponse = new Gson().fromJson(response.getBody(), ProximaVacinaResponse.class)
//
//        Assert.assertEquals(nomeCrianca, proximaResponse.getNomeCrianca());
//        Assert.assertEquals("Sarampo", proximaResponse.getNomeVacina());
//        Assert.assertEquals("Sarampo", proximaResponse.getNomeVacina());
//
//
//
//    }




    @AfterClass
    public static void deletarTudo() {
        criancaService.deletarTudo();
    }


}
