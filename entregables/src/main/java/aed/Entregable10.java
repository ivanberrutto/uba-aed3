package aed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Entregable10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int k = scanner.nextInt();
        String[] lineaEntrada;
        lineaEntrada = scanner.nextLine().split(" ");
        int[] elevSpeed = new int[lineaEntrada.length];
        for (int i = 0; i < lineaEntrada.length; i++) {
            elevSpeed[i] = Integer.parseInt(lineaEntrada[i]);
        }
        int[][] elevPisos = new int[elevSpeed.length][];
        int largoTotal = 0;
        for(int i=0; i < elevSpeed.length ; i++){
            lineaEntrada = scanner.nextLine().split(" ");
            largoTotal += lineaEntrada.length;
            elevPisos[i] = new int[lineaEntrada.length];

            for (int j = 0; j < lineaEntrada.length; j++) {
                elevPisos[i][j] = Integer.parseInt(lineaEntrada[i]);
            }
        }


        Grafo_Pesado grafo = new Grafo_Pesado(largoTotal);


        // Diccionario que que segun pos de grafo me diga numero de piso
        // Diccionario que segun numero de piso me diga pos de grafo
        // Diccionario que segun pos de grafo me diga de que ascensor es
        HashMap<Integer, Integer> posAPiso= new HashMap<Integer, Integer>();
        //ArrayList<HashMap<Integer, Integer>> pisoAPos = null;
        HashMap<Integer, ArrayList<Integer>> pisoAPos= new HashMap<Integer, ArrayList<Integer>>();

        HashMap<Integer, Integer> posAElev= new HashMap<Integer, Integer>();
        int l = 0;
        for(k=0;k< elevSpeed.length ; k++){
            for(int i = 0 ; i < elevPisos[k].length ; i++){
                posAPiso.put(i+l,elevPisos[k][i]);
                posAElev.put(i+l,k);


                if(pisoAPos.containsKey(elevPisos[k][i])){
                    for (Integer elemento : pisoAPos.get(elevPisos[k][i])) {
                        grafo.addEdge(elemento,i+l,60);
                    }
                }
                else{
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i+l);
                    pisoAPos.put(elevPisos[k][i],arrayList);
                }

                for(int j = 0 ; j < i ; j++){
                    grafo.addEdge(i+l,j+l,elevSpeed[k]);
                }
            }
            l += elevPisos[k].length;
        }


    }
}
