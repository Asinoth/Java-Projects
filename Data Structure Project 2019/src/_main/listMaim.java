package _main;

import java.io.IOException;
import java.util.Scanner;

import parser.MovieData.genre_t;
import phase1.lists.movies.*;
import phase1.lists.users.*;
import comparators.MovieListComparatorByYear;


import methods.methods;

public class listMaim {

	private static final String moviesInputFilePath = "data/movies_small.txt";
	private static final String eventsInputFilePath = "data/events_2.txt";
	private static Scanner in;
	
	
	public static void main(String[] args) throws IOException {
		methods meth = new methods();
		MovieList sortedList = new SortedMovieList(new MovieListComparatorByYear());
		MovieList unsortedList = new UnsortedMovieList();
		MovieList selfAdjustingList = new SelfAdjustingMovieList();
		UserList users=new UserList();
		in = new Scanner(System.in);
		long time1,time2;
		int y1,y2,operation=-1;
		genre_t a=null,b=null;
		
		String phrase = null;
		unsortedList = meth.init(unsortedList, moviesInputFilePath, eventsInputFilePath);		
		sortedList = meth.init(sortedList, moviesInputFilePath, eventsInputFilePath);	
		selfAdjustingList = meth.init(selfAdjustingList, moviesInputFilePath, eventsInputFilePath);
	
		users = meth.initUsers(unsortedList, moviesInputFilePath, eventsInputFilePath);
	
		
		while(operation!=0){
			try{
				System.out.println("\n\nTo print the movie List press 1\nTo print the User list press 2\nTo print the movie list of a selected user press 3\nFor other actions press 4\nTo exit the menu press 0\n");
				operation=in.nextInt();
				if(operation==1){
					System.out.println("Select witch list u want to print\nFor the unsorted press 1\nFor the sorted press 2\nFor the selfadjustlist press 3\n");
					operation=in.nextInt();
					if(operation==1)
					System.out.println(unsortedList.toString());
					else if(operation==2)
				   System.out.println(sortedList.toString());
					else if(operation==3)
					System.out.println(selfAdjustingList.toString());
				}else if(operation==2)
					System.out.println(users.toString());
				else if(operation==3){
					System.out.println("Give the username you want\n");
					System.out.println(users.get(in.nextLine()).toString());
				}else if(operation==4){
					System.out.println("To find the movie with the best rank press 1\nTo find how many movies where shot between the year u want press 2 \n"
							+ "To find witch movies belong in two genres press 3\nTo find the duration of the movies a certain user wants to see press 4\n"
							+ "To find the user who wants to see the most movies with the genre u want press 5\nFor the bonus list press 6\n");
					operation=in.nextInt();
					if(operation==1){
						//----------------------------//	
						time1=System.nanoTime();
						System.out.println("The movie with the best rank is "+meth.maxRank(unsortedList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The movie with the best rank is "+meth.maxRank(sortedList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");	
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The movie with the best rank is "+meth.maxRank(selfAdjustingList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting List");
					}else if(operation==2){
						//----------------------------//
						System.out.println("Give the first year ");
						y1=in.nextInt();
						System.out.println("Give the second year ");
						y2=in.nextInt();
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The number of movies between the years "+y1+" and "+y2+" are "+meth.noOfMovies(unsortedList, y1, y2));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The number of movies between the years "+y1+" and "+y2+" are "+meth.noOfMovies(sortedList, y1, y2));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The number of movies between the years "+y1+" and "+y2+" are "+meth.noOfMovies(selfAdjustingList, y1, y2));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting List");
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
						System.out.println("The movies with the given genres are "+meth.genr(unsortedList,a,b));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The movies with the given genres are "+meth.genr(sortedList,a,b));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The movies with the given genres are "+meth.genr(selfAdjustingList,a,b));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting list");				
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
						System.out.println("The given user will watch "+meth.Duration(unsortedList,users,phrase)+" min of movies");
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The given user will watch "+meth.Duration(sortedList,users,phrase)+" min of movies");
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");
						//----------------------------//
						time1=System.nanoTime();
						System.out.println("The given user will watch "+meth.Duration(selfAdjustingList,users,phrase)+" min of movies");
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting list");
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
						System.out.println("The user with the most movies in the given genr is "+meth.UserGenr(unsortedList, users, genre_t.valueOf(phrase)));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//					
						time1=System.nanoTime();
						System.out.println("The user with the most movies in the given genr is "+meth.UserGenr(sortedList, users, genre_t.valueOf(phrase)));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");
						//----------------------------//					
						time1=System.nanoTime();
						System.out.println("The user with the most movies in the given genr is "+meth.UserGenr(selfAdjustingList, users, genre_t.valueOf(phrase)));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting list");					
					}else if(operation==6){
						//----------------------------//					
						time1=System.nanoTime();
						System.out.println(meth.top10(unsortedList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the unsorted list");
						//----------------------------//					
						time1=System.nanoTime();
						System.out.println(meth.top10(sortedList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the sorted list");
						//----------------------------//					
						time1=System.nanoTime();
						System.out.println(meth.top10(selfAdjustingList));
						time2=System.nanoTime();
						System.out.println("It took "+(time2-time1)+" time to calculate for the selfAdjusting list");					
					}
				}
				
			}catch(NullPointerException e){
				System.out.println("Please try again");
			}
		}	
		System.out.println("Program terminated");
		
	}
}
