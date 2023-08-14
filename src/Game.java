import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Tile tiles[];
    PrintBoard board[]; // game board

    List<String> animalPool; // var stores animal tiles on board

    String player1Name, player2Name;

    int turnNumber;
    int pindex; // player turn index
    public void createtiles(){
        for (int i = 0; i < 4; i++){
            tiles[i] = new Tile();
            tiles[i].placed = true;
        }
    }
    Game(){
        turnNumber = 0;

        board = new PrintBoard[2];
        board[0] = new PrintBoard();
        board[1] = new PrintBoard();


        pindex = 0;

        tiles = new Tile[4];
        createtiles();

        animalPool = new ArrayList<>();
        animalPool.add("B");
        animalPool.add("S");
        animalPool.add("H");
        animalPool.add("E");
        animalPool.add("F");

        animalPool = getRandomItemsWithMaxDuplicates(animalPool, 4, 2);
    }

    public void PrintCurrentPlayerBoard(){
        board[pindex].print();
    }

    public void printTileChoices(){
        createtiles();

        System.out.print("\n\n\t\t\t\t\tHabitat Tile Choices:\n\t\t\t\t\t");

        for(int i=1;i<5;i++)
            System.out.print("    #"+i+"          ");
        System.out.println();


        String output = "\t\t\t\t\t    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row1());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "\t\t\t\t\t    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row2());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "\t\t\t\t\t    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row3());
            output = output.concat("    ");
        }
        System.out.println(output);

        output = "\t\t\t\t\t    ";
        for(int j=0;j<4;j++){
            output = output.concat(tiles[j].row4());
            output = output.concat("    ");
        }
        System.out.println(output);


        printAnimalTileChoices();

        // take user input related to habitat tiles
        Scanner scanner = new Scanner(System.in);


        int userChoice,rowChoice, colChoice;
        // habitat tile placement
        System.out.print("\nChoose your Habitat tile:");
        userChoice = scanner.nextInt();

        System.out.print("in which Row to position Habitat tile in:");
        rowChoice = scanner.nextInt();

        System.out.print("in which Column to position Habitat tile in:");
        colChoice = scanner.nextInt();

        if(board[pindex].isValidPlacement(rowChoice-1, colChoice-1)){
            board[pindex].obj[rowChoice-1][colChoice-1] = tiles[userChoice-1];
            board[pindex].obj[rowChoice-1][colChoice-1].placed = true;
            board[pindex].print();
        }
        else{
            while(!board[pindex].isValidPlacement(rowChoice-1, colChoice-1)){
                System.out.print("Invalid index!\nin which Row to position Habitat tile in:");
                rowChoice = scanner.nextInt();
                System.out.print("in which Column to position Habitat tile in:");
                colChoice = scanner.nextInt();
            }
            board[pindex].obj[rowChoice-1][colChoice-1] = tiles[userChoice-1];
            board[pindex].obj[rowChoice-1][colChoice-1].placed = true;
            board[pindex].print();
        }// habitat tile placement ends

        printAnimalTileChoices();

        // animal tile placement starts
        System.out.print("\nChoose your Animal Tile:");
        userChoice = scanner.nextInt();
        if(userChoice-1>4 || userChoice-1<1){
            while(userChoice-1<=4 && userChoice-1>0){
                System.out.print("\nIncorrect input!\nChoose your Animal tile:");
                userChoice = scanner.nextInt();
            }
        }

        System.out.print("in which Row to position Animal tile in:");
        rowChoice = scanner.nextInt();
        System.out.print("in which Column to position Animal tile in:");
        colChoice = scanner.nextInt();

        boolean val = board[pindex].isValidAnimalTilePlacement(rowChoice-1, colChoice-1, animalPool.get(userChoice-1));
        if (!val){
            while(!board[pindex].isValidAnimalTilePlacement(rowChoice-1, colChoice-1, animalPool.get(userChoice-1))){
                System.out.print("Invalid entry!\nin which Row to position Animal tile in:");
                rowChoice = scanner.nextInt();
                System.out.print("in which Column to position Animal tile in:");
                colChoice = scanner.nextInt();
            }
        }

        board[pindex].print();

        // toggle player index value
