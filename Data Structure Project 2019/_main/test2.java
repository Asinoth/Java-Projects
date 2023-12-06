package _main;

import java.io.IOException;

import parser.MovieData.genre_t;
import phase1.lists.movies.MovieList;
import phase1.lists.movies.UnsortedMovieList;
import phase1.lists.users.UserList;
import phase3.hashtables.withTrees.TMovieHashTable;
import phase3.trees.MovieBSTree;
import methos.methods;

public class test2 {

	
	private static final String moviesInputFilePath = "F:/projects/data/movies_small.txt";
	private static final String eventsInputFilePath = "F:/projects/data/events_2.txt";
		
		
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		MovieBSTree tree = meth.init(new MovieBSTree() , moviesInputFilePath ,eventsInputFilePath);	
		TMovieHashTable tree1 = meth.init(new TMovieHashTable(11) , moviesInputFilePath ,eventsInputFilePath);
		MovieList tree2 = meth.init(new UnsortedMovieList() , moviesInputFilePath, eventsInputFilePath);
		//UserList users = meth.initUsers(tree1, moviesInputFilePath, eventsInputFilePath);
		/*long time1 , time2 ;
		time1=System.nanoTime();
		System.out.println(tree.get(368899).toString());
		time2=System.nanoTime();
		System.out.println(time2-time1);*/
		//tree.inOrder(tree.getRoot());
		//tree.inOrder(tree.getRoot());
		//tree.remove(441018);
		//tree.getTableIndex(1).inOrder(tree.getTableIndex(0).getRoot());
		//tree.inOrder(tree.getRoot());
		//System.out.println(meth.genr(tree1, genre_t.valueOf("Action"), genre_t.valueOf("Action")).getSize());
		//System.out.println(users.toString());
		System.out.println(meth.top10(tree1).toString());
		/*MovieList list = new UnsortedMovieList();
		list = meth.init(list, moviesInputFilePath, eventsInputFilePath);
		System.out.println(list.get(368899).toString());
		time2=System.nanoTime();
		System.out.println(time2-time1);
				tree.toStinga();

		*/
	}

}
