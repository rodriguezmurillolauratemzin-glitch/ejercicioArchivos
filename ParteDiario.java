import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;

public class ParteDiario {

    // Lista privada de incidencias
    private ArrayList<String> incidencias = new ArrayList<>();

    // Añadir una incidencia
    public void añadirIncidencia(String incidencia) {

        if (incidencia == null || incidencia.isBlank()) {
            throw new IllegalArgumentException(
                "La incidencia no puede ser nula ni estar vacía."
            );
        }

        incidencias.add(incidencia);
    }

    // Exportar las incidencias a un archivo
    public void exportar(String nombreFichero) {

        StringBuilder contenido = new StringBuilder();

        contenido.append("PARTE DE INCIDENCIAS\n");
        contenido.append("--------------------\n");
        contenido.append("Número de incidencias: ")
                .append(incidencias.size())
                .append("\n\n");

        for (String incidencia : incidencias) {
            contenido.append(incidencia).append("\n");
        }

        try {
            Files.writeString(Path.of(nombreFichero), contenido.toString());

            System.out.println("Informe exportado correctamente: " + nombreFichero);

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo exportar el informe.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
    
    public void registrarIncidencia(String incidencia, String nombreArchivo) {

        if (incidencia == null || incidencia.isBlank()) {
            throw new IllegalArgumentException(
                "La incidencia no puede ser nula ni estar vacía."
            );
        }

        try {
            Files.writeString(
                Path.of(nombreArchivo),
                incidencia + System.lineSeparator(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );

            System.out.println("Incidencia registrada correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo registrar la incidencia.");
            System.out.println("Motivo: " + e.getMessage());
        }
    }
}