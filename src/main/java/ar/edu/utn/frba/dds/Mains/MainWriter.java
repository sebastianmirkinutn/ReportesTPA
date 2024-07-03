package ar.edu.utn.frba.dds.Mains;
import ar.edu.utn.frba.dds.Model.Writer;

public class MainWriter {
    public static void main(String[] args) {
        Writer writer = new Writer();
        writer.writeToFile(args[1], "Resultado reporte");
    }
}
