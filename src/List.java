
public class List<T> {
	private Item<T> head, tail;
	private int lenght;
	
	public List() {
		this.lenght = 0;
		this.head = null;
		this.tail = null;
	}
	
	public int lenght() {
		return this.lenght;
	}
	
	public void push(T value) {
		this.insertValueAt(this.lenght, value);
	}
	
	public T pop(int pos) {
		if(pos <= this.lenght-1) {
			Item<T> old = this.getItemAt(pos);
			
			if(pos == 0) {
				old.getNext().setPrec(null);
				this.head = old.getNext();
			}else if(pos == (this.lenght-1)) {
				old.getPrec().setNext(null);
				this.tail = old.getPrec();
			}else{
				old.getPrec().setNext(old.getNext());
				old.getNext().setPrec(old.getPrec());
			}
			
			this.lenght--;
			
			return old.getValue();
		}else {
			return null;
		}
	}
	
	public void insertValueAt(int pos, T value) {
		Item<T> new_item = new Item<T>(value);
		if(pos == 0) { 
			// insert in head
			new_item.setNext(this.head);
			new_item.setPrec(null);
			if(this.lenght > 0) {  // list is not empty
				this.head.setPrec(new_item); 
			}else { // list is empty
				this.tail = new_item;
			}
			this.head = new_item;
		}else if(pos == this.lenght) {
			// insert in tail
			new_item.setPrec(this.tail);
			new_item.setNext(null);
			this.tail.setNext(new_item);
			this.tail = new_item;
		}else {
			Item<T> old_item = this.getItemAt(pos);
			old_item.getPrec().setNext(new_item);
			new_item.setPrec(old_item.getPrec());
			new_item.setNext(old_item);
			old_item.setPrec(new_item);
		}
		
		this.lenght++;
	}
	
	public T getValueAt(int pos) {
		T retValue = this.getItemAt(pos).getValue();
		
		return retValue;
	}
	
	public Item<T> getItemAt(int pos) {
		Item<T> retValue = null;
		if((this.lenght - pos) > (int)(this.lenght / 2)) {
			// first half - from head
			Item<T> temp = this.head;
			for(int i = 0; i < pos; i++) {
				temp = temp.getNext();
			}
			retValue = temp;
		}else {
			// second half - from tail
			Item<T> temp = this.tail;
			for(int i = 0; i < (this.lenght - pos - 1); i++) { // (this.lenght - pos) è la distanza dal TAIL alla posizione cercata
				temp = temp.getPrec();
			}
			retValue = temp;
		}
		
		return retValue;
	}
	
	public void setValueAt(int pos, T value) {
		Item<T> item = this.getItemAt(pos);
		item.setValue(value);
	}
	
	public void printAll() {
		Item<T> temp;
		for(int i = 0; i < this.lenght; i++) {
			temp = this.getItemAt(i);
			System.out.println("Pos: " + i + " Value: " + temp.getValue());
			
		}
	}
}
