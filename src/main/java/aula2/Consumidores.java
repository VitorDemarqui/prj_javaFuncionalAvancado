package aula2;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args){


        //utiliza o parametro da forma que ele foi recebido

        //esconde o parametro e apenas chama a funcao(println) na forma de uma variavel
        //recebe uma frase passa como parametro e printa
        Consumer<String> imprimirUmaFrase = System.out::println;

        //quando executar a funcao ele imprime na tela a forma
        Consumer<String> imprimirUmaFrase1 = frase -> System.out.println(frase);
        //utiliza o metodo accept que vem do metodo dentro do consumer
        imprimirUmaFrase.accept("Hello world");
    }
}
