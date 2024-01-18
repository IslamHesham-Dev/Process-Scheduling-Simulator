import java.util.*;

class Process implements Comparable {
    private static int processIdCreator =1 ;

    private int processId, programCounter , countdown ,arrivalLatency ;
    private Program prog ;
    private boolean started,done;


    Process( Program program) {
        this.processId = processIdCreator++;
        this.programCounter = program.getStartAddress();
        this.prog = program;
        this.countdown=program.getProgram().size();
        this.started=false; this.done=false;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Program getProgram() {
        return prog;
    }

    public int getProcessId(){
        return this.processId;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void incrementProgramCounter() {
        this.programCounter++;
    }

    @Override
    public String toString() {
        return "Process ID : "+processId + "    |  Memory Location : "+ prog.getStartAddress();
    }

    @Override
    public int compareTo(Object o) {
        if(this.prog.totalExecTime()<((Process)o).getProgram().totalExecTime())
            return -1;
        else if (this.prog.totalExecTime()>((Process)o).getProgram().totalExecTime()) {
            return 1;
        }
        return 0;
    }
}






