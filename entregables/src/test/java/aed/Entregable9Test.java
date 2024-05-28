package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable9Test {
    Entregable9 entregable9 = new Entregable9();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable5ej1.txt", entregable9.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("4", actualOutput);
    }

}