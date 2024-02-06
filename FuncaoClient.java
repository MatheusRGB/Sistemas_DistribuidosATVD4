import java.rmi.Naming;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncaoClient{
    private static Funcao cliente = null;

    public static void main(String[] args){
        try{
            cliente = (Funcao) Naming.lookup("rmi://10.0.2.15:11099/RMIInterface");
            System.out.println(String.valueOf(cliente.retornar_ip()));
            System.out.println(String.valueOf(cliente.retornar_data()));
            cliente.enviar_mensagem("Primeira mensagem!");
            cliente.enviar_mensagem("Segunda mensagem!");
            
            List<String> textos = cliente.listar_mensagem();

            textos= cliente.listar_mensagem();

            for (String mensagem : textos) {
                System.out.println(mensagem);
            }
        }
        catch(Exception e){
            System.out.println("Trouble " + e);
        }
    }
}