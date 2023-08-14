import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// its taking too long
public class Testing2 {
    @Test
    public void testPrintTitle() {
        // Create an instance of the Game class
        Game game = new Game();

        // This test will only check that the method doesn't throw an exception
        game.printTitle();
        game.printOptions();
    }

    @Test
    public void testIsValidPlacementAdjacent() {
        // Create an instance of the Game class
        Game game = new Game();

        // Assuming row 0, col 0 is placed, which should make adjacent cells valid
        assertFalse(game.board[0].isValidPlacement(0, 1));
        assertFalse(game.board[0].isValidPlacement(3, 3));
        assertFalse(game.board[0].isValidPlacement(2, 2)); // Not adjacent
    }

    @Test
    public void testIsValidPlacementOutOfBounds() {
        Game game = new Game();

        assertFalse(game.board[0].isValidPlacement(-1, 0));
        assertFalse(game.board[0].isValidPlacement(0, -1));
        assertFalse(game.board[0].isValidPlacement(5, 0));
        assertFalse(game.board[0].isValidPlacement(0, 5));
    }
}
