
public class Main {

	public static void main(String[] args) {
		List list = new List();
		
		list.push(new Item(1));
		list.push(new Item(2));
		list.push(new Item(3));
		
		list.delete(0);
		
		list.printAll();
		
		list.set(0, 1);
		
		System.out.println(list.get(0));
	}

}
