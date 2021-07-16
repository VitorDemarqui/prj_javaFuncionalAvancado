package aula2;

import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args){
        //utilizar com classes que ajuda voce a lidar com listas arrays e conjuntos
        //suppliers sao supridores que nao recebem parametro e recebem algo que especificamos
        //supplier e bom quando chamaremos um metodo que nao necessita de parametros
        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
        Supplier<Pessoa> instanciaPessoa1 = Pessoa::new;
        System.out.println(instanciaPessoa.get());
    }
}

class Pessoa{
    private final String nome;
    private final Integer idade;

    public Pessoa(){
        nome = "joao";
        idade = 23;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", idade=" + idade;
    }
}