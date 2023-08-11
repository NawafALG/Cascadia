import java.util.Random;

public class Tile {
    boolean placed = false;

    String row1;
    String row2;
    String row3;
    String row4;

    public Tile() {
        Random a = new Random();
        Random b = new Random();

        int clr1 = a.nextInt(5) + 1;
        int clr2 = b.nextInt(5) + 1;

        String colorfillLeft, colorfillRight;
        if (clr1 == 1) colorfillLeft = Colors.darkgreen;
        else if (clr1 == 2) colorfillLeft = Colors.lightgreen;
        else if (clr1 == 3) colorfillLeft = Colors.skyblue;
        else if (clr1 == 4) colorfillLeft = Colors.brown;
        else colorfillLeft = Colors.yellow;

        if (clr2 == 1) colorfillRight = Colors.darkgreen;
        else if (clr2 == 2) colorfillRight = Colors.lightgreen;
        else if (clr2 == 3) colorfillRight = Colors.skyblue;
        else if (clr2 == 4) colorfillRight = Colors.brown;
        else colorfillRight = Colors.yellow;


        row1 = colorfillLeft+"            "+Colors.reset;
        row2 = colorfillLeft+"   "+Colors.reset+"      "+colorfillLeft+"   "+Colors.reset;
        row3 = colorfillLeft+"   "+Colors.reset+"      "+colorfillLeft+"   "+Colors.reset;
        row4 = colorfillRight+"            "+Colors.reset;
    }
//    public void subprint(String coord){
//        String colorfillLeft, colorfillRight;
//        if (clr1 == 1) colorfillLeft = Colors.darkgreen;
//        else if (clr1 == 2) colorfillLeft = Colors.lightgreen;
//        else if (clr1 == 3) colorfillLeft = Colors.skyblue;
//        else if (clr1 == 4) colorfillLeft = Colors.brown;
//        else colorfillLeft = Colors.yellow;
//
//        if (clr2 == 1) colorfillRight = Colors.darkgreen;
//        else if (clr2 == 2) colorfillRight = Colors.lightgreen;
//        else if (clr2 == 3) colorfillRight = Colors.skyblue;
//        else if (clr2 == 4) colorfillRight = Colors.brown;
//        else colorfillRight = Colors.yellow;
//
//        System.out.println(colorfillLeft+"            "+Colors.reset);
//        System.out.println(colorfillLeft+"   "+Colors.reset+"      "+colorfillLeft+"   "+Colors.reset);
//        System.out.println(colorfillLeft+"   "+Colors.reset+"      "+colorfillLeft+"   "+Colors.reset);
//        System.out.println(colorfillRight+"            "+Colors.reset);
//    }
//    public void print(String coord){
//        if (placed == false ) {
//            System.out.println("*-  -  -  -*");
//            System.out.println("`          `");
//            System.out.println("`          `");
//            System.out.println("*-  -  -  -*");
////        }
////        else{
//            subprint(coord);
//        }
//
//    }
    public String row1(){
        String out;
        if (!placed) out = "+-- ---- --+";
        else out = row1;
        return out;
    }
    public String row2(){
        String out;
        if (!placed) out = "|          |";
        else out = row2;
        return out;
    }
    public String row3(){
        String out;
        if (!placed) out = "|          |";
        else out = row3;
        return out;
    }
    public String row4(){
        String out;
        if (!placed) out = "+-- ---- --+";
        else out = row4;
        return out;
    }
}
