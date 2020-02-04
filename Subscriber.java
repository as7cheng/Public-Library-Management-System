
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Subscriber
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
 * This class models a public library subscriber. A subscriber is a card holder 
 * who can borrow (checkout) and return library books
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class Subscriber {

	// static fields
	private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
															// one subscriber
	private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
														// code of the next subscriber to be created
	// Instance fields
	private int pin; // 4-digits Personal Identification Number to verify the identity of this
						// subscriber
	private final Integer CARD_BAR_CODE; // card bar code of this subscriber

	private String name; // name of this subscriber
	private String address; // address of this subscriber
	private String phoneNumber; // phone number of this subscriber

	private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not yet
											// returned. A subscriber can have at most 10 checked out books
	private ArrayList<Book> booksReturned; // list of the books returned by this subscriber

	
	/**
	 * Creates a new subscriber with given name, address, and phone number, and initializes its other 
	 * instance fields
	 * @param name Name of this subscriber
	 * @param pin  4-digits personal information number of this subscriber
	 * @param address Address of this subscriber
	 * @param phoneNumber Phone number of this subscriber
	 */
	public Subscriber(String name, int pin, String address, String phoneNumber) {
		this.name = name;
		this.pin = pin;
		this.address = address;
		this.phoneNumber = phoneNumber;
		CARD_BAR_CODE = nextCardBarCode;
		nextCardBarCode++;
		booksCheckedOut = new ArrayList<Book>();
		booksReturned = new ArrayList<Book>(); 	
	}
	
	/**
	 * Get this subscriber's address
	 * @return The address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Updates this subscriber's address
	 * @param address The address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Get this subscriber's phone number
	 * @return The phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Updates this subscriber's phone number
	 * @param phoneNumber The phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Get this subscriber PIN (4-digits Personal Identification Number)
	 * @return The pin
	 */
	public int getPin() {
		return pin;
	}
	
	/**
	 * Get this subscriber's card bar code
	 * @return The card bar code
	 */
	public Integer getCARD_BAR_CODE() {
		return CARD_BAR_CODE;
	}
	
	/**
	 * Get this subscriber's name
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Checks out an available book. The checkout operation fails if the maximum
	 * number of checked out books by this subscriber is already reached
	 * 
	 * @param book Reference to the book to be checked out by this subscriber
	 */
	public void checkoutBook(Book book) {
		if (booksCheckedOut.size() > MAX_BOOKS_CHECKED_OUT) {
			System.out.println("Checkout Failed: You cannot check out more than " + MAX_BOOKS_CHECKED_OUT + "books.");
		}
		
		else if (booksCheckedOut.contains(book)) {
			System.out.println("You have already checked out " + book.getTitle() + " book.");
		}
		
		else if (book.getBorrowerCardBarCode() != null) {
			System.out.println("Sorry, " + book.getTitle() + " is not available.");
		}
		
		else {
			book.borrowBook(getCARD_BAR_CODE());			
			booksCheckedOut.add(book);
		}
	}
	
	/**
	 * Returns a library book
	 * @param book Reference to the book to return by this subscriber
	 */
	public void returnBook(Book book) {
		if (isBookInBooksCheckedOut(book)) {
			booksReturned.add(book);
			booksCheckedOut.remove(book);
			book.returnBook();
		}
		else {
			System.out.println("Title: " + book.getTitle() + " has not been checked out by you.");
		}
	}
	
	/**
	 * Checks if this subscriber booksCheckedOut list contains a given book
	 * @param book Book to check if it is within this subscriber booksCheckedOut list
	 * @return True if booksCheckedOut contains book, false otherwise
	 */
	  public boolean isBookInBooksCheckedOut(Book book) {
		  return booksCheckedOut.contains(book);
	  }
	  
	  public boolean isBookInBooksReturned(Book book) {
		  return booksReturned.contains(book);
	  }

	 
	  /**
	   * Displays the list of the books checked out and not yet returned
	   */
	  public void displayBooksCheckedOut() {
	    if (booksCheckedOut.isEmpty()) // empty list
	      System.out.println("No books checked out by this subscriber");
	    else
	      // Traverse the list of books checked out by this subscriber and display its content
	      for (int i = 0; i < booksCheckedOut.size(); i++) {
	        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
	        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
	        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
	      }
	  }
	 
	  /**
	   * Displays the history of the returned books by this subscriber
	   */
	  public void displayHistoryBooksReturned() {
	    if (booksReturned.isEmpty()) // empty list
	      System.out.println("No books returned by this subscriber");
	    else
	      // Traverse the list of borrowed books already returned by this subscriber and display its
	      // content
	      for (int i = 0; i < booksReturned.size(); i++) {
	        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
	        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
	        System.out.println("Author: " + booksReturned.get(i).getAuthor());
	      }
	  }
	 
	  /**
	   * Displays this subscriber's personal information
	   */
	  public void displayPersonalInfo() {
	    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
	    System.out.println("  Name: " + name);
	    System.out.println("  Address: " + address);
	    System.out.println("  Phone number: " + phoneNumber);
	  }
	
	
	
}
