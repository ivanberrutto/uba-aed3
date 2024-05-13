package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entregable4Tests {
    Entregable4 entregable4 = new Entregable4();

    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable4ej1.txt", entregable4.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("YES", actualOutput);
    }

    @Test
    void testEjemploEnunciado2()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable4ej2.txt", entregable4.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("NO", actualOutput);
    }
}
