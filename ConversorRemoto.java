import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConversorRemoto extends Remote {

    // Metodos que el cliente puede invocar de forma remota
    // String mensaje() throws RemoteException;
    double convertirFaC(double f) throws RemoteException;
    double convertirCaF(double c) throws RemoteException;
}