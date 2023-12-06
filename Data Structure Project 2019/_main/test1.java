package _main;

import java.io.IOException;

import comparators.MovieListComparatorByYear;

import methos.methods;
import parser.MovieData.genre_t;
import phase1.lists.movies.*;
import phase1.lists.users.UserList;
import phase2.hashtables.withLists.*;

public class test1 {

	
	private static final String moviesInputFilePath = "F:/projects/data/movies_full.txt";
	private static final String eventsInputFilePath = "F:/projects/data/events_2.txt";
		
		
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		
		MovieList list = new UnsortedMovieList();
		LMovieHashTable hash = new SLMovieHashTable(new MovieListComparatorByYear());
		list = meth.init(list, moviesInputFilePath, eventsInputFilePath);
		hash = meth.init(hash, moviesInputFilePath, eventsInputFilePath);
		UserList users = meth.initUsers(hash, moviesInputFilePath, eventsInputFilePath);	
		//System.out.println(meth.UserGenr(list, users,genre_t.valueOf("Action")));
		System.out.println(meth.UserGenr(hash, users,genre_t.valueOf("Action")));	
		}
	

}
