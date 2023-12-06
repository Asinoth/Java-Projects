/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.users;

public class WatchMovieListNode {
    private int movieId;
    private WatchMovieListNode next;

    
    public WatchMovieListNode(int movieId) {
    	this.movieId=movieId;
    }
    public int getMovieId(){
    	return movieId;
    }
    public void setMovieId(int movieId){
    	this.movieId=movieId;	
    }
    public WatchMovieListNode getNext() {
    	return next;
    }
    public void setNext(WatchMovieListNode next) {
    	this.next=next;
    }

    
    
}
