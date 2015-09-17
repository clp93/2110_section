// Create class Person that has two fields, name and age. 
// Throw an Illegal Argument Exception instead of having 
// preconditions when given a null name or a non-positive age.
// Just write the setters.

// -------------------------- Exercise 3 --------------------------

// TODO

class Person {
	String name;
	int age;
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name = name;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("age must be positive");
		}
		this.age = age;
	}
}