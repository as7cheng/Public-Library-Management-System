
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Librarian
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
 * This class models a librarian within our application. A librarian has a name
 * and a password.
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class Librarian {
	// instance fields
	private String username; // librarian's username
	private String password; // librarian password to have access to this application

	/**
	 * Creates a new Librarian with a given name and a given password
	 * 
	 * @param username Username of this librarian
	 * @param password Password of this librarian to have access to this application
	 */
	public Librarian(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Get name of this librarian
	 * 
	 * @return The name of this librarian
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Checks if a given password equals the password of this librarian
	 * 
	 * @param password A given password
	 */
	public boolean checkPassword(String password) {
		if (!(this.password).equals(password)) {
			return false;
		}
		return true;
	}

}
