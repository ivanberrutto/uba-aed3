package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable10Test {
    Entregable10 entregable10 = new Entregable10();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable10ej1.txt", entregable10.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("275" + System.lineSeparator() + "285" + System.lineSeparator() + "3920" + System.lineSeparator() + "IMPOSSIBLE", actualOutput);
    }
}