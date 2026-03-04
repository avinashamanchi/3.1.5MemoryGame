/**
 * Project 3.1.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
public class MemoryGame
{
  public static void main(String[] args) {

    // TO DO: Create the "memory strings" - an array of at least 4 single character  
    // strings to show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.

    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.))
    MemoryGameGUI game = new MemoryGameGUI();
    game.createBoard(3, true);

    // TO DO: Play the game until user wants to quit.
  
        // TO DO: Call the next method in RandomPermutation to create a random version 
        // of the "memory strings"
  
        // TO DO: Play one sequence with a .5 second delay. Save the player's guess. 
        // (Later, you can speed up or slow down the game.)
        String guess = game.playSequence(randomSeq, .5);

        // TO DO: If the gess is not null, determine a match
        
            // TO DO: Cleanup the guess - repalce commas and spaces with the empty string.
            // Refer to a new String method replace.
            
            // TO DO: Iterate to determine if all elements of the guess match sequence
    
            // If match, signal a match, otherwise, try again.
            if (matched)
            {
              game.matched();
              // increase score
             }
            else
            {
              game.tryAgain();
            }
            
  
        // TO DO: Ask if user wants to play another round of the game 
        // and track the number of games played.
   
    // When done playing, show score and end the game.
    game.showScore(score, rounds);
    game.quit();
  }
}