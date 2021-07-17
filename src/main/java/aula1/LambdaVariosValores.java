package aula1;

public class LambdaVariosValores {

    public static void main(String[] args){
        Funcao1 funcao1 = valor -> {
            System.out.println(valor);
            //nao pode ser utilizado se o retorno da funcao for void pois ele nao espera um retorno
            return valor;
        };

        //nao pode ser chamada se a funcao for void pois nao retorna nada
        System.out.println(funcao1.gerar("vitor"));

    }

    //se a classe tem um retorno precisa utilizar ela em algum lugar por exemplo sout
    //se a interface possuir um retorno void vc vai precisar retornar no lambda com sout
    interface Funcao1{
       String gerar(String valor);
    }
}
