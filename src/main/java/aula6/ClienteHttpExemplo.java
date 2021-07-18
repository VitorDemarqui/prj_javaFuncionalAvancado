package aula6;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClienteHttpExemplo {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(@NotNull Runnable runnable) {
            Thread thread = new Thread(runnable);

            System.out.println("Nova Thread criada"+(thread.isDaemon() ? "daemon:" : "") + " Thread Group : "+thread.getThreadGroup());
            return thread;
        }
    });


    public static void main(String[] args) throws Exception {
        connectAkamaiHttp1Client();
    }


    private static void connectAkamaiHttp1Client(){
        System.out.println("Running HTTP/2 example ...");
        try {
            HttpClient httpCLient = HttpClient.newBuilder()
                    //ALTERAR AQUI PARA UTILIZAR HTTTP 2
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            //somente medir performance
            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpCLient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code : " + response.statusCode());
            System.out.println("Response Headers" + response.headers());
            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> future = new ArrayList<>();

            responseBody
            .lines()
            .filter(line -> line.trim().startsWith("<img height"))
            .map(line -> line.substring(line.indexOf("src='") + 5,line.indexOf("'/>")))
            .forEach(image -> {
                Future<?> imgfuture = executor.submit(() ->{
                    HttpRequest imgRequest = HttpRequest.newBuilder()
                            .uri(URI.create("https://http2.akamai.com"+image))
                            .build();

                    try {
                        HttpResponse<String> imageResponse = httpCLient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                        System.out.println("Imagem carregada : " +image+", status code : "+imageResponse.statusCode());

                    } catch (IOException | InterruptedException e) {
                        System.out.println("Erro durante requisicao para recuperar a imagem");
                    }
                });
                future.add(imgfuture);
                System.out.println("Submetido um futura para imagem:  "+image);
            });

            future.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao esperar carregar imagem do futuro");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("tempo de carregamento total : "+ (end - start)+"ms");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            executor.shutdown();
        }
    }




    //comentarios aula 5
    private static void getURL() throws IOException, InterruptedException {
        //cria a requisicao do servodpr
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://www.oracle.com/java/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code : " +response.statusCode());
        System.out.println("HEraders response : "+response.headers());
        System.out.println(response.body());




       /* antigo
       try{
            var url = new URL("https://www.oracle.com/java/");

            var urlConnection = url.openConnection();

            try( var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){

                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }*/


    }
}
