import java.util.ArrayList;

public class Program {

    private int nextInstruction;
    private ArrayList<Instruction> prog ;
    private int  startAddress, endAddress, processId ;
    private static int currAddress = 1000 ;
    private Process p;

    public int getEndAddress() {
        return endAddress;
    }

    public void setEndAddress() {
        this.endAddress = currAddress++;
    }

    public Program (){
        this.startAddress = currAddress;
        this.prog = new ArrayList<Instruction>();
        p = new Process(this);
    }


    public int getStartAddress() {
        return startAddress;
    }

    public Process getProcess() {
        return p;
    }

    public void addInstruction(String s) throws Exception {
        Instruction x =new Instruction(s,this,currAddress++);
        this.prog.add(x);
    }
    public int totalExecTime(){
        int e=0;
        for(Instruction instruction: prog){
            e+=instruction.getExecTime();
        }
        return e;
    }



    public Instruction getInstruction (int i){
        return this.prog.get(i);
    }
    public ArrayList<Instruction> getProgram (){
        return this.prog;
    }

    @Override
    public String toString() {
        String currentProg = "Current Program : Starting From Address " + startAddress  ;

        return currentProg;
    }



    /*    public static void main(String[] args) {
        int[] x = {5,2};
        int i = 0 ;
        System.out.println(x[i]);
        System.out.println(x[i++]);
        System.out.println(i);
    }*/
}
