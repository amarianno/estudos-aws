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
import java.util.List;
import java.util.Locale;

public class ProximaVacina extends Abstracao implements RequestHandler<ProximaVacinaRequest, APIGatewayProxyResponseEvent> {

    //br.com.estudos.aws.proximavacina.ProximaVacina::handleRequest
    public APIGatewayProxyResponseEvent handleRequest(ProximaVacinaRequest request, Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        try {

            LambdaLogger logger = context.getLogger();
            logger.log("received : " + request.getNomeCrianca());

            Crianca crianca = criancaService.buscarPorNome(request.getNomeCrianca());
            List<Vacina> proximaVacinas = vacinaService.calcularProximaVacina(crianca.getDataNascimento());

            String resposta = "A criança " + crianca.getNome();

            if (proximaVacinas.size() > 1) {
                resposta += " tem " + proximaVacinas.size() + " vacinas para tomar. ";
            } else {
                resposta += " tem uma vacina para tomar. ";
            }

            proximaVacinas.forEach(vacina -> resposta += vacina.resumo(crianca.getDataNascimento()));

//            ProximaVacinaResponse proximaVacinaResponse = ProximaVacinaResponse
//                    .builder()
//                    .nomeCrianca(crianca.getNome())
//                    .nomeVacina(proximaVacina.getNome())
//                    .dia(proximaVacina.getQuandoTomar().getDayOfMonth() + "")
//                    .mes(proximaVacina.getQuandoTomar().getMonth().getDisplayName(TextStyle.FULL, new Locale ("pt", "BR")))
//                    .ano(proximaVacina.getQuandoTomar().getYear() + "")
//                    .build();

            response.setBody(resposta);
            response.setStatusCode(200);

        } catch (Exception e) {

            response.setBody(new Gson().toJson(Mensagem.builder().mensagem("Não encontrado {" + e.getMessage() + "} - ["+ request.getNomeCrianca() + "]").build()));
            response.setStatusCode(404);
        }

        return response;
    }
}
