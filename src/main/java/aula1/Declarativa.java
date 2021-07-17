package aula1;

import java.util.function.Function;

public class Declarativa {
    public static void main(String[] args){
        //forma Imperativo de executar a busca de usuario
        System.out.println(buscarUsuario(1));

        //metodo funcional de programar
        Function<Integer,Object> buscarUsuario = idUsuario ->
                //buscar usuario
                new Object();
        System.out.println(buscarUsuario(15));
    }

    public static Object buscarUsuario(int idUsuario){
        return new Object();
    }
}
