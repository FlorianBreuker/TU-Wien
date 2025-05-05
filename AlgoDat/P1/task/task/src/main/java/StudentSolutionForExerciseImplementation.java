import exercise.StudentSolutionForExercise;
import exercise.StudentInformation;
import exercise.Point;
import exercise.ClosestPair;

/**
 * A class intended for students to implement their solutions in.
 */
public class StudentSolutionForExerciseImplementation implements StudentSolutionForExercise {

    /**
     * Collects and returns information about the student working on solving the instance sets.
     * This method is called automatically.
     *
     * @return First name, last name, and matriculation number collected in a {@link StudentInformation} instance.
     */
    public StudentInformation provideStudentInformation() {
        return new StudentInformation("Florian Matthias", // Vorname
                "Breuker", // Nachname
                "12418806" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für die Maximumsuche
    public int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Implementieren Sie hier Ihre Lösung für das dichteste Punktepaar
    public void findClosestPair(Point[] points, ClosestPair closestPair) {
        sortPoints(points, 0, points.length - 1);
        Point[] closest = findClosestX(points, points.length);
        closestPair.setPoint1(closest[0]);
        closestPair.setPoint2(closest[1]);
    }

    private Point[] bruteForceClosestPair(Point[] points) {
        Point closestA = points[0];
        Point closestB = points[1];
        double minDistance = Double.MAX_VALUE;
        Point[] currentPair = new Point[2];
        for (int i = 0; i < points.length; i++) {
            currentPair[0] = points[i];
            for (int j = i + 1; j < points.length; j++) {
                currentPair[1] = points[j];
                if (distance(currentPair) < minDistance) {
                    minDistance = distance(currentPair);
                    closestA = points[i];
                    closestB = points[j];
                }
            }
        }
        return new Point[]{closestA, closestB};
    }

    private Point[] findClosestX(Point[] points, int n) {
        if (points.length <= 3) return bruteForceClosestPair(points);

        int m = points.length / 2;
        Point mid = points[m];

        Point[] l = new Point[m];
        System.arraycopy(points, 0, l, 0, m);
        Point[] r = new Point[m];
        System.arraycopy(points, m, r, 0, points.length / 2);


        Point[] left = findClosestX(l, n);
        Point[] right = findClosestX(r, n);

        Point[] closestX;

        if (distance(left) < distance(right)) {
            closestX = left;
        } else {
            closestX = right;
        }
        double minDistanceX = distance(closestX);

        Point[] alongDivider = new Point[n];
        int divIndex = 0;
        for (Point point : points) {
            if (Math.abs(point.getX() - mid.getX()) < minDistanceX) {
                alongDivider[divIndex++] = point;
            }
        }

        Point[] closestY = findClosestDiv(alongDivider, closestX, divIndex);
        double minDistanceY = distance(closestY);
        if (minDistanceX < minDistanceY) {
            return closestX;
        } else {
            return closestY;
        }
    }

    private Point[] findClosestDiv(Point[] points, Point[] closest, int n) {
        swapAndSortXY(points, n);
        Point[] currentPair = new Point[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && points[j].getY() - points[i].getY() < distance(closest); j++) {
                currentPair[0] = points[i];
                currentPair[1] = points[j];
                if (distance(currentPair) < distance(closest)) {
                    closest[0] = currentPair[0];
                    closest[1] = currentPair[1];
                }
            }
        }
        return closest;
    }

    private void swapAndSortXY(Point[] points, int n) {
        for (int i = 0; i < n; i++) {
            points[i] = new Point(new Integer[]{points[i].getY(), points[i].getX()});
        }
        sortPoints(points, 0, n - 1);
        for (int i = 0; i < n; i++) {
            points[i] = new Point(new Integer[]{points[i].getY(), points[i].getX()});
        }
    }

    private void sortPoints(Point[] points, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortPoints(points, l, m);
            sortPoints(points, m + 1, r);
            mergePoints(points, l, m, r);
        }
    }

    private void mergePoints(Point[] points, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        Point[] temp = new Point[points.length];

        while (i <= m && j <= r) {
            if (points[i].getX() <= points[j].getX()) {
                temp[k++] = points[i++];
            } else {
                temp[k++] = points[j++];
            }
        }
        while (i <= m) {
            temp[k++] = points[i++];
        }
        while (j <= r) {
            temp[k++] = points[j++];
        }
        for (int h = l; h <= r; h++) {
            points[h] = temp[h];
        }
    }

    private double distance(Point[] pair) {
        int xA = pair[0].getX();
        int yA = pair[0].getY();
        int xB = pair[1].getX();
        int yB = pair[1].getY();

        int distanceX = Math.max(xA, xB) - Math.min(xA, xB);
        int distanceY = Math.max(yA, yB) - Math.min(yA, yB);

        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

    // Implementieren Sie hier Ihre Lösung für die Teilsummen
    public boolean hasSubsetSum(int sum, int[] numbers) {
        return subsetSum(sum, numbers, numbers.length - 1);
    }

    private boolean subsetSum(int sum, int[] numbers, int i) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || i < 0) {
            return false;
        }

        boolean in = subsetSum(sum - numbers[i], numbers, i - 1);
        boolean out = subsetSum(sum, numbers, i - 1);

        return in || out;
    }
}
