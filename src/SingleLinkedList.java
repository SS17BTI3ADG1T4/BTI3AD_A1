



public class SingleLinkedList<T> implements OwnList<T>{
	//TODO Size umschreiben sodass er durchzählt?
	private int Size=0;
	private Elem startElem;
	private Elem endElem ;
	
	
	/**
	 * Constructor
	 */
	public SingleLinkedList() {
		startElem = new Elem();
		endElem = new Elem();
		startElem.setNext(endElem);
	}
	/**
	 * Adds an  new Element to the List
	 * @param insertElem
	 * @throws ElementNotFoundException
	 */
	public void add(Elem<T> insertElem) throws ElementNotFoundException{
		if(Size==0){
			startElem.setNext(insertElem);
			insertElem.setNext(endElem);	
		}else{
			Elem elem = startElem;
			while(elem.getNext()!=endElem){
				elem=elem.getNext();
			}
			elem.setNext(insertElem);
			insertElem.setNext(endElem);
		}
		Size++;
	}

	/**
	 * Inserts an Element at a given Positon
	 * @param insertPos position of the Insertion
	 * @param insertElem Element to be inserted
	 * @throws IndexOutOfBoundsException
	 */
	public void insert(Pos insertPos, Elem insertElem) throws IndexOutOfBoundsException {
		if(insertPos.getPos()>Size) throw new IndexOutOfBoundsException();
		if(insertPos.getPos()<0)throw new IndexOutOfBoundsException();
		int index =0;
		Elem prev = startElem;
		while(index<insertPos.getPos()){
			prev=prev.getNext();
			index++;
		}
		Elem after = prev.getNext();
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
		if(deletePos.getPos()>Size) throw new IndexOutOfBoundsException();
		if(Size==0)throw new IndexOutOfBoundsException();
		if(deletePos.getPos()<0) throw new IndexOutOfBoundsException();
		Elem<T> elem = startElem;
		Elem<T> prev = new Elem<T>();
		 Pos position = new Pos(0);
	        while (position.getPos()<deletePos.getPos()){
	        	position.set(position.getPos()+1);//erhöhe position um 1
	        	prev = elem; // setze als vorheriges elem das aktuelle
	        	elem = elem.getNext(); //gehe ein elem weiter
	        }
	        Elem<T> temp = elem.getNext(); //nimm das element nach dem zu löschendem
	        elem.setData(null); //entferne den Inhalt des zu löschenden Obj
	        prev.setNext(temp);// setzte den Zeiger von dem elem vor dem zu löschenden auf das elem nach dem gelöschten
	        Size--;   
	}

	/**
	 * Deletes an Element by a given Key
	 * The Key is the data of the Element
	 * @param deleteKey
	 * @throws ElementNotFoundException 
	 */
	public void delete(T deleteKey) throws ElementNotFoundException {
		Elem<T> temp = new Elem(deleteKey);
		Elem<T> prev = startElem;
		addStopAtEnd(temp);
		while(!prev.getNext().equals(temp)){
			prev =prev.getNext();
		}
		if(prev.getNext().getNext()==endElem){
			removeStopAtEnd();
			throw new ElementNotFoundException();
		}else{
			temp=prev.getNext().getNext();
			prev.setNext(temp);
		}
		Size--;
		
	}
	
	/**
	 * Finds the previous Element to a given Element(exakt) and returns the previous one
	 * @param exakt the Element after the previous element
	 * @return the previous element
	 * @throws ElementNotFoundException
	 */
	
	private Elem<T> findPrevious(Elem<T> exakt) throws ElementNotFoundException{
		if(this.Size==1) return startElem.getNext();
		Elem<T> elem = startElem;
		addStopAtEnd(exakt);
		while(elem.getNext()!=exakt){
			elem=elem.getNext();
		}
		if(elem==endElem &&elem.getNext()!=endElem){
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
	 * @return position of the element that was looked for or (-1 if the Element is not in List)
	 * @throws ElementNotFoundException
	 */
	public Pos find(Elem findElem) {		
		if(this.Size==0)return new Pos(-1);
		if(this.Size==1)return new Pos(0);
		Elem elem = startElem;
		addStopAtEnd(findElem);
		Pos position = new Pos(0);	
		while (!elem.equals(findElem)){	
			position.set(position.getPos()+1);//erhöhe position um 1
			elem=elem.getNext(); //gehe ein elem weiter
	        }
		if(elem.getNext()==(endElem)){		
			removeStopAtEnd();
			position.set(-1);
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
		if(retrievePos.getPos()>=Size){
			
			throw new IndexOutOfBoundsException();
		}
		Elem<T> elem = startElem;
		
		 Pos position = new Pos(-1);
	        while (elem.getNext()!=endElem && position.getPos()!=retrievePos.getPos()){
	        	position.set(position.getPos()+1);//erhöhe position um 1
	        	
	        	elem=elem.getNext(); //gehe ein elem weiter
	        }
		return elem;
	}

	/**
	 * Concatenates this List with an other List
	 * @param otherList the List that you want to be concatenated
	 * @throws ElementNotFoundException 
	 */
	@Override
	public void concat(OwnList<T> otherList) {
		if(otherList.getClass().equals(this.getClass())){
			if(Size==0);
			if(otherList.size()==0);
			Elem elem =startElem;
			int counter =0;
			while(elem.getNext()!=(endElem)){
				elem = elem.getNext();
				counter++;
			}
			System.out.println("Counter:" + counter);
			//setze den Zeiger dieses Elements auf das erste element der otherList nach dem start elem.
			
			elem.setNext(((SingleLinkedList)otherList).getStartElem().getNext());
			//ändere das endElement auf das endElem der anderen Liste
			endElem=((SingleLinkedList)otherList).getEndElem();
			updateSize(Size, otherList.size());
		
		}else{
			//TODO 
		}
		
	}
	
	private void updateSize(int a, int b) {
		Size = a+b;	
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
		while(elem.getNext()!=endElem){
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
		while(elem.getNext().getNext()!=endElem){
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
	


}
