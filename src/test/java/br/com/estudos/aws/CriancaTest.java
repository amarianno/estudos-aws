package br.com.estudos.aws;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class CriancaTest {

    static CriancaService criancaService = new CriancaService();

//    @Test
//    public void deve_cadastrar_crianca() {
//
//        String nomeCrianca = "Guilherme";
//        criancaService.salvar(nomeCrianca);
//        Crianca crianca = criancaService.buscarPorNome(nomeCrianca);
//        Assert.assertEquals(nomeCrianca, crianca.getNome());
//    }
//
//    @Test(expected = Exception.class)
//    public void deve_retornar_erro_ao_buscar_crianca() {
//        Crianca crianca = criancaService.buscarPorNome("Artur");
//    }

    @Test
    public void deve_voltar_crianca_a_partir_do_nome() throws Exception {
        Crianca crianca = criancaService.buscarPorNome("Marianna");
        Assert.assertEquals(1L, crianca.getId());
        Assert.assertEquals("Marianna", crianca.getNome());
    }

    @AfterClass
    public static void deletarTudo() {
        criancaService.deletarTudo();
    }


}
