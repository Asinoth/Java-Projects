/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3.trees;


import parser.MovieData;

/**
 *
 * 
 */
public class MovieBSTree {
    
    protected int size;         // The total number of elements in the tree
    protected MovieBSTreeNode root;  // The root node of the tree

    
    /**
     * Creates an empty BSTree
     */
    public MovieBSTree() {
    	this.size = 0;
    }
    
    
    
    /**
     * Inserts a BSTreeNode in the tree. The appropriate position of the leave of the
     * binary search tree is determined by the id of the MovieData
     * @param data
     */
    public void insert(MovieData data) {
    	MovieBSTreeNode insert = new MovieBSTreeNode(data.getId(),data.getTitle(),data.getYear(),data.getRating(),data.getVotes(),data.getDuration(),data.getGenres());
    	
    	if(size == 0)
    		root = insert;
    	else{
    		MovieBSTreeNode tmp = root;
    		while(true){
    			if(insert.getId()<tmp.getId()){
    				if(tmp.getlChild() == null){
    					tmp.setlChild(insert);
    					insert.setParent(tmp);
    					break;
    				}	
    				tmp = tmp.getlChild();    			
    			}else{
    				if(tmp.getrChild() == null){
    					tmp.setrChild(insert);
    					insert.setParent(tmp);
    					break;
    				}	    			
    				tmp = tmp.getrChild();
    			}
    		}
    	}
    	size++;
    	rebalance(insert);
    }
    
    
    
    /**
     * Removes the first occurrence of the specified element (id) from this tree, if it is
     * present (optional operation). If this tree does not contain the element, it is unchanged
     * @param id
     * @return the element which have been deleted or null if the element is not present
     */
    public MovieBSTreeNode remove(int id) {
    	MovieBSTreeNode nod = get(id);
    	if(size == 0 || nod ==null)
    		return null;
    	size--;
    	return deleteNode(nod);
    }
    
    
    
    /**
     * Returns the element with the specified id in the tree or null if it not present
     * @param id
     * @return the element
     */
    public MovieBSTreeNode get(int id) {
    	MovieBSTreeNode tmp = this.root;
    	while(tmp != null){
    		if(tmp.getId()<id)
    			tmp = tmp.getrChild();
    		else if(tmp.getId()>id)
    			tmp = tmp.getlChild();
    		else
    			return tmp;
    	}
    	return null;
    }
    
    
            
    /**
     * Removes all of the elements from this tree. The tree will be empty
     * after this call returns
     */
    public void clear() {
    	this.root = null;
    	this.root.setlChild(null);
    	this.root.setrChild(null);
    	this.size = 0;
    }
    
    
    public String toString(){
    	String out="";
    	return inOrderString(getRoot(), out); 	
    }
   
    
    ///////BOOLEAN/////////
    
    /**
     * Returns true if this tree contains no elements
     * @return true if the number of elements in hashTable equals to 0 and false otherwise
     */
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public boolean isRoot(MovieBSTreeNode tmp){
    	return tmp == root;
    }
    
    public boolean isRight(MovieBSTreeNode tmp){
    	if(tmp==root)
    		return false;
    	else 
    		return tmp.getParent().getrChild()==tmp;    			
    }
  
    public boolean isLeft(MovieBSTreeNode nod){
    	if(nod==root)
    		return false;
    	else 
    		return nod.getParent().getlChild()==nod;    			
    }

    public boolean isInternal(MovieBSTreeNode nod){
    	if(nod.getrChild() != null || nod.getlChild() != null)
    		return true;
    	return false;
    }
    
    public boolean isExternal(MovieBSTreeNode nod){
    	if(nod.getrChild() == null && nod.getlChild() == null)
    		return true;
    	return false;

    }
    
    ////setters/getters/////
    
    ///getters////
    
    /**
     * Returns the number of all elements that are inside the tree
     * @return nElements
     */
    public int getSize() {
    	return size;
    }
    
    public MovieBSTreeNode getRoot(){
    	return root;
    }
        
    ///setters/////
    
    public void setSize(int size){
    	this.size = size;
    }
    
    public void setRoot(MovieBSTreeNode root){
    	this.root = root;
    }
    
    
    
    /////balance////
    
    private int getLeftSonHeight(MovieBSTreeNode nod){
    	if(nod == null)
    		return -1;
    	return (nod.getlChild()!=null ? nod.getlChild().getHeight() : 0);    		
    }
    
