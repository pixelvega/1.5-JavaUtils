package level1.exercise4;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            String rutaDirectorio = args[0];
            String archivoSalida = "level1/exercise4/resultado.txt";

            ManageDirectory manager = new ManageDirectory();
            manager.listarContenidoRecursivo(rutaDirectorio, 0, archivoSalida);
            manager.leerArchivoTxt(args[1]);
        } else {
            System.out.println("Por favor, proporcione la ruta del directorio y el archivo TXT.");
        }
    }
}
