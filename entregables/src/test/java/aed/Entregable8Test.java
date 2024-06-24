package aed;

import org.junit.jupiter.api.Test;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.*;

class Entregable8Test {
    Entregable8 entregable8 = new Entregable8();
    @Test
    void testEjemploEnunciado1()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable8ej1.txt", entregable8.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("2 3"+ System.lineSeparator() +"3 3"+ System.lineSeparator() +"4 2"+ System.lineSeparator() + "0 1", actualOutput);
    }
}