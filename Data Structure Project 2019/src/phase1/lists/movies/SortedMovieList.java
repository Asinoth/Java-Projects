/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.movies;

import java.util.Comparator;

import parser.MovieData;

/**
 *
 * 
 */
public class SortedMovieList extends MovieList {
    
    /*
     * Comparator<MovieListNode> is an object that implements the int compare(MovieListNode o1, MovieListNode o2) method.
     * This method compares two MovieListNodes and returns:
     *     A positive number when the first MovieListNode is bigger than the second element
     *     Zero when the first MovieListNode is equal to the second element
     *     A negative number when the first MovieListNode is smaller than the second element
     * To compare two MovieListNode objects call "comparator.compare(m1, m2);" method.
     */
    private Comparator<MovieListNode> comparator;
    
    
    /**
     * Creates an empty sorted list
     * @param comparator is an object that implements compare method 
     *        which defines how objects should be compared
     */
    public SortedMovieList(Comparator<MovieListNode> comparator){
    	this.comparator=comparator;
    }

    
    
    /**
     * Creates a MovieListNode and appends the specified element (MovieListNode) in the sorted list in such
     * way that list should remain sorted. The comparator defines the way 2 nodes should be compared.
     * The values for the MovieListNode are contained inside MovieData
     * @param node
     * @return true if node inserted successfully, false otherwise
     */
    @Override
    public void insert(MovieData data){
    	boolean flag = true;
    	if(size==0)
    		insertAfter(head,data);
    	else{
    		MovieListNode tmp=new MovieListNode(data.getId(),data.getTitle(),data.getYear(),data.getRating(),data.getVotes(),data.getDuration(),data.getGenres());
    		MovieListNode pos=head;
    		while(pos.getNext()!=tail){
    			pos=pos.getNext();
    			if(comparator.compare(pos, tmp)>=0){
    				insertAfter(pos.getPrevious(),data);
    				flag = false;
    				break;
    			}
    		}
    		if(pos.getNext()==tail && flag){
    			insertAfter(tail.getPrevious(),data);    			
    		}
    			
    	}
    	
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
		MovieListNode tmp=get(id);
		tmp.getPrevious().setNext(tmp.getNext());
		tmp.getNext().setPrevious(tmp.getPrevious());
    	tmp.setNext(null);
    	tmp.setPrevious(null);
    	return tmp;
    }
    
    
    
    /**
     * Returns the element with the specified id in this list or null if it not present
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
    			return tmp;
    		}
    	}
		return null;
	}
    
    
}
