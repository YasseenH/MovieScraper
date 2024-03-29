import java.util.ArrayList;
import java.util.Scanner;

public class Movie implements Comparable<Movie>{
	private String title;
	private int year;
	private ArrayList<String> cast;
	private String genre;
	private String description;
	private double rating;
	private String filmRating = "";
	private String duration;
	
	//TODO fix this logic of parsing the movie details paragraph
	public Movie(String movieDetails) {
		Scanner sc = new Scanner(movieDetails);
		sc.next();
		title = sc.next();
		sc.nextLine();
		sc.next();
		year = sc.nextInt();
		sc.nextLine();
		sc.next();
		rating = sc.nextDouble();
		sc.next();
		while (sc.hasNext()) {
			filmRating += sc.next();
		}
		sc.nextLine();
		while (sc.hasNext()) {
			genre += sc.next();
		}
		sc.nextLine();
		sc.next();
		while (sc.hasNext()) {
			description += sc.next();
		}
		sc.nextLine();
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			cast.add(sc.next());
		}
		sc.nextLine();
		sc.reset();
		sc.next();
		while (sc.hasNext()) {
			duration += sc.next();
		}
		sc.close();
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @return the film's rating
	 */
	public String getFilmRating() {
		return filmRating;
	}

	/**
	 * @return the rating
	 */
	public double getFanRating() {
		return rating;
	}
	
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the year
	 */
	public int getReleaseYear() {
		return year;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public String getCastList() {
		StringBuilder result = new StringBuilder();
		result.append(cast.get(0));
		for (int i = 1; i < cast.size(); i++) {
			result.append(",");
			result.append(cast.get(i));
		}
		return result.toString();
	}
	
	public boolean isActorHere(String actor) {
		String realName = actor.toLowerCase();
		for (int i = 0; i < cast.size(); i++) {
			if (cast.get(i).toLowerCase().equals(realName)) {
				return true;
			}
		}
		return false;
	}
	
	public int getTime(String duration) {
		Scanner sc = new Scanner(duration);
		int totalTime = Integer.parseInt(sc.next().substring(0, 1));
		totalTime *= 60;
		if (sc.hasNext()) {
			totalTime += Integer.parseInt(sc.next().replace("m", ""));
		}
		sc.close();
		return totalTime;
	}

	/**
	 * @return a string representation of all the movie's details
	 */
	public String toString() {
		return "Title: " + this.getTitle() + "\nYear: " + this.getReleaseYear() + "\nRating: " + this.getFanRating() + "\nFilm Rating: " + filmRating
		+ "\nGenre: " + genre + "\nDescription: " + description + "\nCast: " + getCastList() + "\nDuration:" + duration + "\n";
	}

	/*
	 * Allows Movies to be comparable by the Title String
	 */
	public int compareTo(Movie o) {
		return title.compareTo(o.getTitle());
	}
}
