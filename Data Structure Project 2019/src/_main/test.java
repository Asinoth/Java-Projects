package _main;

import java.io.IOException;

import parser.FileParsers;
import parser.MovieData;
import phase4.PQ.pQueue;

public class test {
	private static final String moviesInputFilePath = "data/movies_small.txt";
	private static final String eventsInputFilePath = "data/events_2.txt";

	public static void main(String[] args) throws IOException {
		pQueue pq = new pQueue();
		FileParsers.initializeParsers(moviesInputFilePath , eventsInputFilePath );
		   while( FileParsers.hasNextMovie() ){
            MovieData movie = FileParsers.getNextMovie();
            pq.insert(movie);
        }

		   System.out.println(pq.getRoot().rank());
		   System.out.println(pq.getRoot().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getrChild().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().getlChild().rank());
		   System.out.println("------------------");
		   pq.getMax();
		   System.out.println(pq.getRoot().rank());
		   System.out.println(pq.getRoot().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getrChild().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().getrChild().rank());	   
		   System.out.println("------------------");
		   pq.getMax();		   
		   System.out.println(pq.getRoot().rank());
		   System.out.println(pq.getRoot().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getrChild().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().getlChild().rank());
		   System.out.println("------------------");
		   pq.getMax();		   
		   System.out.println(pq.getRoot().rank());
		   System.out.println(pq.getRoot().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getrChild().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().getrChild().rank());

		   System.out.println("------------------");
		   pq.getMax();		   
		   System.out.println(pq.getRoot().rank());
		   System.out.println(pq.getRoot().getlChild().rank());
		   System.out.println(pq.getRoot().getrChild().rank());
		   System.out.println(pq.getRoot().getlChild().getlChild().rank());
		   System.out.println(pq.getRoot().getlChild().getrChild().rank());
		   System.out.println(pq.getRoot().getrChild().getlChild().rank());




		   //System.out.println(pq.newLast().rank());
		   FileParsers.finalizeParsers();
		
		
		
		
		
		
	}
}


