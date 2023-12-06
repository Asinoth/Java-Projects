/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1.lists.movies;


import parser.MovieData;
import parser.MovieData.genre_t;

import java.util.ArrayList;

/**
 *
 * 
 */
public class MovieListNode {
    
    private int id;
    private String title;
    private int year;
    private double rating;
    private int votes;
    private int duration;
    private ArrayList<genre_t> genres;
    
    private MovieListNode previous;
    private MovieListNode next;

    
    public MovieListNode(int id, String title, int year, double rating, int votes, int duration, ArrayList<genre_t> genres) {
    	this.id=id;
    	this.title=title;
    	this.year=year;
    	this.rating=rating;
    	this.votes=votes;
    	this.duration=duration;
    	this.genres=genres;    			
    }


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public ArrayList<genre_t> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<genre_t> genres) {
		this.genres = genres;
	}
	public MovieListNode getPrevious() {
		return previous;
	}
	public void setPrevious(MovieListNode previous) {
		this.previous = previous;
	}
	public MovieListNode getNext() {
		return next;
	}
	public void setNext(MovieListNode next) {
		this.next = next;
	}
	public double rank(){
		return (((double)votes)/(votes+25000))*rating+((25000)/((double)votes+25000))*6.9;
	}
	
	public MovieData toData(){
		return new MovieData(id,title,year,rating,votes,duration,genres);
	}
	
	
	@Override
    public String toString(){
        String out = "";
        out += "---------------------- Movie ----------------------\n";
        out += "ID:       " + this.id + "\n";
        out += "Title:    " + this.title + "\n";
        out += "Year:     " + this.year + "\n";
        out += "Rating:   " + this.rating + "\n";
        out += "Votes:    " + this.votes + "\n";
        out += "Duration: " + this.duration + " min\n";
        out += "Genres:   ";
        for( genre_t g : this.genres )
            out += g + ", ";
        out = out.substring(0, out.length()-2); // remove last comma
        out += "\n";
        return out;
    }
   

            
}
