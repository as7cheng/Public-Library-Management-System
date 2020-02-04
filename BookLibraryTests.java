
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           BooklibraryTests
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ruoxi Shen
// Partner Email:   rshen27@wisc.edu
// Partner Lecturer's Name: LEC-005
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * This class includes some tests for the Class Book, Subscriber, Librarian and
 * Library. Every test should test the function of methods in four Class. All
 * the test methods must be static and return a boolean.
 * 
 * @author Shihan Cheng, Ruoxi Shen
 */
public class BookLibraryTests {

	/**
	 * Checks whether the constructor of your Book class initializes correctly the
	 * new Book instance fields: title, author, borrowerCardBarCode, ID, and
	 * increments nextID static field.
	 * 
	 * @return true if the constructor works well
	 */
	public static boolean testBookConstructorGetters() {
		// Declare variables for creating the constructor
		Integer code = null; // For testing if the BorrowerCardBarCode is null at beginning
		int num = 0; // As a counter to count the number of bugs
		String nameJava = "java"; // Name of book
		String authorJava = "Cheng"; // Author of book
		String nameC = "C"; // Name of book
		String authorC = "Shen"; // Author of book
		boolean check = true;

		Book java = new Book(nameJava, authorJava); // Create a new book1 object
		Book C = new Book(nameC, authorC); // Create a new book2 object for checking the nextId
											// increases correctly

		// If the title is not "java", constructor fails
		if (!(java.getTitle().equals(nameJava))) {
			System.out.println("The title of book java is incorrect.");
			++num;
		}
		// If the author is not "Jay", constructor fails
		if (!(java.getAuthor().equals(authorJava))) {
			System.out.println("The author of this java is incorrect.");
			++num;
		}
		// If the ID of the book is not 1, constructor fails
		if (java.getID() != 1) {
			System.out.println("The ID of book java is incorrect.");
			++num;
		}
		// If the borrower's card bar code is not null, constructor fails
		if (java.getBorrowerCardBarCode() != code) {
			System.out.println("The borrower1's card bar code is not incerrect.");
			++num;
		}
		// If the difference between book1 and book2 is not 1, nextId increases
		// incorrectly
		if ((C.getID() - java.getID()) != 1) {
			System.out.println("The nextId in Class Book increases incorrectly.");
			++num;
		}
		// If the number of bugs is greater than 0, the constructor fails
		// Print out the amount of bugs
		if (num > 0) {
			System.out.println("The constructor has " + num + "bugs.");
			check = false;
		}

		// If no bug, return true
		return check;

	}

	/**
	 * Checks whether returnBook() method defined within your Book class sets
	 * correctly the instance field borrowerCardBarCode. A Book must be available
	 * after this instance method is called.
	 * 
	 * @return true if the book returned successful
	 */
	public static boolean testBookReturnBook() {
		Book java = new Book("java", "Jay"); // Create a new book object
		Integer code = 1234; // Create a borrower code
		boolean check = true;

		java.borrowBook(code); // Make the book borrowed out
		java.returnBook(); // Make the book returned
		// If Book.isAvailable() returns true, then the book is returned successful
		if (java.isAvailable() != true) {
			System.out.println("The book is failed to return");
			check = false;
		}
		// If no bug, return true
		return check;
	}

	/**
	 * check that the constructor as well as the other methods defined in this class
	 * including the accessors (getter methods) work correctly.
	 * 
	 * @return true if the constructor works well
	 */
	public static boolean testSubcriberConstructorGetters() {
		// Declare variables for creating the constructor
		String name1 = "Shihan";
		String name2 = "Ruoxi";
		int pin1 = 1125;
		int pin2 = 1015;
		String addr = "Seattle";
		String ph1 = "9156";
		String ph2 = "3411";
		boolean check = true;
		
		// Create two subscribers
		Subscriber Shihan = new Subscriber(name1, pin1, addr, ph1); // Create subscriber 1
		Subscriber Ruoxi = new Subscriber(name2, pin2, addr, ph2); // Create subscriber 2
		int num = 0; // As a counter to count the number of bugs
		
		// If name does not match
		if (!(Shihan.getName().equals(name1))) {
			System.out.println("The subscriber1's name is incorrect.");
			++num;
		}
		// If address does not match
		if (!(Shihan.getAddress().equals(addr))) {
			System.out.println("The subscriber1's address is incorrect.");
			++num;
		}
		// If phone number does not match
		if (!(Shihan.getPhoneNumber().equals(ph1))) {
			System.out.println("The subscriber1's phone number is incorrect.");
			++num;
		}
		// If the pin number does not match
		if (Shihan.getPin() != pin1) {
			System.out.println("The subscriber1's pin is incorrect.");
			++num;
		}
		// If the difference between subscriber1 and subscruber2 is not 1, CARD_BAR_CODE
		// increases incorrectly
		if ((Ruoxi.getCARD_BAR_CODE() - Shihan.getCARD_BAR_CODE()) != 1) {
			System.out.println("The card bar code in Class Subscriber increases incorrectly.");
			++num;
		}

		// If the number of bugs is greater than 0, the constructor fails
		// Print out the amount of bugs
		if (num > 0) {
			System.out.println("The constructor has " + num + " bugs.");
			check = false;
		}

		// If no bug, return true
		return check;
	}

