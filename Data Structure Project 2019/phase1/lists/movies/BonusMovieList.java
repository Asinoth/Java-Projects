package phase1.lists.movies;

import java.util.Comparator;

import parser.MovieData;



public class BonusMovieList extends SortedMovieList{
	
	
	public BonusMovieList(Comparator<MovieListNode> comparator) {
		super(comparator);
	}
	
	public void insertBonus(MovieData data){
		insert(data);
		if(size>10){
			deleteFirst();
			
		}	
		
	}	

	public String toString(){
		String out="Top 10 ranked movies :\n";
		MovieListNode tmp=tail;
		while(tmp.getPrevious()!=head){
			tmp=tmp.getPrevious();
			out+=tmp.getTitle()+"         "+tmp.rank()+"\n";
		}
		return out;
		
	}

}
