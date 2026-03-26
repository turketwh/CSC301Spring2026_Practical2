import java.util.ArrayList;

public class PatternMatcher {

    public static void main(String[] args) {
        String text = "ATCACG";
        String pattern = "ACG";

        int textLength = text.length();
        int patternLength = pattern.length();

        ArrayList<Integer> textIndicesOfPattern = new ArrayList<Integer>();
        int lastPossibleTextIndex = textLength - patternLength + 1;

        boolean matched;
        int textIndex;
        int patternIndex;
        for (textIndex = 0; textIndex < lastPossibleTextIndex; textIndex++) {
            matched = true;
            for (patternIndex = 0; patternIndex < patternLength; patternIndex++) {
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

