package Aula1.imperativoEFuncional;

import java.util.function.UnaryOperator;

public class Funcional {
    public static void main(String[] args){
        //na lambida fala o que quer ela faça quando eu passar um determinado parametro
        //UnaryOperator operacao com um operador que produz um resultado do mesmo tipo(int) só aceita tipo lambda
        UnaryOperator<Integer> calcularValorVezes3 = valor -> valor * 3;
        //Declara o comportamento dele antes de precisar usa-lo
        //Conceito de paradigma funcional ou programação funcional
        System.out.println("O resultado é :: " + calcularValorVezes3.apply(10));
    }

}



