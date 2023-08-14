import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Testing3 {
    @Test
    public void testCalculateSpace() {
        assertEquals(0, Score.calculateSpace(1, 1));
        assertEquals(1, Score.calculateSpace(2, 1));
        assertEquals(0, Score.calculateSpace(1, 2));
        assertEquals(1, Score.calculateSpace(2, 2));
    }

    @Test
    public void testGetAnimalPlaced() {
        Tile tile = new Tile();
        tile.animaltileplaced = true;
        tile.animalSelectedIndex = 1;
        tile.animalPoolDistinct = new ArrayList<>(Arrays.asList("E", "H"));

        assertEquals("H", tile.getAnimalPlaced());
    }

    @Test
    public void testIsValidAnimalTilePlacement() {
        Tile tile = new Tile();
        tile.animalPoolDistinct = new ArrayList<>(Arrays.asList("E", "H"));

        assertTrue(tile.isValidAnimalTilePlacement("E"));
        assertTrue(tile.animaltileplaced);
        assertEquals(0, tile.animalSelectedIndex);
    }

    @Test
    public void testIsValidAnimalTilePlacementInvalid() {
        Tile tile = new Tile();
        tile.animalPoolDistinct = new ArrayList<>(Arrays.asList("E", "H"));

        assertFalse(tile.isValidAnimalTilePlacement("B"));
        assertFalse(tile.animaltileplaced);
    }
}
