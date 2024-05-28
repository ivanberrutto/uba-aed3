package aed;

import java.util.Scanner;

public class Entregable9 {
     static int [][] valores = {{0,1,2,3,4,5,4,3,2,1} , {1,0,1,2,3,4,5,4,3,2} , {2,1,0,1,2,3,4,5,4,3} , {3,2,1,0,1,2,3,4,5,4} , {4,3,2,1,0,1,2,3,4,5} ,
            {5,4,3,2,1,0,1,2,3,4} , {4,5,4,3,2,1,0,1,2,3} , {3,4,5,4,3,2,1,0,1,2} , {2,3,4,5,4,3,2,1,0,1} , {1,2,3,4,5,4,3,2,1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numero1 = scanner.next();;
        String numero2 = scanner.next();
        System.out.println(calcularPeso(numero1,numero2));
    }

    public static int calcularPeso(String numero1 , String numero2) {
        int peso = 0;

        // Iterar sobre los dígitos de ambos números
        for (int i=0 ; i<4 ; i++) {
            // Obtener el último dígito de cada número
            int digito1 = Character.getNumericValue(numero1.charAt(i));
            int digito2 = Character.getNumericValue(numero2.charAt(i));
            peso += valores[digito1][digito2];

            // Eliminar el último dígito de cada número
        }

        return peso;
    }



}
