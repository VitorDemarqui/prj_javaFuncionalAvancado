package aula1;

public class InterfaceFuncional {
    public static void main(String[] args){
        String teste = "testando";

        //utilizando lambda
        Funcao1 funcao1 = valor -> valor+"paradigma funcional"+teste;
        System.out.println(funcao1.gerar("Teste"));



        //utilizando funcao anonima
        Funcao1 colocarTextoTestando = new Funcao1() {
            @Override
            public String gerar(String valor) {
                return valor +" "+teste;
            }
        };
        System.out.println(colocarTextoTestando.gerar("Vitao"));
    }


    //SINTAXE BASICA DE UMA LAMBDA
    // INTERFACEFUNCIONAL nomeVariavel = PARAMETRO -> Logica

    //esta é uma função funcional, que possui apenas 1 metodo abstrato
    //proteja a interface para caso alguem queira transformar a interface em outra coisa que nao seja funcional
   @FunctionalInterface
    interface  Funcao1{
        String gerar(String valor);
    }
}


