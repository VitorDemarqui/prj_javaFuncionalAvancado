package Aula1.fatorialRecursivo;

public class FatorialRecursivo {
    public static void main(String[] args){
        //chama o metodo recursivo
        System.out.println(fatorial(100));
    }


    //recursividade ele chama ele mesmo ate acabar, ficando assim em um loop
    public static int fatorial(int value){
        if (value == 1){
            return value;
        }else{
            //subtrai um para soma
            return value * fatorial(value-1);
        }
    }
}
