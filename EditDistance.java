public class EditDistance {

    public static void printColumn(int[][] table, int columnOfInterest) {
        int row;
        int numberOfRows = table.length;
        for (row = 0; row < numberOfRows; row++) {
            System.out.print("[" + table[row][columnOfInterest] + "]");
        }
    }

    public static int editDistance(String a, String b) {
        int row, column, north, northwest, west;
        String aExtended = "_" + a;
        String bExtended = "_" + b;
        int numberOfRows = aExtended.length();
        int numberOfColumns = bExtended.length();
        int[][] table = new int[numberOfRows][numberOfColumns];

        // base cases
        for (row = 1; row < numberOfRows; row++) {
            table[row][0] = row;
        }
        System.out.println("After processing column 0:");
        printColumn(table, 0);
        System.out.println();

        for (column = 1; column < numberOfColumns; column++) {
            table[0][column] = column;
        }

        // fill in rest of table, column-wise
        for (column = 1; column < numberOfColumns; column++) {
            for (row = 1; row < numberOfRows; row++) {
                north = 1 + table[row-1][column];
                west = 1 + table[row][column-1];
                northwest = table[row-1][column-1];
                if (aExtended.charAt(row) != bExtended.charAt(column)) {
                    northwest += 1;
                }
                table[row][column] = Math.min(north,Math.min(west, northwest));
            }
            System.out.println("After processing column " + column + ":");
            printColumn(table, column);
            System.out.println();
        }
        return table[numberOfRows-1][numberOfColumns-1];
    }

    public static void main(String[] args) {
        String word1 = "book";
        String word2 = "loot";

        int editDistance = editDistance(word1, word2);
        System.out.println("ed(" + word1 + "," + word2 + ") = " + editDistance);
    }
}
