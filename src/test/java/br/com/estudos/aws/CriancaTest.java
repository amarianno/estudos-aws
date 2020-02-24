package br.com.estudos.aws;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CriancaTest {

    static CriancaService criancaService = new CriancaService();

    @Test
    public void deve_cadastrar_crianca() throws Exception {
        String nomeCrianca = "Teste Guilherme";
        LocalDate hoje = LocalDate.now();

        Crianca crianca = Crianca.builder().nome(nomeCrianca).dataNascimento(LocalDate.of(2008, 3, 24)).build();
        criancaService.salvar(crianca);

        Crianca criancaDaBase = criancaService.buscarPorNome(nomeCrianca);
        Assert.assertEquals(nomeCrianca, criancaDaBase.getNome());
        Assert.assertEquals(24, criancaDaBase.getDataNascimento().getDayOfMonth());
        Assert.assertEquals(3, criancaDaBase.getDataNascimento().getMonthValue());
        Assert.assertEquals(2008, criancaDaBase.getDataNascimento().getYear());
    }

    @Test(expected = Exception.class)
    public void deve_retornar_erro_ao_buscar_crianca() throws Exception {
        Crianca crianca = criancaService.buscarPorNome("Artur");
    }

    @AfterClass
    public static void deletarTudo() {
        criancaService.deletarTudo();
    }


}
