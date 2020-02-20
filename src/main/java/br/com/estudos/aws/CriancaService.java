package br.com.estudos.aws;

public class CriancaService {

    public void salvar(String nome) {

    }


    public Crianca buscarPorNome(String nome) {
        return Crianca
                .builder()
                .id(1L)
                .nome("Marianna")
                .build();
    }

    public void deletarTudo() {

    }
}
