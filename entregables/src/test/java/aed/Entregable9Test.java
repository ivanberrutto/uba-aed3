package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable9Test {
    Entregable9 entregable9 = new Entregable9();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej1.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("16", actualOutput);
    }
    @Test
    void testEjemploEnunciado2()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej2.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("20", actualOutput);
    }
    @Test
    void testEjemploEnunciado3()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej3.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("26", actualOutput);
    }
    @Test
    void testEjemploEnunciado4()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej4.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("17", actualOutput);
    }

    @Test
    void testEjemploEnunciado5()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej5.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("16" + System.lineSeparator() + "20" + System.lineSeparator() + "26" + System.lineSeparator() + "17", actualOutput);
    }

}