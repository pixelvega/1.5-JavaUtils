package level1.exercise5;

import java.io.*;

public class ManageDirectory {

    public void serializarObjeto(Serializable objeto, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado: " + objeto.toString());
        } catch (IOException e) {
            System.err.println("Error al serializar el objeto: " + e.getMessage());
        }
    }

    public Serializable deserializarObjeto(String rutaArchivo) {
        Serializable objeto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            objeto = (Serializable) ois.readObject();
            System.out.println("Objeto deserializado: " + objeto.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el objeto: " + e.getMessage());
        }
        return objeto;
    }
}
