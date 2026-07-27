package comparators;

import java.util.Comparator;

import phase1.lists.movies.MovieListNode;

public class MovieListComparatorByYear implements Comparator<MovieListNode> {

	@Override
	public int compare(MovieListNode o1, MovieListNode o2) {
		return o1.getYear()-o2.getYear();
	}
	
}
