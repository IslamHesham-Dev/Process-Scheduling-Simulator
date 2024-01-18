import javafx.scene.chart.LineChart;

import java.io.*;
import java.util.ArrayList;

public class Parser {

    private File workingDirectory ;
    private ArrayList<String> programFiles ;
    private ArrayList<Program> programs;
    public Parser(String dir){
        this.workingDirectory = new File(dir);
        this.programFiles = new ArrayList<String>();
        this.programs = new ArrayList<Program>();
    }

    public void fileFinder (String extension){
        File[] srcFiles = this.workingDirectory.listFiles();
        if(srcFiles!=null){
            for (File file : srcFiles){
                if(file.isFile() && file.getName().endsWith(extension))
                    this.programFiles.add(file.getPath());
            }
        }
    }

    public ArrayList<String> getFiles (){
        return this.programFiles;
    }
    public ArrayList<Program> getPrograms (){
        return this.programs;
    }
    public void setWorkingDirectory(String s){
        this.workingDirectory=new File(s);
    }


    public void fileParser (String file) throws Exception {
        Program currProgram = new Program();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String test;
            while ((test = bufferedReader.readLine())!=null){
                currProgram.addInstruction(test);
            }
            currProgram.setEndAddress();
            this.programs.add(currProgram);
        }
        catch (Exception e ){
            System.out.println("Error parsing file : "+ file);
        }


    }

}
