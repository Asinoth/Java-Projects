/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.users;

import parser.MovieData.genre_t;

import phase1.lists.movies.MovieList;

/**
 *
 * 
 */
public class UserList {
    private UserListNode head;
    private int noOFusers;
    
    public UserList(){
    	this.head=null;
    	this.setNoOFusers(0);
    }
    
    public void insert(String username){
    	if(isEmpty()){
    		head=new UserListNode(username);
    		head.setNext(null);
    	}else{
    		UserListNode tmp=new UserListNode(username);
    		tmp.setNext(head);
    		head=tmp;
    	}
    	setNoOFusers(getNoOFusers() + 1);
    		
    }
    public UserListNode remove(String username){
    	if(get(username)!=null){
    		UserListNode prev=head;
    		if(head.getUsername().equals(username)){
    			head=prev.getNext();
    			prev.setNext(null);
    			noOFusers--;
    			return prev;
    		}else{
    			while(prev.getNext()!=null){
    				if(prev.getNext().getUsername().equals(username)){
    					UserListNode del=prev.getNext();
    					prev.setNext(del.getNext());
    					del.setNext(null);
    					noOFusers--;
    					return del;
    				}else
    					prev=prev.getNext();
    			}
    		}  		
    	}
    	return null;
    }
    public UserListNode get(String username){
    	UserListNode tmp=head;
    	if(!isEmpty()){
    		if(tmp.getUsername().equals(username))
    			return tmp;
    		while(tmp.getNext()!=null){
    			tmp=tmp.getNext();
    			if(tmp.getUsername().equals(username))
    				return tmp;
    		}
    	}
    	return null;
    }
    public boolean isEmpty(){
    	return (noOFusers==0);
    }

	public int getNoOFusers() {
		return noOFusers;
	}

	public void setNoOFusers(int noOFusers) {
		this.noOFusers = noOFusers;
	}
    
	/*public void Userdur(String username,MovieList list){
		get(username).Duration(list);
	}*/
	public void MostGenrUser(genre_t s,MovieList list){
		UserListNode tmp=head;
		UserListNode user=head.getNext();
		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum(s, list)<tmp.genrNum(s, list)){
				user=tmp;
			}
		}
		
		System.out.println("The user with the most movies in the given genre is "+user.getUsername());
	}
	
	/*public void MostGenrUser1(genre_t s,LMovieHashTable hash){
		UserListNode tmp=head;
		UserListNode user=head.getNext();
		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum1(s, hash)<tmp.genrNum1(s, hash)){
				user=tmp;
			}
		}
		
		System.out.println("The user with the most movies in the given genre is "+user.getUsername());
	}
	
	
	*/
	
	public UserListNode getHead(){
		return head;
	}
	
	
	public String toString(){
		String users="---------UserList---------"+"\n";
		UserListNode tmp=head;
		
		while(tmp!=null){
			users=users+tmp.toString();
			tmp=tmp.getNext();
		}
		users+="--------------------------"+"\n";
		return users;
	}
}
