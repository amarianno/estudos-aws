package br.com.estudos.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App implements RequestHandler<RequestDoGateway, Crianca> {


    public Crianca handleRequest(RequestDoGateway requestDoGateway, Context context) {

        Gson gson = new Gson();

        LambdaLogger logger = context.getLogger();
        logger.log("received : " + requestDoGateway.toString());

        Crianca crianca = new Crianca();
        crianca.setNome(requestDoGateway.getNome());
       // crianca.setDataNascimento("28/10/2014");

//        ResponseAws resp = new ResponseAws();
//        resp.setBody(crianca);
//        resp.setStatusCode(200);
//        resp.setBase64Encoded(false);
//        resp.setHeaders(Collections.singletonMap("x-alberto", "marianno"));

        return crianca;
    }
}
