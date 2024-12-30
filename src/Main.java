import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorMoneda consulta = new ConversorMoneda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("**********************************************************");
            System.out.println("\nSea bienvenido o bienvenida al conversor de Moneda =]");
            System.out.println("1) $Peso mexicano =>> $Dólar");
            System.out.println("2) $Dólar =>> Peso mexicano");
            System.out.println("3) $Dólar =>> Peso argentino");
            System.out.println("4) $Peso argentino =>> $Dólar");
            System.out.println("5) $Dolar  ==>> $Real brasieleño");
            System.out.println("6) $Real brasieleño  ==>> $Dolar");
            System.out.println("7) $Dolar  ==>> $peso colombiano");
            System.out.println("8) $Peso colombiano ==>> $Dolar");
            System.out.println("9) Salir");
            System.out.println("Por favor, elija una opción: ");
            System.out.println("**********************************************************");

            try {
                // Verifica si la entrada es un número
                if (lectura.hasNextInt()) {
                    int opcion = lectura.nextInt(); // Si es un número, continúa

                    // Solicitamos la cantidad después de seleccionar la opción
                    System.out.println("Por favor, ingrese la cantidad: ");
                    double cantidad = lectura.nextDouble();

                    switch (opcion) {
                        case 1: // Peso mexicano a Dólar
                            convertirMoneda("MXN", "USD", consulta,cantidad);
                            break;
                        case 2: // Dólar a Peso mexicano
                            convertirMoneda("USD", "MXN", consulta,cantidad);
                            break;
                        case 3: // Dólar a Peso argentino
                            convertirMoneda("USD", "ARS", consulta,cantidad);
                            break;
                        case 4: // Peso argentino a Dólar
                            convertirMoneda("ARS", "USD", consulta,cantidad);
                            break;
                        case 5: // Dólar a Real brasileño
                            convertirMoneda("USD", "BRL", consulta,cantidad);
                            break;
                        case 6: // Real brasileño a Dólar
                            convertirMoneda("BRL", "USD", consulta,cantidad);
                            break;
                        case 7: // Dólar a Peso colombiano
                            convertirMoneda("USD", "COP", consulta,cantidad);
                            break;
                        case 8: // Peso colombiano a Dólar
                            convertirMoneda("COP", "USD", consulta,cantidad);
                            break;
                        case 9: // Salir
                            continuar = false;
                            System.out.println("Gracias por usar el conversor de moneda.");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }

                } else {
                    // Si la entrada no es un número, limpia el buffer y muestra un mensaje
                    String input = lectura.nextLine(); // Lee la entrada errónea
                    System.out.println("Entrada no válida: " + input + ". Por favor, ingrese un número.");
                }
            } catch (NumberFormatException e){
                System.out.println("Número no encontrado "+e.getMessage());
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
    }

    private static void convertirMoneda(String baseCode, String targetCode, ConversorMoneda consulta,double cantidad) {
        try {
            double tasa = consulta.obtenerTasa(baseCode, targetCode);
            double resultado = cantidad * tasa;
            System.out.printf("La tasa de cambio de %s a %s es: %.2f\n", baseCode, targetCode, tasa);
            System.out.printf("La cantidad de %.2f %s es igual a %.2f %s.\n", cantidad, baseCode, resultado, targetCode);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
