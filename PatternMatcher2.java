import java.util.ArrayList;

public class PatternMatcher2 {

    public static ArrayList<Integer> findUsefulStartingPoints(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int textIndex;
        int textLength = text.length();
        int lastPossibleTextIndex = textLength - pattern.length() + 1;
        char patternFirstSymbol = pattern.charAt(0);

        for (textIndex = 0; textIndex < lastPossibleTextIndex; textIndex++) {
            if (text.charAt(textIndex) == patternFirstSymbol)
                result.add(textIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "ATCACG";
        String pattern = "ACG";

        int textLength = text.length();
        int patternLength = pattern.length();

        ArrayList<Integer> usefulStartingPoints = findUsefulStartingPoints(text, pattern);

        ArrayList<Integer> textIndicesOfPattern = new ArrayList<Integer>();

        boolean matched;
        int usefulStartingPointsIndex;
        int textIndex;
        int numberOfUsefulStartingPoints = usefulStartingPoints.size();
        int patternIndex;
        for (usefulStartingPointsIndex = 0; usefulStartingPointsIndex < numberOfUsefulStartingPoints;
             usefulStartingPointsIndex++) {
            textIndex = usefulStartingPoints.get(usefulStartingPointsIndex);
            matched = true;
            for (patternIndex = 1; patternIndex < patternLength; patternIndex++) {
                if (text.charAt(textIndex + patternIndex) != pattern.charAt(patternIndex)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                textIndicesOfPattern.add(textIndex);
            }
        }
        System.out.println(textIndicesOfPattern.toString());
    }
}

