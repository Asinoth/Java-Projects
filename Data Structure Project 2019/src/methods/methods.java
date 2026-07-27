package methods;




import java.io.IOException;
import java.util.Collection;
import java.util.EnumMap;
import comparators.MovieListComparatorByRank;
import parser.EventData;
import parser.FileParsers;
import parser.MovieData;
import parser.MovieData.genre_t;
import phase1.lists.movies.*;
import phase1.lists.users.*;
import phase2.hashtables.withLists.LMovieHashTable;
import phase3.hashtables.withTrees.TMovieHashTable;
import phase3.trees.MovieBSTree;
import phase3.trees.MovieBSTreeNode;
import phase4.PQ.pQueue;

public class methods {
	
	
	//////Questions phase 1////////
	public MovieListNode maxRank(MovieList list){
		MovieListNode best=list.getHead().getNext();
    	MovieListNode tmp=list.getHead();
    	while(tmp.getNext()!=list.getTail()){
    		tmp=tmp.getNext();
    		if(best.rank()<tmp.rank()){
    			best=tmp;
    		}	
    	}
		return best;
    }
	
	public MovieListNode maxRank(MovieList list ,genre_t s){
		MovieListNode best=list.getHead().getNext();
    	MovieListNode tmp=list.getHead();
    	while(tmp.getNext()!=list.getTail()){
    		tmp=tmp.getNext();
    		if(best == null && tmp.getGenres().contains(s))
    			best = tmp;
    		else if(best.rank()<tmp.rank() && tmp.getGenres().contains(s)){
    			best=tmp;
    		}	
    	}
		return best;
    }
		
	public int noOfMovies(MovieList list, int y1, int y2){
    	int no=0;
    	MovieListNode tmp=list.getHead();
    	while(tmp.getNext()!=list.getTail()){
    		tmp=tmp.getNext();
    		if(y1<=tmp.getYear()&&tmp.getYear()<=y2)
    			no++;
    	}
    	return no;
	 } 
    	
	public MovieList genr(MovieList list, genre_t s, genre_t t){
	    MovieList genrList = new UnsortedMovieList();
		MovieListNode tmp=list.getHead();
	    while(tmp.getNext()!=list.getTail()){
	    	tmp=tmp.getNext();
	    		if(tmp.getGenres().contains(s)&&(tmp.getGenres().contains(t)))
	    			genrList.insert(tmp.toData());
	    }
	    return genrList;	    	
	}
	
	public int Duration(MovieList list, UserList users , String username ){
		int dur=0;
		try{
		UserListNode user = users.get(username);
    	WatchMovieListNode tmp=user.getHead();
    	while(tmp.getNext()!=null){
    		tmp=tmp.getNext();
    		dur+=list.get(tmp.getMovieId()).getDuration();
    	}
		}catch(NullPointerException e){		
    		return dur;}
		return dur;		
	}
	
