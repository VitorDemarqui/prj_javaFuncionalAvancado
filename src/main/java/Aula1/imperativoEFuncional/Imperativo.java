package Aula1.imperativoEFuncional;

public class Imperativo {
    public static void main(String[] args){
        //paradigma imperativo executa instruçoes funciona como ordens de computador,
        //alem disso as funcoes sao instantaneas a partir do momento que indica elas, elas estao sendo executadas

        //fala pro computador que o valor é igual a 10 na memoria
        int valor = 10;//instrucao
        //pega mais memoria do computador e coloca na memoria
        int resultado = valor * 3;//instrucao

        System.out.println("O resultado é:"+resultado);//instrucao
    }

    //impossivel chamar um metodo passando parametro um objeto
    //impossivel com o metodo imperativo
    //com programação ficarica muito facil


    // public void calcular(somar(x,y)){}
    public int somar(int x, int y){
        return x + y;
    }
}
