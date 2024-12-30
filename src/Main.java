import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sea bienvenido o bienvenida al conversor de Moneda");
        System.out.println("1) $Peso mexicano =>> $Dolar");
        System.out.println("2) $Dolar =>> peso mexicano");
        System.out.println("3) $Dolar  =>>$Pesor argentino");
        System.out.println("4) $Peso argentino ==>> $Dolar");
        System.out.println("5) $Dolar  ==>> $Real brasieleño");
        System.out.println("6) $Real brasieleño  ==>> $Dolar");
        System.out.println("7) $Dolar  ==>> $peso colombiano");
        System.out.println("8) $Peso colombiano ==>> $Dolar");
        System.out.println("9) Salir");
        System.out.println("Elija una opcion valida ");

        Scanner lectura = new Scanner(System.in);
        ConversorMoneda consulta = new ConversorMoneda();
        try {
            var opcionDeMoneda= Integer.valueOf(lectura.nextLine());
            Moneda moneda =consulta.tipoCambio(opcionDeMoneda);
            System.out.println("moneda = " + moneda);

        } catch (NumberFormatException e) {
            System.out.println("Opcion no valida"+e.getMessage());

        } catch (RuntimeException  e){
            System.out.println(e.getMessage());
            System.out.println("Aplicacion finalizada");
        }

    }
}