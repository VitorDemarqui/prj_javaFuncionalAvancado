package Aula1;

import java.util.function.BiPredicate;

public class FuncoesPuras {
    public static void main(String[] args){
        //sempre que eu passar os mesmos argumentos no paradigma funcional ele tem que retornar os mesmo resultados
        //BiPredicate é uma interface funcional pode, portanto,
        // pode ser usado como o destino de atribuição para uma expressão lambda ou reference method.
        //é uma funcao booleana de dois argumentos
        BiPredicate<Integer,Integer> verificaSeEMaior =
                (parametro, valorComparacao) -> parametro > valorComparacao;

        System.out.println(verificaSeEMaior.test(12, 13));
        System.out.println(verificaSeEMaior.test(12, 13));

        System.out.println(verificaSeEMaior.test(13, 13));
    }
}
