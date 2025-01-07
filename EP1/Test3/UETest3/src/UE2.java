import java.lang.reflect.Array;
import java.util.Arrays;

public class UE2 {
    public static void main(String[] args) {
        int[][] test1 = { {1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1} };
        int[][] test2 = { {1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = { {1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2} };
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("_____________________________");

        fill(test1, test2[3], test2[4]);
        System.out.println(Arrays.deepToString(test1));

        fill(result1, test2[2], test2[4]);
        System.out.println(Arrays.deepToString(result1));

        fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("______________________________");

        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));
        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));

        System.out.println("_____________________own________________");
        //target=test3, values=test2[0] und times=test2[1]
        fill(test3, test2[0], test2[1]);
        System.out.println(Arrays.deepToString(test3));
    }

    private static int[][] generate(int[][] input){
        int[][] result = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            result[i] = new int[input[i].length];
            int lastIndex = 0;
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] < 0) {
                    result[i][lastIndex++] = input[i][j];
                }
            }
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] >= 0) {
                    result[i][lastIndex++] = input[i][j];
                }
            }
        }
        return result;
    }

    private static void fill(int[][] target, int[] values, int[] times){
        int valuesIndex = 0;
        int targetRow = 0;
        int targetCol = 0;
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i]; j++) {
                if (target[targetRow].length == targetCol) {
                    targetRow++;
                    targetCol = 0;
                }
                if (target[targetRow].length == 0){
                    targetRow++;
                    targetCol = 0;
                }
                target[targetRow][targetCol++] = values[valuesIndex];
            }
            valuesIndex++;
        }
    }

    private static String extractString(char[] sequence, int start, int end, char omit){
        if (start == end){
            return "";
        }

        if (sequence[start] != omit){
            return sequence[start] + extractString(sequence, start + 1, end, omit);
        } else {
            return extractString(sequence, start + 1, end, omit);
        }
    }
}
