package Film;

import java.sql.*;
import java.util.ArrayList;

public class Databaza {
    private Connection connection;

    public boolean connect(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:Movies.db");
            System.out.println("Pripojenie k databazi uspesne!");
            return true;
                 }catch(SQLException e){
                     e.printStackTrace();
        }
        return false;
    }
    
    public boolean disconnect(){
        try{
            connection.close();
            System.out.println("Odpojenie z databazi uspesne!");
            return true;
                   }catch(SQLException e){
                        e.printStackTrace();
        }
        return false;
    }
    public boolean createTablePlayed(){
        String sql ="CREATE TABLE IF NOT EXISTS Hrane (" +
                	"Nazov TEXT NOT NULL," +
                	"Reziser TEXT NOT NULL," +
                	"Rok int NOT NULL," +
                	"Herci TEXT NOT NULL, " +
                	"Hodnotenie DOUBLE NOT NULL," +
                	"Koment TEXT NOT NULL, " +
                	"PRIMARY KEY (Nazov)" +
                	")";
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            return true;
    }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean createTableAnimated(){
        String sql = "CREATE TABLE IF NOT EXISTS Anime (" +
            		"Nazov TEXT NOT NULL," +
            		"Reziser TEXT NOT NULL," +
            		"Rok int NOT NULL," +
            		"Animatori TEXT NOT NULL, " +
            		"Hodnotenie DOUBLE NOT NULL," +
            		"Koment TEXT NOT NULL, " +
            		"OdporucanyVek INT NOT NULL, " +
            		"PRIMARY KEY (Nazov)" +
            		")";
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void insertAnimated(String meno, String director, int year, ArrayList<String> animators, double rating, String comment, int recomAge){
        String sql = "INSERT INTO Anime(title,director,year,animators,rating,comment,recommendedAge) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, meno);
            pstmt.setString(2, director);
            pstmt.setInt(3, year);
            pstmt.setString(4, String.join(", ", animators));
            pstmt.setDouble(5, rating);
            pstmt.setString(6, comment);
            pstmt.setInt(7, recomAge);
            pstmt.execute();
            pstmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void insertPlayed(String meno, String director, int year, ArrayList<String> actors, double rating, String comment){
    	String sql = "INSERT INTO Hrane(title,director,year,actors,rating,comment) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, meno);
            pstmt.setString(2, director);
            pstmt.setInt(3, year);
            pstmt.setString(4, String.join(", ", actors));
            pstmt.setDouble(5, rating);
            pstmt.setString(6, comment);
            pstmt.execute();
            pstmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}    