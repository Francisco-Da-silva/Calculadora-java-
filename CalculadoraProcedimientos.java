import java.util.Scanner;

public class CalculadoraProcedimientos {

    // Método para mostrar el menú
    public static void menu() {
        System.out.println("\nIngrese una operacion:");
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Multiplicacion");
        System.out.println("4 - Division");
        System.out.println("0 - Salir");
    }

    // SUMA
    public static void suma(int num1, int num2) {
        if (num1 >= 0 && num2 >= 0) {  // Verifica si los números son positivos
            int resultado = num1 + num2;
            System.out.println("El resultado de la suma es: " + resultado);
        } else {
            System.out.println("Error: Ambos números deben ser positivos.");
        }
    }

    // RESTA (mayor - menor)
    public static void resta(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            System.out.println("Error: Ambos números deben ser positivos.");
            return;
        }

        int mayor = Math.max(num1, num2);
        int menor = Math.min(num1, num2);

        int resultado = mayor - menor;

        System.out.println("El resultado de la resta (mayor - menor) es: " + resultado);
    }

    // MULTIPLICACIÓN
    public static void multiplicacion(int num1, int num2) {
        // Verificación de números positivos
        if (num1 >= 0 && num2 >= 0) {
            int resultado = num1 * num2;
            System.out.println("El resultado de la multiplicacion es: " + resultado);
        } else {
            System.out.println("Error: Ingrese números positivos.");
        }
    }

    // DIVISIÓN (mayor / menor)
    public static void division(int num1, int num2) {
        int menor = 999, mayor = 0;

        // Determinar el menor y el mayor
        if (num1 > mayor) {
            mayor = num1;
        }
        if (num1 < menor) {
            menor = num1;
        }
        if (num2 > mayor) {
            mayor = num2;
        }
        if (num2 < menor) {
            menor = num2;
        }

        // Verificar si el menor número es cero 
        if (menor == 0) {
            System.out.println("No se puede dividir por 0.");
            return;
        }

        // Realizar la división si ambos números son positivos
        if (num1 > 0 && num2 > 0) {
            double resultado = (double) mayor / menor;
            System.out.println("El resultado de la division (mayor entre menor) es: " + resultado);
        } else {
            System.out.println("Ambos números deben ser positivos para realizar la division.");
        }
    }

    // MÉTODO PRINCIPAL
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Declaramos el Scanner
        boolean continuar = true;

        while (continuar) {
            menu();  // Mostramos el menú

            System.out.print("Opcion: ");
            int operacion = scanner.nextInt();

            // Verificamos si el usuario quiere salir
            if (operacion == 0) {
                System.out.println("Salir del programa");
                break;
            }

            // Validar operación
            while (operacion < 0 || operacion > 4) {
                System.out.println("Operacion invalida, ingrese otra opcion:");
                operacion = scanner.nextInt();
            }

            // Pedir los números
            System.out.print("Ingrese el primer numero: ");
            int num1 = scanner.nextInt();

            System.out.print("Ingrese el segundo numero: ");
            int num2 = scanner.nextInt();

            // Ejecutar operación
            switch (operacion) {
                case 1 -> suma(num1, num2);
                case 2 -> resta(num1, num2);
                case 3 -> multiplicacion(num1, num2);
                case 4 -> division(num1, num2);
            }

            // Preguntar si desea realizar otra operación
            System.out.print("¿Desea realizar otra operacion? (s/n): ");
            char respuesta = scanner.next().toLowerCase().charAt(0);
            if (respuesta != 's') {
                continuar = false;
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
