import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        char userInput = '0';
        Parser parser = new Parser("src");
        parser.fileFinder(".txt");
        for (String s : parser.getFiles()) {
            parser.fileParser(s);
        }

        Scheduler scheduler = new Scheduler();
        for (Program x : parser.getPrograms()) {
            scheduler.addToReadyQueue(x.getProcess());
        }
        Memory memory = new Memory();
        ExecutionQueue executionQueue =  scheduler.scheduleRoundRobin();
        executionQueue.executeQueue(memory);
        memory.showMemory();
    }
}
