import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// import the Association class here

public class Main {
    public static void main(String[] args) {
        BinaryTree<String, Association<String, String>> dictionaryTree = new BinaryTree<>();

        // Leer el archivo dictionary.txt
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

        // Leer el archivo texto.txt
        try {
            File textoFile = new File("texto.txt");
            Scanner textoScanner = new Scanner(textoFile);

            while (textoScanner.hasNextLine()) {
                String line = textoScanner.nextLine();
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

            textoScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: texto.txt not found.");
            e.printStackTrace();
        }
    }
}