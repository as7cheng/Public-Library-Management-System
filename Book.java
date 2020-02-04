
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book
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

/**
 * This class models a book within our book library. 
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class Book {

	// class/static fields
	private static int nextId = 1; // class variable that represents the identifier of the next
	                               // book
	// Instance fields
	private final int ID; // unique identifier of this book
	private String author; // name of the author of this book
	private String title; // title of this book
	private Integer borrowerCardBarCode; // card bar code of the borrower of this book
	                                     // When borrowerCardBarCode == null, the book is available 
	                                     //                                  (no one has the book)
	
	
	/**
	 * Construct a new Book object and initialize its instance fields
	 * @param Title Title of this new book
	 * @param Author Author of this new book
	 */
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		ID = nextId;
		nextId++;
		borrowerCardBarCode = null;
	}
	
	/**
	 * Get the author of this book
	 * @return The author of this book
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Get the title of this book
	 * @return The title of this book
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Get the the borrower's card bar code of this book if the book has been 
	 * checked out or null if not
	 * @return The borrowerCardBarCode
	 */
	public Integer getBorrowerCardBarCode() {
		return borrowerCardBarCode;
	}
	
	/**
	 * Get the ID of this Book object
	 * @return The ID of this Book object
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Records the borrower's card bar code of this book if the book is available.
	 * If this book is not available, this method does nothing. 
	 * @param borrowerCardBarCode The borrowerCardBarCode to set
	 */
	public void borrowBook(Integer borrowerCardBarCode) {
		if (isAvailable()) {
		this.borrowerCardBarCode = borrowerCardBarCode;
		}
	}
	
	/**
	 * Sets this book to be available. When the borrowerCardBarCode is set to null, 
	 * no one is borrowing it
	 */
	public void returnBook() {
		borrowerCardBarCode = null;
	}
	
	/**
	 * Checks if this book is available
	 * @return True if no one is borrowing this book, false otherwise
	 */
	public boolean isAvailable() {
		if (borrowerCardBarCode != null) {
			return false;
		}
		return true;
	}


	
	
	
	
	
	
	
	
	
	
}
