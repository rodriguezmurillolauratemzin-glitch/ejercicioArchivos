public class Main {

    public static void main(String[] args) {

    ParteDiario parte = new ParteDiario();

        // Registrar tres incidencias
        parte.registrarIncidencia(
            "Ordenador del aula 1 no funciona.",
            "historial.txt"
        );

        parte.registrarIncidencia(
            "Problemas de conexión a Internet.",
            "historial.txt"
        );

        parte.registrarIncidencia(
            "El proyector del aula 2 está averiado.",
            "historial.txt"
        );
    }
}