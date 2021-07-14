package fatorialRecursivo;

public class FatorialTailCall {
    public static void main(String[] args){
        //chama o metodo recursivo
        System.out.println(fatorialA(200));
    }

    private static double fatorialA(double valor1) {
        return fatorialComTailCall(valor1,1);
    }

    private static double fatorialComTailCall(double valor, double numero){
        if (valor ==0 ){
            return numero;
        }
        //recursao, multiplicando do valor e subtraindo
        return fatorialComTailCall(valor-1, numero*valor);
    }
}
