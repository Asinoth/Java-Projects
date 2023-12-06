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
public class SelfAdjustingMovieList extends MovieList {
    
    /**
     * Creates an empty self adjusting list
     */
    public SelfAdjustingMovieList(){}

    
    /**
     * Creates a MovieListNode and appends it the specified element (MovieListNode) in the list.
     * The values for the MovieListNode are contained inside MovieData
     * @param node
     * @return true if node inserted successfully, false otherwise
     */
    @Override
    public void insert(MovieData data){
    	insertAfter(head,data);
    }
    
    
    /**
     * Removes the first occurrence of the specified element (id) from this list, if it is
     * present (optional operation). If this list does not contain the element, it is unchanged
     * @param id
     * @return the element which have been deleted or null if the element is not present
     */
    @Override
    public MovieListNode remove(int id){
    	if(get(id)==null)
			return null;
		MovieListNode tmp=head.getNext();
		head.setNext(tmp.getNext());
		tmp.getNext().setPrevious(head);
    	tmp.setNext(null);
    	tmp.setPrevious(null);
    	return tmp;
    	
    }
    
    
    /**
     * Returns the element with the specified id in this list or null if it not present. If the
     * element is present, then it moves to the front of the list
     * @param id
     * @return the element
     */
    @Override
    public MovieListNode get(int id){
    	if(size==0)
    		return null;
    	
    		
    	MovieListNode tmp=head;
    	while(tmp.getNext()!=tail){
    		tmp=tmp.getNext();
    		if(tmp.getId()==id){
    			tmp.getNext().setPrevious(tmp.getPrevious());
    			tmp.getPrevious().setNext(tmp.getNext());
    			head.getNext().setPrevious(tmp);
    			tmp.setNext(head.getNext());
    			tmp.setPrevious(head);
    			head.setNext(tmp);			
    			return tmp;
    		}
    	}
		return null;}
    	
    }

