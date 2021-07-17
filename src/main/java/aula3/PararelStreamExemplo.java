package aula3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PararelStreamExemplo {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,100000).parallel().forEach(PararelStreamExemplo::fatorial);//parallel
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execucao : "+ (fim-inicio));


        inicio = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(PararelStreamExemplo::fatorial);//serial
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execucao : "+ (fim-inicio));


        List<String> nomes = Arrays.asList("Joao", "paulo", "oliveira", "Santos");
        nomes.parallelStream().forEach(System.out::println);

    }

    public static void fatorial(long num){
        int fat = 1;

        for (int i = 1; i <= num ; i++)
            fat *= i;

    }
}
