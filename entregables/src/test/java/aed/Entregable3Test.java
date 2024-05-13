package aed;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class Entregable3Test {
    Entregable3 entregable3 = new Entregable3();

    @Test
    void testEjemploEnunciado()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable3ej1.txt", entregable3.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("8", actualOutput);
    }


}