    private int getRightSonHeight(MovieBSTreeNode nod){
    	if(nod == null)
    		return -1;
    	return (nod.getrChild()!=null ? nod.getrChild().getHeight() : 0);    		
    }
     
    private boolean isBlanced(MovieBSTreeNode nod){
    	if(nod == null)
    		return false;
    	return Math.abs(getRightSonHeight(nod)-getLeftSonHeight(nod))<=1;
    	
    	
    }
   
    private void remedyHeight(MovieBSTreeNode nod){
    	if(nod == null)
    		return;
    	nod.setHeight(1+Math.max(getLeftSonHeight(nod),getRightSonHeight(nod)));
        	
    }
    
    private MovieBSTreeNode reconstruct(MovieBSTreeNode nod, MovieBSTreeNode son, MovieBSTreeNode grson){
    	if(isLeft(son) && isLeft(grson)){
    		if(!isRoot(nod)){
    			if(isLeft(nod))
    				nod.getParent().setlChild(son);
    			else
    				nod.getParent().setrChild(son);
    			son.setParent(nod.getParent());	
    		}
    		nod.setlChild(son.getrChild());
    		if(son.getrChild() != null)
    			son.getrChild().setParent(nod);
    		son.setrChild(nod);
    		nod.setParent(son);
    		if(isRoot(nod)){
    			setRoot(son);
    			son.setParent(null);    			
    		}
    		return son;
    	}else if(isRight(son)&&isRight(grson)){                   
    		if(!isRoot(nod)){
    			if(isRight(nod))
    				nod.getParent().setrChild(son);
    			else
    				nod.getParent().setlChild(son);
    			son.setParent(nod.getParent());
    		}
    		nod.setrChild(son.getlChild());
    		if(son.getlChild() != null)
    			son.getlChild().setParent(nod);
    		son.setlChild(nod);
    		nod.setParent(son);
    		if(isRoot(nod)){
    			setRoot(son);
    			son.setParent(null);
    		}
    		return son;    			
    	}else if(isLeft(grson)){
    		nod.setrChild(grson.getlChild());
    		if(grson.getlChild() != null )
    			grson.getlChild().setParent(nod);
    		son.setlChild(grson.getrChild());
    		if(grson.getrChild() != null)
    			grson.getrChild().setParent(son);
    		if(!isRoot(nod)){
    			if(isRight(nod))
    				nod.getParent().setrChild(grson);
    			else
    				nod.getParent().setlChild(grson);
    		grson.setParent(nod.getParent());	
    		}
    		nod.setParent(grson);
    		son.setParent(grson);
    		grson.setlChild(nod);
    		grson.setrChild(son);
    		if(isRoot(nod)){
    			setRoot(grson);
    			grson.setParent(null);
    		}
    		return grson;
    	}else{
    		nod.setlChild(grson.getrChild());
    		if(grson.getrChild() != null)
    			grson.getrChild().setParent(nod);
    		son.setrChild(grson.getlChild());
    		if(grson.getlChild() != null)
    			grson.getlChild().setParent(son);
    		if(!isRoot(nod)){
    			if(isLeft(nod))
    				nod.getParent().setlChild(grson);
    			else
    				nod.getParent().setrChild(grson);
    			grson.setParent(nod.getParent());
    		}
    		nod.setParent(grson);
    		son.setParent(grson);
    		grson.setlChild(son);
    		grson.setrChild(nod);
    		if(isRoot(nod)){
    			setRoot(grson);
    			grson.setParent(null);
    		}
    		return grson;	
    		
    	}
    		
    }
    
    private MovieBSTreeNode rebalanceSon(MovieBSTreeNode nod){
    	if( nod == null)
    		return null;
    	if(getLeftSonHeight(nod)>getRightSonHeight(nod))
    		return nod.getlChild();
    	else if(getLeftSonHeight(nod)<getRightSonHeight(nod))
    		return nod.getrChild();
    	else if (isLeft(nod))
    		return nod.getlChild();
    	else
    		return nod.getrChild();
    }
    
