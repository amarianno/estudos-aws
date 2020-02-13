package br.com.estudos.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

public class App {

//    public static void main(String[] args) {
//        App app = new App();
//        app.handleRequest("Marianna", null)
//    }

    public static ResponseAws handleRequest(Context context) {



        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject event = (JSONObject) parser.parse(reader);
//
//
//        LambdaLogger logger = context.getLogger();
//
//        logger.log("received : " + nomeCrianca);

        Crianca crianca = new Crianca();
        crianca.setNome("Marianna Araújo");

        Gson gson = new Gson();
        String criancaJson = gson.toJson(crianca);

        ResponseAws resp = new ResponseAws();
        resp.setBody(criancaJson);
        resp.setStatusCode(200);

        //String json = gson.toJson(resp);

        return resp;
    }

    static class ResponseAws {
        private boolean isBase64Encoded;
        private int statusCode;
        private String body;
        private List<String> headers;


        public void setHeaders(List<String> headers) {
            this.headers = headers;
        }

        public List<String> getHeaders() {
            return headers;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public boolean isBase64Encoded() {
            return isBase64Encoded;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public boolean getIsBase64Encoded() {
            return isBase64Encoded;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getBody() {
            return body;
        }
    }

    static class Crianca {
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
