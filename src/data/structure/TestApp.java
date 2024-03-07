package data.structure;

public class TestApp {
	public static void main(String []args) {
		LinkedPriorityQueue<Integer,String> tasks = new LinkedPriorityQueue<>();
		
		tasks.add(5, "Exception");
		tasks.add(1, "Java IO");
		tasks.add(2, "MultiThreading");
		tasks.add(3, "Network programming");
		
		
		System.out.println(tasks.removeMin());
		
		System.out.println(tasks.removeMin());
		
	}

}
