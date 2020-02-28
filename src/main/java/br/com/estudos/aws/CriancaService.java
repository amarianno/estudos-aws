package br.com.estudos.aws;

import br.com.estudos.aws.buscarcrianca.BuscarCriancaDao;

import java.util.List;

public class CriancaService {

    BuscarCriancaDao buscarCriancaDao = new BuscarCriancaDao();

    public void salvar(Crianca crianca) {
        buscarCriancaDao.salvar(crianca);
    }


    public Crianca buscarPorNome(String nome) throws Exception {
        Crianca crianca = buscarCriancaDao.buscarPorNome(nome);
        return crianca;
    }

    public List<Crianca> buscarPorUserId(String userId) throws Exception {

        List<Crianca> criancas = buscarCriancaDao.buscarPorUserId(userId);

        if (criancas == null || criancas.isEmpty()) {
            throw new Exception("Não há registros");
        }

        return criancas;

    }

    public void deletarTudo() {
        buscarCriancaDao.deletarTudo();
    }
}
