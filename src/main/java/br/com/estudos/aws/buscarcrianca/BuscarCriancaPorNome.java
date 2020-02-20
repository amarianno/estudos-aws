package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.util.Collections;

public class BuscarCriancaPorNome extends Abstracao implements RequestHandler<RequestDoGateway, Crianca> {

    public Crianca handleRequest(RequestDoGateway requestDoGateway, Context context) {
        try {
            return criancaService.buscarPorNome(requestDoGateway.getNome());
        } catch (Exception e) {
            return null;
        }
    }
}
