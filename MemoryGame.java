
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

    int score = 0;
    int rounds = 0;
    boolean keepPlaying = true;

    // role switch: Hrihaan (driver) , Avi (navigator)
    // main game loop runs until the player decides to stop   

    while (keepPlaying) {
        rounds++;
        
        // get the random order from our permutation class
        int[] nums = RandomPermutation.next(memoryStrings.length);
        String[] randomSeq = new String[memoryStrings.length];
        
        // use the random numbers to pick the letters
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1; // subtract 1 because array starts at 0
            randomSeq[i] = memoryStrings[index]; 
        }

        // show the sequence and get what the user typed
        String guess = game.playSequence(randomSeq, 0.5);

        // role switch: Avi (driver), Hrihaan (navigator)
        if (guess != null) {
            // get rid of spaces and commas so it doesn't break
            String userAnswer = guess.replace(" ", "");
            userAnswer = userAnswer.replace(",", "");
            
            // build the string to check against the user
            String correctAnswer = "";
            for (int j = 0; j < randomSeq.length; j++) {
                correctAnswer = correctAnswer + randomSeq[j];
            }

            // check if they got it right
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                game.matched();
                score++;
            } else {
                game.tryAgain();
            }
        }

        // check if they want to go again
        keepPlaying = game.playAgain();
    }
    
    // final score displayed 
    game.showScore(score, rounds);
  }

  // the random permutation class from the previous activity
  public static class RandomPermutation {
    public static int[] next(int n) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
        }
        
        // shuffle the numbers
        for (int i = 0; i < n; i++) {
            int randomPos = (int) (Math.random() * n);
            int temp = p[i];
            p[i] = p[randomPos];
            p[randomPos] = temp;
        }
        return p;
    }
  }
}
