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
 * Some tests with different lists.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 19.06.2013
 */
public class Dictionary {
    
    public static Map<String, Set<String>> DeEn;
    public static Map<String, Set<String>> EnDe;
        
    /**
     * Simple method for parsing a file which stores the Strings with the edge
     * description.
     * 
     * @param fileName
     *            Path to the input file.
     * @return An array of string with each line parsed to one string.
     * @throws IOException
     */
    public static void fileReader(final String fileName)
            throws IOException {

        DeEn = new HashMap<String,Set<String>>();
        EnDe = new HashMap<String,Set<String>>();

        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String line = null;
        while ((line = in.readLine()) != null) {
            String[] splitted = line.split("\t");
            
            if (DeEn.containsKey(splitted[1])){
                DeEn.get(splitted[1]).add(splitted[2]);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(splitted[2]);
                DeEn.put(splitted[1], set);
            }
            
            if (EnDe.containsKey(splitted[2])){
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
    

    public static ArrayList<String> translate(Map<String,Set<String>> dic, String query){
        ArrayList<String> answer = new ArrayList<String>();
        if (dic.containsKey(query)){
            for (String entry : dic.get(query)){
                answer.add(entry);
            }
        }
        if (answer.isEmpty()) answer.add("Sorry, word not found"); 
        return answer;
    }
    
    public static void main(String[] strings){
        String filename = "DeutschEnglisch.txt";
        
        try {
            fileReader(filename);
        } catch (IOException e) {
            System.err.println("Dateilesefehler");
            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        int dict = 0;
        String word;
        boolean done = false;
        while (!done && dict >= 0 && dict <= 2){
            System.out.println("Which dictionary [1 = En -> De, 2= De -> En, 0 = exit]? ");
            dict = s.nextInt();
            switch (dict) {
            case 1 : System.out.println("Enter word: ");
            word = s.next();
            System.out.println(translate(EnDe,word));
            break;
            case 2 : System.out.println("Enter word: ");
            word = s.next();
            System.out.println(translate(DeEn,word));
            break;
            default : done = true; 
            }
        }
        s.close();
    }
}
