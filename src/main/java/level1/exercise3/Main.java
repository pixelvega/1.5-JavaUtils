package level1.exercise3;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String rutaDirectorio = args[0];
            String archivoSalida = "level1/exercise3/resultado.txt";

            ManageDirectory manager = new ManageDirectory();
            manager.listarContenidoRecursivo(rutaDirectorio, 0, archivoSalida);

        } else {
            System.out.println("Por favor, proporcione la ruta del directorio.");
        }
    }
}