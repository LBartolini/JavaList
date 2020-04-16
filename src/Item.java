
public class Item <T>{
	private T value;
	private Item<T> next=null, prec=null;
	
	public Item(T val) {
		value = val;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setNext(Item<T> next) {
		this.next = next;
	}
	
	public void setPrec(Item<T> prec) {
		this.prec = prec;
	}
	
	public Item<T> getNext() {
		return this.next;
	}
	
	public Item<T> getPrec() {
		return this.prec;
	}
}
