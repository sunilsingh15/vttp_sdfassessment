import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) throws Exception {

        File directory = new File(args[0]);
        List<File> files = new ArrayList<>();

        addFiles(directory, files);

        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, Map<String, Integer>> nextWord = new HashMap<>();

        for (File file : files) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                


            }
        }

        


    }

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
