import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MovieRating {
    String rating;
    int ratingValue;

    public MovieRating(String rating, int ratingValue) {
        this.rating = rating;
        this.ratingValue = ratingValue;
    }
}

public class MovieRatings {

    public static void main(String[] args) {
        List<MovieRating> movieRatings = new ArrayList<>();

        movieRatings.add(new MovieRating("PG", 7));
        movieRatings.add(new MovieRating("PG-13", 8));
        movieRatings.add(new MovieRating("R", 9));
        movieRatings.add(new MovieRating("PG", 6));
        movieRatings.add(new MovieRating("PG-13", 7));
        movieRatings.add(new MovieRating("R", 9));
        movieRatings.add(new MovieRating("PG", 8));

        Map<String, List<MovieRating>> ratingWiseMovieRatings = new HashMap<>();

        for (MovieRating rating : movieRatings) {
            if (!ratingWiseMovieRatings.containsKey(rating.rating)) {
                ratingWiseMovieRatings.put(rating.rating, new ArrayList<>());
            }
            ratingWiseMovieRatings.get(rating.rating).add(rating);
        }

        int totalRatings = movieRatings.size();
        double totalAverage = 0;

        for (Map.Entry<String, List<MovieRating>> entry : ratingWiseMovieRatings.entrySet()) {
            int count = entry.getValue().size();
            double sum = 0;
            for (MovieRating movieRating : entry.getValue()) {
                sum += movieRating.ratingValue;
            }
            double average = sum / count;
            totalAverage += average * count;

            System.out.printf("%s: %d ratings, average rating %.2f%n",
                    entry.getKey(), count, average);
        }

        System.out.printf("Total: %d ratings, average rating %.2f%n", totalRatings, totalAverage / totalRatings);
    }
}