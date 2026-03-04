/**
 * Project 3.1.5 Memory Game
 * * Logic: Displays a randomized sequence of strings. The player must 
 * recreate the sequence from memory.
 */
public class MemoryGame
{
  public static void main(String[] args) {

    // TO DO: Create the "memory strings" - an array of 5 single character strings
    String[] memoryStrings = {"A", "B", "C", "D", "E"};

    // Create the game and gameboard. Configure with 3 buttons.
    MemoryGameGUI game = new MemoryGameGUI();
    game.createBoard(3, true);

    // Initialize scoring and loop variables
    int score = 0;
    int rounds = 0;
    boolean keepPlaying = true;

    // --- PARTNER SWITCH: [Name] as Driver, [Name] as Navigator ---

    while (keepPlaying) {
        rounds++;
        
        // Create a random version of the memory strings using a shuffle algorithm
        String[] randomSeq = new String[memoryStrings.length];
        System.arraycopy(memoryStrings, 0, randomSeq, 0, memoryStrings.length);
        
        // Random Permutation Algorithm (Swapping elements)
        for (int i = 0; i < randomSeq.length; i++) {
            int randIndex = (int)(Math.random() * randomSeq.length);
            String temp = randomSeq[i];
            randomSeq[i] = randomSeq[randIndex];
            randomSeq[randIndex] = temp;
        }

        // Play sequence with .5 second delay and capture guess
        // Test Note: You can change .5 to other values to test speed requirements
        String guess = game.playSequence(randomSeq, .5);

        // --- PARTNER SWITCH: [Name] as Driver, [Name] as Navigator ---

        // Determine a match if the guess is not null (handles "Cancel" test case)
        if (guess != null) {
            // Cleanse data: replace commas and spaces with empty string
            String cleanGuess = guess.replace(" ", "").replace(",", "");
            
            // Build a string from the array to compare against the cleansed guess
            String actualSeq = "";
            for (String s : randomSeq) {
                actualSeq += s;
            }

            // Iterate to determine if elements match
            if (cleanGuess.equalsIgnoreCase(actualSeq)) {
                game.matched();
                score++;
            } else {
                game.tryAgain();
            }
        }
            
        // Ask to play again and track rounds
        keepPlaying = game.playAgain();
    }
   
    // Final score summary
    game.showScore(score, rounds);
  }
}