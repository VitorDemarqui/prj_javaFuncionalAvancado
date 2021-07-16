package aula2;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args){
        //predicados recebem um parametro qualquer e retorna um bool
        Predicate<String> estaVazio = valor ->valor.isEmpty();
        Predicate<String> estaVazioComRefMet = String::isEmpty;
        System.out.println(estaVazioComRefMet.test(""));
        System.out.println(estaVazio.test("Joao"));
    }
}