//        if(pindex == 0)
//            pindex = 1;
//        else
//            pindex = 0;

        turnNumber++;
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Colors.space();
    }


    public void printAnimalTileChoices() { // only prints animal tile choices
//        List<String> animalPool = new ArrayList<>();
//        animalPool.add("B");
//        animalPool.add("S");
//        animalPool.add("H");
//        animalPool.add("E");
//        animalPool.add("F");
//
//        List<String> chosenAnimals = getRandomItemsWithMaxDuplicates(animalPool, 4, 2);

        System.out.println("\n\t\t\t\t\tAnimal Tile Choices:");
        for (int i = 0; i < animalPool.size(); i++) {
            String animal = animalPool.get(i);
            String animalName = getAnimalName(animal);
            System.out.println("\t\t\t\t\t"+(i + 1) + ".  " + animalName);
        }
    }

    // sub-sub function
    private String getAnimalName(String animalCode) {
        if (animalCode.equals("B")) {
            return "Bear";
        } else if (animalCode.equals("H")) {
            return "Hawk";
        } else if (animalCode.equals("E")) {
            return "Elk";
        } else if (animalCode.equals("S")) {
            return "Salmon";
        } else if (animalCode.equals("F")) {
            return "Fox";
        }
        return "";
    }
    //sub function
    private List<String> getRandomItemsWithMaxDuplicates(List<String> list, int n, int maxDuplicates) {
        Random random = new Random();
        int listSize = list.size();
        if (n >= listSize) {
            return new ArrayList<>(list);
        }
        List<String> randomItems = new ArrayList<>();
        int duplicateCount = 0;
        while (randomItems.size() < n) {
            String randomItem = list.get(random.nextInt(listSize));
            if (randomItems.contains(randomItem)) {
                if (duplicateCount < maxDuplicates) {
                    randomItems.add(randomItem);
                    duplicateCount++;
                }
            } else {
                randomItems.add(randomItem);
            }
        }
        return randomItems;
    }




    // Misc functions
    public void printTitle(){
        System.out.println("\n\n\n\t\t\t ██████╗ █████╗ ███████╗ ██████╗ █████╗ ██████╗ ██╗ █████╗ ");
        System.out.println("\t\t\t██╔════╝██╔══██╗██╔════╝██╔════╝██╔══██╗██╔══██╗██║██╔══██╗");
        System.out.println("\t\t\t██║     ███████║███████╗██║     ███████║██║  ██║██║███████║");
        System.out.println("\t\t\t██║     ██╔══██║╚════██║██║     ██╔══██║██║  ██║██║██╔══██║");
        System.out.println("\t\t\t╚██████╗██║  ██║███████║╚██████╗██║  ██║██████╔╝██║██║  ██║");
        System.out.println("\t\t\t ╚═════╝╚═╝  ╚═╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝╚═╝  ╚═╝");
    }
    public int printOptions(){
        printTitle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t1. Start game");
        System.out.println("\t\t\t\t\t\t\t\t2. How to Play");
        System.out.print("\t\t\t\t\t\t\t\t3. Exit\n\n\t\t\t\t\t\t\t\tEnter your choice:");

        int userChoice = scanner.nextInt();
        if (userChoice>0 && userChoice<4)
            return userChoice;
        else{
            while(!(userChoice>0 && userChoice<4)) {
                System.out.print("\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\terror\n\t\t\t\t\t\t\t\tEnter your choice:");
                userChoice = scanner.nextInt();

            }
        }
        return userChoice;
    }
    public void printHelp(){
        System.out.println("----- SCORING CARDS FOR EACH WILDLIFE -----\n");
        System.out.println("----- BEAR SCORING CARD (A) -----");
        System.out.println("Score points for total number of pairs of Bears.");
        System.out.println("A pair of Bears is exactly two Bears adjacent to each other with no other adjacent Bears.\n");

        System.out.println("----- ELK SCORING CARD (A) -----");
        System.out.println("Score points for each straight line of adjacent Elk, depending on the number of Elk in the line.");
        System.out.println("A straight line of Elk is a line of Elk that are adjacent to each other with no other adjacent Elk.");
        System.out.println("Lines do not need to be horizontal.\n");

        System.out.println("----- FOX SCORING CARD (A) -----");
        System.out.println("Score points for each Fox, depending on the number of unique, wildlife types adjacent to it.");
        System.out.println("Other Foxes may be scored as unique when scoring each Fox.\n");

        System.out.println("----- HAWK SCORING CARD (A) -----");
        System.out.println("Score points for each Hawk for total number of Hawks that are not adjacent to any other Hawks.\n");

        System.out.println("----- SALMON SCORING CARD (C) -----");
        System.out.println("Score points for each run of Salmon, depending on the number/length of Salmon in the run.");
        System.out.println("A run is defined as a group of adjacent Salmon where each Salmon is adjacent to no more than two other Salmon.");
        System.out.println("A group of three Salmon in a triangle shape may count as a run, but no other Salmon may be attached to this run.");
        System.out.print("\nEach run of Salmon may not have any other Salmon adjacent to it.\n\nPress 0 to exit:");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        System.out.println("__________________________________________________________________________________________");
    }
    public void askNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\t\tEnter the name of Player 1: ");
        player1Name = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t\tEnter the name of Player 2: ");
        player2Name = scanner.nextLine();
        Colors.space();

        board[0].playername = player1Name;
        board[1].playername = player2Name;
    }

    public void printGameOver(){
        Colors.space();
        System.out.println("\t\t\t ██████╗  █████╗ ███╗   ███╗███████╗    ███████╗███╗   ██╗██████╗ ███████╗");
        System.out.println("\t\t\t██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔════╝████╗  ██║██╔══██╗██╔════╝");
        System.out.println("\t\t\t██║  ███╗███████║██╔████╔██║█████╗      █████╗  ██╔██╗ ██║██║  ██║███████╗");
        System.out.println("\t\t\t██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██╔══╝  ██║╚██╗██║██║  ██║╚════██║");
        System.out.println("\t\t\t╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ███████╗██║ ╚████║██████╔╝███████║");
        System.out.println("\t\t\t ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝    ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝");
        System.out.println("\n\n\t\t\t                           Displaying Results...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Colors.space();
        printScoreBoard();
    }
    public void printScoreBoard(){
        System.out.println(Colors.HEADER3+"Players\t\t\t\t\t"+player1Name+"\t\t"+player2Name+""+Colors.reset);
        System.out.println("Bear\t\t\t\t\t"+Score.GetBearScore(board[0])+"\t\t\t"+Score.GetBearScore(board[1]));
        System.out.println("Hawk\t\t\t\t\t"+Score.GetHawkScore(board[0])+"\t\t\t"+Score.GetHawkScore(board[1]));
        System.out.println("Elk\t\t\t\t\t\t"+Score.GetElkScore(board[0])+"\t\t\t"+Score.GetElkScore(board[1]));
        System.out.println("Salmon\t\t\t\t\t"+Score.GetSalmonScore(board[0])+"\t\t\t"+Score.GetSalmonScore(board[1]));
        System.out.println("Fox\t\t\t\t\t\t"+Score.GetFoxScore(board[0])+"\t\t\t"+Score.GetFoxScore(board[1]));

        System.out.println("\nForest\t\t\t\t\t"+Score.GetMaxHabitatChunkSize(board[0], "FRST")+"\t\t\t"+Score.GetMaxHabitatChunkSize(board[1], "FRST"));
        System.out.println("Wetland\t\t\t\t\t"+Score.GetMaxHabitatChunkSize(board[0], "GRASS")+"\t\t\t"+Score.GetMaxHabitatChunkSize(board[1], "GRASS"));
        System.out.println("River\t\t\t\t\t"+Score.GetMaxHabitatChunkSize(board[0], "RIVER")+"\t\t\t"+Score.GetMaxHabitatChunkSize(board[1], "RIVER"));
        System.out.println("Mountain\t\t\t\t"+Score.GetMaxHabitatChunkSize(board[0], "MNTAIN")+"\t\t\t"+Score.GetMaxHabitatChunkSize(board[1], "MNTAIN"));
        System.out.println("Prairie\t\t\t\t\t"+Score.GetMaxHabitatChunkSize(board[0], "YLW")+"\t\t\t"+Score.GetMaxHabitatChunkSize(board[1], "YLW"));


        int scorePlayer1=0;
        int scorePlayer2=0;

        System.out.print("\n"+Colors.HEADER2+"Final score\t\t\t\t\t"+scorePlayer1+"\t\t\t"+scorePlayer2+Colors.reset);

    }

}
