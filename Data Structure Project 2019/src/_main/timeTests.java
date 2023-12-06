package _main;

import java.io.IOException;
import java.util.EnumMap;


import comparators.MovieListComparatorByYear;
import methods.methods;
import parser.MovieData.genre_t;
import phase1.lists.movies.MovieList;
import phase1.lists.movies.SelfAdjustingMovieList;
import phase1.lists.movies.SortedMovieList;
import phase1.lists.movies.UnsortedMovieList;
import phase1.lists.users.UserList;
import phase2.hashtables.withLists.LMovieHashTable;
import phase2.hashtables.withLists.SALMovieHashTable;
import phase2.hashtables.withLists.SLMovieHashTable;
import phase2.hashtables.withLists.ULMovieHashTable;
import phase3.hashtables.withTrees.TMovieHashTable;
import phase3.trees.MovieBSTree;
import phase4.PQ.pQueue;

public class timeTests {
	private static final String moviesInputFilePath = "data/movies_full.txt";
	private static final String eventsInputFilePath = "data/events_2.txt";

	public static void main(String[] args) throws IOException {
		methods meth = new methods();
				
		long time1,time2;
		MovieList sortedList = new SortedMovieList(new MovieListComparatorByYear());
		MovieList unsortedList = new UnsortedMovieList();
		MovieList selfAdjustingList = new SelfAdjustingMovieList();
		LMovieHashTable HsortedList = new SLMovieHashTable(new MovieListComparatorByYear());
		LMovieHashTable HunsortedList = new ULMovieHashTable();
		LMovieHashTable HselfAdjustingList = new SALMovieHashTable();
		MovieBSTree tree = new MovieBSTree();
		TMovieHashTable Htree = new TMovieHashTable(11);
		EnumMap<genre_t, pQueue> GenreMap = new EnumMap<genre_t, pQueue>(genre_t.class);		
		genre_t s = genre_t.Drama;
		genre_t t = genre_t.Drama;
		int y1,y2;
		y1 = 1999;	
		y2 = 2005;
		String username ="user567";//"user71";//"user589";///.
				
	
		//////////////////////lists//////////////////////////
		time1=System.currentTimeMillis();
		meth.init(unsortedList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.init(sortedList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.init(selfAdjustingList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.init(HunsortedList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.init(HsortedList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.init(HselfAdjustingList, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.init(tree, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.init(Htree, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		////////Prioriy Queue//////////////
		time1=System.currentTimeMillis();
		GenreMap = meth.init(GenreMap, moviesInputFilePath, eventsInputFilePath);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		////////////////////////////////////
		UserList users = meth.initUsers(unsortedList, moviesInputFilePath, eventsInputFilePath);
		////////////////////////////////////
		System.out.println("Max Rank "+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.maxRank(unsortedList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(sortedList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(selfAdjustingList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		///////////Hash Table ////////////
		meth.maxRank(HunsortedList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(HsortedList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(HselfAdjustingList);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.maxRank(tree);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.maxRank(Htree);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		////////Prioriy Queue//////////////
		time1=System.currentTimeMillis();
		meth.maxRank(GenreMap);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////////////////////////////
		System.out.println("Max Rank with given genre"+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.maxRank(unsortedList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(sortedList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(selfAdjustingList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);		
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.maxRank(HunsortedList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(HsortedList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.maxRank(HselfAdjustingList,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.maxRank(tree,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.maxRank(Htree,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		////////Prioriy Queue//////////////
		time1=System.currentTimeMillis();
		GenreMap.get(s).getRoot();
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////////////////////////////
		System.out.println("No of movies "+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.noOfMovies(unsortedList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.noOfMovies(sortedList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.noOfMovies(selfAdjustingList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);		
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.noOfMovies(HunsortedList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.noOfMovies(HsortedList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.noOfMovies(HselfAdjustingList,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.noOfMovies(tree,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.noOfMovies(Htree,y1,y2);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////////////////////////////
		System.out.println("List of movies with the given genres "+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.genr(unsortedList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.genr(sortedList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.genr(selfAdjustingList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);		
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.genr(HunsortedList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.genr(HsortedList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.genr(HselfAdjustingList,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.genr(tree,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.genr(Htree,s,t);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////////////////////////////
		System.out.println("Given user movies duration "+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.Duration(unsortedList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.Duration(sortedList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.Duration(selfAdjustingList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);		
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.Duration(HunsortedList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.Duration(HsortedList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.Duration(HselfAdjustingList,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.Duration(tree,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.Duration(Htree,users,username);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////////////////////////////
		System.out.println("user with most movies in given genre "+"\n"+"-----------------------"+'\n'+"----------------------");
		time1=System.currentTimeMillis();
		meth.UserGenr(unsortedList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.UserGenr(sortedList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.UserGenr(selfAdjustingList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);		
		///////////Hash Table ////////////
		time1=System.currentTimeMillis();
		meth.UserGenr(HunsortedList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.UserGenr(HsortedList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		time1=System.currentTimeMillis();
		meth.UserGenr(HselfAdjustingList,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////////Tree////////////////////
		time1=System.currentTimeMillis();
		meth.UserGenr(tree,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		///////Hash Tree//////////////////
		time1=System.currentTimeMillis();
		meth.UserGenr(Htree,users,s);
		time2=System.currentTimeMillis();
		System.out.println(time2-time1);
	
	
	
	}

}
