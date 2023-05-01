package Film;

import java.util.ArrayList;

abstract class Main {
	protected String nazov;
    protected String reziser;
    protected int releaseYear;
    protected double rating;
    protected String comment;
    protected int recommendedAge;
    
    public Main(String title, String director,
    		int releaseYear,
    		double rating, String comment) {
    	this.nazov = title;
        this.reziser = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.comment = comment;
    }
    
    public String getTitle() {
        return nazov;
    }
    public void setTitle(String title) {
        this.nazov = title;
    }
    public String getDirector() {
        return reziser;
    }
    public void setDirector(String director) {
        this.reziser = director;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
   
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRecommendedAge() {
        return recommendedAge;
    }
    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

	protected abstract void displayMovieDetails();
	protected abstract void setActors(ArrayList<String> newActors);

}