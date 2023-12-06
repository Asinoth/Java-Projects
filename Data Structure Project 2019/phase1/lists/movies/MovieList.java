/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.movies;

import parser.MovieData;

/**
 *
 * 
 */
public abstract class MovieList {
    protected int size;
    protected MovieListNode head;
    protected MovieListNode tail;
    
    
    
    /**
     * Creates an empty sorted list, with size=0 and null head/tail
     * @param comparator is an object that implements compare method 
     *        which defines how objects should be compared
     */
    public MovieList(){
    	head=new MovieListNode(0,null,0,0,0,0,null);
    	tail=new MovieListNode(0,null,0,0,0,0,null);
    	head.setPrevious(null);
    	head.setNext(tail);
    	tail.setPrevious(head);
    	tail.setNext(null);
    	size=0;
    }
    
    /*
     * These 3 methods should not be implemented here. They are implementation
     * specific and should be implemented inside unsortedList, sortedList, selfAdjustingList
     */
    abstract public void insert(MovieData data);
    abstract public MovieListNode remove(int id);
    abstract public MovieListNode get(int id);
       
    /**
     * Removes all of the elements from this list. The list will be empty after this call returns
     */
    public void clear(){
    	head.setNext(tail);
    	tail.setPrevious(head);
    	size=0;
    	
    		
    }
    
    
    /**
     * Returns the number of elements in this list
     * @return the size of the list
     */
    public int getSize(){
    	return size;
    }
    
    /**
     * Returns true if this list contains no elements
     * @return true if the size of the list equals to 0 and false otherwise
     */
    public boolean isEmpty(){
    	return (size==0);
    }
    
    public void insertAfter(MovieListNode nod,MovieData data){
    	size++;
    	MovieListNode inser=new MovieListNode(data.getId(),data.getTitle(),data.getYear(),data.getRating(),data.getVotes(),data.getDuration(),data.getGenres());
    	inser.setNext(nod.getNext());
    	inser.setPrevious(nod);
    	nod.getNext().setPrevious(inser);
    	nod.setNext(inser);
    }
      
    public String toString(){
    	String out="";
    	MovieListNode tmp=head;
    	while(tmp.getNext()!=tail){
    		tmp=tmp.getNext();
    		out+=tmp.toString();
    	}
    	
    	return out;
    }
    
   
    public MovieListNode deleteFirst(){
    	MovieListNode tmp;
    	size--;
    	tmp = head.getNext();
    	head.setNext(tmp.getNext());
    	tmp.getNext().setPrevious(head);
    	tmp.setNext(null);
    	tmp.setPrevious(null);
    	return tmp;
    }
    
    public MovieListNode getHead(){
    	return head; 	
    }
    
    public MovieListNode getTail(){
    	return tail;
    }
    
    public void append(MovieList list){
    	while(!list.isEmpty()){
    		insert(list.deleteFirst().toData());
    	}
    }
    
    
}
