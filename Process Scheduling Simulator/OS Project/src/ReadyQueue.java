import java.util.ArrayList;

public class ReadyQueue
{
	private ArrayList<Process> elements;

	public ReadyQueue()
	{
		elements = new ArrayList<Process>();
	}

	public void enqueue(Process x)
	{
		elements.add(x);

	}

	public Process dequeue()
	{
		Process result = elements.get(0);
		elements.remove(0);
		return result;
	}

	public Process peek()
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

	public void displayReadyQueue() {
		if(elements.isEmpty()){
			System.out.println("The queue is empty!");
			return;
		}
		for (Process process: elements ) {
			System.out.println(process + "\n");
		}
		System.out.println();
	}
}
