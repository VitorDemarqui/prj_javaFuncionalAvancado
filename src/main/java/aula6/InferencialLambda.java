package aula6;

import java.util.function.Function;

public class InferencialLambda {
    public static void main(String[] args) {
        //lambda pode ser utilizada com var
        Function<Integer, Double> divisaoPor2 = (var numero) -> numero/2d;

        System.out.println(divisaoPor2.apply(4));
    }

}