    private void rebalance(MovieBSTreeNode nod){
    	if(nod == null)
    		return;
    	MovieBSTreeNode son,grson;
    	while (nod != null){
    		remedyHeight(nod);
    		if(!isBlanced(nod)){
    			son = rebalanceSon(nod);
    			grson = rebalanceSon(son);
    			nod = reconstruct(nod ,son ,grson);                
    			remedyHeight(nod.getlChild());
    			remedyHeight(nod.getrChild());
    			remedyHeight(nod);
    		}
    		nod = nod.getParent();
    					
    		
    	}
    	

    }
    
    public void inOrder(MovieBSTreeNode nod){
    	if(nod!=null){
    		if(isInternal(nod)){
    			inOrder(nod.getlChild());
    		}    	
    		System.out.println(nod.getId());	
    		if(isInternal(nod)){
    			inOrder(nod.getrChild());
    		}
    	}
    }
    
    private String inOrderString(MovieBSTreeNode nod,String out){
    	if(nod!=null){
    		if(isInternal(nod)){
    			out=inOrderString(nod.getlChild(),out);
    		}    	
    		out+=nod.toString();	
    		if(isInternal(nod)){
    			out=inOrderString(nod.getrChild(),out);
    		}
    	}
    	return out;
    }
    

    public void toStinga(){
    	/*System.out.println(root.getId()+"\t");
    	System.out.print(root.getlChild().getId()+"\t");
    	System.out.println(root.getrChild().getId()+"\t");
    	System.out.print(root.getlChild().getlChild().getId()+"\t");
    	System.out.print(root.getlChild().getrChild().getId()+"\t");
    	System.out.print(root.getrChild().getlChild().getId()+"\t");
    	System.out.println(root.getrChild().getrChild().getId()+"\t");
    	System.out.print(root.getlChild().getlChild().getlChild().getId()+"\t");
    	//System.out.println(root.getlChild().getlChild().getrChild().getId());
    	System.out.print(root.getlChild().getrChild().getlChild().getId()+"\t");
    	//System.out.println(root.getlChild().getrChild().getrChild().getId());
    	System.out.println(root.getrChild().getlChild().getlChild().getId()+"\t");
    	//System.out.println(root.getrChild().getlChild().getrChild().getId());
    	//System.out.println(root.getrChild().getrChild().getlChild().getId());
    //	System.out.println(root.getrChild().getrChild().getrChild().getId());*/
    	System.out.println(root.getlChild().getlChild().getlChild().getHeight());
    }
 
    private MovieBSTreeNode deleteNode(MovieBSTreeNode nod){
    	if(nod.getlChild() == null && nod.getrChild() == null){
    		if(isLeft(nod))
    			nod.getParent().setlChild(null);
    		else
    			nod.getParent().setrChild(null);
    		return nod;
    	}else if((nod.getlChild() != null && nod.getrChild() == null) && (nod.getlChild() == null && nod.getrChild() != null)){
    		if(isLeft(nod)){
    			if(nod.getlChild()!=null){
    				nod.getParent().setlChild(nod.getlChild());
    				nod.getlChild().setParent(nod.getParent());
    			}else{
    				nod.getParent().setlChild(nod.getrChild());
    				nod.getrChild().setParent(nod.getParent());
    			}
    			return nod;
    		}else{ 
    			if(nod.getlChild()!=null){
    				nod.getParent().setrChild(nod.getlChild());
    				nod.getlChild().setParent(nod.getParent());
    			}else{
    				nod.getParent().setrChild(nod.getrChild());
    				nod.getrChild().setParent(nod.getParent());
    			}
    			return nod;
    		}
    	}else{
    		MovieBSTreeNode tmp = minValue(nod);
    		tmp.getParent().setlChild(tmp.getrChild());
    		if(tmp.getrChild()!=null){
    			tmp.getrChild().setParent(nod.getParent());
    			rebalance(tmp.getParent());
    		}else
    			rebalance(tmp.getParent());
    		if(!isRoot(nod)){
    			if(isLeft(nod))
    				nod.getParent().setlChild(tmp);
    			else
    				nod.getParent().setrChild(tmp);
    			tmp.setParent(nod.getParent());
    		}else{
    			tmp.setParent(null);
    			setRoot(tmp);
    		}
    		tmp.setlChild(nod.getlChild());
    		tmp.setrChild(nod.getrChild());
    		return nod;
    	}
    }

    private MovieBSTreeNode minValue(MovieBSTreeNode nod){
    	while(nod.getlChild() != null)
    		nod = nod.getlChild();
    	return nod;
    	
    }
    
    
}
