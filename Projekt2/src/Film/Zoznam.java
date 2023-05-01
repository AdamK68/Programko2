package Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;


public class Zoznam extends Databaza {
    static ArrayList<Main> movieList;
    
    public Zoznam() {
        movieList = new ArrayList<>();
    }
    public void addMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj detaily o filme:");
        System.out.print("Názov: ");
        String title = scanner.nextLine();
        System.out.print("Režisér: ");
        String director = scanner.nextLine();
        System.out.print("Rok vydania: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine(); 											
        System.out.print("[1] = Hrany Film [2] = Animovaný Film: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 											
        if (choice == 1) {
            System.out.print("Zadaj počet hercov: "); 
            int numActors = scanner.nextInt();
            scanner.nextLine(); 										
            ArrayList<String> actors = new ArrayList<>();				 
            for (int i = 0; i < numActors; i++) {
                System.out.print("Herec " + (i + 1) + ": ");
                actors.add(scanner.nextLine()); 						
            }
            System.out.print("Hodnotenie: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Koment: ");
            String comment = scanner.nextLine();

            Hrane main = new Hrane(title, director, releaseYear, actors, rating, comment);		 
            movieList.add(main);										
            System.out.println("Film sa uspešne uložil!");
        } else if (choice == 2) {
            System.out.print("Zadajte počet animatorov: ");
            int numAnimators = scanner.nextInt();
            scanner.nextLine(); 										
            ArrayList<String> animators = new ArrayList<>();
            for (int i = 0; i < numAnimators; i++) {
                System.out.print("Animator " + (i + 1) + ": ");
                animators.add(scanner.nextLine());
            }
            System.out.print("Hodnotenie: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); 										
            System.out.print("Koment: ");
            String comment = scanner.nextLine();
            System.out.print("Odporúčany vek: ");
            int recommendedAge = scanner.nextInt();
            scanner.nextLine(); 										

            Anime movie = new Anime(title, director, releaseYear, animators, rating, comment, recommendedAge);	
            movieList.add(movie);
            System.out.println("Film bol pridaný!");
        } else {
            System.out.println("Zla volba!");
        }
    }

    public void editMovie() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Názov filmu: ");
        String titleToEdit = scanner.nextLine();
        
        if (movieList.isEmpty()) {
    		System.out.println("Film sa nepodarilo nájsť.");
        }
        for (Main movie : movieList) {
            if (titleToEdit.equals(movie.getTitle())) {
            	System.out.print("Nový názov: ");
            	String newTitle = scanner.nextLine();
            	System.out.print("Nový režisér: ");
                String newDirector = scanner.nextLine();
                System.out.print("Nový rok vydania: ");
                int newYear = scanner.nextInt();
                scanner.nextLine(); 											
                System.out.print("[1] = Hrany Film [2] = Animovaný Film: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 											
                if (choice == 1) {
                    System.out.print("Zadaj počet hercov: "); 
                    int numActors = scanner.nextInt();
                    scanner.nextLine(); 										
                    ArrayList<String> newActors = new ArrayList<>();				 
                    for (int i = 0; i < numActors; i++) {
                        System.out.print("Herec " + (i + 1) + ": ");
                        newActors.add(scanner.nextLine()); 						
                    }
                    System.out.print("Nové hodnotenie: ");
                    double newRating = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Nový koment: ");
                    String newComment = scanner.nextLine();
                    
                    movie.setTitle(newTitle);
                    movie.setDirector(newDirector);
                    movie.setReleaseYear(newYear);
                    movie.setActors(newActors);
                    movie.setRating(newRating);
                    movie.setComment(newComment);
                    
                } else if (choice == 2) {
                    System.out.print("Zadajte počet animatorov: ");
                    int numAnimators = scanner.nextInt();
                    scanner.nextLine(); 										
                    ArrayList<String> animators = new ArrayList<>();
                    for (int i = 0; i < numAnimators; i++) {
                        System.out.print("Animator " + (i + 1) + ": ");
                        animators.add(scanner.nextLine());
                    }
                    System.out.print("Hodnotenie: ");
                    double newRating = scanner.nextDouble();
                    scanner.nextLine(); 										
                    System.out.print("Koment: ");
                    String newComment = scanner.nextLine();
                    System.out.print("Odporúčany vek: ");
                    int recommendedAge = scanner.nextInt();
                    scanner.nextLine();
           
                    movie.setTitle(newTitle);
                    movie.setDirector(newDirector);
                    movie.setReleaseYear(newYear);
                    movie.setActors(animators);
                    movie.setRating(newRating);
                    movie.setComment(newComment);
                    movie.setRecommendedAge(recommendedAge);                   
            }
        }
      }
   }      
    
    public void removeMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadaj Film ktorý chceš odstraniť: ");
        String removeTitle = scanner.nextLine();
        boolean removed = false;
        for (Main movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(removeTitle)) {
                movieList.remove(movie);
                System.out.println("Film bol uspešne odstranený");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Nenašiel sa film zo zadaným menom");
        }
       
    }
    
    public void searchMovieByTitle() {									 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadajte názov filmu: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;
        for (Main movie : movieList) {									
            if (movie.getTitle().equalsIgnoreCase(searchTitle)) {		
                movie.displayMovieDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Film s názvom " + searchTitle +" sa nenchádza v zozname");
        }
       
    }
    
    public void displayMovies() { 
        if (movieList.isEmpty()) {
            System.out.println("Nenašli sa žiadne filmy");				
        } else {
            System.out.println("Filmy:");
            for(Main movie : movieList) {
                movie.displayMovieDetails();
                System.out.println("--------------------");
            }
        }
    }
    
    public void listActorsAndAnimators() {
        HashMap<String, ArrayList<String>> actorMovies = new HashMap<>(); 					
        HashMap<String, ArrayList<String>> animatorMovies = new HashMap<>(); 				

        for (Main movie : movieList) {
        	if (movie instanceof Hrane) {        		
        		ArrayList<String> actors = ((Hrane) movie).getActors();
        		for (String actor : actors) {
        			if (!actorMovies.containsKey(actor)) {
        				actorMovies.put(actor, new ArrayList<String>());
        			}
        			actorMovies.get(actor).add(movie.getTitle());
        		}
        	}
        	else if (movie instanceof Anime) {        		
        		ArrayList<String> animators = ((Anime) movie).getAnimators();
        		for (String animator : animators) {
        			if (!animatorMovies.containsKey(animator)) {
        				animatorMovies.put(animator, new ArrayList<String>());
        			}
        			animatorMovies.get(animator).add(movie.getTitle());
        		}
        	}


        }

        System.out.println("Herci ktorí su vo viac ako v jednom filme: ");
        for (String actor : actorMovies.keySet()) {
            ArrayList<String> movies = actorMovies.get(actor);
            if (movies.size() > 1) {
                System.out.println(actor + ": " + movies.toString());
            }
        }

        System.out.println("Animatori ktorí su vo viac ako v jednom filme:");
        for (String animator : animatorMovies.keySet()) {
            ArrayList<String> movies = animatorMovies.get(animator);
            if (movies.size() > 1) {
                System.out.println(animator + ": " + movies.toString());
            }
        }
    }
    
    
   public void searchMoviesByActor() {
	   Scanner scanner = new Scanner(System.in);
        ArrayList<Main> matchedMovies = new ArrayList<>();
        System.out.print("Zadajte meno herca: ");
        String actorName = scanner.nextLine();
        for (Main movie : movieList) {
            if (((Hrane) movie).getActors().contains(actorName)) {
            	matchedMovies.add(movie);
            }
            else if(((Anime) movie).getAnimators().contains(actorName)) {
                matchedMovies.add(movie);
            }
        }

        if (matchedMovies.isEmpty()) {
            System.out.println("Nenašli sa filmy s tímto hercom" + actorName);
        } else {
            System.out.println("Filmy v ktorych su herci a animatori: " + actorName + ":");
            for (Main movie : matchedMovies) {
                System.out.println(movie.getTitle() + " (" + movie.getReleaseYear() + ")");
            }
        }
    }
    
   
    
    public void saveMovieToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Názov Filmu: ");
        String title = scanner.nextLine();

        Main movieToSave = null;
        for (Main movie : movieList) {
            if (movie.getTitle().equals(title)) {
                movieToSave = movie;
                break;
            }
        }
        
        if (movieToSave != null) {
            try {
                FileWriter writer = new FileWriter(movieToSave.getTitle() + ".txt");
                writer.write("Názov: " + movieToSave.getTitle() + "\n");
                writer.write("Režiser: " + movieToSave.getDirector() + "\n");
                writer.write("Rok: " + movieToSave.getReleaseYear() + "\n");
                if( movieToSave instanceof Hrane) {
                	writer.write("Type: Played\n");
                	writer.write("Cast: " + String.join(", ", ((Hrane) movieToSave).getActors()) + "\n");
                } else if(movieToSave instanceof Hrane) {
                	writer.write("Type: Anime\n");
                	writer.write("Cast: " + String.join(", ", ((Anime) movieToSave).getAnimators()) + "\n");
                }
                writer.write("Hodnotenie: " + movieToSave.getRating() + "\n");
                writer.write("Koment: " + movieToSave.getComment() + "\n");
                writer.write("Odporučaný vek: " + movieToSave.getRecommendedAge() + "\n");
                writer.close();
                System.out.println("Movie information saved to file: " + movieToSave.getTitle() + ".txt");
            } catch (IOException e) {
                System.out.println("Error saving movie information to file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Movie not found.");
        }
    }
   
    public void loadMoviesFromFile() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Zadaj nazov suboru: ");
    	String filename = scanner.nextLine() + ".txt";	
        try {												
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);				

            String line;
            ArrayList<String> fields = new ArrayList<String>();
            while ((line = bufferedReader.readLine()) != null) {
                																		
                 fields.add(line);
            }
                																		
            String title = fields.get(0).split(": ")[1];
            String director = fields.get(1).split(": ")[1];
            int year = Integer.parseInt(fields.get(2).split(": ")[1]);
            String type = fields.get(3).split(": ")[1];
            String[] actorArray = fields.get(4).split(": ")[1].split(",");
            ArrayList<String> actors = new ArrayList<>(Arrays.asList(actorArray));
            double rating = Double.parseDouble(fields.get(5).split(": ")[1]);
            String comment = fields.get(6).split(": ")[1];
            int recomAge = Integer.parseInt(fields.get(7).split(": ")[1]);
            
            if (type.equals("Played")) {
            	Main movie = new Hrane(title, director, year, actors, rating, comment);
            	movieList.add(movie);
            }else if(type.equals("Animated")) {
            	Main movie = new Anime(title, director, year, actors, rating, comment, recomAge);
            	movieList.add(movie);
            }
                																		

            bufferedReader.close();
            fileReader.close();

            System.out.println("Movies loaded from file: " + filename);

        } catch (IOException e) {
            System.out.println("Error loading movies from file: " + e.getMessage());
        }
    }
    
    
public static void main(String[] args) {
    Zoznam listManager = new Zoznam();
    Scanner scanner = new Scanner(System.in);
	boolean exit = false;
	do {
    	System.out.println("[1] Pridaj Film");
    	System.out.println("[2] Vypis Filmov");
    	System.out.println("[3] Vypis Hercov");
    	System.out.println("[4] Vypis Filmov Podla Hercov");
    	System.out.println("[5] Najdi Film Podla Nazvu");
    	System.out.println("[6] Upraviť Informacie Filmu");
    	System.out.println("[7] Odstraniť Film");
    	System.out.println("[8] Ulož do Suboru");
    	System.out.println("[9] Načitaj zo Suboru");
    	System.out.print("-----Čo chceš spraviť? ");
    	int pick = scanner.nextInt();
    	
    	switch (pick) {
        case 1: 
           listManager.addMovie();
            break;
        case 2: 
            listManager.displayMovies();
            break;
        case 3: 
            listManager.listActorsAndAnimators();
            break;
        case 4: 
        	listManager.searchMoviesByActor(); 
            break;
        case 5:  
        	listManager.searchMovieByTitle();
        	break;
        case 6: 
        	listManager.editMovie();
        	break;	
        case 7:
        	listManager.removeMovie();
        	break;
        case 8:
        	listManager.saveMovieToFile(); 
        	break;	
        case 9:
        	listManager.loadMoviesFromFile();
        	break;   
        case 10: 
        	
        	listManager.connect();
        	listManager.createTablePlayed();
        	listManager.createTableAnimated();
        	
        	for(Main movie: movieList) {
        		if (movie instanceof Hrane) {
        			listManager.insertPlayed(movie.getTitle(), movie.getDirector(), movie.getRecommendedAge(), ((Hrane) movie).getActors(), movie.getRating(), movie.getComment());
        		} else if( movie instanceof Anime) {
        			listManager.insertAnimated(movie.getTitle(), movie.getDirector(), movie.getRecommendedAge(), ((Anime) movie).getAnimators(), movie.getRating(), movie.getComment(), movie.getRecommendedAge());
        		}
        	}
        	
        	listManager.disconnect();
        	System.out.println("Program uspešne ukončený");
        	exit  = true; 
        	break;
        	default:
        	System.out.println("Invalid choice. Please try again.");
        	break;
        	}
        	} while (!exit);
    	scanner.close();
   	}
}