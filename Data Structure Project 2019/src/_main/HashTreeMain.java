package _main;

import java.io.IOException;
import java.util.Scanner;

import methods.methods;
import parser.MovieData.genre_t;
import phase1.lists.users.UserList;
import phase3.hashtables.withTrees.TMovieHashTable;

public class HashTreeMain {
	private static final String moviesInputFilePath = "F:/projects/data/movies_full.txt";
	private static final String eventsInputFilePath = "F:/projects/data/events_2.txt";
	private static Scanner in;	
		
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		in = new Scanner(System.in);
		System.out.println("Please insert the size of the hash table for the trees");
		TMovieHashTable tree = meth.init(new TMovieHashTable(in.nextInt()) , moviesInputFilePath ,eventsInputFilePath);	
		UserList users = meth.initUsers(tree, moviesInputFilePath, eventsInputFilePath);		
		long time1,time2;
		int y1,y2,operation=-1;
		genre_t a=null,b=null;		
		String phrase = null;

		while(operation!=0){
			try{
				System.out.println("\n\nTo print the movie hash tree press 1\nTo print the User list press 2\n"
						+ "To print the movie list of a selected user press 3\nFor other actions press 4\nTo exit the menu press 0\n");
				operation=in.nextInt();
				if(operation==1){
					System.out.println(tree.toString());
				}else if(operation==2)
					System.out.println(users.toString());
				else if(operation==3){
					System.out.println("Give the username you want\n");
					in.nextLine();
					System.out.println(users.get(in.nextLine()).toString());
	
				}else if(operation==4){					
				System.out.println("To find the movie with the best rank press 1\nTo find how many movies where shot between the year u want press 2 \n"
						+ "To find witch movies belong in two genres press 3\nTo find the duration of the movies a certain user wants to see press 4\n"
						+ "To find the user who wants to see the most movies with the genre u want press 5\nFor the bonus list press 6\n");
				operation=in.nextInt();
				if(operation==1){
					//----------------------------//	
					time1=System.nanoTime();
					System.out.println("The movie with the best rank is "+meth.maxRank(tree));
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" ns to calculate for the hash tree");
				}else if(operation==2){
					//----------------------------//
					System.out.println("Give the first year ");
					y1=in.nextInt();
					System.out.println("Give the second year ");
					y2=in.nextInt();
					//----------------------------//
					time1=System.nanoTime();
					System.out.println("The number of movies between the years "+y1+" and "+y2+" are "+meth.noOfMovies(tree, y1, y2));
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" ns to calculate for the hash tree");
				}else if(operation==3){
					System.out.print("Give the genres of the movies\n");					
					phrase = "val";
					while(phrase.equals("val"))
						try{
							phrase = in.nextLine();
							a=genre_t.valueOf(phrase);
						}catch(IllegalArgumentException e){
							System.out.println("Insert the first genre");
							phrase = "val";							
						}
					System.out.println("Insert the second genre");
					phrase = "val";
					while(phrase.equals("val"))
						try{
							phrase = in.nextLine();
							b=genre_t.valueOf(phrase);
						}catch(IllegalArgumentException e){
							System.out.println("Insert the second genre");
							phrase = "val";							
						}
					//----------------------------//
					time1=System.nanoTime();
					System.out.println("The movies with the given genres are "+meth.genr(tree,a,b));
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" ns to calculate for the hash tree");
				}else if(operation==4){
					phrase=null;
					System.out.println("Give the username you want\n");
					phrase = in.nextLine();
					while(users.get(phrase)==null){						
						phrase = in.nextLine();
						if(users.get(phrase)==null)
							System.out.println("Invalid username try again");
					}
					//----------------------------//
					time1=System.nanoTime();
					System.out.println("The given user will watch "+meth.Duration(tree,users,phrase)+" min of movies");
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" ns to calculate for the hash tree");
				}else if(operation==5){					
					phrase = "val";
					while(phrase.equals("val"))
						try{
							phrase = in.nextLine();
							genre_t.valueOf(phrase);
						}catch(IllegalArgumentException e){
							System.out.println("Give the genre you want to search\n");
							phrase = "val";							
						}					
					//----------------------------//					
					time1=System.nanoTime();
					System.out.println("The user with the most movies in the given genr is "+meth.UserGenr(tree, users, genre_t.valueOf(phrase)));
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" time to calculate for the hash tree");
				}else if(operation==6){
					//----------------------------//					
					time1=System.nanoTime();
					System.out.println(meth.top10(tree));
					time2=System.nanoTime();
					System.out.println("It took "+(time2-time1)+" ns to calculate for the hash tree");
				}else
					System.out.println("Invalid option try again");
				}	
			}catch(NullPointerException e){
				System.out.println("Please try again");
			}
		}	
		System.out.println("Program terminated");
	}
}

