package br.com.estudos.aws.proximavacina;

import br.com.estudos.aws.Abstracao;
import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.Mensagem;
import br.com.estudos.aws.Vacina;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.time.format.TextStyle;
import java.util.Locale;

public class ProximaVacina extends Abstracao implements RequestHandler<ProximaVacinaRequest, APIGatewayProxyResponseEvent> {

    //br.com.estudos.aws.proximavacina.ProximaVacina::handleRequest
    public APIGatewayProxyResponseEvent handleRequest(ProximaVacinaRequest request, Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        try {

            LambdaLogger logger = context.getLogger();
            logger.log("received : " + request.getNomeCrianca());

            Crianca crianca = criancaService.buscarPorNome(request.getNomeCrianca());
            Vacina proximaVacina = vacinaService.calcularProximaVacina(crianca.getDataNascimento());
            ProximaVacinaResponse proximaVacinaResponse = ProximaVacinaResponse
                    .builder()
                    .nomeCrianca(crianca.getNome())
                    .nomeVacina(proximaVacina.getNome())
                    .dia(proximaVacina.getQuandoTomar().getDayOfMonth() + "")
                    .mes(proximaVacina.getQuandoTomar().getMonth().getDisplayName(TextStyle.FULL, new Locale ("pt", "BR")))
                    .ano(proximaVacina.getQuandoTomar().getYear() + "")
                    .build();

            response.setBody(new Gson().toJson(proximaVacinaResponse));
            response.setStatusCode(200);

        } catch (Exception e) {

            response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Não encontrado {" + e.getMessage() + "} - ["+ request.getNomeCrianca() + "]").build()));
            response.setStatusCode(404);
        }

        return response;
    }
}
