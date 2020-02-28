package br.com.estudos.aws.buscar.user;

import br.com.estudos.aws.Abstracao;
import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.CriancaRequest;
import br.com.estudos.aws.Mensagem;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuscarCriancaPorUserID extends Abstracao implements RequestHandler<BuscarCriancaPorUserIdRequest, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(BuscarCriancaPorUserIdRequest request, Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        try {

            LambdaLogger logger = context.getLogger();
            logger.log("received : " + request.getUserId());

            List<Crianca> criancas = criancaService.buscarPorUserId(request.getUserId());

            response.setBody(new Gson().toJson(
                    criancas.stream().map(BuscarCriancaPorUserIdResponse::parse).collect(Collectors.toList())
            ));
            response.setStatusCode(200);

        } catch (Exception e) {

            response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Não encontrado {" + e.getMessage() + "} - ["+ request.getUserId() + "]").build()));
            response.setStatusCode(404);
        }

        return response;
    }
}
