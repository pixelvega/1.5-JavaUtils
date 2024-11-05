package level1.exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ManageDirectory {

    public void listarContenidoRecursivo(String rutaDirectorio, int nivel, String archivoSalida) {
        File directorio = new File(rutaDirectorio);
        String[] contenido = directorio.list();

        if (contenido != null) {
            Arrays.sort(contenido);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida, true))) {
                for (String nombre : contenido) {
                    File archivo = new File(directorio, nombre);

                    StringBuilder line = new StringBuilder();

                    for (int i = 0; i < nivel; i++) {
                        line.append("    ");
                    }

                    if (archivo.isDirectory()) {
                        line.append("[D] ").append(nombre).append(" (Última modif.: ").append(sdf.format(new Date(archivo.lastModified()))).append(")");
                        writer.write(line.toString());
                        writer.newLine();

                        listarContenidoRecursivo(archivo.getAbsolutePath(), nivel + 1, archivoSalida);
                    } else {
                        line.append("[F] ").append(nombre).append(" (Última modif.: ").append(sdf.format(new Date(archivo.lastModified()))).append(")");
                        writer.write(line.toString());
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El directorio no existe o no se pudo acceder: " + rutaDirectorio);
        }
    }

    public void leerArchivoTxt(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + rutaArchivo);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("Contenido del archivo " + rutaArchivo + ":");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
