import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Scheduler {
    private ReadyQueue readyQueue , r2;
    private ExecutionQueue exeQue ;

    Scheduler() {
        this.readyQueue = new ReadyQueue();
        this.exeQue = new ExecutionQueue();
    }

    public void addToReadyQueue(Process process) {
        readyQueue.enqueue(process);
    }



    public ExecutionQueue scheduleRoundRobin(){
        int quantum = 2;
        Process curr ;
        while(!readyQueue.isEmpty()){
            curr = readyQueue.peek();
            while(!curr.getProgram().getProgram().isEmpty()){
                Instruction i= curr.getProgram().getProgram().get(0);
                if (i.getExecTime()<=quantum){
                    exeQue.enqueue(i);
                    curr.getProgram().getProgram().remove(0);
                }
                else {
                    i.setExecTime(i.getExecTime()-quantum);
                    break;
                }
            }
            if(curr.getProgram().getProgram().isEmpty()) {
                r2.enqueue(readyQueue.dequeue());
            }
            else
                readyQueue.enqueue(readyQueue.dequeue());
        }
        return this.exeQue;
    }
    public ReadyQueue scheduleShortestJob (){
        Process shortest ; ReadyQueue shortestQueue = new ReadyQueue();
        while(!readyQueue.isEmpty()) {
            shortest = readyQueue.peek();
            for (int i = 0; i < readyQueue.size(); i++) {
                readyQueue.enqueue(readyQueue.dequeue());
                if (shortest.compareTo(readyQueue.peek()) <= 0)
                    shortest = readyQueue.peek();
            }
            for (int i = 0; i < readyQueue.size(); i++) {
                if (shortest.equals(readyQueue.peek()))
                    r2.enqueue(readyQueue.dequeue());
            }
            shortestQueue.enqueue(shortest);
        }
        return shortestQueue;
    }





}
