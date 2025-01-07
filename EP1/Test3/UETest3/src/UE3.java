import java.util.Arrays;

public class UE3 {

    private static int[][] labelPath(int n, int[][] points) {
        int[][] result = new int[n][n];
        for (int j = 0; j < result.length; j++) {
            for (int k = 0; k < result[j].length; k++) {
                result[j][k] = n;
            }
        }
        for (int[] point : points) {
            result[point[0]][point[1]] = -1;
        }
        return result;
    }

    private static void findMatches(int[][] data, int[] pattern, int[] target) {
        for (int i = 0; i < data.length; i++) {
            target[i] = 0;
        }

        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == pattern[0]) {
                    for (int k = 0; k < pattern.length; k++) {
                        if (j + k < data[i].length) {
                            if (data[i][j + k] == pattern[k]) {
                                count++;
                            } else {
                                break;
                            }

                            if (count == pattern.length) {
                                target[i]++;
                            }
                        }
                    }
                    count = 0;
                }
            }
        }
    }

    private static String insertMiddle(String input, String seps) {
        if (input.isEmpty()) {
            return "";
        }

        return seps.charAt(0) + insertMiddle(input.substring(0, input.length() / 2), seps.substring(1));
    }

    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][]{})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));

        System.out.println("_____________________________________");

        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));

        System.out.println("_____________________________________");

        System.out.println(insertMiddle("XY", "abc"));


    }
}
