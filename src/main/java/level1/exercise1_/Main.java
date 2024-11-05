package level1.exercise1_;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Por favor, proporciona un directorio como argumento.");
            return;
        }

        String directoryPath = args[0];
        ManageDirectory directorios = new ManageDirectory();

        directorios.listSortedContentASC(directoryPath);
    }
}
