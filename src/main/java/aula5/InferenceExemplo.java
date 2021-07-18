package aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class InferenceExemplo {
    //o var vai precisar estar dentro de um metodo, um for, um while, nao conseguimos utilizar a nivel de classe
    //private  var joao = new String("teste");
    
    public static void main(String[] args) throws IOException {
        printarNomeCompleto("Vitor");
        printarSoma(2,5,4,4,5,7,89,56);

        getURL();
    }

    private static void getURL() throws IOException {

        //quem implementa closable pode estar dentro do try
        try{
            //pegando conteudo da pagina
            var url = new URL("https://www.oracle.com/java/");
            //abre uma coneccao com a pagina para pegar os dados
            var urlConnection = url.openConnection();

        //ele fecha automaticamente a conexao
        try( var bufferedReader = new BufferedReader(//tranforma em linhas
                new InputStreamReader
                        (urlConnection.getInputStream()//pega os caracteres tambem
                                /*pega toda entrada de dados que estao vindo e ta colodando no imput stream*/))){

            //pega as linhas do buffered reader, e esta colletando e concatenando em uma string só
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));

             }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //var nao pode ser utilizado como parametro
    public static void printarNomeCompleto(String nome){
        var nomeCompleto = nome + " Demarqui";
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        //nao pode utilar em variaveis nao inicializada;
        //var soma;

        int soma;
        if (numeros.length > 0) {
            soma = 0;

            for (var  numero : numeros) {
                soma += numero;
            }

            for (int i = 0; i < numeros.length; i++) {
                soma += numeros[i];
            }

            System.out.println("A soma é : " + soma);
        }

    }
}
