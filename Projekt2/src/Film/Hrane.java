package Film;

import java.util.ArrayList;

public class Hrane extends Main {

	private ArrayList<String> herci;
	
	public Hrane(String title, String director,
			int releaseYear, ArrayList<String> actors,
			double rating, String comment) {
		super(title,director,releaseYear,rating,comment);
        this.herci = actors; 
        
    }
	 public ArrayList<String> getActors() {
	        return herci;
	    }
	 public void setActors(ArrayList<String> actors) {
	        this.herci = actors;
	    }
	 public void displayMovieDetails() {
	        System.out.println("Nazov: " + nazov);
	        System.out.println("Reziser: " + reziser);
	        System.out.println("Rok vydania: " + releaseYear);
	        
	               if (herci.size() > 0) 
	                   System.out.println("Herci: " + herci);
	                   System.out.println("Hodnotenie: " + rating);
	                   System.out.println("Koment: " + comment);
	                   
	                     if (recommendedAge > 0) 
	                         System.out.println("Odporucany vek: " + recommendedAge + "+");
	        
	    }
}