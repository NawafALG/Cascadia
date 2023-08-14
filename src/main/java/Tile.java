import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Tile {
    boolean placed = false;

    boolean animaltileplaced = false;
    int animalSelectedIndex;
    RandomInt rdm;
    String row1;
    String row2;
    String row3;
    String row4;

    String upinfo,downinfo,leftinfo,rightinfo;

    List<String> animalPoolDistinct;

    
    String colorfillLeft, colorfillRight;

    public String getAnimalPlaced(){
        if(animaltileplaced)
            return animalPoolDistinct.get(animalSelectedIndex);
        else
            return " ";
    }
    public void checkedBool(){
        animalPoolDistinct.add(animalSelectedIndex, getAnimalPlaced().toLowerCase());
    }
    public Tile() {
        rdm = new RandomInt();

        Random a = new Random();
        Random b = new Random();
        Random c = new Random();

        int clr1 = a.nextInt(5) + 1;
        int clr2 = b.nextInt(5) + 1;

        
        if (clr1 == 1) {
            colorfillLeft = Colors.darkgreen;
            upinfo = "FRST";
        } else if (clr1 == 2) {
            colorfillLeft = Colors.lightgreen;
            upinfo = "GRASS";
        } else if (clr1 == 3) {
            colorfillLeft = Colors.skyblue;
            upinfo = "RIVER";
        } else if (clr1 == 4) {
            colorfillLeft = Colors.brown;
            upinfo = "MNTAIN";
        } else {
            colorfillLeft = Colors.yellow;
            upinfo = "YLW";
        }

        if (clr2 == 1) {
            colorfillRight = Colors.darkgreen;
            downinfo = "FRST";
        } else if (clr2 == 2) {
            colorfillRight = Colors.lightgreen;
            downinfo = "GRASS";
        } else if (clr2 == 3) {
            colorfillRight = Colors.skyblue;
            downinfo = "RIVER";
        } else if (clr2 == 4) {
            colorfillRight = Colors.brown;
            downinfo = "MNTAIN";
        } else {
            colorfillRight = Colors.yellow;
            downinfo = "YLW";
        }
        row1 = colorfillLeft + "            " + Colors.reset;


        //   animals = {'B', 'H', 'E', 'S', 'F'};
        //        "Bear", "Hawk", "Elk", "Salmon", "Fox"

        int i = rdm.randomint(100);

        List<String> animalPool = new ArrayList<>();

        if (upinfo.equals("FRST") || downinfo.equals("FRST")) {
            animalPool.add("E");
            animalPool.add("F");
            animalPool.add("B");
        } else if (upinfo.equals("GRASS") || downinfo.equals("GRASS")) {
            animalPool.add("H");
            animalPool.add("F");
        } else if (upinfo.equals("RIVER") || downinfo.equals("RIVER")) {
            animalPool.add("B");
            animalPool.add("S");
        } else if (upinfo.equals("MNTAIN") || downinfo.equals("MNTAIN")) {
            animalPool.add("H");
            animalPool.add("S");
        } else if (upinfo.equals("YLW") || downinfo.equals("YLW")) {
            animalPool.add("E");
            animalPool.add("H");
        }
        animalPoolDistinct = new ArrayList<>(new HashSet<>(animalPool));
        int animalCount;
        if (i > 66)
            animalCount = 3;
        else if (i > 33)
            animalCount = 2;
        else
            animalCount = 1;

        animalPoolDistinct = getRandomItems(animalPoolDistinct, animalCount);
        
            // choosing left diagnol or right diagnol at random
            if (c.nextInt(100) % 2 == 0) {
    
    
                if (animalPoolDistinct.size() == 3) {
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillRight + "   " + Colors.reset;
                } else if (animalPoolDistinct.size() == 2) {
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + "      " + colorfillRight + "   " + Colors.reset;
                } else {
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "    " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + "      " + colorfillRight + "   " + Colors.reset;
                }
    
                leftinfo = upinfo;
                rightinfo = downinfo;
            } else {
                if (animalPoolDistinct.size() == 3) {
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillLeft + "   " + Colors.reset;
                } else if (animalPoolDistinct.size() == 2) {
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + "      " + colorfillLeft + "   " + Colors.reset;
                } else {
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "    " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + "      " + colorfillLeft + "   " + Colors.reset;
                }
    
                leftinfo = downinfo;
                rightinfo = upinfo;
            }
        
        row4 = colorfillRight+"            "+Colors.reset;
    }

    public static <T> List<T> getRandomItems(List<T> list, int n) {
        Random random = new Random();
        int listSize = list.size();
        if (n >= listSize) {
            return new ArrayList<>(list);
        }
        List<T> randomItems = new ArrayList<>();
        List<Integer> selectedIndices = new ArrayList<>();
        while (randomItems.size() < n) {
            int randomIndex = random.nextInt(listSize);
            if (!selectedIndices.contains(randomIndex)) {
                selectedIndices.add(randomIndex);
                randomItems.add(list.get(randomIndex));
            }
        }
        return randomItems;
    }

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

    public void updateRowsAnimalTilePlaced(){
        // checking if right diagonal terrain and animal terrain has been placed
        if (animaltileplaced && leftinfo.equals(upinfo)){
            if (animalPoolDistinct.size() == 3) {
                if(animalSelectedIndex == 0) {
                    row2 = colorfillLeft + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+" " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillRight + "   " + Colors.reset;
                }
                else if (animalSelectedIndex == 1){
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + " "+Colors.CHOSEN+" " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillLeft + "   " + Colors.reset;
                }
                else{
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(2) + " "+Colors.reset+"   " + colorfillLeft + "   " + Colors.reset;
                }
            }
            else if (animalPoolDistinct.size() == 2) {
                if(animalSelectedIndex == 0) {
                    row2 = colorfillLeft + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+" " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + "      " + colorfillRight + "   " + Colors.reset;
                }
                else{
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + " "+Colors.CHOSEN+" " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + "      " + colorfillRight + "   " + Colors.reset;
                }
            }
            else {
                row2 = colorfillLeft + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+ "   " + colorfillRight + "   " + Colors.reset;
                row3 = colorfillLeft + "   " + Colors.reset + "      " + colorfillRight + "   " + Colors.reset;
            }
        }
        else{ // terrain left diagonally aligned
            if (animalPoolDistinct.size() == 3) {
                if(animalSelectedIndex == 0) {
                    row2 = colorfillRight + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+" " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillLeft + "   " + Colors.reset;
                }
                else if (animalSelectedIndex == 1){
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + " "+Colors.CHOSEN+" " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(2) + "    " + colorfillRight + "   " + Colors.reset;
                }
                else{
                    row2 = colorfillLeft + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + "  " + animalPoolDistinct.get(1) + " " + colorfillRight + "   " + Colors.reset;
                    row3 = colorfillLeft + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(2) + " "+Colors.reset+"   " + colorfillRight + "   " + Colors.reset;
                }
            }
            else if (animalPoolDistinct.size() == 2) {
                if(animalSelectedIndex == 0) {
                    row2 = colorfillRight + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+" " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + "      " + colorfillLeft + "   " + Colors.reset;
                }
                else{
                    row2 = colorfillRight + "   " + Colors.reset + " " + animalPoolDistinct.get(0) + " "+Colors.CHOSEN+" " + animalPoolDistinct.get(1) + " " + colorfillLeft + "   " + Colors.reset;
                    row3 = colorfillRight + "   " + Colors.reset + "      " + colorfillLeft + "   " + Colors.reset;
                }
            }
            else {
                row2 = colorfillRight + "   " + Colors.CHOSEN + " " + animalPoolDistinct.get(0) + " "+Colors.reset+ "   " + colorfillLeft + "   " + Colors.reset;
                row3 = colorfillRight + "   " + Colors.reset + "      " + colorfillLeft + "   " + Colors.reset;
            }
        }
    }
    public boolean isValidAnimalTilePlacement(String AnimalType){
        if(animalPoolDistinct.contains(AnimalType)){
            animaltileplaced = true;
            animalSelectedIndex = animalPoolDistinct.indexOf(AnimalType);
            updateRowsAnimalTilePlaced();
            return true;
        }
        return false;
    }
}
