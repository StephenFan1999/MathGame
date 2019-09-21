//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P6 Math Game
// Files: GameApplication.java, GameList.java, GameNode.java,
// GameTests.java, GameOperator.java
// Course: CS300, Fall 2018
//
// Author: Stephen Fan
// Email: sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

/**
 * GameList class that contains the head node of a Linked List of GameNodes
 * @author Stephen Fan
 *
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * initializes list to start out empty constructor for GameList class
   */
  public GameList() {
    // initialize Random object
    Random r = new Random();

    // initialize GameNode
    list = new GameNode(r);
  }

  /**
   * adds the new node to the end of this list
   * 
   * @param newNode is the new node to be added
   */
  public void addNode(GameNode newNode) {
    // create another GameNode to iterate through list with
    GameNode iterator = list;

    // traverse the list until the next node is null
    // iterator should now refer to the tail node
    while (iterator.getNext() != null) {
      iterator = iterator.getNext();
    }

    // once iterator points to the tail node
    // set the node iterator points to to newNode
    if (iterator.getNext() == null) {
      iterator.setNext(newNode);
    }
  }

  /**
   * only returns true when this list contains a node with the specified number
   * 
   * @param number is the number we are looking for instances of
   * @return whether this list contains the number we are looking for
   */
  public boolean contains(int number) {
    // whether list contains the number
    boolean numfound = false;

    // creates an iterator to go through the list with
    GameNode iterator = list;

    // goes through the list until the iterator becomes null
    while (iterator != null) {
      // checks if the iterator equals the number given
      if (iterator.getNumber() == number) {
        numfound = true;
      }

      // sets the iterator to the next node
      iterator = iterator.getNext();
    }

    return numfound;
  }

  /**
   * returns a string with each number in the list separated by " -> "s, and 
   * ending with " -> END"
   */
  public String toString() {
    // creates an iterator to go through the list with
    GameNode iterator = list;

    // creates the string of nodes to return
    // string initially starts with one node
    String stringList = new String(Integer.toString(iterator.getNumber()));

    // goes through the list until the next node is null
    while (iterator.getNext() != null) {
      // changes iterator to the next node
      iterator = iterator.getNext();

      // adds the current node to the list
      stringList = stringList + " -> " + Integer.toString(iterator.getNumber());
    }

    // ends the list with -> END
    stringList = stringList + " -> END";

    return stringList;
  }

  /**
   * applies the Operator to a number
   * @param number is the number that you are applying the operator to
   * @param operator is the operator that you are applying on the number
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    // creates an iterator to go through the list with
    GameNode iterator = list;

    // while the iterator isn't null, checks if the node equals the number
    // and if it does, applies the operator to the number
    while (iterator != null) {
      // checks if the node equals the number
      if (iterator.getNumber() == number) {
        // applies the operator to the number
        iterator.applyOperator(operator);
        break;
      }
      // moves on to the next node if it is not equal
      iterator = iterator.getNext();
    }
  }
}
