import java.util.function.UnaryOperator;

public class Imutabilidade {
    public static void main(String[] args){
        UnaryOperator<Integer> retornarDobro = v -> v * 2 ;
        //O VALOR DE UM PARADIGMA FUNCIONAL NAO É MUTAVEL, OU SEJA, A VARIAVEL VALOR NUNCA SERA ALTERADA.
        int valor = 20;

        //retorna o dobro do valor, entao ele retorna o 40
        System.out.println(retornarDobro.apply(valor));
        //ele retorna o valor 20
        System.out.println(valor);
    }
}

