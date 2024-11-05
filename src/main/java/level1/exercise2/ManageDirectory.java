package level1.exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ManageDirectory {

    public void listarContenidoRecursivo(String rutaDirectorio, int nivel) {
        File directorio = new File(rutaDirectorio);
        String[] contenido = directorio.list();

        if (contenido != null) {
            Arrays.sort(contenido);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (String nombre : contenido) {
                File archivo = new File(directorio, nombre);

                for (int i = 0; i < nivel; i++) {
                    System.out.print("    ");
                }

                if (archivo.isDirectory()) {
                    System.out.println("[D] " + nombre + " (Última modif.: " + sdf.format(new Date(archivo.lastModified())) + ")");

                    listarContenidoRecursivo(archivo.getAbsolutePath(), nivel + 1);
                } else {
                    System.out.println("[F] " + nombre + " (Última modif.: " + sdf.format(new Date(archivo.lastModified())) + ")");
                }
            }
        } else {
            System.out.println("El directorio no existe o no se pudo acceder: " + rutaDirectorio);
        }
    }
}
