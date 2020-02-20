package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.Abstracao;
import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.CriancaService;
import br.com.estudos.aws.RequestDoGateway;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.util.Collections;

public class BuscarCriancaPorNome extends Abstracao implements RequestHandler<RequestDoGateway, Crianca> {

    public Crianca handleRequest(RequestDoGateway requestDoGateway, Context context) {
        Crianca crianca = criancaService.buscarPorNome(requestDoGateway.getNome());
        return crianca;
    }
}
