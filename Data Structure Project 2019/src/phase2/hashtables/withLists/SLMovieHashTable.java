/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase2.hashtables.withLists;

import java.util.Comparator;
import parser.MovieData;
import phase1.lists.movies.*;


/**
 *
 * 
 */
public class SLMovieHashTable extends LMovieHashTable{
    private Comparator<MovieListNode> listComparator;
    
    /**
     * Creates an new hashTable (initializes the table variable) of size="initialTableSize"
     * with empty SortedMovieList in each cell.
     */
    public SLMovieHashTable(Comparator<MovieListNode> listComparator) {
    	table = new SortedMovieList[initialTableSize];
    	for(int i=0;i<initialTableSize;i++){
    		table[i] = new SortedMovieList(listComparator);
    	}
    	this.listComparator=listComparator;
    }

    
    /**
     * When the number of elements in the table is over 2*tableSize, this method should
     * be called. It creates a new table of SortedMovieList with size: a prime
     * number over 2*tableSize and re-inserts all elements to the new table.
     */
    @Override
    protected void rehash() {
     	MovieList[] table1;
    	int size=tableSize;
    	tableSize = firstNum(tableSize);
    	MovieData tmp; 
    	table1 =new MovieList[firstNum(tableSize)];
    	for(int i=0;i<tableSize;i++)
    		table1[i]=new SortedMovieList(listComparator);
       	for(int i=0;i<size;i++){    		
    		while(!table[i].isEmpty()){
    			tmp = table[i].deleteFirst().toData();
    			table1[getHashIndex(tmp.getId())].insert(tmp);
    		}
    	}
    	table = table1;	    
    }
    	
    	
    	
 }
    
    




