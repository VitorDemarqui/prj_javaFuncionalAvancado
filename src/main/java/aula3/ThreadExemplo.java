package aula3;

public class ThreadExemplo {
    public static void main(String[] args) {
        /*
        BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
        //inicia e retorna o numero do thread
        BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
        barraDeCarregamento2.start();
        barraDeCarregamento3.start();

        Thread thread = new Thread(new BarraDeCarregamento2());
        Thread thread2 = new Thread(new BarraDeCarregamento3());

        thread.start();
        thread2.start();
        //2 nome diferentes de thread
        System.out.println("Nome da thread: "+thread.getName() );
        System.out.println("Nome da thread: "+thread2.getName() );*/

        GeradorDePDF iniciarGerarPDF = new GeradorDePDF();
        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(iniciarGerarPDF);

        iniciarGerarPDF.start();
        barraDeCarregamento.start();

    }
}


class GeradorDePDF extends  Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF gerado");
    }
}


class BarraDeCarregamento extends Thread {
    private final Thread initGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.initGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!initGeradorPdf.isAlive())
                break;
            System.out.println("Loading...");
        }

    }
}
  /*  class BarraDeCarregamento2 extends Thread{
        @Override
        public void run() {
            super.run();

            //trava o thread por um tempo
            try {
                Thread.sleep(5000);
                //retorna o nome do thread
                System.out.println("rodei2 - " + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

class BarraDeCarregamento3 extends Thread{
    @Override
    public void run() {
        super.run();

        //trava o thread por um tempo
        try {
            Thread.sleep(5000);
            //retorna o nome do thread
            System.out.println("rodei3 - " + this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
*/
