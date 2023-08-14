import java.util.Random;
public class RandomInt {
    public int randomint(int upperbound, int lowerbound){
        Random a = new Random();
        int num = a.nextInt(upperbound) + lowerbound;
        return num;
    }
    public int randomint(int upperbound){
        Random a = new Random();
        return a.nextInt(upperbound);
    }
}
