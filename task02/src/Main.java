import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        // accept input from user with args[0], in this case it will be "../texts"
        File directory = new File(args[0]);
        List<File> files = new ArrayList<>();

        // call method to add files from given directory into List files
        addFiles(directory, files);

        // new HashMaps to store word count values as well as next word values
        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, Map<String, Integer>> nextWord = new HashMap<>();

        // for each loop to read each file line by line
        // line 35 will strip it of all punctuation and make every word lowercase, as
        // well as split to a array
        // line 37 is a for i loop that will go through the current word and next word
        // in the array
        // this is so we can update our word count and next word maps
        for (File file : files) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (int i = 0; i < words.length - 1; i++) {
                    String currentWord = words[i];
                    String next = words[i + 1];

                    // update word count map
                    wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0) + 1);

                    // initialise new current word map
                    // add next word info inside
                    // update next word map 
                    Map<String, Integer> currentWordMap = nextWord.getOrDefault(currentWord, new HashMap<>());
                    currentWordMap.put(next, currentWordMap.getOrDefault(next, 0) + 1);
                    nextWord.put(currentWord, currentWordMap);
                }
            }
            // close bufferedreader to clear warning and release resources
            br.close();
        }

        // another for each loop to go through the map and update total count
        // probability is calculated by dividing frequency by total count
        for (String word : nextWord.keySet()) {
            Map<String, Integer> currentWordMap = nextWord.get(word);
            int totalCount = wordCount.get(word);

            for (String next : currentWordMap.keySet()) {
                int frequency = currentWordMap.get(next);
                double probability = (double) frequency / totalCount;

                // then we will print each word
                // followed by a new line with some spacing to follow sample output given in
                // assessment paper
                System.out.println(word);
                System.out.println("    " + next + " " + String.format("%.2f", probability));
            }
        }

    }

    // method to add files into list to read from
    // needed for calling the same method within a method to access subdirectories
    // (recursive)
    public static void addFiles(File directory, List<File> files) {
        File[] fileList = directory.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    addFiles(file, files);
                }
            }
        }
    }

}
