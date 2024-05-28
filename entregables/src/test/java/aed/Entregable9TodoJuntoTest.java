package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable9TodoJuntoTest {
    Entregable9TodoJunto entregable9TodoJunto = new Entregable9TodoJunto();
    @Test
    void testEjemploEnunciado5()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable9ej5.txt", entregable9TodoJunto.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("16" + System.lineSeparator() + "20" + System.lineSeparator() + "26" + System.lineSeparator() + "17", actualOutput);
    }
}