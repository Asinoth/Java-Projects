package _main;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Scanner;

import methods.methods;

import parser.MovieData.genre_t;
import phase4.PQ.*;




public class priorityQueue {
	private static final String moviesInputFilePath = "data/movies_full.txt";
	private static final String eventsInputFilePath = "data/events_2.txt";
	private static Scanner in;	
		
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		EnumMap<genre_t, pQueue> GenreMap = new EnumMap<genre_t, pQueue>(genre_t.class);		
		
		GenreMap = meth.init(GenreMap, moviesInputFilePath, eventsInputFilePath);
		int x = 2;
		String line ;

		in = new Scanner(System.in);
		while(x!=0){	
			System.out.println("Press 1 to find the movie with the best rank ,Press 2 to find the best movie in a given genre ,Press 0 to exit");
			x = in.nextInt();
			if(x==1)
				System.out.println(meth.maxRank(GenreMap).toString());
			else if (x==2 ){
				System.out.println("Give the genre u want to search");
				line = in.nextLine();
				line = in.nextLine();
				System.out.println(GenreMap.get(genre_t.valueOf(line)).getRoot().toString());

			}
			
		}
		System.out.println("Program terminated ");
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
         

		
	


