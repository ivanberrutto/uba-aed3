package aed;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFunciones {

    public static String probarEjercicio(String pathtext,Class ejercicio)  {
        try {
            String input = Files.readString(Paths.get(pathtext));

            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Capturar salida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            // Llamar al método que resuelve el problema
            ejercicio.getMethod("main", String[].class).invoke(null, (Object) null);
            String actualOutput = outContent.toString().trim(); // Obtener salida sin espacios en blanco
            return actualOutput;
        } catch (IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
