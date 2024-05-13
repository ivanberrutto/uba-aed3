package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable5Test {
    Entregable5 entregable5 = new Entregable5();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable5ej1.txt", entregable5.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("9\n9000", actualOutput);
    }
}