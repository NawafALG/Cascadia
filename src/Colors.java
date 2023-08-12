public class Colors {

    static final String darkgreen = "\033[42m";   // Dark Green background
    static final String lightgreen = "\u001B[102m"; // Light Green background
    static final String skyblue = "\u001B[44m";    // Sky Blue background
    static final String brown = "\u001B[43m";       // Brown background
    static final String yellow = "\u001B[103m";     // Yellow background
    static final String reset = "\u001B[0m";          // Reset to default colors

    // highlight background colours
    public static final String CHOSEN = "\033[48;5;160m";    // RED
    public static final String HEADER = "\u001B[41m";    // Light RED
    public static final String HEADER2 = "\033[1;91m";    // Light RED
    public static final String HEADER3 = "\033[1;93m";    // Light RED

    public static void space(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
