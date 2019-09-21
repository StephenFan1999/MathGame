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
import java.util.Scanner;

/**
 * GameApplication class that runs the game
 * 
 * @author Stephen Fan
 *
 */
public class GameApplication {
  // declare variables
  private int goal;
  private int moves;
  private GameList list;

  /**
   * constructor for class GameApplication creates a goal number between 10-99 
   * sets moves to zero
   * creates a GameList and has it start with 7 GameNodes
   */
  public GameApplication() {
    // use random to create a random goal between 10-99
    Random r = new Random();
    goal = r.nextInt(89) + 10;

    // sets moves to 0
    moves = 0;

    // create a new GameList
    list = new GameList();

    // add 6 GameNodes to GameList
    for (int i = 0; i < 6; i++) {
      list.addNode(new GameNode(r));
    }
  }

  /**
   * Runs every time a player takes a turn until they win, quit, or enter 
   * invalid input.
   * 
   * @param scan is an object of Scanner class that will take in user input
   */
  public void nextTurn(Scanner scan) {
    // print out the current list, goal, and moves taken
    System.out.println("Goal: " + goal + " Moves Taken: " + moves);
    System.out.println(list.toString());

    // print out the prompt statement
    System.out.print("Number and Operation ");
    for (int i = 0; i < GameOperator.ALL_OPERATORS.size(); i++) {
      System.out.print(GameOperator.ALL_OPERATORS.get(i));
    }
    System.out.print(" to Apply: ");

    // obtain user input using Scanner class
    String input;
    while (!scan.hasNext()) {
    }
    input = scan.nextLine();

    // trim the user input
    input = input.trim();

    // obtain the operator from the user's input
    char operator = input.charAt(input.length() - 1);

    // obtain the integer portion of the user's input
    String intInput = input.substring(0, input.length() - 1);

    // determine what to do with the user's input
    // if they input "quit" then exit the program
    if (input.toLowerCase().equals("quit")) {
      System.out.println("Goodbye");
    }
    // if they input invalid command then send a warning and exit program
    else if (!isInteger(intInput)) {
      System.out.println("WARNING: The input you have entered is not " + 
        "valid.");
      nextTurn(scan);
    }
    // if they input invalid command then send a warning and exit program
    else if (operator != '+' && operator != '-' && operator != 'x' 
      && operator != '/' && operator != '&') {
      System.out.println("WARNING: The input you have entered is not " + 
        "valid.");
      nextTurn(scan);
    }
    // if their input is valid and not "quit" then carry out the correct
    // operations on the list
    else {
      // parse the integer part of the input to an integer
      int newnumber = Integer.parseInt(intInput);

      // increment moves by 1
      moves++;

      // apply the operator to the number
      list.applyOperatorToNumber(newnumber, GameOperator.getFromChar(operator));

      // add a random node to the end of the list
      Random r = new Random();
      list.addNode(new GameNode(r));

      // check if the user hit the goal
      if (list.contains(goal)) {
        System.out.println("Congratulations, you won in " + moves + " moves.");
        System.out.println("Solution: " + list.toString());
      }
      // if they did not hit their goal then go to next turn
      else {
        nextTurn(scan);
      }
    }
  }

  /**
   * checks if the String the user entered is an integer
   * 
   * @param str is the String that we are checking if it is an Integer or not
   * @return true if the String was an integer and false if not
   */
  public static boolean isInteger(String str) {
    // checks if the string is null
    if (str == null) {
      return false;
    }
    // checks if the string is empty
    if (str.isEmpty()) {
      return false;
    }
    int i = 0;

    // checks if the String is negative and if the length is 1
    if (str.charAt(0) == '-') {
      if (str.length() == 1) {
        return false;
      }
      i = 1;
    }

    // checks if each character in the String is outside 0-9
    for (; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c < '0' || c > '9') {
        return false;
      }
    }
    return true;
  }

  /**
   * Main method to run the game application
   * @param args
   */
  public static void main(String args[]) {
    // create a GameApplication
    GameApplication app = new GameApplication();
    
    // create a Scanner
    Scanner scan = new Scanner(System.in);
    app.nextTurn(scan);
    scan.close();
  }
}
