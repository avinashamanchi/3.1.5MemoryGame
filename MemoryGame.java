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

    String[] memoryStrings = {"A", "B", "C", "D", "E"};

    MemoryGameGUI game = new MemoryGameGUI();
    game.createBoard(3, true);

    int score = 0;
    int rounds = 0;
    boolean keepPlaying = true;

        // TO DO: Play the game until user wants to quit.
  
        // TO DO: Call the next method in RandomPermutation to create a random version 
        // of the "memory strings"
  
        // TO DO: Play one sequence with a .5 second delay. Save the player's guess. 
        // (Later, you can speed up or slow down the game.)

    // role switch
    // Hrihaan (person writing the code)
    // Avi (suggesting edits and guiding)

    // main game loop runs until the player decides to stop
    while (keepPlaying) {
        rounds++;
        
        // copy the memory strings into a new array that will be shuffled
        String[] randomSeq = new String[memoryStrings.length];
        System.arraycopy(memoryStrings, 0, randomSeq, 0, memoryStrings.length);
        
        // shuffle the sequence using a random swapping algorithm
        for (int i = 0; i < randomSeq.length; i++) {
            int randIndex = (int)(Math.random() * randomSeq.length);
            String temp = randomSeq[i];
            randomSeq[i] = randomSeq[randIndex];
            randomSeq[randIndex] = temp;
        }

        // play the sequence on screen with a 5 second delay 
        // the player's input guess is captured 
        String guess = game.playSequence(randomSeq, 5);

            // TO DO: If the gess is not null, determine a match
        
            // TO DO: Cleanup the guess - repalce commas and spaces with the empty string.
            // Refer to a new String method replace.
            
            // TO DO: Iterate to determine if all elements of the guess match sequence
    
            // If match, signal a match, otherwise, try again.


        // role switch #2
        // Avi main coder 
        // Hrihaan edits

        // check that the guess is not null (handles the Cancel button case)
        if (guess != null) {

            // clean the user's input by removing spaces and commas
            String cleanGuess = guess.replace(" ", "").replace(",", "");
            
            // convert the correct sequence array into a string for comparison
            String actualSeq = "";
            for (String s : randomSeq) {
                actualSeq += s;
            }

            // compare the user's guess to the actual sequence
            if (cleanGuess.equalsIgnoreCase(actualSeq)) {
                game.matched();
                score++;
            } else {
                game.tryAgain();
            }
        }


        // role switch #3
        // Hrihaan code driver
        // Avi edit navigator

        // ask the player if they want to keep playing
        keepPlaying = game.playAgain();
    }
   
    // print the final score and number of rounds played
    game.showScore(score, rounds);
  }
}
