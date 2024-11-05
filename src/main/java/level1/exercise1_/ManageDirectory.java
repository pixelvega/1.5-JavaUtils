package level1.exercise1_;

import java.io.File;
import java.util.Arrays;

public class ManageDirectory {

    public void listSortedContentASC(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("La ruta proporcionada no es un directorio válido.");
            return;
        }

        String[] content = directory.list();
        if (content != null) {
            Arrays.sort(content);
            System.out.println("Contenido del directorio \"" + directoryPath + "\":");
            for (String fileName : content) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No se pudo acceder al contenido del directorio.");
        }
    }
}
