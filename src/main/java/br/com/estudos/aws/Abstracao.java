package br.com.estudos.aws;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

public abstract class Abstracao {


    protected CriancaService criancaService = new CriancaService();
    protected VacinaService vacinaService = new VacinaService();


    /**
     *
     * @return
     */
    protected APIGatewayProxyResponseEvent tratarErroPadrao() {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Sistema indisponível").build()));
        response.setStatusCode(500);
        return response;
    }


}
