package Bookland;

public class Book {
	private String Title;
	private Author author;
	private String genre;
	private int numPages;
	
	public Book(String Title, Author author, String genre, int number) {
		this.Title = Title;
		this.author = author;
		this.genre = genre;
		numPages = number;
		
	}
	public String getTitle() {
		return Title;
	}
	public String getAutherName() {
		String name = author.getName();
		
		return name;
	}
	
}