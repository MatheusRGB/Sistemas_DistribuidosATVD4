import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncaoServer extends UnicastRemoteObject implements Funcao{
    public FuncaoServer() throws RemoteException{
        super();
    }

    @Override
    public String retornar_ip() throws RemoteException{
        return "10.0.2.15";

    }

    @Override
    public String retornar_data() throws RemoteException{
        LocalDateTime agora = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        return agora.format(formatter);
        
    }

    private static List<String> mensagens = new ArrayList<>();

    @Override
    public String enviar_mensagem(String mensagem) throws RemoteException{
        mensagens.add(mensagem);
        return "Mensagem enviada!";
    }
    
    @Override
    public List<String> listar_mensagem() throws RemoteException{
        return mensagens;

    }

    public static void main(String[] args){
        try{
            FuncaoServer server = new FuncaoServer();
            System.out.println("Servidor Online!\n");
            Naming.rebind("rmi://10.0.2.15:11099/RMIInterface", new FuncaoServer());
        } catch (Exception e){
            System.out.println("Troube: " + e);
        }    
    }
}