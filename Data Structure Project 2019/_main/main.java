package _main;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import methos.methods;
import comparators.MovieListComparatorByYear;
import phase1.lists.movies.*;
import phase1.lists.users.UserList;
import phase2.hashtables.withLists.*;
import phase3.hashtables.withTrees.TMovieHashTable;
import phase3.trees.MovieBSTree;

public class main {

	private static final String moviesInputFilePath = "F:/projects/data/movies_small.txt";
	private static final String eventsInputFilePath = "F:/projects/data/events_2.txt";
	
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		Scanner scanIn = new Scanner(System.in);
		
		////////////////////
		/////variables//////
		////////////////////
		
		MovieList list = new UnsortedMovieList();
		LMovieHashTable hlist = new ULMovieHashTable();			
		MovieBSTree tree = new MovieBSTree();
		System.out.println("Give the size of the hashtable for the tree");
		TMovieHashTable htree = new TMovieHashTable(scanIn.nextInt());
		UserList users;
		
		////////////////////
		///initialisation///
		////////////////////
		list = meth.init(list,moviesInputFilePath , eventsInputFilePath);
		hlist = meth.init(hlist,moviesInputFilePath , eventsInputFilePath);
		tree = meth.init(tree,moviesInputFilePath , eventsInputFilePath);
		htree = meth.init(htree,moviesInputFilePath , eventsInputFilePath);
		
		////////////////////
		users = meth.initUsers(list, moviesInputFilePath, eventsInputFilePath);
		

	
	
	
	}
}
