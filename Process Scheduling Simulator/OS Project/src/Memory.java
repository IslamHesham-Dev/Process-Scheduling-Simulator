import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Memory {
    private Map<String, Object> variables;
    private Set<String> fileNames;
    private static int noOfFiles = 0 ;

    Memory() {
        variables = new HashMap<>();
        fileNames = new HashSet<>();
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public Set<String> getFileNames() {
        return fileNames;
    }

    public void assignValue(String variable, Object value) {
        variables.put(variable, value);
    }

    public Object readValue(String variable) {
        return variables.getOrDefault(variable, null);
    }

    public void writeFile(String fileName, String data) {
        Path path = Path.of("src/"+fileName);
        try {
            ArrayList<String> fileData = new ArrayList<String>(); fileData.add(data);
            Files.write(path,fileData , StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Writing to file " + fileName + ": " + data);
            fileNames.add(fileName);
            noOfFiles++;
        }
        catch (IOException e){
            System.out.println("Writing to file failed");
        }
    }

    public String readFile(String fileName) {
        String fileData = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String test;
            while ((test = bufferedReader.readLine())!=null){
                fileData+= test+"\n";
            }
            System.out.println("Reading from file " + fileName);
        }
        catch (Exception e ){
            System.out.println("Error parsing file : "+ fileName);
        }
        return fileData;
    }
    public void showMemory(){
        System.out.println("Memory: \n-----------|-------------\n  variable |     value   \n");
        for(String key : variables.keySet()){
            System.out.println("  "+key+"        |       "+variables.get(key)+"\n");
        }
        System.out.println(variables);
    }
}