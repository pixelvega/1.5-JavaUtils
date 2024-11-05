package level1.exercise5;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String filePath = args[0];
            String rutaArchivoSalida = "exercise5/sampleObject.ser";
            File outputDir = new File("exercise5");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }


            File fileToSerialize = new File(filePath);
            if (fileToSerialize.exists() && !fileToSerialize.isDirectory()) {
                SampleObject sampleObject = new SampleObject(
                        fileToSerialize.getName(),
                        fileToSerialize.length(),
                        new Date(fileToSerialize.lastModified())
                );


                ManageDirectory manager = new ManageDirectory();
                manager.serializarObjeto(sampleObject, rutaArchivoSalida);


                SampleObject deserializedSampleObject = (SampleObject) manager.deserializarObjeto(rutaArchivoSalida);

            } else {
                System.out.println("El archivo no existe o es un directorio: " + filePath);
            }
        } else {
            System.out.println("Por favor, proporcione la ruta del archivo a serializar.");
        }
    }
}
