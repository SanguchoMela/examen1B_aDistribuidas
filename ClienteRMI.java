import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        try {
            // Obtener el registro 
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
    
            // Crear instancia de la implementación la interfaz 
            ConversorRemoto objetoRemoto = (ConversorRemoto) registro.lookup("ClienteRemoto");

            int opcion = 0;
            double numero = 0;
            double respuesta = 0;

            do {
                System.out.println("\nIngresa el numero a convertir: ");
                numero = escaner.nextInt();

                System.out.println("\nOpciones de conversion");
                System.out.println("1. Farenheit a Celsius");
                System.out.println("2. Celsius a Farenheit");
                System.out.println("3. Salir");
                System.out.print("Ingresa la opcion: ");
                opcion = escaner.nextInt();

                switch (opcion) {
                    case 1:
                        respuesta = objetoRemoto.convertirFaC(numero);
                        System.out.println("Celsius: " + respuesta + "°C");
                        break;
                    case 2:
                        respuesta = objetoRemoto.convertirCaF(numero);
                        System.out.println("Farenheit: " + respuesta + "°F");
                        break;
                    default:
                        System.out.println("Adios!");
                        break;
                }

            } while (opcion != 3);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        escaner.close();
    }
}
