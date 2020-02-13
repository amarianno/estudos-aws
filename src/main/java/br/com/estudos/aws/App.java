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
import java.util.Map;

public class App {

//    public static void main(String[] args) {
//        App app = new App();
//        app.handleRequest("Marianna", null)
//    }

    public static ResponseAws handleRequest(InputStream inputStream,
                                            OutputStream outputStream,
                                            Context context) {

        Gson gson = new Gson();

        //JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //JSONObject event = (JSONObject) parser.parse(reader);
        Map mapa = gson.fromJson(reader, Map.class);

        LambdaLogger logger = context.getLogger();
        logger.log("received : " + mapa.toString());

        Crianca crianca = new Crianca();
//        crianca.setNome(mapa.get("nome") + "");
        crianca.setNome("Marianna");
        crianca.setDataNascimento("28/10/2014");


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
