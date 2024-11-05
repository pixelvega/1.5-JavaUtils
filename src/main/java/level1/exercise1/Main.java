package level1.exercise1;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:");
            System.out.println("java Main <command> <directory_path> [additional_parameters]");
            System.out.println("Commands: list, tree, save_tree, read, serialize, deserialize");
            return;
        }

        String command = args[0];
        String path = args[1];
        ManageDirectory manager = new ManageDirectory();

        switch (command.toLowerCase()) {
            case "list":
                System.out.println("Ejecutando Ejercicio 1: Listar el contenido de un directorio alfabéticamente.");
                manager.sortAndListDirectory(path);
                break;

            case "tree":
                System.out.println("Ejecutando Ejercicio 2: Listar el árbol de directorios recursivamente.");
                manager.sortAndListDirectoryTree(path, "");
                break;

            case "save_tree":
                if (args.length != 3) {
                    System.out.println("Please specify an output file path for save_tree.");
                    return;
                }
                String outputFilePath = args[2];
                System.out.println("Ejecutando Ejercicio 3: Guardar el árbol de directorios en un archivo .txt.");
                manager.saveDirectoryTreeToFile(path, outputFilePath);
                break;

            case "read":
                System.out.println("Ejecutando Ejercicio 4: Leer y mostrar el contenido de un archivo TXT.");
                manager.readTextFile(path);
                break;

            case "serialize":
                System.out.println(args);
                if (args.length != 3) {
                    System.out.println("Please, specify an output file path for serialization.");
                    return;
                }
                String serializeOutputPath = args[2];
                SampleObject sample = new SampleObject("Juan Perez", 30);
                System.out.println("Ejecutando Ejercicio 5: Serializar un objeto Java.");
                manager.serializeObject(sample, serializeOutputPath);
                break;

            case "deserialize":
                System.out.println("Ejecutando Ejercicio 5: Deserializar un objeto Java.");
                Object deserializedObj = manager.deserializeObject(path);
                System.out.println("Objeto deserializado: " + deserializedObj);
                break;

            default:
                System.out.println("Invalid command. Use:\n 'list'\n, 'tree'\n, 'save_tree'\n, 'read'\n, 'serialize'\n, or 'deserialize'.");
                break;
        }

    }
}

