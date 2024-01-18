import java.util.Scanner;

public class Executor {
    private Instruction currentInst ;
    public Executor(){
        currentInst = null ;
    }

    public void setCurrentInst(Instruction i) {
        currentInst = i ;
    }

    public void executeCurrentInstruction (Memory memory ) {
        int x , y ;
        switch (currentInst.getType()){
            case 'a':
                switch (currentInst.getSecondaryOptype()){
                    case 'i':
                        Scanner scanner = new Scanner(System.in); System.out.println("Enter Integer value to assign to variable "+currentInst.getVariable()[0]);
                        memory.assignValue(currentInst.getVariable()[0],scanner.nextInt());
                        break;
                    case 'o' :
                        x = (int) memory.readValue(currentInst.getOperands()[0]);
                        y = (int) memory.readValue(currentInst.getOperands()[1]);
                        switch (currentInst.getOperation()){
                            case'+':
                                memory.assignValue(currentInst.getVariable()[0], x+y);
                                break;
                            case'-':
                                memory.assignValue(currentInst.getVariable()[0], x-y);
                                break;
                            case'*':
                                memory.assignValue(currentInst.getVariable()[0], x*y);

                                break;
                            case'/':
                                memory.assignValue(currentInst.getVariable()[0], x/y);
                                break;

                        }
                        break;
                    case 'r':
                        memory.assignValue(currentInst.getVariable()[0],memory.readFile(""+memory.readValue(currentInst.getVariable()[1])));
                    default:
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                }
                break;
            case 'p':
                System.out.println(">> "+currentInst.getVariable()[0]+" : "+memory.getVariables().get(currentInst.getVariable()[0]));
                break;
            case 'w':
                memory.writeFile(""+memory.readValue(currentInst.getVariable()[0]),""+memory.readValue(currentInst.getVariable()[1]));

        }
        currentInst.setExecuted(true);
        currentInst.getProgram().getProcess().setStarted(true);
        currentInst.getProgram().getProcess().setProgramCounter(currentInst.getCurrInstructionAddress());
        currentInst.getProgram().getProcess().setCountdown(currentInst.getProgram().getProcess().getCountdown()-1);
        if(currentInst.getProgram().getProcess().getCountdown()==0)
            currentInst.getProgram().getProcess().setDone(true);



    }
    public Instruction getCurrentInst() {
        return currentInst;
    }

    public void viewCurrent(){
        System.out.println("CPU Currently Executing instruction from process with ID : "+currentInst.getProgram().getProcess().getProcessId()+"\n"+currentInst);
    }

}
