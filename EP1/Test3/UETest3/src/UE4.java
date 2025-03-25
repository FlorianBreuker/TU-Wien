import java.util.Arrays;

public class UE4 {


    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
        int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
        int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
        int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};

        int[][] result1 = rearrange(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = rearrange(test3);
        System.out.println(Arrays.deepToString(result2));

        System.out.println(Arrays.deepToString(rearrange(new int[][]{{}})));

        System.out.println("____________________________________________");

        label(test1);
        System.out.println(Arrays.deepToString(test1));

        label(test2);
        System.out.println(Arrays.deepToString(test2));

        label(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("__________________________________________");

        System.out.println(findMaxOppositeSum(seq1, 0, 7));

        System.out.println(findMaxOppositeSum(seq1, 0, 5));

        System.out.println(findMaxOppositeSum(seq1, 4, 7));
    }

    private static int findMaxOppositeSum(int[] sequence, int start, int end) {
        if (start >= end) return 0;

        int lastSum = findMaxOppositeSum(sequence, start + 1, end - 1);
        return Math.max(lastSum, sequence[start] + sequence[end]);
    }

    private static void label(int[][] inputArray) {
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i < inputArray.length - 1 && inputArray[i].length == inputArray[i + 1].length) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    if (inputArray[i][j] == inputArray[i + 1][j]) {
                        counter++;
                    }
                }
                if (counter == inputArray[i].length) {
                    for (int j = 0; j < inputArray[i].length; j++) {
                        inputArray[i][j] = -9;
                    }
                }
                counter = 0;
            }
        }
    }

    private static int[][] rearrange(int[][] inputArray) {
        int amountsOfCols = 4;
        int amountOfElements = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                amountOfElements++;
            }
        }

        int amountOfRows = 0;

        if (amountOfElements % 4 == 0) {
            amountOfRows = amountOfElements / amountsOfCols;
        } else {
            amountOfRows = amountOfElements / amountsOfCols + 1;
        }

        int[][] result = new int[amountOfRows][amountsOfCols];
        int iRow = 0;
        int iCol = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (iRow % 2 == 0) {
                    result[iRow][iCol++] = inputArray[i][j];
                    if (iCol >= result[iRow].length) {
                        iRow++;
                        iCol = amountsOfCols - 1;
                    }
                } else {
                    result[iRow][iCol--] = inputArray[i][j];
                    if (iCol < 0) {
                        iRow++;
                        iCol = 0;
                    }
                }

            }
        }
        return result;
    }
}
