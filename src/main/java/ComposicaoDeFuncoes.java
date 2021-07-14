import imperativoEFuncional.Funcional;

import java.util.Arrays;

public class ComposicaoDeFuncoes {
    public static void main(String[] args){
        int [] valores = {0,1,2,3,4};

        //                                  FUNCIONAL


        Arrays.stream(valores)
                //filta os dados, se o numero mod 2 for igual a 0
                //para cada numero que entra aqui verifica se o resto da divisao é igual a 0 se for prossegue para o map
                .filter(numero -> numero % 2 == 0)
                //se for divisivel por 2 e o resto for 0, pega ele e multiplica por dois
                .map(numero -> numero * 2 )
                //printa o numero
                .forEach(numero -> System.out.println(numero));
        //tenho valores que sao arrays, pego os valores, e para cada valor e vou validar se valor mod 2 é == 0
        //se o valor for igual a 0
        //vou pegar o numero que peguei como parametro e vou multiplicar por dois
        // e se o valor for diferente de 0 vai imprimir na tela

        //                                  IMPERATIVA

        for (int i =0;i<valores.length;i++){
            int valor = 0;
            if(valores[i] % 2 == 0){
                valor = valores[i] * 2;
                    System.out.println(valor);

            }
        }
    }

}
