import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Instruction {

    private String [] inst ;
    private boolean executed;
    private final ArrayList<String> instList = new ArrayList<String>(Arrays.asList("assign","print","writeFile","input","readFile")) ;
    private final ArrayList<String> operators = new ArrayList<String>(Arrays.asList("add","multiply","divide","subtract")) ;

    private char operation;
    private String [] variable;
    private String [] operands;
    private char type , secondaryOptype ;
    private int currInstructionAddress;



    private int execTime ;
    private Program program ;
    public Instruction( String m,Program program , int currAddress) throws Exception {
        currInstructionAddress = currAddress;
        execTime=0;
        this.program=program;
        this.executed=false;
        this.secondaryOptype='0';
        this.operation='0';
        ArrayList<String> instItems = new ArrayList<String>(Arrays.asList( m.split(" ")));
        String curr = instItems.get(0);
        inst = new String[2];
        inst[0] = instItems.contains(instList.get(0))? instList.get(0) : instItems.contains(instList.get(1))? instList.get(1) : instItems.contains(instList.get(2))? instList.get(2):null ;
        execTime+=2;
        variable = new String[2];
        variable[0] = instItems.get(1);
        if(instItems.size()==3){
            if(instList.contains(instItems.get(2)))
                inst[1]=instItems.get(2);
            else
                variable[1]=instItems.get(2);

        }
        else if (instItems.size()==4){
            if ((instList.contains(instItems.get(2))))
                inst[1] =instItems.get(2);
            else
                throw new Exception("Invalid Instruction");

        }
        else if (instItems.size()==5){
            operands = new String[2];
            if(operators.contains(instItems.get(2)))
                operation = instItems.get(2).equals(operators.get(0))? '+' : instItems.get(2).equals(operators.get(1))?'*':instItems.get(2).equals(operators.get(2))? '/': instItems.get(2).equals(operators.get(3))? '-' : '0';

            else
                throw new Exception("Invalid operation");
            if((!instList.contains(instItems.get(3))&&(!instList.contains(instItems.get(4))))){
                operands[0]=instItems.get(3); operands[1]=instItems.get(4);
                execTime+=2;
            }
            else
                throw new Exception("Invalid operands naming , invalid Instruction");
        }

        switch(instList.indexOf(inst[0])){
            case 0:
                this.type = 'a';

                switch (instList.indexOf(inst[1])){
                    case 3:
                        this.secondaryOptype = 'i';
                        break;
                    case 4 :
                        this.secondaryOptype = 'r';
                        break;
                }
                ArrayList <Character> ops = new ArrayList<Character>(Arrays.asList('+','-','*','/'));
                if(ops.contains(operation)){
                    this.secondaryOptype = 'o';
                }
                break;
            case 1:
                this.type='p';
                break;
            case 2 :
                this.type = 'w';
        }


    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public Program getProgram() {
        return program;
    }



    public int getCurrInstructionAddress() {
        return currInstructionAddress;
    }

    public String[] getInst() {
        return this.inst;
    }

    public char getOperation() {
        return this.operation;
    }

    public String[] getVariable() {
        return this.variable;
    }

    public String[] getOperands() {
        return this.operands;
    }
    public char getType (){
        return this.type;
    }
    public char getSecondaryOptype (){
        return this.secondaryOptype;
    }



    @Override
    public String toString() {
        String s = "";
        s+="Instructions : "+ this.inst[0]+" "+this.inst [1];
        s+="\nVariables : "+ this.variable[0]+" "+this.variable [1];
        if(this.operation!=0 && this.operands!=null)
            s+="\nOperation : "+ this.operation+" ,Operands : "+this.operands[0]+" "+this.operands[1];
        s+="\nFrom Process : "+this.program.getProcess().getProcessId();
        return s;
    }

    public int getExecTime() {
        return execTime;
    }
    public void setExecTime(int execTime) {
        this.execTime = execTime;
    }


    public static void main(String[] args) throws Exception {



    }
}
