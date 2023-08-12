public class Game {
    Tile tiles[];

    public void createtiles(){
        for (int i = 0; i < 4; i++){
            tiles[i] = new Tile();
            tiles[i].placed = true;
        }
    }
    Game(){
        tiles = new Tile[4];
        createtiles();
    }
    public void startGame(){
        PrintBoard board = new PrintBoard();
        board.init();
    }

    public void printTileChoices(){
        for(int i=1;i<5;i++)
            System.out.print("    #"+i+"          ");
        System.out.println();


        String output = "    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row1());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row2());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row3());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row4());
            output = output.concat("    ");
        }
        System.out.println(output);

        System.out.println("\nChoose your Habitat tile:");
    }

}
