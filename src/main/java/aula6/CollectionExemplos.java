package aula6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionExemplos {
    public static void main(String[] args) {
        //instanciando lista
        Collection<String> nomes = Arrays.asList("joao","pedro","jose");

        //instanciando lista de forma mais facil
        Collection<String> nomesList = List.of("joao","pedro","jose");
        Collection<String> nomesSet = Set.of("joao","pedro","jose");

        System.out.println(nomes);
    }


}
