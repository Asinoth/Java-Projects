package phase3.hashtables.withTrees;

import parser.MovieData;
import phase3.trees.MovieBSTree;
import phase3.trees.MovieBSTreeNode;

public class TMovieHashTable {
	 private int nElements;     // The total number of elements inside the hash table
     private int tableSize;     // The current table size
     protected MovieBSTree[] table; // The table with lists
     

     
     
     
     ///////Constructor////////////////
     
     public TMovieHashTable(int tableSize){
    	 this.tableSize = tableSize;
    	 this.nElements = 0;
    	 table = new MovieBSTree[tableSize];
    	 for(int i = 0;i <tableSize;i++)
    		 table[i] = new MovieBSTree();
    	 
     }
   
     ///////Public Operations///////////
     
     public MovieBSTreeNode get(int id){
    	 MovieBSTreeNode nod = table[getHashIndex(id)].get(id);
    	 if(nod == null )
    		 System.out.println("Element not found");
    	 return nod;
     }     

     public void insert(MovieData data){
    	 nElements++;
    	 table[getHashIndex(data.getId())].insert(data);
     }
     
     public MovieBSTreeNode remove(int id) {
      	if(table[getHashIndex(id)].get(id)!=null)
      		nElements--;
      	return table[getHashIndex(id)].remove(id);
      	 
      }

     public void Clear(){
    	 this.nElements = 0;
    	 table = new MovieBSTree[tableSize];
    	 for(int i = 0;i <tableSize;i++)
    		 table[i] = new MovieBSTree();
    	
     }
     
     public boolean isEmpty() {
     	return nElements==0;
     }
     
     public String toString(){
    	 String out="";
    	 for(int i=0;i<tableSize;i++){
    		 if(!getTableIndex(i).isEmpty())
    			 out+=getTableIndex(i).toString();
    	 }
    	 return out;
    		 
     }
     //////////getters///////////////
     
     public int getTableSize(){
    	 return this.tableSize;
     }

     public int getNElements(){
    	 return this.nElements;
     }

     public MovieBSTree getTableIndex(int i){
     	return table[i];
     }
     
     /////////Private Operations/////////
     
     private int getHashIndex(int movieId){
    	 return Math.abs((movieId*911)/17)%tableSize;
     }
     
 
}
