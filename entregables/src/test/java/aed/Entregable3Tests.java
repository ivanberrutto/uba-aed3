package aed;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import static aed.TestFunciones.probarEjercicio;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class Entregable3Tests {
    Entregable3 entregable3 = new Entregable3();

    @Test
    void testEjemploEnunciado()  {
        // Lee el archivo de entrada
        String actualOutput = probarEjercicio("entregable3ej.txt", entregable3.getClass());

        // Verificar si la salida coincide con el resultado esperado
        assertEquals("8", actualOutput);
    }


}
