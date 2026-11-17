import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class ArchivosDemo {
    
 public static void main(String[] args) {

        Path ruta = Path.of("mensaje.txt");

        try {
            Files.writeString(ruta, "Hola, Mundo\n");
            System.out.println("Archivo guardado correctamente.");

        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo.");
            System.out.println(e.getMessage());
        }
        leerArchivo(ruta);
    }

    public static void leerArchivo(Path ruta) {
        try {
            String contenido = Files.readString(ruta);

            System.out.println("Contenido del archivo:");
            System.out.println(contenido);

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
    
}