package phase4.PQ;

import parser.MovieData;
import phase3.trees.MovieBSTreeNode;

public class pQueue {
	
	MovieBSTreeNode root;
	public MovieBSTreeNode last;
	MovieBSTreeNode seclast;
	int size;
	
	public pQueue(){
		this.root = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insert(MovieData data){
		MovieBSTreeNode insert = new MovieBSTreeNode(data.getId(),data.getTitle(),data.getYear(),data.getRating(),data.getVotes(),data.getDuration(),data.getGenres());  	
		
		if(size == 0){
    		root = insert;
    		last = insert;
		}else if(root == last ){			
			if( insert.rank()>root.rank()){
				insert.setlChild(root);
				root.setParent(insert);
				last = root;
				root = insert;
			}else 
				root.setlChild(insert);
				insert.setParent(root);
        		last = insert;    	
		}else{
			MovieBSTreeNode tmp = last;
			if(isLeft(tmp)){
				tmp.getParent().setrChild(insert);
				insert.setParent(tmp.getParent());
			}else{			
				while(isRight(tmp))
					tmp=tmp.getParent();
				if(!isRoot(tmp))
					tmp = tmp.getParent().getrChild();
				while(!(tmp.getlChild() == null))
					tmp = tmp.getlChild();
				tmp.setlChild(insert);	
				insert.setParent(tmp);
			}
			if(insert.rank()>insert.getParent().rank())
				last = insert.getParent();
			else
        		last = insert;
    		
        	swapPar(insert);
    	}
    	size++;
    	
    	
    	
		
	}
	
	
	
	public MovieBSTreeNode newLast(){
		MovieBSTreeNode tmp = last;
		if(isRight(tmp)){			
			return tmp.getParent().getlChild();			
		}while(isLeft(tmp))
			tmp=tmp.getParent();
		if(!isRoot(tmp))
			tmp = tmp.getParent().getlChild();
		while(!(tmp.getrChild() == null))
			tmp = tmp.getrChild();
		return tmp;
		
	}
	
	
	public MovieBSTreeNode getMax(){
		MovieBSTreeNode max = root;
		MovieBSTreeNode secLast = newLast();
		if(isRight(last))
			last.getParent().setrChild(null);
		else 
			last.getParent().setlChild(null);
		last.setlChild(root.getlChild());
		last.setrChild(root.getrChild());
		if(root.getrChild()!=null)
			root.getrChild().setParent(last);
		if(root.getlChild()!=null)
			root.getlChild().setParent(last);
		last.setParent(null);
		root = last;
		
		swapPar1(root);
		if(secLast.getrChild()!=last && secLast.getlChild()!=last)
			last = secLast;
		size -- ;
		return max;
	
	}
	
	

	private void swapPar1(MovieBSTreeNode nod){
		MovieBSTreeNode rchild,lchild,tmp;
		rchild = nod.getrChild();
		lchild = nod.getlChild();
		
		if(lchild!=null&&rchild==null){
			
			if(lchild.rank()>nod.rank()){
				
				if(isRight(nod)){
					nod.getParent().setrChild(lchild);
					lchild.setParent(nod.getParent());
					lchild.setlChild(nod);
					nod.setParent(lchild);
					return ; 
				}else{
					nod.getParent().setlChild(lchild);
					lchild.setParent(nod.getParent());
					lchild.setlChild(nod);
					nod.setParent(lchild);
					return ; 
			
				}
			} 			
		}else if(lchild!=null&&lchild!=null){
			if(rchild.rank()>lchild.rank())
				tmp = rchild;
			else 
				tmp = lchild;
			if(tmp.rank()>nod.rank()){
				swap(tmp);
				swapPar1(nod);
			}	
		}else if(lchild ==null&&rchild == null)
			return;
			
	}	
		
	private void swap(MovieBSTreeNode nod){
		if(!isRoot(nod)){
    		MovieBSTreeNode par = nod.getParent();
    		MovieBSTreeNode rchild,lchild ;
    		if(par.rank()<nod.rank()){
    			if(isRoot(par)){    				
    				rchild = nod.getrChild();
    				lchild = nod.getlChild();
    				if(isRight(nod)){    					
    					nod.setlChild(par.getlChild());
    					nod.setrChild(par);
    					par.getlChild().setParent(nod);    					
    				}else{
    					nod.setrChild(par.getrChild());
    					nod.setlChild(par);
    					par.getrChild().setParent(nod);
    				}
    				par.setlChild(lchild);
    				par.setrChild(rchild);
    				if(lchild!=null)
    					lchild.setParent(par);
    				if(rchild!=null)
    					rchild.setParent(par);
    				par.setParent(nod);
    				nod.setParent(null);
    				root = nod;
    				
    			}else{
    				rchild = nod.getrChild();
    				lchild = nod.getlChild();  
    				boolean flag = isRight(nod);
     				if(isRight(par)){
    					par.getParent().setrChild(nod);
    					nod.setParent(par.getParent());
    					par.setParent(nod);   				
    				}else{
    					par.getParent().setlChild(nod);
    					nod.setParent(par.getParent());
    					par.setParent(nod);
    				}
    				if(flag){
    					nod.setrChild(par);
    					nod.setlChild(par.getlChild());
    					if(par.getlChild()!=null)
    						par.getlChild().setParent(nod);
    				}else{
    					nod.setlChild(par);
    					nod.setrChild(par.getrChild());
    					if(par.getrChild()!=null)
    						par.getrChild().setParent(nod); 
    				} 
    				par.setlChild(lchild);
    				par.setrChild(rchild);
    				if(lchild!=null)
    					lchild.setParent(par);
    				if(rchild!=null)
    					rchild.setParent(par);
    			}
    		}
		}
		
	}
			
			
			
			
	
	
	
	
	/////////////////////////////////////////////

	public boolean isEmpty() {
    	return size == 0;
    }
    
	private boolean isRoot(MovieBSTreeNode tmp){
    	return tmp == root;
    }
    
    private boolean isRight(MovieBSTreeNode tmp){
    	if(tmp==root)
    		return false;
    	else 
    		return tmp.getParent().getrChild()==tmp;    			
    }
  
    private boolean isLeft(MovieBSTreeNode nod){
    	if(nod==root)
    		return false;
    	else 
    		return nod.getParent().getlChild()==nod;    			
    }

    private void swapPar(MovieBSTreeNode nod){   
    		if(!isRoot(nod)){
    		MovieBSTreeNode par = nod.getParent();
    		MovieBSTreeNode rchild,lchild ;
    		if(par.rank()<nod.rank()){
    			if(isRoot(par)){    				
    				rchild = nod.getrChild();
    				lchild = nod.getlChild();
    				if(isRight(nod)){    					
    					nod.setlChild(par.getlChild());
    					nod.setrChild(par);
    					par.getlChild().setParent(nod);    					
    				}else{
    					nod.setrChild(par.getrChild());
    					nod.setlChild(par);
    					par.getrChild().setParent(nod);
    				}
    				par.setlChild(lchild);
    				par.setrChild(rchild);
    				if(lchild!=null)
    					lchild.setParent(par);
    				if(rchild!=null)
    					rchild.setParent(par);
    				par.setParent(nod);
    				nod.setParent(null);
    				root = nod;
    				
    			}else{
    				rchild = nod.getrChild();
    				lchild = nod.getlChild();  
    				boolean flag = isRight(nod);
     				if(isRight(par)){
    					par.getParent().setrChild(nod);
    					nod.setParent(par.getParent());
    					par.setParent(nod);   				
    				}else{
    					par.getParent().setlChild(nod);
    					nod.setParent(par.getParent());
    					par.setParent(nod);
    				}
    				if(flag){
    					nod.setrChild(par);
    					nod.setlChild(par.getlChild());
    					if(par.getlChild()!=null)
    						par.getlChild().setParent(nod);
    				}else{
    					nod.setlChild(par);
    					nod.setrChild(par.getrChild());
    					if(par.getrChild()!=null)
    						par.getrChild().setParent(nod); 
    				} 
    				par.setlChild(lchild);
    				par.setrChild(rchild);
    				if(lchild!=null)
    					lchild.setParent(par);
    				if(rchild!=null)
    					rchild.setParent(par);
    			
    				swapPar(nod);	
    			}
    		}
    	}
  }
    

    public MovieBSTreeNode getRoot(){
    	return root;
    }
    

    
    
}


