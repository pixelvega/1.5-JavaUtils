package level1.exercise2;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String directoryPath = args[0];
            ManageDirectory manager = new ManageDirectory();
            manager.listarContenidoRecursivo(directoryPath, 0);  // Iniciar con nivel 0 (la raíz)
        } else {
            System.out.println("Por favor, proporcione la ruta del directorio.");
        }
    }
}