	/**
	 * Checks whether the checkoutBook() method defined within the Subscriber class
	 * works correctly.
	 * 
	 * @return true if the method works in three conditions
	 */
	public static boolean testSubscriberCheckoutBook() {
		// Declare variables for creating the constructor
		String title1 = "java";
		String title2 = "C";
		String name1 = "Shihan";
		String name2 = "Ruoxi";
		int pin = 1125;
		String addr = "Seattle";
		String ph = "9156";
		// Create two subscribers
		Subscriber Shihan = new Subscriber(name1, pin, addr, ph); // Create subscriber
		Book java = new Book(title1, name1); // Create a new book1 object
		Book C = new Book(title2, name2); // Create a new book2 object

		// Subscriber checked out 2 books
		Shihan.checkoutBook(java);
		Shihan.checkoutBook(C);

		// If the book is not checked out, return false
		// Check form Class Subscriber
		if (Shihan.isBookInBooksCheckedOut(java) != true) {
			System.out.println(
					"The subcriber " + Shihan.getName() + " has not checked out the book " + java.getTitle() + " .");
			return false;
		}

		// If the book is not checked out, return false
		// Check form Class Book
		if (java.isAvailable() != false) {
			System.out.println(
					"The subcriber " + Shihan.getName() + " has not checked out the book " + java.getTitle() + " .");
			return false;

		}

		// If the book is not checked out, return false
		// Check form Class Book with the borrower's card number
		if (java.getBorrowerCardBarCode() != Shihan.getCARD_BAR_CODE()) {
			System.out.println(
					"The subcriber " + Shihan.getName() + " has not checked out the book " + java.getTitle() + " .");
			return false;
		}

		// If no bug, return true
		return true;
	}

	/**
	 * Check that the constructor as well as the other methods defined in this class
	 * including the accessors (getter methods) work correctly.
	 * 
	 * @return true if the constructor works well
	 */
	public static boolean testLibrarianConstructorGetters() {
		String name = "Shihan";
		String password = "1125";
		boolean check = true;
		Librarian Shihan = new Librarian(name, password); // Create a new Librarian
		int num = 0; // As a counter to count the number of bugs
		
		// If name does not match
		if (!(Shihan.getUsername().equals(name))) {
			System.out.println("The librarian's name is incorrect.");
			++num;
		}
		// If password does not match
		if (Shihan.checkPassword(password) != true) {
			System.out.println("The librarian's password is incorrect.");
			++num;
		}

		// If the number of bugs is greater than 0, the constructor fails
		// Print out the amount of bugs
		if (num > 0) {
			System.out.println("The constructor has " + num + " bugs.");
			check = false;
		}
		
		// If no bug, return true
		return check;
	}

	/**
	 * Checks whether returnBook() method defined within your Book class sets
	 * correctly the instance field borrowerCardBarCode.
	 * 
	 * @return
	 */
	public static boolean testLibraryFindBookByAuthor() {
		// Declare variables for creating objects
		String name = "Madison"; // Name of library
		String username = "Shihan"; // Name of librarian
		String password = "1125"; // Librarian's password
		String title = "java"; // Title of the book
		String author = "cheng"; // Author of the book

		// Create a Library object for testing
		Library uwMadison = new Library(name, username, password);
		// Add the book into the book list of the library
		uwMadison.addBook(title, author);
		// Create an array list for storing the book list returned by the method
		ArrayList<Book> checkList = uwMadison.findBookByAuthor(author);

		// A Book must be available after this instance method is called.
		// Also, due to we only create a single Book, it must be store at index 0
		if (checkList.get(0).isAvailable() != true) {
			System.out.println("This book " + title + " is not available.");
			return false;
		}
		// If the checkList does not contain book java, method fails
		if (!checkList.contains(uwMadison.findBookByAuthor(author).get(0))) {
			System.out.println("Find book by author failed");
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * The main method is to run the tests above. Call the methods within the print
	 * method to display the message. If the massage after the test method is true,
	 * then the method works. If false, the method has bugs
	 * 
	 * @param arg Any String type
	 */
	public static void main(String[] arg) {
		System.out.println("testBookConstructorGetters(): " + testBookConstructorGetters());
		System.out.println("testBookReturnBook(): " + testBookReturnBook());
		System.out.println("testSubcriberConstructorGetters: " + testSubcriberConstructorGetters());
		System.out.println("testSubscriberCheckoutBook(): " + testSubscriberCheckoutBook());
		System.out.println("testLibrarianConstructorGetters(): " + testLibrarianConstructorGetters());
		System.out.println("testLibraryFindBookByAuthor(): " + testLibraryFindBookByAuthor());
	}
}
