import java.util.ArrayList;

public class ExecutionQueue
{
	private ArrayList<Instruction> elements;

	public ExecutionQueue()
	{
		elements = new ArrayList<Instruction>();
	}

	public void enqueue(Instruction x)
	{
		elements.add(x);

	}

	public Instruction dequeue()
	{
		Instruction result = elements.get(0);
		elements.remove(0);
		return result;
	}

	public Instruction peek()
	{
		return elements.get(0);
	}

	public boolean isEmpty()
	{
		return (elements.isEmpty());
	}


	public int size()
	{
		return elements.size();
	}

	public void displayExecutionQueue() {
		if(elements.isEmpty()){
			System.out.println("The Execution queue is empty!");
			return;
		}
		for (Instruction instruction: elements ) {
			System.out.println(instruction + "\n");
		}
		System.out.println();
	}
	public void executeQueue(Memory memory) throws InterruptedException {
		if(elements.isEmpty()){
			System.out.println("The Execution queue is empty!");
			return;
		}
		Executor executor = new Executor();
		for (Instruction instruction: elements ) {
			executor.setCurrentInst(instruction);
			executor.executeCurrentInstruction(memory);
			Thread.sleep(2000);
		}
		System.out.println();
	}
}
