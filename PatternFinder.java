import java.util.ArrayList;

public class PatternFinder {

    public static ArrayList<Integer> findPatternWithinText(String text) {
        int textLength;
        int position;
        int state;
        ArrayList<Integer> listOfLocations;
        int[][] table;

        table = new int[5][3];
        table[0][0] = 0;
        table[0][1] = 0;
        table[0][2] = 1;
        table[1][0] = 0;
        table[1][1] = 0;
        table[1][2] = 2;
        table[2][0] = 0;
        table[2][1] = 3;
        table[2][2] = 2;
        table[3][0] = 0;
        table[3][1] = 0;
        table[3][2] = 4;
        table[4][0] = 0;
        table[4][1] = 0;
        table[4][2] = 2;

        listOfLocations = new ArrayList<>();
        textLength = text.length();

        state = 0;
        for (position = 0; position < textLength; position++) {
            if (text.charAt(position) == '0') { state = table[state][0]; }
            else if (text.charAt(position) == '1') { state = table[state][1]; }
            else { state = table[state][2]; }
            if (4 == state) {
                listOfLocations.add(position-3);
            }
        }

        return listOfLocations;
    }

    public static void main(String[] args) {
        String text = "20221212221202";
        ArrayList<Integer> locations = findPatternWithinText(text);
        System.out.println("Pattern found in text starting at the following indices: " + locations);
    }
}
