import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorMoneda consulta = new ConversorMoneda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSea bienvenido o bienvenida al conversor de Moneda");
            System.out.println("1) $Peso mexicano =>> $Dólar");
            System.out.println("2) $Dólar =>> Peso mexicano");
            System.out.println("3) $Dólar =>> Peso argentino");
            System.out.println("4) $Peso argentino =>> $Dólar");
            System.out.println("5) $Dolar  ==>> $Real brasieleño");
            System.out.println("6) $Real brasieleño  ==>> $Dolar");
            System.out.println("7) $Dolar  ==>> $peso colombiano");
            System.out.println("8) $Peso colombiano ==>> $Dolar");
            System.out.println("9) Salir");
            System.out.println("Elija una opcion valida ");

            int opcion = lectura.nextInt();
            switch (opcion) {
                case 1: // Peso mexicano a Dólar
                    convertirMoneda("MXN", "USD", consulta);
                    break;
                case 2: // Dólar a Peso mexicano
                    convertirMoneda("USD", "MXN", consulta);
                    break;
                case 3: // Dólar a Peso argentino
                    convertirMoneda("USD", "ARS", consulta);
                    break;
                case 4: // Peso argentino a Dólar
                    convertirMoneda("ARS", "USD", consulta);
                    break;
                    

                case 9: // Salir
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de moneda.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void convertirMoneda(String baseCode, String targetCode, ConversorMoneda consulta) {
        try {
            double tasa = consulta.obtenerTasa(baseCode, targetCode);
            System.out.printf("La tasa de cambio de %s a %s es: %.4f\n", baseCode, targetCode, tasa);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