	public UserListNode UserGenr(MovieList list, UserList users, genre_t t){
		UserListNode tmp=users.getHead();
		UserListNode user=users.getHead().getNext();		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum(t, list)<tmp.genrNum(t, list)){
				user=tmp;
			}
		}			
		return user;
	}
		
	public MovieList top10(MovieList list){
		BonusMovieList bonus = new BonusMovieList(new MovieListComparatorByRank());
		while(!list.isEmpty())
			bonus.insertBonus(list.deleteFirst().toData());	
		return bonus;
		
	}
	
	//////Questions phase 2////////
	
	public MovieListNode maxRank(LMovieHashTable hash){
		MovieListNode tmp=null;
    	for(int i=0;i<hash.getTableSize();i++){
    		if(hash.getTableIndex(i)!=null)
    			if(tmp==null) 
    				tmp=maxRank(hash.getTableIndex(i));
    			else if(tmp.rank()<maxRank(hash.getTableIndex(i)).rank())
    				tmp=maxRank(hash.getTableIndex(i));
    	}
      	return tmp;		
	}
	
	public MovieListNode maxRank(LMovieHashTable hash ,genre_t s){
		MovieListNode tmp=null;
    	for(int i=0;i<hash.getTableSize();i++){
    		if(hash.getTableIndex(i)!=null)
    			if(tmp==null) 
    				tmp=maxRank(hash.getTableIndex(i),s);
    			else if(tmp.rank()<maxRank(hash.getTableIndex(i)).rank())
    				tmp=maxRank(hash.getTableIndex(i),s);
    	}
      	return tmp;		
	}
	
	public int noOfMovies(LMovieHashTable hash, int y1, int y2){
    	int num=0;
    	for(int i=0;i<hash.getTableSize();i++){
    		if(!hash.getTableIndex(i).isEmpty()){
    			num+= noOfMovies(hash.getTableIndex(i), y1, y2);
    		}	
    	}
    	return num;
    }		
	
	public MovieList genr(LMovieHashTable hash, genre_t s, genre_t t){
    	MovieList genrList = new UnsortedMovieList();
    	for(int i=0;i<hash.getTableSize();i++)
    		genrList.append(genr(hash.getTableIndex(i), s, t));
    	return genrList;
	
	}
	
	public int Duration(LMovieHashTable hash, UserList users , String username){
		int dur = 0;
		for(int i = 0;i<hash.getTableSize();i++)
			dur += Duration(hash.getTableIndex(i), users ,username);
		return dur;
	}

	public UserListNode UserGenr(LMovieHashTable hash, UserList users , genre_t t){
		UserListNode tmp=users.getHead();
		UserListNode user=users.getHead().getNext();		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum(t, hash)<tmp.genrNum(t, hash)){
				user=tmp;
			}
		}			
		return user;
	}
	
	public MovieList top10(LMovieHashTable hash){
		BonusMovieList bonus = new BonusMovieList(new MovieListComparatorByRank());
		for(int i = 0;i<hash.getTableSize();i++){
			while(!hash.getTableIndex(i).isEmpty()){
				bonus.insertBonus(hash.getTableIndex(i).deleteFirst().toData());
			}
		}
		return bonus;
	}
		
	//////Questions phase 3 Simple trees//////
	
	public MovieBSTreeNode maxRank(MovieBSTree tree){		
		return inOrderMaxRank(tree,tree.getRoot(),tree.getRoot());		
	}
	
	public MovieBSTreeNode maxRank(MovieBSTree tree , genre_t s){		
		return inOrderMaxRank(tree,tree.getRoot(),tree.getRoot(),s);		
	}
	
	public int noOfMovies(MovieBSTree tree, int y1, int y2){
		int num = 0;
		return inOrderNumoFMovies(tree, tree.getRoot(),num , y1 , y2);
	}
	
	public MovieList genr(MovieBSTree tree, genre_t s, genre_t t){
		MovieList genrList = new UnsortedMovieList();
		genrList = inOrderGenreList(tree, tree.getRoot(), genrList, s, t);	
		return genrList;
	}
	
	public int Duration(MovieBSTree tree, UserList users , String username ){
		int dur=0;
		try{
		UserListNode user = users.get(username);
    	WatchMovieListNode tmp=user.getHead();
    	while(tmp.getNext()!=null){
    		tmp=tmp.getNext();
    		dur+=tree.get(tmp.getMovieId()).getDuration();
    	}
		}catch(NullPointerException e){		
    		return dur;}
		return dur;		
	}
	
	public UserListNode UserGenr(MovieBSTree tree, UserList users , genre_t t){
		UserListNode tmp=users.getHead();
		UserListNode user=users.getHead().getNext();		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum(t, tree)<tmp.genrNum(t, tree)){
				user=tmp;
			}
		}			
		return user;
	}
			
	public BonusMovieList top10(MovieBSTree tree){
		BonusMovieList bonus = new BonusMovieList(new MovieListComparatorByRank());		
		return inOrderBonus(tree, tree.getRoot(), bonus);		
	}
	
	
	//////Questions phase 3 Hash trees /////
	
	public MovieBSTreeNode maxRank(TMovieHashTable table){
		MovieBSTreeNode max=null;
		for(int i = 0;i < table.getTableSize();i++){
			if(!table.getTableIndex(i).isEmpty()){
				if(max ==null)
					max = maxRank(table.getTableIndex(i));
				else 
					if(max.rank()<maxRank(table.getTableIndex(i)).rank())
						max = maxRank(table.getTableIndex(i));
			}
		}
		return max;
	}
	
	public MovieBSTreeNode maxRank(TMovieHashTable table, genre_t s){
		MovieBSTreeNode max=null;
		for(int i = 0;i < table.getTableSize();i++){
			if(!table.getTableIndex(i).isEmpty()){
				if(max ==null)
					max = maxRank(table.getTableIndex(i), s);
				else 
					if(max.rank()<maxRank(table.getTableIndex(i)).rank())
						max = maxRank(table.getTableIndex(i), s);
			}
		}
		return max;
	}
	
	public int noOfMovies(TMovieHashTable table, int y1, int y2){
		int num = 0;
		for(int i = 0;i < table.getTableSize();i++)
			num+=(noOfMovies(table.getTableIndex(i),y1,y2));		
		return num;		
	}
	
	public MovieList genr(TMovieHashTable table, genre_t s, genre_t t){
		MovieList genrList = new UnsortedMovieList();
		for(int i=0;i<table.getTableSize();i++)
    		genrList.append(genr(table.getTableIndex(i), s, t));	
		return genrList;
	}
	
	public int Duration(TMovieHashTable table, UserList users , String username){
		int dur = 0;
		for(int i = 0;i<table.getTableSize();i++)
			dur += Duration(table.getTableIndex(i), users ,username);
		return dur;
	}
	
	public UserListNode UserGenr(TMovieHashTable table, UserList users , genre_t t){
		UserListNode tmp=users.getHead();
		UserListNode user=users.getHead().getNext();		
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			if(user.genrNum(t, table)<tmp.genrNum(t, table)){
				user=tmp;
			}
		}			
		return user;
	}
	
	public MovieList top10(TMovieHashTable table){
		BonusMovieList bonus = new BonusMovieList(new MovieListComparatorByRank());
		for(int i = 0;i<table.getTableSize();i++){
			if(!table.getTableIndex(i).isEmpty()){
				bonus=inOrderBonus(table.getTableIndex(i) , table.getTableIndex(i).getRoot() , bonus);
			}
		}
		return bonus;
	}

	//////Questions phase 4 Priority Queue /////
	
	public MovieBSTreeNode maxRank(EnumMap<genre_t, pQueue> GenreMap){
		MovieBSTreeNode max = null;
		
		Collection<pQueue> list = GenreMap.values();
		for (pQueue elem : list){
			if(max==null)
				max = elem.getRoot();
			else if(max.rank()<elem.getRoot().rank())
				max = elem.getRoot();
		}
		return max;
	}
	
	
	//////Methods for initialization/////
	
	//////Movies init ///////
	
	public MovieList init(MovieList list , String filepath1 , String filepath2) throws IOException{
		FileParsers.initializeParsers(filepath1 , filepath2 );
		long time1 , time2 ;
		time1=System.currentTimeMillis();
        while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            list.insert(movie);
        }
		time2=System.currentTimeMillis();
		System.out.println("The list took "+(time2-time1)+" time to fill");
		FileParsers.finalizeParsers();
		return list;
	}	
			
	public LMovieHashTable init(LMovieHashTable hash , String filepath1 , String filepath2) throws IOException{
		FileParsers.initializeParsers(filepath1 , filepath2 );
		long time1 , time2 ;
		time1=System.currentTimeMillis();
        while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            hash.insert(movie);
        }
		time2=System.currentTimeMillis();
		System.out.println("The List hash table took "+(time2-time1)+" time to fill");
		FileParsers.finalizeParsers();
		return hash;
	}

	public MovieBSTree init(MovieBSTree tree , String filepath1 , String filepath2) throws IOException{
		FileParsers.initializeParsers(filepath1 , filepath2 );
		long time1 , time2 ;
		time1=System.currentTimeMillis();
        while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            tree.insert(movie);
        }
		time2=System.currentTimeMillis();
		System.out.println("The tree took "+(time2-time1)+" time to fill");
		FileParsers.finalizeParsers();
		return tree;
	}
	
	public TMovieHashTable init(TMovieHashTable hash , String filepath1 , String filepath2) throws IOException{
		FileParsers.initializeParsers(filepath1 , filepath2 );
		long time1 , time2 ;
		time1=System.currentTimeMillis();
        while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            hash.insert(movie);
        }
		time2=System.currentTimeMillis();
		System.out.println("The Tree hash table took "+(time2-time1)+" time to fill");
		FileParsers.finalizeParsers();
		return hash;
	
	}
		
	public EnumMap<genre_t, pQueue> init(EnumMap<genre_t, pQueue> GenreMap,String FilePath1 ,String FilePath2 ) throws IOException{
		FileParsers.initializeParsers(FilePath1 , FilePath2 );
		int i;
		int size=0;
		long time1 , time2 ;
		time1=System.currentTimeMillis();
		while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            i=0;
            
            while(i<movie.getGenres().size()){
            	size++;
            	if(GenreMap.containsKey(movie.getGenres().get(i)))
            		GenreMap.get(movie.getGenres().get(i)).insert(movie);
            	else{
            		GenreMap.put(movie.getGenres().get(i), new pQueue());		 
            		GenreMap.get(movie.getGenres().get(i)).insert(movie);
            	}	
            	i++;
            	
            }
		}    
		time2=System.currentTimeMillis();
		System.out.println("The PQ took "+(time2-time1)+" time to fill");
		System.out.println(size);
        FileParsers.finalizeParsers();
		return GenreMap;
		
	}
	
	
	//////Users init ///////
	

	public UserList initUsers(MovieList list , String filepath1 , String filepath2) throws IOException{
		UserList users = new UserList();
		FileParsers.initializeParsers(filepath1, filepath2);
		while( FileParsers.hasNextEvent() ){
            EventData event = FileParsers.getNextEvent();
            System.out.print("["+event.getOperation()+"]  -  ["+event.getUsername()+"]  -  [");
            System.out.println(event.getMovieId()+"]");
            System.out.print("Searching title...");
            if(list.get(event.getMovieId())==null){
            	System.out.println("title not found");
            	System.out.print("Action: Movie ");
            	System.out.print(event.getMovieId());
            	System.out.println(" doesnt exist in database. Ignoring event ...");           	
            }else{
            	System.out.print("success");
            	System.out.println("["+list.get(event.getMovieId()).getTitle()+"]");
            	System.out.print("Action: ");
            	if(users.get(event.getUsername())==null){
            		System.out.print("User doesn't exist.");
            		if(event.getOperation().equals("I")){
            			System.out.println("Creating user and inserting movie...");
            			users.insert(event.getUsername());
            			users.get(event.getUsername()).insertMovie(event.getMovieId());
            		}else
            			System.out.println("Do nothing...");
            	}else{
            		System.out.print("User exists.");
            		if(event.getOperation().equals("I")){
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie already in list. Do nothing ...");
            			}else{
            				System.out.println("Movie not in list. Adding movie...");
            				users.get(event.getUsername()).insertMovie(event.getMovieId());
            			}            				
            		}else{
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie exist. Removing from list ...");
            				users.get(event.getUsername()).removeMovie(event.getMovieId());
            				if(users.get(event.getUsername()).isMoviesListEmpty()){
            					users.remove(event.getUsername());
            					System.out.print("User ");
            					System.out.print(event.getUsername());
            					System.out.println(" deleted...");
            				}
            			}else
            				System.out.println("Movie doesn't exist. Do nothing...");
            		}            		
            	}
           }            	
           //System.out.println(users.toString());	              
		}
		return users;
		
		
	}
	
	public UserList initUsersNo(MovieList list , String filepath1 , String filepath2) throws IOException{
		UserList users = new UserList();
		FileParsers.initializeParsers(filepath1, filepath2);
		while( FileParsers.hasNextEvent() ){
            EventData event = FileParsers.getNextEvent();
              if(list.get(event.getMovieId())==null){
                }else{
               	if(users.get(event.getUsername())==null){
             		if(event.getOperation().equals("I")){
            			}
             	}else{
              		if(event.getOperation().equals("I")){
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
             			}else{
              				users.get(event.getUsername()).insertMovie(event.getMovieId());
            			}            				
            		}else{
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				users.get(event.getUsername()).removeMovie(event.getMovieId());
            				if(users.get(event.getUsername()).isMoviesListEmpty()){
                				}
            			}
            			
            		}            		
            	}
           }            	
            
		}
		return users;
		
		
	}
	
	public UserList initUsers(LMovieHashTable list , String filepath1 , String filepath2) throws IOException{
		UserList users = new UserList();
		FileParsers.initializeParsers(filepath1, filepath2);
		while( FileParsers.hasNextEvent() ){
            EventData event = FileParsers.getNextEvent();
            System.out.print("["+event.getOperation()+"]  -  ["+event.getUsername()+"]  -  [");
            System.out.println(event.getMovieId()+"]");
            System.out.print("Searching title...");
            if(list.get(event.getMovieId())==null){
            	System.out.println("title not found");
            	System.out.print("Action: Movie ");
            	System.out.print(event.getMovieId());
            	System.out.println(" doesnt exist in database. Ignoring event ...");           	
            }else{
            	System.out.print("success");
            	System.out.println("["+list.get(event.getMovieId()).getTitle()+"]");
            	System.out.print("Action: ");
            	if(users.get(event.getUsername())==null){
            		System.out.print("User doesn't exist.");
            		if(event.getOperation().equals("I")){
            			System.out.println("Creating user and inserting movie...");
            			users.insert(event.getUsername());
            			users.get(event.getUsername()).insertMovie(event.getMovieId());
            		}else
            			System.out.println("Do nothing...");
            	}else{
            		System.out.print("User exists.");
            		if(event.getOperation().equals("I")){
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie already in list. Do nothing ...");
            			}else{
            				System.out.println("Movie not in list. Adding movie...");
            				users.get(event.getUsername()).insertMovie(event.getMovieId());
            			}            				
            		}else{
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie exist. Removing from list ...");
            				users.get(event.getUsername()).removeMovie(event.getMovieId());
            				if(users.get(event.getUsername()).isMoviesListEmpty()){
            					users.remove(event.getUsername());
            					System.out.print("User ");
            					System.out.print(event.getUsername());
            					System.out.println(" deleted...");
            				}
            			}else
            				System.out.println("Movie doesn't exist. Do nothing...");
            		}            		
            	}
           }            	
           //System.out.println(users.toString());	              
		}
		return users;
		
		
	}

	public UserList initUsers(MovieBSTree list , String filepath1 , String filepath2) throws IOException{
		UserList users = new UserList();
		FileParsers.initializeParsers(filepath1, filepath2);
		while( FileParsers.hasNextEvent() ){
            EventData event = FileParsers.getNextEvent();
            System.out.print("["+event.getOperation()+"]  -  ["+event.getUsername()+"]  -  [");
            System.out.println(event.getMovieId()+"]");
            System.out.print("Searching title...");
            if(list.get(event.getMovieId())==null){
            	System.out.println("title not found");
            	System.out.print("Action: Movie ");
            	System.out.print(event.getMovieId());
            	System.out.println(" doesnt exist in database. Ignoring event ...");           	
            }else{
            	System.out.print("success");
            	System.out.println("["+list.get(event.getMovieId()).getTitle()+"]");
            	System.out.print("Action: ");
            	if(users.get(event.getUsername())==null){
            		System.out.print("User doesn't exist.");
            		if(event.getOperation().equals("I")){
            			System.out.println("Creating user and inserting movie...");
            			users.insert(event.getUsername());
            			users.get(event.getUsername()).insertMovie(event.getMovieId());
            		}else
            			System.out.println("Do nothing...");
            	}else{
            		System.out.print("User exists.");
            		if(event.getOperation().equals("I")){
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie already in list. Do nothing ...");
            			}else{
            				System.out.println("Movie not in list. Adding movie...");
            				users.get(event.getUsername()).insertMovie(event.getMovieId());
            			}            				
            		}else{
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie exist. Removing from list ...");
            				users.get(event.getUsername()).removeMovie(event.getMovieId());
            				if(users.get(event.getUsername()).isMoviesListEmpty()){
            					users.remove(event.getUsername());
            					System.out.print("User ");
            					System.out.print(event.getUsername());
            					System.out.println(" deleted...");
            				}
            			}else
            				System.out.println("Movie doesn't exist. Do nothing...");
            		}            		
            	}
           }            	
           //System.out.println(users.toString());	              
		}
		return users;
		
		
	}
	
	public UserList initUsers(TMovieHashTable list , String filepath1 , String filepath2) throws IOException{
		UserList users = new UserList();
		FileParsers.initializeParsers(filepath1, filepath2);
		while( FileParsers.hasNextEvent() ){
            EventData event = FileParsers.getNextEvent();
            System.out.print("["+event.getOperation()+"]  -  ["+event.getUsername()+"]  -  [");
            System.out.println(event.getMovieId()+"]");
            System.out.print("Searching title...");
            if(list.get(event.getMovieId())==null){
            	System.out.println("title not found");
            	System.out.print("Action: Movie ");
            	System.out.print(event.getMovieId());
            	System.out.println(" doesnt exist in database. Ignoring event ...");           	
            }else{
            	System.out.print("success");
            	System.out.println("["+list.get(event.getMovieId()).getTitle()+"]");
            	System.out.print("Action: ");
            	if(users.get(event.getUsername())==null){
            		System.out.print("User doesn't exist.");
            		if(event.getOperation().equals("I")){
            			System.out.println("Creating user and inserting movie...");
            			users.insert(event.getUsername());
            			users.get(event.getUsername()).insertMovie(event.getMovieId());
            		}else
            			System.out.println("Do nothing...");
            	}else{
            		System.out.print("User exists.");
            		if(event.getOperation().equals("I")){
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie already in list. Do nothing ...");
            			}else{
            				System.out.println("Movie not in list. Adding movie...");
            				users.get(event.getUsername()).insertMovie(event.getMovieId());
            			}            				
            		}else{
            			if(users.get(event.getUsername()).containsMovie(event.getMovieId())){
            				System.out.println("Movie exist. Removing from list ...");
            				users.get(event.getUsername()).removeMovie(event.getMovieId());
            				if(users.get(event.getUsername()).isMoviesListEmpty()){
            					users.remove(event.getUsername());
            					System.out.print("User ");
            					System.out.print(event.getUsername());
            					System.out.println(" deleted...");
            				}
            			}else
            				System.out.println("Movie doesn't exist. Do nothing...");
            		}            		
            	}
           }            	
           //System.out.println(users.toString());	              
		}
		return users;
		
		
	}
	
	
	
	//////private methods for trees/////
	
	private MovieBSTreeNode inOrderMaxRank(MovieBSTree tree ,MovieBSTreeNode nod , MovieBSTreeNode max){
    	if(nod!=null){
    		if(tree.isInternal(nod)){
    			max = inOrderMaxRank(tree,nod.getlChild(),max);
    		}    	
    		if(max.rank()<nod.rank())
    			max = nod;
    		if(tree.isInternal(nod)){
    			max = inOrderMaxRank(tree,nod.getrChild(),max);
    		}
    	}
		return max;
    }	
	
	private int inOrderNumoFMovies(MovieBSTree tree ,MovieBSTreeNode nod ,int num, int y1, int y2){
    	if(nod!=null){
    		if(tree.isInternal(nod)){
    			num = inOrderNumoFMovies(tree, nod.getlChild(), num, y1, y2);
    		}    	
    		if(y1<=nod.getYear()&&nod.getYear()<=y2)
    			num++;
    		if(tree.isInternal(nod)){
    			num = inOrderNumoFMovies(tree, nod.getrChild(), num, y1, y2);
    		}
    	}
		return num;
    }
	
	private MovieList inOrderGenreList(MovieBSTree tree ,MovieBSTreeNode nod ,MovieList list, genre_t s, genre_t t){
    	if(nod!=null){
    		if(tree.isInternal(nod)){
    			list = inOrderGenreList(tree, nod.getlChild(), list, s, t);
    		}    	
    		if(nod.getGenres().contains(s)&&(nod.getGenres().contains(t)))
    			list.insert(nod.toData());
    		if(tree.isInternal(nod)){
    			list = inOrderGenreList(tree, nod.getrChild(), list, s, t);
    		}
    	}
		return list;
    }
	
	private BonusMovieList inOrderBonus(MovieBSTree tree ,MovieBSTreeNode nod, BonusMovieList list){
		if(nod!=null){
    		if(tree.isInternal(nod)){
    			list = inOrderBonus(tree, nod.getlChild(), list);
    		}    	
    			list.insertBonus(nod.toData());
    		if(tree.isInternal(nod)){
    			list = inOrderBonus(tree, nod.getrChild(), list);
    		}
    	}
		return list;
    }
	
	private MovieBSTreeNode inOrderMaxRank(MovieBSTree tree ,MovieBSTreeNode nod , MovieBSTreeNode max , genre_t s){
    	if(nod!=null){
    		if(tree.isInternal(nod)){
    			max = inOrderMaxRank(tree,nod.getlChild(),max,s);
    		}  
    		if(max == null && nod.getGenres().contains(s))
    			max = nod;
    		if(max.rank()<nod.rank() && nod.getGenres().contains(s))
    			max = nod;
    		if(tree.isInternal(nod)){
    			max = inOrderMaxRank(tree,nod.getrChild(),max,s);
    		}
    	}
		return max;
    }
	
	
	
}

