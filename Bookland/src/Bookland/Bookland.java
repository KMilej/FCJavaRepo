package Bookland;

public class Bookland {

	public static void main(String[] args) {
		
		Author myAuthor = new Author("Emily Bronte", 233);
		
		Book myBook = new Book("booknr1", myAuthor, "Classic", 102);
		System.out.println("title = " + myBook.getTitle());
		
		System.out.println("author = " + myBook.getAutherName());
	}

}
