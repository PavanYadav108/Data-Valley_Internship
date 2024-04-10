import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTestScores {

    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(75, 65, 85, 95, 55, 80, 70, 60, 90, 85);

        double averageScore = getAverageScore(scores);
        List<Integer> belowAverageScores = getScoresBelowAverage(scores, averageScore);
        List<Integer> aboveAverageScores = getScoresAboveAverage(scores, averageScore);

        System.out.println("Number of students who scored below the average: " + belowAverageScores.size());
        System.out.println("Number of students who scored at the average: " + (scores.size() - belowAverageScores.size() - aboveAverageScores.size()));
        System.out.println("Number of students who scored above the average: " + aboveAverageScores.size());

        System.out.println("Median score for students below the average: " + getMedian(belowAverageScores));
        System.out.println("Median score for students above the average: " + getMedian(aboveAverageScores));
    }

    private static double getAverageScore(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    private static List<Integer> getScoresBelowAverage(List<Integer> scores, double averageScore) {
        return new ArrayList<Integer>(scores).subList(0, scores.size() / 2);
    }

    private static List<Integer> getScoresAboveAverage(List<Integer> scores, double averageScore) {
        List<Integer> aboveAverageScores = new ArrayList<Integer>();
        for (int score : scores) {
            if (score > averageScore) {
                aboveAverageScores.add(score);
            }
        }
        return aboveAverageScores;
    }

    private static int getMedian(List<Integer> scores) {
        if (scores.size() % 2 == 0) {
            return (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2;
        } else {
            return scores.get(scores.size() / 2);
        }
    }
}