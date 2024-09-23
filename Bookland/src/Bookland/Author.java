package Bookland;

public class Author {
	private String name;
	private int age;
	
	public Author(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//set age
	public void setAge(int newAge) {
		age = newAge;
	}
	// get name
	public String getName() {
		return name;
	}
	public int getage() {
		return age;
	}
}
