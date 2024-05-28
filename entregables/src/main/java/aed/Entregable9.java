package aed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Entregable9 {
     static int [][] valores = {{0,1,2,3,4,5,4,3,2,1} , {1,0,1,2,3,4,5,4,3,2} , {2,1,0,1,2,3,4,5,4,3} , {3,2,1,0,1,2,3,4,5,4} , {4,3,2,1,0,1,2,3,4,5} ,
            {5,4,3,2,1,0,1,2,3,4} , {4,5,4,3,2,1,0,1,2,3} , {3,4,5,4,3,2,1,0,1,2} , {2,3,4,5,4,3,2,1,0,1} , {1,2,3,4,5,4,3,2,1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Grafo_Pesado grafo = new Grafo_Pesado(n);
        HashMap<Integer, String> numerosDeCadaPos= new HashMap<Integer, String>();

        int rolls =0;

        for(int i = 0 ; i < n ; i++){
            String contra = scanner.next();
            numerosDeCadaPos.put(i,contra);
            for(int j = 0 ; j < i ; j++){
                int pesoArista = calcularPeso(numerosDeCadaPos.get(j),contra);
                grafo.addEdge(i,j,pesoArista);
                grafo.addEdge(j,i,pesoArista);
            }
        }
        int nodoInicial = 0;
        int nodoInicialMinimo = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int pesocalculado =calcularPeso("0000",numerosDeCadaPos.get(i));
            if (pesocalculado<nodoInicialMinimo){
                nodoInicial = i;
                nodoInicialMinimo = pesocalculado;
            }
        }
        //grafo.printGraph();
        rolls += nodoInicialMinimo;
        rolls += grafo.primMST(nodoInicial);
        System.out.println(rolls);

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
