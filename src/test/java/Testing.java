import org.junit.jupiter.api.Test;


public class Testing {

    @Test
    public void testIsValidPlacementAdjacent() {
        PrintBoard board = new PrintBoard();
        board.TestAllTrue();
        // Assuming row 0, col 0 is placed, which should make adjacent cells valid
        assert !board.isValidPlacement(0, 1);
        assert !board.isValidPlacement(1, 0);
        assert !board.isValidPlacement(1, 1);
        assert !board.isValidPlacement(2, 2); // Not adjacent
    }

    @Test
    public void testIsValidPlacementOutOfBounds() {
        PrintBoard board = new PrintBoard();
        board.TestAllTrue();
        assert !board.isValidPlacement(-1, 0);
        assert !board.isValidPlacement(0, -1);
        assert !board.isValidPlacement(5, 0);
        assert !board.isValidPlacement(0, 5);
    }

    @Test
    public void testIsValidAnimalTilePlacementValid() {
        PrintBoard board = new PrintBoard();
        board.TestAllTrue();
        // Assuming row 0, col 0 is placed
        assert board.isValidAnimalTilePlacement(0, 0, "B");
    }

    @Test
    public void testIsValidAnimalTilePlacementInvalid() {
        PrintBoard board = new PrintBoard();
        board.TestAllTrue();

        // Assuming row 0, col 0 is placed and animal tile is also placed
        assert !board.isValidAnimalTilePlacement(0, 0, "B");
    }

    @Test
    public void testIsValidAnimalTilePlacementOutOfBounds() {
        PrintBoard board = new PrintBoard();
        board.TestAllTrue();
        assert !board.isValidAnimalTilePlacement(-1, 0, "B");
        assert !board.isValidAnimalTilePlacement(0, -1, "B");
        assert !board.isValidAnimalTilePlacement(5, 0, "B");
        assert !board.isValidAnimalTilePlacement(0, 5, "B");
    }

}
