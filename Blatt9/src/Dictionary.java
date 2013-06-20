import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * A basic dictionary that reads its words from a file.
 *
 * a) the UML diagram is just one class, because we don't need fancy structures
 * with many classes for words or translations. Everything fits in here.
 * b) We used two (Hash)Map as data structure for our two dictionaries.
 * One Map contains all the german to english words, the other one the english
 * to german translations.
 * For excactly one translation per word a Map<String,String> would suffice.
 * But as we should tune the program to return multiple translations we improved
 * our Map to a Map<String,Set<String>> that for every word of language1 holds
 * a set of words in language2. We can find the set of translations for our
 * queryword in O(1) and then iterate over the whole set of translations in the
 * set.
 * c) We limited our GUI to a commandline GUI
 * d) done
 *
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 20.06.2013
 */
public class Dictionary {
    /**
     * the german to english dictionary.
     */
    private static Map<String, Set<String>> DeEn;
    /**
     * the english to german dictionary.
     */
    private static Map<String, Set<String>> EnDe;

    /**
     * Simple method for parsing a file which stores the words.
     *
     * @param fileName
     *            Path to the input file.
     * @throws IOException if file cannot be read
     */
    public static void fileReader(final String fileName)
            throws IOException {

        DeEn = new HashMap<String, Set<String>>();
        EnDe = new HashMap<String, Set<String>>();

        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String line = null;
        while ((line = in.readLine()) != null) {
            String[] splitted = line.split("\t");

            if (DeEn.containsKey(splitted[1])) {
                DeEn.get(splitted[1]).add(splitted[2]);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(splitted[2]);
                DeEn.put(splitted[1], set);
            }

            if (EnDe.containsKey(splitted[2])) {
                EnDe.get(splitted[2]).add(splitted[1]);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(splitted[1]);
                EnDe.put(splitted[2], set);
            }
        }

        in.close();

        return;
    }

    /**
     * translate method, that returns all found translations in the given
     * dictionary for the given query string.
     * @param dic the dictionary to search in
     * @param query the word to be translated
     * @return an ArrayList of found translations.
     */
    public static ArrayList<String>
    translate(final Map<String, Set<String>> dic, final String query) {
        ArrayList<String> answer = new ArrayList<String>();
        if (dic.containsKey(query)) {
            for (String entry : dic.get(query)) {
                answer.add(entry);
            }
        }
        if (answer.isEmpty()) {
            answer.add("Sorry, word not found");
        }
        return answer;
    }

    /**
     * main method.
     * @param strings commandline args
     */
    public static void main(final String[] strings) {
        String filename = "DeutschEnglisch.txt";

        try {
            fileReader(filename);
        } catch (IOException e) {
            System.err.println("Cannot find/read file.");
            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        int dict = 0;
        String word;
        boolean done = false;
        while (!done && dict >= 0 && dict <= 2) {
            System.out.println("Which dictionary [1 = En -> De,"
                    + " 2= De -> En, 0 = exit]? ");
            dict = s.nextInt();
            switch (dict) {
            case 1 : System.out.println("Enter word: ");
            word = s.next();
            System.out.println(translate(EnDe, word));
            break;
            case 2 : System.out.println("Enter word: ");
            word = s.next();
            System.out.println(translate(DeEn, word));
            break;
            default : done = true;
            }
        }
        s.close();
    }
}
