/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3.trees;

import java.util.ArrayList;
import parser.MovieData;
import parser.MovieData.genre_t;

/**
 *
 * 
 */
public class MovieBSTreeNode {
    private int id;
    private String title;
    private int year;
    private double rating;
    private int votes;
    private int duration;
    private ArrayList<MovieData.genre_t> genres;
    
    private MovieBSTreeNode parent;   // the parent node
    private MovieBSTreeNode lChild;   // the left child node
    private MovieBSTreeNode rChild;   // the right child node
    private int height;

    public MovieBSTreeNode(int id, String title, int year, double rating, int votes, int duration, ArrayList<genre_t> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.votes = votes;
        this.duration = duration;
        this.genres = genres;      
        this.parent = null;
        this.lChild = null;
        this.rChild = null;
        this.height = 1;
    }

    
    
    public int getDuration() {
        return duration;
    }

    public ArrayList<genre_t> getGenres() {
        return genres;
    }

    public int getId() {
        return id;
    }

    public MovieBSTreeNode getlChild() {
        return lChild;
    }

    public MovieBSTreeNode getParent() {
        return parent;
    }

    public MovieBSTreeNode getrChild() {
        return rChild;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public int getVotes() {
        return votes;
    }

    public int getYear() {
        return year;
    }

    public void setlChild(MovieBSTreeNode lChild) {
        this.lChild = lChild;
    }

    public void setParent(MovieBSTreeNode parent) {
        this.parent = parent;
    }

    public void setrChild(MovieBSTreeNode rChild) {
        this.rChild = rChild;
    }

    public int getHeight(){
    	return height;
    }
    
    public void setHeight(int height){
    	this.height = height;
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
        for( MovieData.genre_t g : this.genres )
            out += g + ", ";
        out = out.substring(0, out.length()-2); // remove last comma
        out += "\n";
        return out;
    }
}
