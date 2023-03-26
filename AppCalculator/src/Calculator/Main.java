
package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num1, num2;
        System.out.print("Ingrese el primer numero: ");
        num1 = input.nextDouble();
        System.out.print("Ingrese el segundo numero: ");
        num2 = input.nextDouble();

        System.out.println("Seleccione operacion");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        int choice;
        System.out.print("Ingrese opcion (1/2/3/4): ");
        choice = input.nextInt();
        
        Operations.Operations(num1, num2, choice);
    }
}
