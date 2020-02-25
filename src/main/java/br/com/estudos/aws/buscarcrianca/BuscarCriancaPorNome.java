package br.com.estudos.aws.buscarcrianca;

import br.com.estudos.aws.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.Collections;

public class BuscarCriancaPorNome extends Abstracao implements RequestHandler<CriancaRequest, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(CriancaRequest request, Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        try {

            LambdaLogger logger = context.getLogger();
            logger.log("received : " + request.getNome());

            Crianca crianca = criancaService.buscarPorNome(request.getNome());

            response.setBody(new Gson().toJson(crianca));
            response.setStatusCode(200);

        } catch (Exception e) {

            response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Não encontrado {" + e.getMessage() + "} - ["+ request.getNome() + "]").build()));
            response.setStatusCode(404);
        }

        return response;
    }
}
