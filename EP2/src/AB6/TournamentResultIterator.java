package AB6;

import AB6.Interfaces.Dinosaur;

/**
 * An iterator class designed to traverse the results of a dinosaur tournament
 * in descending order of scores. The iterator ensures that each dinosaur is
 * processed only once, based on their scores and, in case of identical scores,
 * based on their order in the roster array.
 */
public class TournamentResultIterator {
    private int[] scoreSheet;
    private Dinosaur[] roster;
    private int currentMax;
    private int[] prev;

    // TODO: variable declarations (optional)

    /**
     * Constructs a TournamentResultIterator to iterate over the tournament results.
     *
     * @param roster     an array of {@code Dinosaur} objects representing the participants of the tournament. Must not be {@code null}
     * @param scoreSheet an array of integers representing the scores (number of wins) of the dinosaurs in the tournament. Must not be {@code null}
     */
    public TournamentResultIterator(Dinosaur[] roster, int[] scoreSheet) {
        this.scoreSheet = scoreSheet;
        this.roster = roster;
        this.prev = new int[roster.length];

        this.currentMax = -1;
        for (int i = 0; i < roster.length; i++) {
            if (scoreSheet[i] > currentMax) {
                currentMax = scoreSheet[i];
            }
        }
    }

    /**
     * Checks if there are any dinosaurs left in the roster, which can be returned by the iterator.
     * <p>A dinosaur can be returned<br>
     * - if it has not been returned so far<br>
     * - and if its score is less or equal than the score of the previously returned dinosaur
     * (or less or equal than the highest possible score, if no participant has been returned so far).</p>
     *
     * @return {@code true} if there are dinosaurs in the roster that have not been processed
     * and meet the criteria; {@code false} otherwise.
     */
    public boolean hasNext() {
        for (int i = 0; i < roster.length; i++) {
            if (prev[i] == 0 && scoreSheet[i] <= currentMax) return true;
        }
        return false;
    }

    /**
     * Retrieves the next unprocessed {@code Dinosaur} from the roster based on its score.
     * The order of the iteration is from the highest score to the lowest.
     * If multiple participants with the same score exist, these are ordered according to their
     * position in the roster (first come, first served).
     *
     * <p>The method iterates over the roster to find a dinosaur that:<br>
     * 1. Matches the current score criteria (the score is greater than or equal to zero
     * and equal to the current score).<br>
     * 2. Has not been processed yet.<br></p>
     *
     * <p>Once a suitable dinosaur is found, it is returned. If no such dinosaur exists, the score is reduced by one and
     * processing continues. If the score is less than zero (all valid scores are exhausted, so no more dinosaur can be
     * returned) {@code null} is returned.</p>
     *
     * @return the next unprocessed {@code Dinosaur} meeting the criteria, or {@code null} if no suitable dinosaur is found.
     */
    public Dinosaur next() {
        if (!hasNext()) return null;
        while (currentMax >= 0) {
            for (int i = 0; i < scoreSheet.length; i++) {
                if (prev[i] == 0 && scoreSheet[i] == currentMax) {
                    prev[i] = -1;
                    return roster[i];
                }
            }
            currentMax--;
        }
        return null;
        /*
        if (!hasNext()) return null;
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < scoreSheet.length; i++) {
            if (prev[i] == 0 && scoreSheet[i] > max) {
                max = scoreSheet[i];
                maxIndex = i;
            }
        }
        if (prev[maxIndex] < 0) return null;
        prev[maxIndex] = -1;
        return roster[maxIndex];
        */
    }
}
