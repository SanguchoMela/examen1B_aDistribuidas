import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversorRemotoImpl extends UnicastRemoteObject implements ConversorRemoto {
    
    public ConversorRemotoImpl() throws RemoteException{
        super();
    }

    @Override
    public double convertirFaC(double f){
        return ((f - 32) * 5/9);
    }

    @Override
    public double convertirCaF(double c){
        return ((c * 9/5) + 32);
    }
}
