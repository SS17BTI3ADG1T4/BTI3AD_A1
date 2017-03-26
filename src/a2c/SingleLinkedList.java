package a2c;

import ADP_1.Pos;

public class SingleLinkedList<T> {

	private int Size=0;
	Elem startElem = new Elem(null);
	Elem endElem = new Elem(null);
	
	
	/**
	 * Constructor
	 */
	public SingleLinkedList() {
		startElem.setNextElement(endElem);
	}
	/**
	 * Adds an  new Element to the List
	 * @param insertElem
	 * @throws ElementNotFoundException
	 */
	public void add(Elem<T> insertElem) throws ElementNotFoundException{
		Elem<T> prev = findPrevious(endElem);
		insertElem.setNextElement(prev.getNextElement());
		prev.setNextElement(insertElem);
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
			prev=prev.getNextElement();
			index++;
		}
		if(index+1>=Size) throw new IndexOutOfBoundsException();
		Elem<T> after = prev.getNextElement();
		prev.setNextElement(insertElem);
		insertElem.setNextElement(after);
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
		Elem<T> prev = new Elem<T>(null);
		 Pos position = new Pos(0);
	        while (elem.getNextElement() != endElem && !position.equals(deletePos)){
	        	position.set(position.get()+1);//erhöhe position um 1
	        	prev = elem; // setze als vorheriges elem das aktuelle
	        	elem.getNextElement(); //gehe ein elem weiter
	        }
	        Elem<T> temp = elem.getNextElement(); //nimm das element nach dem zu löschendem
	        elem.setObj(null); //entferne den Inhalt des zu löschenden Obj
	        prev.setNextElement(temp);// setzte den Zeiger von dem elem vor dem zu löschenden auf das elem nach dem gelöschten
	           
	}

	/**
	 * Deletes an Element by a given Key
	 * The Key is the data of the Element
	 * @param deleteKey
	 * @throws ElementNotFoundException 
	 */
	public void delete(Object deleteKey) throws ElementNotFoundException {
		Elem<T> prev = findPrevious(new Elem<T>(deleteKey));
		Elem<T> after = prev.getNextElement().getNextElement();
		prev.getNextElement().setObj(null);
		prev.getNextElement().setNextElement(null);
		prev.setNextElement(after);
		
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
		while(!elem.getNextElement().equals(exakt.getObj())){
			elem=elem.getNextElement();
		}
		if(elem.getNextElement().equals(endElem.getObj())){
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
	        	
	        	elem.getNextElement(); //gehe ein elem weiter
	        }
	        if(elem.getNextElement().equals(endElem)){
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
	        while (elem.getNextElement() != endElem && !position.equals(retrievePos)){
	        	position.set(position.get()+1);//erhöhe position um 1
	        	
	        	elem.getNextElement(); //gehe ein elem weiter
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
		elem.setNextElement(otherList.getStartElem().getNextElement());
		//ändere das endElement auf das endElem der anderen Liste
		endElem=otherList.getEndElem();
		
	}
	
	/**
	 * Inserts a Stop Element at the beginning;
	 * @param newElement
	 */
	private void addStopAtStart(Elem<T> newElement){
		Elem<T> elem = startElem.getNextElement();
		startElem.setNextElement(newElement);
		newElement.setNextElement(elem);
	}
	
	/**
	 * Removes a Stop Element
	 */
	private void removeStopAtStart(){
		Elem<T> elem = startElem.getNextElement().getNextElement();
		startElem.setNextElement(elem);
	}
	
	/**
	 * Adds a Stop Element at the End
	 * @param newElem
	 */
	private void addStopAtEnd(Elem<T> newElem){
		Elem<T> elem = startElem;
		while(!elem.getNextElement().equals(endElem)){
			elem=elem.getNextElement();
		}
		elem.setNextElement(newElem);
		newElem.setNextElement(endElem);
	}
	
	/**
	 * removes the Stop element at the end
	 */
	private void removeStopAtEnd(){
		Elem<T> elem = startElem;
		while(!elem.getNextElement().getNextElement().equals(endElem)){
			elem = elem.getNextElement();
		}
		elem.setNextElement(endElem);
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


}
