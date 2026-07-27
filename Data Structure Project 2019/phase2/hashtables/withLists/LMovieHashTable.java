/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase2.hashtables.withLists;


import phase1.lists.movies.MovieList;
import phase1.lists.movies.MovieListNode;
import parser.MovieData;


/**
 *
 * 
 */
abstract public class LMovieHashTable {
    /**
     *  These read-only variables are used inside this class.
     *  initialTableSize: The initial tableSize 
     */
    protected static final int initialTableSize = 11;
    
    
    protected int nElements;     // The total number of elements inside the hash table
    protected int tableSize;     // The current table size
    protected MovieList[] table; // The table with lists

    
    
    
    /**
     * Initializes the nElements and tableSize variables
     */
    protected LMovieHashTable() {
    	tableSize = initialTableSize;
    	nElements = 0;
    	}
   
    /**
     * This is the hash function of the hash table. It calculates the index of the table
     * where the element should be.
     * A good hash function should distribute elements uniformly in the table
     */
    protected int getHashIndex(int movieId){
    	return Math.abs(movieId)%tableSize;
    }  
    
    /**
     * ! DO NOT IMPLEMENT HERE !
     * This method is list-specific and should be implemented in sub-classes
     * When the number of elements in the table is over 2*tableSize, this method should
     * be called. It creates a new table with size: a prime number over 2*tableSize and
     * re-inserts all elements to the new table.
     * ! DO NOT IMPLEMENT HERE !
     */
    abstract protected void rehash();
    
    
    
    /**
     * Inserts a MovieListNode inside the hash table. The appropriate cell of the hash
     * table is determined by the hash function and the MovieData is inserted in the 
     * pointing list(chain)
     * @param data
     */
    public void insert(MovieData data) {
    	nElements++;
    	table[getHashIndex(data.getId())].insert(data);
    	if(nElements>2*tableSize){
    		rehash();
    	}	
    } 
    
    /**
     * Removes the first occurrence of the specified element (id) from this table, if it is
     * present (optional operation). If this table does not contain the element, it is unchanged
     * @param id
     * @return the element which have been deleted or null if the element is not present
     */
    public MovieListNode remove(int id) {
    	if(table[getHashIndex(id)].get(id)!=null)
    		nElements--;
    	return table[getHashIndex(id)].remove(id);
    	 
    } 
    
    /**
     * Returns the element with the specified id in the hashTable or null if it not present
     * @param id
     * @return the element
     */
    public MovieListNode get(int id) {
    	return table[getHashIndex(id)].get(id);
    	
    }
           
    /**
     * Removes all of the elements from this hashTable. The lists in each cell
     * of the table will be empty after this call returns
     */
    public void clear(){
    	for(int i=0;i<tableSize;i++){
    		table[i].clear();
    	}
    	nElements = 0;
    }
     
    /**
     * Returns the number of all elements that are inside the hashTable
     * @return nElements
     */
    public int getSize() {
    	return nElements;
    }
   
    public int getTableSize(){
    	return tableSize;
    }
    public MovieList getTableIndex(int i){
    	return table[i];
    }
    /**
     * Returns true if this list contains no elements
     * @return true if the number of elements in hashTable equals to 0 and false otherwise
     */
    public boolean isEmpty() {
    	return getSize()==0;
    }
    
    
    public int  firstNum(int n){
    	int prime=2*n+1;
    	boolean test;
    	while(true){
    		test=true;
    		for(int i=2;i<prime/2;i++){
    			if(prime%i==0){
    				test=false;
    			}			
    		}
    		if(test==true)
    			break;
    		else 
    			prime++;
    	}
    	return prime;
    		
    }

    public String toString(){
    	String out="";
    	for(int i=0;i<tableSize;i++)
    		out+=table[i];
    	return out;
    }
}
