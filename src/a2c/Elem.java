package a2c;



public class Elem<T> {
	
	private Elem<T> nextElement;
	private Object obj;
	
	
	public Elem( Object obj) {
		this.nextElement = null;
		this.obj = obj;
		
	}
	public Elem<T> getNextElement() {
		return nextElement;
	}
	public void setNextElement(Elem<T> nextElement) {
		this.nextElement = nextElement;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this.obj == obj)
			return true;
		else if (obj == null)
			return false;
		else return false;
	}
	
	
	
	
	
	
}
