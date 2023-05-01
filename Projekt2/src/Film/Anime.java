package Film;

import java.util.ArrayList;

public class Anime extends Main {

	private ArrayList<String> animators;
	
	public Anime(String title, String director,
			int releaseYear,ArrayList<String> animators,
			double rating, String comment,
			int recommendedAge) {
		
		super(title,director,releaseYear,rating,comment);
        this.animators = animators;
        
    }
	 public ArrayList<String> getAnimators() {
	        return animators;
	    }
	 public void setActors(ArrayList<String> actors) {
	        this.animators = actors;
	    }
	 public void displayMovieDetails() {
	   System.out.println("Nazov: " + nazov);
	   System.out.println("Reziser: " + reziser);
	   System.out.println("Rok vydania: " + releaseYear);
	   
	        if (animators.size() > 0) 
	            System.out.println("Herci: " + animators);
	            System.out.println("Hodnotenie: " + rating);
	            System.out.println("Koment: " + comment);
	            
	             if (recommendedAge > 0) 
	                  System.out.println("Odporucany vek: " + recommendedAge + "+");
	        
	    }
	 
}

