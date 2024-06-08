package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable11Test {
    Entregable11 entregable11 = new Entregable11();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable11ej1.txt", entregable11.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("lamentable kingdom" + System.lineSeparator() + "successful conspiracy", actualOutput);
    }
}