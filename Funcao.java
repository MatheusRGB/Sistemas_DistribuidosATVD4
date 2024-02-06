import java.rmi.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public interface Funcao extends Remote{
    public String retornar_ip() throws RemoteException;
    public String retornar_data() throws RemoteException;
    public String enviar_mensagem(String mensagem) throws RemoteException;
    public List<String> listar_mensagem() throws RemoteException;
}