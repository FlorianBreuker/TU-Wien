import java.util.Arrays;

public class UE1 {
    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
        int[][] test2 = {{1}};
        int[][] test3 = {{6, 7, 8}, {7, 5, 3, 1}, {2}};
        String seq1 = "ABBAACBA";

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        System.out.println(Arrays.deepToString(result1));

        reorder(result2);
        System.out.println(Arrays.deepToString(result2));

        reorder(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));
    }

    private static int[][] generate(int[][] input) {
        int[][] result = new int[input.length * 2 - 1][];
        int currentLineLength = input[0].length + 1;
        int currentRow = 0;

        for (int i = 0; i <= result.length / 2; i++) {
            currentLineLength--;

            result[i] = new int[currentLineLength];
            for (int j = 0; j < currentLineLength; j++) {
                result[i][j] = input[currentRow][j];
            }
            currentRow++;
        }
        currentRow--;
        currentRow--;
        for (int i = result.length / 2 + 1; i < result.length; i++) {
            currentLineLength++;
            result[i] = new int[currentLineLength];
            for (int k = 0; k < currentLineLength; k++) {
                result[i][k] = input[currentRow][k];
            }
            currentRow--;
        }

        return result;
    }

    private static void reorder(int[][] input){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length / 2; j++) {
                int exchange = input[i][j];
                input[i][j] = input[i][input[i].length - 1 - j];
                input[i][input[i].length - 1 - j] = exchange;
            }
        }
    }

    private static boolean isPresentNTimes(String sequence, char marker, int count){
        if (sequence.isEmpty() && count == 0){
            return true;
        } else if (sequence.isEmpty()){
            return false;
        } else {
            if (sequence.charAt(0) == marker){
                return isPresentNTimes(sequence.substring(1), marker, --count);
            } else {
                return isPresentNTimes(sequence.substring(1), marker, count);
            }
        }
    }
}
