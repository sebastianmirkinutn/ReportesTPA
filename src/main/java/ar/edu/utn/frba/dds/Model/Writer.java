package ar.edu.utn.frba.dds.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Writer {
    public void writeToFile(String filePath, String text) {
        BufferedWriter writer = null;
        try {
            // Crear archivo si no existe
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Obtener fecha y hora actual en el formato deseado
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            String formattedDateTime = now.format(formatter);

            // Abrir archivo en modo de adición (append) y escribir en la última línea
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine(); // Añadir una nueva línea
            writer.write("[" + formattedDateTime + "] \"" + text + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
