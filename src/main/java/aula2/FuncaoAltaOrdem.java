package aula2;

public class FuncaoAltaOrdem {
    public static void main(String[] args){
        //o que ele vai fazer quando executar o comando
        Calculo soma =  (a,b) -> a+b;
        Calculo subtracao =  (a,b) -> a-b;
        Calculo divisao =  (a,b) -> a/b;
        Calculo mult =  (a,b) -> a*b;

        System.out.println(executarOperacao(soma,1,3));//4
        System.out.println(executarOperacao(subtracao,4,3));//1
        System.out.println(executarOperacao(divisao,4,2));//2
        System.out.println(executarOperacao(mult,7,3));//21
    }

    //funcao de alta ordem
    public static int executarOperacao(Calculo calculo,int a, int b){
        //chama o obj soma
        return calculo.calcular(a,b);
    }


    //a mesma ação que a que esta em cima
    public int soma(int a, int b){
        return a + b;
    }

}


//cada interface funcional só pode ter 1 metodo abstrato
interface Calculo{
    public int calcular(int a, int b);
}

//FUNCAO DE ALTA ORDEM É UMA FUNCAO QUE RECEBE OUTRA FUNCAO
// OU QUE ELA RETORNA UMA FUNCAO