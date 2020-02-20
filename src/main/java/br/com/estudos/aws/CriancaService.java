package br.com.estudos.aws;

import br.com.estudos.aws.buscarcrianca.BuscarCriancaDao;

public class CriancaService {

    BuscarCriancaDao buscarCriancaDao = new BuscarCriancaDao();

    public void salvar(String nome) {

    }


    public Crianca buscarPorNome(String nome) throws Exception {
        return buscarCriancaDao.buscarPorNome(nome);
    }

    public void deletarTudo() {

    }
}
