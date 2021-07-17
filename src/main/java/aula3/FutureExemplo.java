package aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class FutureExemplo {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        //limita as thread
        Casa casa = new Casa(new Quarto());
        //para cada atividade manda uma pessoa executar
        List<Future<String>> futuros =
                casa.obterAfazeresDaCasa().stream()
                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                                try {
                                    return atividade.realizar();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            return null;
                            })
                        ).collect(Collectors.toCollection(CopyOnWriteArrayList::new));


        while (true){
            int numeroDeAtividadesNaoFinalizadas = 0;
            for(Future<?> futuro : futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabens voce terminou de " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }
            if(futuros.stream().allMatch(Future::isDone)) break;

            System.out.println("Numero de atividades nao finalizadas : "+numeroDeAtividadesNaoFinalizadas);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //mata a execucao
        pessoasParaExecutarAtividade.shutdown();

    }
}


class Casa{
    private final List<Comodo> comodos;

    Casa(Comodo... comodos){this.comodos = Arrays.asList(comodos);}

    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo,atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo{
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo{
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        new ArrayList<>();

        return Arrays.asList(
                this::arrumarAcama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String arrumarQuarto = "Arrumar o guarda roupa";
        System.out.println("Arrumar o guarda roupa");
        return arrumarQuarto;
    }

    private String varrerOQuarto(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String varrerOQuarto = "Varrer o quarto";
        System.out.println("Varrer o quarto");
        return varrerOQuarto;
    }

    private String arrumarAcama(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String arrumarACama = "Arrumar a cama";
        System.out.println("Arrumar a cama");
        return arrumarACama;
    }
}

