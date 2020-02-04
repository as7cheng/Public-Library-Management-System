
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Library
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
import java.util.Scanner;

/**
 * This class models a simple book library. Include methods to access the
 * library management system
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class Library {

	// instance fields
	private String address; // Street address of this library
	private Librarian librarian; // this library's librarian. This library must have only ONE
									// librarian
	private ArrayList<Book> books; // list of the books in this library
	private ArrayList<Subscriber> subscribers; // list of this library's subscribers

	/**
	 * Creates a new Library and initializes all its instance fields. Initially both
	 * books and subscribers lists are empty.
	 * 
	 * @param address           Address of this Library
	 * @param librarianUsername Username of the librarian of this book library
	 * @param librarianLogin    Password of the librarian of this book library
	 */
	public Library(String address, String librarianUsername, String librarianLogin) {
		this.address = address;
		librarian = new Librarian(librarianUsername, librarianLogin);
		books = new ArrayList<Book>();
		subscribers = new ArrayList<Subscriber>();
	}

	/**
	 * Get the librarian of this library
	 * 
	 * @return The librarian
	 */
	public Librarian getLibrarian() {
		return librarian;
	}

	/**
	 * Get the address of this library
	 * 
	 * @return The address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Find a Book a book by the given identifier
	 * 
	 * @param bookId Identifier of the book to find
	 * @return Reference to the Book if found and null otherwise
	 */
	public Book findBook(int bookId) {
		// If the library is empty
		if (books.isEmpty()) {
			return null;
		}
		// If not, tracking the books and find the match book
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getID() == bookId) {
				return books.get(i);
			}
		}
		// If the book is not found, this method displays the following message
		System.out.println("Error: this book identifier didn't match any of our books identifiers.");
		// Return null otherwise
		return null;
	}

	/**
	 * Find the list of books having a given title in this library.
	 * 
	 * @param title Title of the book(s) to find
	 * @return ArrayList of the books having a given author (0 or more books can be
	 *         found)
	 */
	public ArrayList<Book> findBookByTitle(String title) {
		// Create a new array list to store the book found
		ArrayList<Book> titledBook = new ArrayList<Book>();
		
		// If the library is empty
		if (books.isEmpty()) {
			return null;
		}
		// If not, tracking the books and find the match book
		// Due to in this method, comparison is case insensitive
		// We change all the string to lower case
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
				titledBook.add(books.get(i));
			}
		}
		// If there is no matching book, return the array list
		return titledBook;
	}

	/**
	 * Find the list of books having a given author.
	 * 
	 * @param author Author of the book(s) to find
	 * @return ArrayList of the books having a given author (0 or more books can be
	 *         found)
	 */
	public ArrayList<Book> findBookByAuthor(String author) {
		// Create a new array list to store the book found
		ArrayList<Book> authorBook = new ArrayList<Book>(); 
		
		// If the library is empty
		if (books.isEmpty()) {
			return null;
		}
		// If not, tracking the books and find the match book
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getAuthor().equals(author)) {
				authorBook.add(books.get(i));
			}
		}
		// Return the array list
		return authorBook;
	}

	/**
	 * Adds a new book to the library (to the books list)
	 * 
	 * @param title  Title of the new book
	 * @param author Author of the new book
	 */
	public void addBook(String title, String author) {
		Book newBook = new Book(title, author); // Create a new book object
		books.add(newBook); // Add the book into the book list of this library
		// Displays the following message
		System.out.println("Book with Title " + newBook.getTitle() + " is successfully added to the library.");
	}

	/**
	 * Removes a book given its identifier from the library (from books list)
	 * 
	 * @param bookId Identifier of the book to remove
	 * @return A reference to the removed book, and null if the book is not found in
	 *         this library or if it is not available
	 */
	public Book removeBook(int bookId) {
		// If cannot find the book, return null
		if (findBook(bookId) == null) {
			return null;
		}
		// If find the book and it is available, return the book object
		else if (findBook(bookId).isAvailable()) {
			Book book1 = findBook(bookId);
			this.books.remove(findBook(bookId));
			return book1;
		}
		// Otherwise return null
		return null;
	}

	/**
	 * Adds a new subscriber to this library (to subscribers list)
	 * 
	 * @param name        Name of the new subscriber
	 * @param pin         4-digit personal identifier number of the new subscriber
	 * @param address     Address of the new subscriber
	 * @param phoneNumber Phone number of the new subscriber
	 */
	public void addSubscriber(String name, int pin, String address, String phoneNumber) {
		// Create a new subscriber object with given data
		Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber);
		// Add the subscriber into the array list
		subscribers.add(subscriber);
		// Displays the following message
		System.out.println("Library card with bar code " + subscriber.getCARD_BAR_CODE()
				+ " is successfully issued to the new subscriber " + subscriber.getName() + ".");
	}

	/**
	 * Finds a subscriber given its cardBarCode
	 * 
	 * @param cardBarCode Of the subscriber to find
	 * @return A reference to the subscriber if found, otherwise null
	 */
	public Subscriber findSubscriber(int cardBarCode) {
		// If the subscribers list is null
		if (subscribers == null) {
			return null;
		}
		// This loop is tracking every single elements and compare them with the code provided
		for (int i = 0; i < subscribers.size(); i++) {
			if (subscribers.get(i).getCARD_BAR_CODE().equals(cardBarCode)) {
				return subscribers.get(i);
			}
		}
		// If no matching subscriber found, display following message
		System.out.println("Error: this card bar code didn't match any of our records.");
		return null;
	}

	/**
	 * Displays a list of books
	 * 
	 * @param books ArrayList of books
	 */
	public static void displayBooks(ArrayList<Book> books) {
		// Traverse the list of books and display book id, title, author, and
		// availability of each book
		for (int i = 0; i < books.size(); i++) {
			System.out.print("<Book ID>: " + books.get(i).getID() + " ");
			System.out.print("<Title>: " + books.get(i).getTitle() + " ");
			System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
			System.out.println("<Is Available>: " + books.get(i).isAvailable());
		}
	}

	/**
	 * Main method that represents the driver for this application. Call
	 * readProcessUserCommand() to access the user's input. After user's actions
	 * finished return to main() and display goodbye message
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
		// create a new library object
		Library madisonLibrary = new Library("Madison, WI", "april", "abc");
		// read and process user command lines
		madisonLibrary.readProcessUserCommand(scanner);
		displayGoodByeLogoutMessage(); // display good bye message
		scanner.close();// close this scanner
	}

	/**
	 * Reads and processes the user commands with respect to the menu of this
	 * application
	 * 
	 * @param scanner Scanner object used to read the user command lines
	 */
	public void readProcessUserCommand(Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		displayMainMenu(); // display the library management system main menu
		System.out.print(promptCommandLine);
		String command = scanner.nextLine(); // read user command line
		String[] commands = command.trim().split(" "); // split user command

		// '3': Exit the application
		while (commands[0].trim().charAt(0) != '3') {
			switch (commands[0].trim().charAt(0)) {
			case '1': // login as librarian commands[1]: password
				if (this.librarian.checkPassword(commands[1])) {
					// read and process librarian commands
					readProcessLibrarianCommand(scanner);
				} else { // error password
					System.out.println("Error: Password incorrect!");
				}
				break;
			case '2': // login as subscriber commands[1]: card bar code
				Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				if (subscriber != null) {
					if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
						// read and process subscriber commands
						readProcessSubscriberCommand(subscriber, scanner);
					else
						System.out.println("Error: Incorrect PIN.");
				}
				break;
			}
			// read and split next user command line
			displayMainMenu(); // display the library management system main menu
			System.out.print(promptCommandLine);
			command = scanner.nextLine(); // read user command line
			commands = command.trim().split(" "); // split user command line
		}
	}

	/**
	 * Displays the main menu for this book library application
	 */
	private static void displayMainMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("     Welcome to our Book Library Management System");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <password>] Login as a librarian");
		System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
		System.out.println("[3] Exit"); // Exit the application
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Displays the menu for a Subscriber
	 */
	private static void displaySubscriberMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("    Welcome to Subscriber's Space");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <book ID>] Check out a book");
		System.out.println("[2 <book ID>] Return a book");
		System.out.println("[3 <title>] Search a Book by title");
		System.out.println("[4 <author>] Search a Book by author");
		System.out.println("[5] Print list of books checked out");
		System.out.println("[6] Print history of returned books");
		System.out.println("[7 <address>] Update address");
		System.out.println("[8 <phone number>] Update phone number");
		System.out.println("[9] Logout");
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Displays the menu for the Librarian
	 */
	private static void displayLibrarianMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("    Welcome to Librarian's Space");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <title> <author>] Add new Book");
		System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
		System.out.println("[3 <card bar code> <book ID>] Check out a Book");
		System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
		System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
		System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
		System.out.println("[7] Display All Books");
		System.out.println("[8 <book ID>] Remove a Book");
		System.out.println("[9] Logout");
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Display the Application GoodBye and logout message.
	 */
	private static void displayGoodByeLogoutMessage() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("       Thanks for Using our Book Library App!!!!");
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Reads and processes the librarian commands according to the librarian menu
	 * 
	 * @param scanner Scanner object used to read the librarian command lines
	 */
	private void readProcessLibrarianCommand(Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		displayLibrarianMenu(); // display the librarian's main menu
		System.out.print(promptCommandLine);
		String command = scanner.nextLine();
		String[] commands = command.trim().split(" "); // Separate the command

		// Check the librarian's command
		// When librarian's 1st number of command is 9, quit the librarian application
		while (commands[0].trim().charAt(0) != '9') {
			// Start checking the librarian's command
			switch (commands[0].trim().charAt(0)) {
			// When librarian's 1st number of command is 1
			// Add a new book into book list of library
			case '1':
				addBook(commands[1].trim(), commands[2].trim());
				break;
			// When librarian's 1st number of command is 2
			// Add a new subscriber into the subscribers list
			case '2':
				addSubscriber(commands[1].trim(), Integer.parseInt(commands[2].trim()), commands[3].trim(),
						commands[4].trim());
				break;
			// When librarian's 1st number of command is 3
			// Check out a book
			case '3':
				if (findBook(Integer.parseInt(commands[2].trim())) != null) {
					findSubscriber(Integer.parseInt(commands[1].trim()))
							.checkoutBook(findBook(Integer.parseInt(commands[2].trim())));
				} else {
					findBook(Integer.parseInt(commands[2].trim()));
				}
				break;
			// When librarian's 1st number of command is 4
			// Return a Book for a subscriber
			case '4':
				if (findBook(Integer.parseInt(commands[2].trim())) != null) {
					findSubscriber(Integer.parseInt(commands[1].trim()))
							.returnBook(findBook(Integer.parseInt(commands[2].trim())));
				} else {
					findBook(Integer.parseInt(commands[2].trim()));
				}
				break;
			// When librarian's 1st number of command is 5
			// Display Personal Info of a Subscriber
			case '5':
				findSubscriber(Integer.parseInt(commands[1].trim())).displayPersonalInfo();
				break;
			// When librarian's 1st number of command is 6
			// Display Books Checked out by a Subscriber
			case '6':
				findSubscriber(Integer.parseInt(commands[1].trim())).displayBooksCheckedOut();
				break;
			// When librarian's 1st number of command is 7
			// Display All Books
			case '7':
				displayBooks(this.books);
				break;
			// When librarian's 1st number of command is 8
			// Remove a Book
			case '8':
				removeBook(Integer.parseInt(commands[1].trim()));
				break;
			}

			// read and split next user command line
			displayLibrarianMenu(); // display the library management system main menu
			System.out.print(promptCommandLine);
			command = scanner.nextLine(); // Read librarian's next command
			commands = command.trim().split(" "); // Separate the command
		}

	}

	/**
	 * Reads and processes the subscriber commands according to the subscriber menu
	 * 
	 * @param subscriber Current logged in subscriber
	 * @param scanner    Scanner object used to read the librarian command lines
	 */
	private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		displaySubscriberMenu(); // display the subscriber's menu
		System.out.print(promptCommandLine);
		String command = scanner.nextLine(); // read user command line
		String[] commands = command.trim().split(" "); // split user command

		// Check the subscriber's command
		// When subscriber's 1st number of command is 9, quit the librarian application
		while (commands[0].trim().charAt(0) != '9') {
			switch (commands[0].trim().charAt(0)) {
			// When subscriber's 1st number of command is 1
			// Check out a book
			case '1':
				if (findBook(Integer.parseInt(commands[1].trim())) != null) {
					subscriber.checkoutBook(findBook(Integer.parseInt(commands[1].trim())));
				} else {
					findBook(Integer.parseInt(commands[1].trim()));
				}
				break;
			// When subscriber's 1st number of command is 2
			// Return a book
			case '2':
				subscriber.returnBook(findBook(Integer.parseInt(commands[1].trim())));
				break;
			// When subscriber's 1st number of command is 3
			// Search a Book by title
			case '3':
				displayBooks(findBookByTitle(commands[1].trim()));
				break;
			// When subscriber's 1st number of command is 4
			// Search a Book by author
			case '4':
				displayBooks(findBookByAuthor(commands[1].trim()));
				break;
			// When subscriber's 1st number of command is 5
			// Print list of books checked out
			case '5':
				subscriber.displayBooksCheckedOut();
				break;
			// When subscriber's 1st number of command is 6
			// Print history of returned books
			case '6':
				subscriber.displayHistoryBooksReturned();
				break;
			// When subscriber's 1st number of command is 7
			// Update address
			case '7':
				subscriber.setAddress(commands[1].trim());
				break;
			// When subscriber's 1st number of command is 8
			// Update phone number
			case '8':
				subscriber.setPhoneNumber(commands[1].trim());
				break;
			}
			// read and split next user command line
			displaySubscriberMenu(); // display the library management system main menu
			System.out.print(promptCommandLine);
			command = scanner.nextLine(); // Read librarian's next command
			commands = command.trim().split(" "); // Separate the command

		}
	}
}
