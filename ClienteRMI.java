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

                System.out.println("\nElija una opcion: ");
                System.out.println("1. Farenheit a Celsius");
                System.out.println("2. Celsius a Farenheit");
                System.out.println("3. Salir");
                System.out.print("Ingresa la opcion: ");
                opcion = escaner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("\nIngresa la temperatura: ");
                        numero = escaner.nextInt();

                        respuesta = objetoRemoto.convertirFaC(numero);
                        System.out.println("\nCelsius: " + respuesta + " °C");
                        break;
                    case 2:
                        System.out.print("\nIngresa la temperatura: ");
                        numero = escaner.nextInt();

                        respuesta = objetoRemoto.convertirCaF(numero);
                        System.out.println("\nFarenheit: " + respuesta + " °F");
                        break;
                    case 3:
                        System.out.println("\nAdios!");
                        break;
                    default:
                        System.out.println("Opcion no valida!");
                        break;
                }

            } while (opcion != 3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        escaner.close();
    }
}
