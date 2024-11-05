package level1.exercise1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;


public class ManageDirectory {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Properties config;

    public ManageDirectory() {
        config = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            config.load(input);
            System.out.println("Configuration loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    public String getConfigProperty(String key) {
        return config.getProperty(key);
    }

    public void sortAndListDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("Directory not found.");
            return;
        }

        String[] files = directory.list();
        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            System.out.println("Files in directory \"" + directoryPath + "\":");

            for (String file : files) {
                System.out.println(file);
            }

        } else {
            System.out.println("The directory is empty.");
        }
    }

    public void sortAndListDirectoryTree(String directoryPath, String indent) {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

            for (File file : files) {
                String type = file.isDirectory() ? "D" : "F";

                String lastModified = dateFormat.format(new Date(file.lastModified()));
                System.out.printf("%s[%s] %s - Last Modified: %s%n", indent, type, file.getName(), lastModified);

                if (file.isDirectory()) {
                    sortAndListDirectoryTree(file.getAbsolutePath(), indent + "    ");
                }
            }

        } else {
            System.out.println("The directory is empty.");
        }
    }

    public void saveDirectoryTreeToFile(String directoryPath, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            saveDirectoryTreeRecursive(directoryPath, "", writer);
            System.out.println("Directory tree saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        }
    }

    private void saveDirectoryTreeRecursive(String directoryPath, String indent, FileWriter writer) throws IOException {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            writer.write("The specified path is not a directory.\n");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

            for (File file : files) {
                String type = file.isDirectory() ? "D" : "F";
                String lastModified = dateFormat.format(new Date(file.lastModified()));
                writer.write(String.format("%s[%s] %s - Last Modified: %s%n", indent, type, file.getName(), lastModified));

                if (file.isDirectory()) {
                    saveDirectoryTreeRecursive(file.getAbsolutePath(), indent + "    ", writer);
                }
            }
        } else {
            writer.write("The directory is empty.\n");
        }
    }

    public void readTextFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid file.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Content of \"" + filePath + "\":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file." + e);
        }
    }

    public void serializeObject(Object obj, String outputFilePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
            objectOutputStream.writeObject(obj);
            System.out.println("Object serialized to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("An error occurred while serializing the object." + e);
        }
    }

    public Object deserializeObject(String inputFilePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(inputFilePath))) {
            Object obj = objectInputStream.readObject();
            System.out.println("Object deserialized from: " + inputFilePath);
            return obj;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while deserializing the object.");
        }

        return null;
    }


}

