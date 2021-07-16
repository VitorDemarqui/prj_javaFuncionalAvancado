package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Joao", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
        Integer[] numeros = {1, 2, 3, 4, 5};
        imprimirNomesFIltrados(nomes);

        List<String> listaProfissoes = new ArrayList<>();
        listaProfissoes.add("Desenvolvedor");
        listaProfissoes.add("Testador");
        listaProfissoes.add("Gerente de projeto");
        listaProfissoes.add("Gerente de qualidade");

        listaProfissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach((System.out::println));
    }

    //... = array
    public static void imprimirNomesFIltrados(String... nomes) {
       String nomesParaImprimir = "";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("Joao"))
                nomesParaImprimir += " " + nomes[i];
        }
        System.out.println("nome for: "+nomesParaImprimir);


        //new Stream nao pode ser instanciado póis e uma classe abstrata
        //chamando ele de forma statica e adiciona na corrente de streams
       String nomesImprimirStream = Stream.of(nomes)
                .filter(nome -> nome.equals("joao"))
                //pega um array de strings e transforma em uma string só, concatenando
                .collect(Collectors.joining());
        System.out.println("nome stream: "+ nomesImprimirStream);

    }

    //... significa array
    public static void imprimirTodosNomes(String... nomes) {
        for(String nome : nomes){
            System.out.println(nome);
        }

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Imprimido pelo foreach: "+ nome));
    }

    public static void imprimirODobroDeTodosNumeros(Integer... numeros) {
     for (Integer numero : numeros)
         System.out.println(numero);

     //stream
        Stream.of(numeros)
                //map recebe uma function, recebe um valor e me retorna um valor
                .map(numero -> numero * 2)
                .forEach(System.out::println);

    }



}




