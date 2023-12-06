/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.users;

import parser.MovieData.genre_t;
import phase1.lists.movies.MovieList;
import phase2.hashtables.withLists.LMovieHashTable;
import phase3.hashtables.withTrees.TMovieHashTable;
import phase3.trees.MovieBSTree;

/**
 *
 * 
 */
public class UserListNode {
    private String username;
    private UserListNode next;
    private WatchMovieListNode watchMoviesList;//head
    private int noOFmovies;
    private int noOfgenrMovs;
    
    public UserListNode(String username){
    	this.username=username;
    	this.noOFmovies=0;
    	
    }

    public String getUsername() {
    	return username;
    }
    public UserListNode getNext() {
    	return next;
    }
    public void setNext(UserListNode next) {
    	this.next=next;
    }
    
    public boolean insertMovie(int id){
    	WatchMovieListNode tmp=new WatchMovieListNode(id);
    	if(noOFmovies==0){
    		watchMoviesList=tmp;
    		watchMoviesList.setNext(null);
    	}else{
    		tmp.setNext(watchMoviesList);
    		watchMoviesList=tmp;
    	}
    	noOFmovies++;
    	return true;
    }
    public WatchMovieListNode removeMovie(int id){
    	if(containsMovie(id)){
    		noOFmovies--;
    		WatchMovieListNode tmp=watchMoviesList;
    		if(tmp.getMovieId()==id){
    			watchMoviesList=tmp.getNext();
    			tmp.setNext(null);    			
    			return tmp;
    		}
    		
    		while(tmp.getNext()!=null){  			
    			if(tmp.getNext().getMovieId()==id){
    				WatchMovieListNode prev=tmp;    				
    				tmp=tmp.getNext();
    				prev.setNext(tmp.getNext());
    				tmp.setNext(null);
    				return tmp;
    			}
    			tmp=tmp.getNext();
    		}
    			
       	}
    	return null;
    }
    public boolean containsMovie(int id){
    	WatchMovieListNode tmp=watchMoviesList;
       	if(!isMoviesListEmpty()){
       		if (tmp.getMovieId()==id)
       			return true;
       		while(tmp.getNext()!=null){
       			tmp=tmp.getNext();
       			if(tmp.getMovieId()==id){
       				return true;
       			}
       		}
       	}       	
       	return false;	       	
       	
    }
    public boolean isMoviesListEmpty(){
    	return (noOFmovies==0);
    }
    public String toString(){
    	String movies="User: "+getUsername()+":";    	
    	WatchMovieListNode tmp=watchMoviesList;
    	while(tmp!=null){
    		movies=movies+"\n"+"	  -"+Integer.toString(tmp.getMovieId());
    		
    		
    		tmp=tmp.getNext();
    	}
    	
    	return movies+"\n";
    }
 

    public int genrNum(genre_t s,MovieList list){
    	noOfgenrMovs=0;
    	WatchMovieListNode tmp=watchMoviesList;
    	while(tmp.getNext()!=null){
    		tmp=tmp.getNext();
    		if(list.get(tmp.getMovieId()).getGenres().contains(s))
    			noOfgenrMovs++;
    	}
    	return noOfgenrMovs;
    }
    
   public int genrNum(genre_t s,LMovieHashTable tabl){
    	noOfgenrMovs=0;
    	WatchMovieListNode tmp=watchMoviesList;
    	while(tmp.getNext()!=null){
    		tmp=tmp.getNext();
    		if(tabl.get(tmp.getMovieId()).getGenres().contains(s))
    			noOfgenrMovs++;
    	}
    	return noOfgenrMovs;
    }
     
   public int genrNum(genre_t s,MovieBSTree tree){
   		noOfgenrMovs=0;
   		WatchMovieListNode tmp=watchMoviesList;
   		while(tmp.getNext()!=null){
   			tmp=tmp.getNext();
   			if(tree.get(tmp.getMovieId()).getGenres().contains(s))
   				noOfgenrMovs++;
   		}
   		return noOfgenrMovs;
   }
    
   public int genrNum(genre_t s,TMovieHashTable hash){
	   	noOfgenrMovs=0;
	   	WatchMovieListNode tmp=watchMoviesList;
	   	while(tmp.getNext()!=null){
	   		tmp=tmp.getNext();
	   		if(hash.get(tmp.getMovieId()).getGenres().contains(s))
	   			noOfgenrMovs++;
	   	}
	   	return noOfgenrMovs;
	   } 
    
    public WatchMovieListNode getHead(){
    	return	watchMoviesList;
    }
    
}
