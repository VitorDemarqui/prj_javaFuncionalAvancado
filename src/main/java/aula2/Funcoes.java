package aula2;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args){
        //cria uma funcao que retorna o nome reverso
        Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(retornarNomeAoContrario.apply("Joao"));


        //passa uma string e converta ela em inteiro
        //passa string , retorna inteiro
        Function<String,Integer> ConverterStringParaInteiroECalcularODobro = string -> {
            return Integer.parseInt(string) * 2;
        };
        System.out.println(ConverterStringParaInteiroECalcularODobro.apply("10"));

        //Integer::valueOf funcioona com method reference pois é apenas 1 comando
        // se fosse multiplicar por dois nao daria, pois ai ele ja entende como dois comandos
        Function<String,Integer> ConverterStringParaInteiroECalcularODobro3 = Integer::valueOf;
    };

}

