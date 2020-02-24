package br.com.estudos.aws;

import br.com.estudos.aws.buscarcrianca.BuscarCriancaDao;

public class CriancaService {

    BuscarCriancaDao buscarCriancaDao = new BuscarCriancaDao();

    public void salvar(Crianca crianca) {
        buscarCriancaDao.salvar(crianca);
    }


    public Crianca buscarPorNome(String nome) throws Exception {
        Crianca crianca = buscarCriancaDao.buscarPorNome(nome);
        return crianca;
    }

    public void deletarTudo() {
        buscarCriancaDao.deletarTudo();
    }
}
