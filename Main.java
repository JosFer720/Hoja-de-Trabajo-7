/**Fernando Ruiz 23065
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase principal que lee archivos de texto para construir un diccionario y traducir texto.
 */
public class Main {
    /**
     * Método principal que maneja la lectura de archivos de texto y la traducción del contenido.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear un árbol binario para almacenar el diccionario
        BinaryTree<String, Association<String, String>> dictionaryTree = new BinaryTree<>();

        // Leer el archivo dictionary.txt y construir el diccionario
        try {
            File dictionaryFile = new File("dictionary.txt");
            Scanner dictionaryScanner = new Scanner(dictionaryFile);

            while (dictionaryScanner.hasNextLine()) {
                String line = dictionaryScanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String englishWord = parts[0].substring(1);
                    String spanishWord = parts[1].substring(0, parts[1].length() - 1);
                    Association<String, String> association = new Association<>(spanishWord, null);
                    dictionaryTree.insert(englishWord, association);
                }
            }

            dictionaryScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: dictionary.txt not found.");
            e.printStackTrace();
        }
        dictionaryTree.inOrderTraversal();

        // Leer el archivo texto.txt y traducir el contenido
        try {
            File textFile = new File("texto.txt");
            Scanner textScanner = new Scanner(textFile);

            while (textScanner.hasNextLine()) {
                String line = textScanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase(); // Convertir a minúsculas para buscar en el diccionario
                    Association<String, String> translated = dictionaryTree.search(word);
                    if (translated != null) {
                        System.out.print(translated.getKey() + " ");
                    } else {
                        System.out.print(word + " ");
                    }
                }
                System.out.println();
            }

            textScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: texto.txt not found.");
            e.printStackTrace();
        }
    }
}