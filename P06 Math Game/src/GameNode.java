////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P6 Math Game
// Files:           GameApplication.java, GameList.java, GameNode.java,
//                  GameTests.java, GameOperator.java
// Course:          CS300, Fall 2018
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

public class GameNode {
  private int number;    // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the 
  // last node
 
  /**
   * initializes number to random 1-9 value, and next to null
   * constructor for GameNode class
   * @param rng is an object of the Random class that will be used to 
   * generate a random number between 1-9
   */
  public GameNode(Random rng) {
	// generate random number between 1-9
    this.number = rng.nextInt(9) + 1;
    
    // set next node to null
    this.next = null;
  }
  
  /**
   * accessor for the number field
   * @return number is the number the node contains
   */
  public int getNumber() {
    return this.number;
  }
  
  /**
   * accessor for the next field
   * @return GameNode is the next GameNode
   */
  public GameNode getNext() {
	return this.next;
  }
  
  /**
   * mutator for the next field
   * @param next is the GameNode that should be set as the next one
   */
  public void setNext(GameNode next) {
	this.next = next;
  }
  
  /**
   * scans through this list searching for the first occurrence of a node 
   * with the specified number. After finding a node with that number, 
   * it calls the applyOperator method on that GameNode, passing along the 
   * specified operator object reference. If the node that applyOperator() 
   * is called on happens to be the last node in the list, 
   * then applyOperator() will throw a NullPointerException.
   * 
   * @param operator is the operator that we are applying on the two numbers
   */
  public void applyOperator(GameOperator operator) {
	// checks if the next node is null and throws an exception
	if (this.getNext() == null) {
	  throw new NullPointerException();
	}
	
	// applies the operator to the number and the next number
	this.number = operator.apply(this.number, this.next.getNumber());
	
	// sets next to the next node
	this.next = this.next.getNext();
  }
}
