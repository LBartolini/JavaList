
public class List {
	Item firstItem;
	int position = 0;
	public void push(Item item) {
		if (position == 0) {
			firstItem = item;
		}else {
			Item temp = firstItem;
			for(int i = 1; i < position; i++) {
				temp = temp.next;
			}
			temp.next = item;
		}
		position++;
	}
	
	public void delete(int pos) {
		Item temp = firstItem;
		Item prec = null;
		
		for(int i = 0; i < pos; i++) {
			prec = temp;
			temp = temp.next;
		}
		if (pos == 0) {
			firstItem = firstItem.next;	
		}else if (pos != position-1) {
			prec.next = temp.next;
		}
		
		position--;
	}
	
	public int get(int pos) {
		Item temp = firstItem;
		for(int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		return temp.value;
	}
	
	public void set(int pos, int value) {
		Item temp = firstItem;
		for(int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		temp.value = value;
	}
	
	public void printAll() {
		Item temp = firstItem;
		for(int i = 0; i < position; i++) {
			System.out.println("Pos: " + i + " Value: " + temp.value);
			temp = temp.next;
		}
	}
}
