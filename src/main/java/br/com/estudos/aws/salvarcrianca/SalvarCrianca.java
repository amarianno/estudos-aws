package br.com.estudos.aws.salvarcrianca;

import br.com.estudos.aws.Abstracao;
import br.com.estudos.aws.Crianca;
import br.com.estudos.aws.Mensagem;
import br.com.estudos.aws.proximavacina.ProximaVacina;
import br.com.estudos.aws.proximavacina.ProximaVacinaRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.time.LocalDate;

public class SalvarCrianca extends Abstracao implements RequestHandler<SalvarCriancaRequest, APIGatewayProxyResponseEvent> {


    public APIGatewayProxyResponseEvent handleRequest(SalvarCriancaRequest request, Context context) {

        try {

            LambdaLogger logger = context.getLogger();
            logger.log("received: " + request.toString());

            Crianca crianca = Crianca
                    .builder()
                    .nome(request.getNome())
                    .dataNascimento(LocalDate.from(2014, 10, 28))
                    .build();

            criancaService.salvar(crianca);

            ProximaVacina proximaVacina = new ProximaVacina();

            return proximaVacina.handleRequest(ProximaVacinaRequest
                    .builder()
                    .nomeCrianca(crianca.getNome())
                    .build(), context);

        } catch (Exception e) {

            APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
            response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Não encontrado {" + e.getMessage() + "} - [" + request.getNomeCrianca() + "]").build()));
            response.setStatusCode(404);
            return response;
        }
    }
}
