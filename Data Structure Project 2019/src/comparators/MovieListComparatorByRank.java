package comparators;

import java.util.Comparator;

import phase1.lists.movies.MovieListNode;

public class MovieListComparatorByRank implements Comparator<MovieListNode>  {

	@Override
	public int compare(MovieListNode o1, MovieListNode o2) {		
		if(o1.rank()-o2.rank()>0)
				return 1;
		else 
			return -1;
	}
}
