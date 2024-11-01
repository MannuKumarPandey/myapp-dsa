package stack;

public class TwoStacksInAnArray {
	
	static int array[] = new int[10];
	static int n = array.length;
	static int firstTop = -1;
	static int secondTop = n/2-1;

	public static void main(String[] args) {
		add(10,1);
		add(15,1);
		add(1000,2);
		add(2000,2);
		display();
		System.out.println(pop(1));
		System.out.println(pop(2));
		display();
		
	}
	
	
	public static void add(int data, int stackNumber) {
		if(stackNumber == 1) {
			if(firstTop != n/2-1  )
				array[++firstTop] = data;
		}
		else {
			if(secondTop != n-1) {
				array[++secondTop] = data;
			}
		}
	}
	
	static void display() {
		for(int i = 0; i <= firstTop; i++ ) {
			System.out.print(array[i]+ " ");
		}
		for(int i = n/2; i <= secondTop; i++ ) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	static int pop(int stackNumber) {
		if(stackNumber == 1) {
			int res = array[firstTop--];
			return res;
		}
		else {
			int res = array[secondTop--];
			return res;
		}
	}
}
