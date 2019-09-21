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
 * Test class that checks whether 2 methods in GameNode and 2 methods in 
 * GameList are functioning properly
 * 
 * @author Stephen Fan
 *
 */
public class GameTests {
  /**
   * Test method for the getNumber() method in the GameNode class
   * 
   * @return true if it gets the correct number and false if it does not
   */
  public static boolean testGetNumber() {
    // variable that shows whether the test was passed
    boolean passed = false;

    // generate GameNode
    Random r = new Random();
    GameNode node1 = new GameNode(r);

    // check if GameNode number was between 1-9
    if (node1.getNumber() >= 1 && node1.getNumber() <= 9) {
      passed = true;
    }

    return passed;
  }

  /**
   * Test method for the getNext() method in the GameNode class
   * 
   * @return true if it gets the correct node and false if it does not
   */
  public static boolean testGetNext() {
    // create variable that shows whether the test passed
    boolean passed = false;

    // generate 2 GameNodes
    Random r = new Random();
    GameNode node1 = new GameNode(r);
    GameNode node2 = new GameNode(r);

    // set the next pointer of node1 to node2
    node1.setNext(node2);

    // check if the getNext() method accesses the correct node
    if (node1.getNext().equals(node2)) {
      passed = true;
    }

    return passed;
  }

  /**
   * Test method for the addNode() method in the GameList class
   * 
   * @return true if it correctly adds the node and false if it does not
   */
  public static boolean testAddNode() {
    // create variable to show whether the test passed
    boolean passed = false;

    // create a GameList
    GameList game = new GameList();

    // create and add 3 GameNodes to the GameList
    Random r = new Random();
    GameNode newnode1 = new GameNode(r);
    GameNode newnode2 = new GameNode(r);
    GameNode newnode3 = new GameNode(r);
    game.addNode(newnode1);
    game.addNode(newnode2);
    game.addNode(newnode3);

    // make 3 integers that hold each nodes number
    int numnode1 = newnode1.getNumber();
    int numnode2 = newnode2.getNumber();
    int numnode3 = newnode3.getNumber();

    // if the GameList now contains all 3 numbers, then they were added
    // successfully
    if (game.contains(numnode1) && game.contains(numnode2) && 
        game.contains(numnode3)) {
      passed = true;
    }

    return passed;
  }

  /**
   * Test method for the Contains() method in the GameList class
   * 
   * @return true if the contains() method properly checks if the list really 
   * contains a number and false if it does not
   */
  public static boolean testContains() {
    // variable to show whether the test passed
    boolean passed = false;

    // create new GameList
    GameList game = new GameList();

    // create 3 new GameNodes and add them to GameList
    Random r = new Random();
    GameNode newnode1 = new GameNode(r);
    GameNode newnode2 = new GameNode(r);
    GameNode newnode3 = new GameNode(r);
    game.addNode(newnode1);
    game.addNode(newnode2);
    game.addNode(newnode3);

    // create 3 integers to hold each node's number
    int numnode1 = newnode1.getNumber();
    int numnode2 = newnode2.getNumber();
    int numnode3 = newnode3.getNumber();

    // check if the contains method shows that the list now contains
    // the nodes
    if (game.contains(numnode1) && game.contains(numnode2) 
        && game.contains(numnode3)) {
      passed = true;
    }

    return passed;
  }

  /**
   * main method to run all the tests and print out whether they passed
   * 
   * @param args
   */
  public static void main(String args[]) {
    System.out.println("testGetNumber() method has returned: " + 
      testGetNumber());
    System.out.println("testGetNext() method has returned: " + testGetNext());
    System.out.println("testAddNode() method has returned: " + testAddNode());
    System.out.println("testContains() method has returned: " + testContains());
  }
}
