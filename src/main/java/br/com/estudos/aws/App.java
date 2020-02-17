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

public class App implements RequestHandler<RequestDoGateway, App.Crianca> {


    public Crianca handleRequest(RequestDoGateway requestDoGateway, Context context) {

        Gson gson = new Gson();

        LambdaLogger logger = context.getLogger();
        logger.log("received : " + requestDoGateway.toString());

        Crianca crianca = new Crianca();
        crianca.setNome(requestDoGateway.getNome());
        crianca.setDataNascimento("28/10/2014");

        ResponseAws resp = new ResponseAws();
        resp.setBody(crianca);
        resp.setStatusCode(200);
        resp.setBase64Encoded(false);
        resp.setHeaders(Collections.singletonMap("x-alberto", "marianno"));

        return crianca;
    }

    static class ResponseAws {
        private boolean isBase64Encoded;
        private Integer statusCode;
        private Crianca body;
        private Map<String, String> headers;

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public void setBody(Crianca body) {
            this.body = body;
        }

        public void setBase64Encoded(boolean base64Encoded) {
            isBase64Encoded = base64Encoded;
        }

        public Crianca getBody() {
            return body;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public boolean isBase64Encoded() {
            return isBase64Encoded;
        }


    }

    static class Crianca {
        private String nome;
        private String dataNascimento;

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
