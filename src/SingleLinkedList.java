



public class SingleLinkedList<T> implements OwnList<T>{

	private int Size=0;
	Elem startElem = new Elem();
	Elem endElem = new Elem();
	
	
	/**
	 * Constructor
	 */
	public SingleLinkedList() {
		startElem.setNext(endElem);
	}
	/**
	 * Adds an  new Element to the List
	 * @param insertElem
	 * @throws ElementNotFoundException
	 */
	public void add(Elem<T> insertElem) throws ElementNotFoundException{
		Elem<T> prev = findPrevious(endElem);
		insertElem.setNext(prev.getNext());
		prev.setNext(insertElem);
		Size++;
	}

	/**
	 * Inserts an Element at a given Positon
	 * @param insertPos position of the Insertion
	 * @param insertElem Element to be inserted
	 * @throws IndexOutOfBoundsException
	 */
	public void insert(Pos insertPos, Elem<T> insertElem) throws IndexOutOfBoundsException {
		int index =0;
		Elem<T> prev = startElem;
		while(index+1<insertPos.get()){
			prev=prev.getNext();
			index++;
		}
		if(index+1>=Size) throw new IndexOutOfBoundsException();
		Elem<T> after = prev.getNext();
		prev.setNext(insertElem);
		insertElem.setNext(after);
		Size++;
		
	}

	/**
	 * Deletes an Element at a given position
	 * @param deletePos
	 * @throws IndexOutOfBoundsException
	 */
	public void delete(Pos deletePos) throws IndexOutOfBoundsException {
		if(deletePos.get()>=Size) throw new IndexOutOfBoundsException();
		Elem<T> elem = startElem;
		Elem<T> prev = new Elem<T>();
		 Pos position = new Pos(0);
	        while (elem.getNext() != endElem && !position.equals(deletePos)){
	        	position.set(position.get()+1);//erhöhe position um 1
	        	prev = elem; // setze als vorheriges elem das aktuelle
	        	elem.getNext(); //gehe ein elem weiter
	        }
	        Elem<T> temp = elem.getNext(); //nimm das element nach dem zu löschendem
	        elem.setData(null); //entferne den Inhalt des zu löschenden Obj
	        prev.setNext(temp);// setzte den Zeiger von dem elem vor dem zu löschenden auf das elem nach dem gelöschten
	           
	}

	/**
	 * Deletes an Element by a given Key
	 * The Key is the data of the Element
	 * @param deleteKey
	 * @throws ElementNotFoundException 
	 */
	public void delete(T deleteKey) throws ElementNotFoundException {
		Elem<T> temp = new Elem();
		temp.setData(deleteKey);
		Elem<T> prev = findPrevious(temp);
		Elem<T> after = prev.getNext().getNext();
		prev.getNext().setData(null);
		prev.getNext().setNext(null);
		prev.setNext(after);
		
	}
	
	/**
	 * Finds the previous Element to a given Element(exakt) and returns the previous one
	 * @param exakt the Element after the previous element
	 * @return the previous element
	 * @throws ElementNotFoundException
	 */
	
	private Elem<T> findPrevious(Elem<T> exakt) throws ElementNotFoundException{
		Elem<T> elem = startElem;
		addStopAtEnd(exakt);
		while(!elem.getNext().equals(exakt.getData())){
			elem=elem.getNext();
		}
		if(elem.getNext().equals(endElem.getData())){
			removeStopAtEnd();
			throw new ElementNotFoundException();
			
		}
		removeStopAtEnd();
		return elem;
	}

	/**
	 * Finds the position of an Element with a Stop element at the end of the list.
	 * 
	 * @param findElem
	 * @return position of the element that was looked for
	 * @throws ElementNotFoundException
	 */
	public Pos find(Elem<T> findElem) throws ElementNotFoundException {
		Elem<T> elem = startElem;
		addStopAtEnd(findElem);
		 Pos position = new Pos(0);
	        while (!elem.equals(findElem)){
	        	position.set(position.get()+1);//erhöhe position um 1
	        	
	        	elem.getNext(); //gehe ein elem weiter
	        }
	        if(elem.getNext().equals(endElem)){
	        	removeStopAtEnd();
	        	throw new ElementNotFoundException();
	        	
	        }
	       removeStopAtEnd(); 
	           
		return position;
	}

	/**
	 * Returns the Element at a given at a given Position
	 * @param retrievePos position of the element in List
	 * @return the Element at a Position
	 * @throws IndexOutOfBoundsException
	 */
	public Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
		if(retrievePos.get()>=Size)throw new IndexOutOfBoundsException();
		Elem<T> elem = startElem;
		
		 Pos position = new Pos(0);
	        while (elem.getNext() != endElem && !position.equals(retrievePos)){
	        	position.set(position.get()+1);//erhöhe position um 1
	        	
	        	elem.getNext(); //gehe ein elem weiter
	        }
		return elem;
	}

	/**
	 * Concatenates this List with an other List
	 * @param otherList the List that you want to be concatenated
	 * @throws ElementNotFoundException 
	 */
	public void concat(SingleLinkedList<T> otherList) throws ElementNotFoundException {
		Elem<T> elem = startElem;
		//finde das Element vor dem endElement
		elem=findPrevious(endElem);
		//setze den Zeiger dieses Elements auf das erste element der otherList nach dem start elem.
		elem.setNext(otherList.getStartElem().getNext());
		//ändere das endElement auf das endElem der anderen Liste
		endElem=otherList.getEndElem();
		
	}
	
	/**
	 * Inserts a Stop Element at the beginning;
	 * @param newElement
	 */
	private void addStopAtStart(Elem<T> newElement){
		Elem<T> elem = startElem.getNext();
		startElem.setNext(newElement);
		newElement.setNext(elem);
	}
	
	/**
	 * Removes a Stop Element
	 */
	private void removeStopAtStart(){
		Elem<T> elem = startElem.getNext().getNext();
		startElem.setNext(elem);
	}
	
	/**
	 * Adds a Stop Element at the End
	 * @param newElem
	 */
	private void addStopAtEnd(Elem<T> newElem){
		Elem<T> elem = startElem;
		while(!elem.getNext().equals(endElem)){
			elem=elem.getNext();
		}
		elem.setNext(newElem);
		newElem.setNext(endElem);
	}
	
	/**
	 * removes the Stop element at the end
	 */
	private void removeStopAtEnd(){
		Elem<T> elem = startElem;
		while(!elem.getNext().getNext().equals(endElem)){
			elem = elem.getNext();
		}
		elem.setNext(endElem);
	}
	
	
	
	

	
	public Elem<T> getStartElem() {
		return startElem;
	}



	public void setStartElem(Elem<T> startElem) {
		this.startElem = startElem;
	}



	public Elem<T> getEndElem() {
		return endElem;
	}



	public void setEndElem(Elem<T> endElem) {
		this.endElem = endElem;
	}



	public int size() {
		// TODO Auto-generated method stub
		return Size;
	}
	@Override
	public void concat(OwnList<T> otherList) {
		// TODO Auto-generated method stub
		
	}


}
