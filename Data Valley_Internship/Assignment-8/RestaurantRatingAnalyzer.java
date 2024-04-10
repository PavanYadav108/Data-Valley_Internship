import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant {
    private String name;
    private int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant1", 4));
        restaurants.add(new Restaurant("Restaurant2", 8));
        restaurants.add(new Restaurant("Restaurant3", 6));
        restaurants.add(new Restaurant("Restaurant4", 2));
        restaurants.add(new Restaurant("Restaurant5", 10));
        restaurants.add(new Restaurant("Restaurant6", 3));

        // Define rating ranges
        int[][] ratingRanges = {{1, 5}, {6, 10}};

        // Count of restaurants rated within specified rating ranges
        Map<String, Integer> restaurantsByRange = countRestaurantsByRange(restaurants, ratingRanges);

        // Average rating for each range
        Map<String, Double> averageRatingsByRange = calculateAverageRatingByRange(restaurants, ratingRanges);

        // Print results
        System.out.println("Number of restaurants rated within specific ranges:");
        for (Map.Entry<String, Integer> entry : restaurantsByRange.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nAverage rating for each range:");
        for (Map.Entry<String, Double> entry : averageRatingsByRange.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Count restaurants rated within specified rating ranges
    private static Map<String, Integer> countRestaurantsByRange(List<Restaurant> restaurants, int[][] ratingRanges) {
        Map<String, Integer> countByRange = new HashMap<>();
        for (Restaurant restaurant : restaurants) {
            int rating = restaurant.getRating();
            for (int[] range : ratingRanges) {
                if (rating >= range[0] && rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    countByRange.put(key, countByRange.getOrDefault(key, 0) + 1);
                    break;
                }
            }
        }
        return countByRange;
    }

    // Calculate average rating for each range
    private static Map<String, Double> calculateAverageRatingByRange(List<Restaurant> restaurants, int[][] ratingRanges) {
        Map<String, Double> averageRatingsByRange = new HashMap<>();
        Map<String, Integer> sumRatingsByRange = new HashMap<>();
        Map<String, Integer> countByRange = countRestaurantsByRange(restaurants, ratingRanges);

        for (Restaurant restaurant : restaurants) {
            int rating = restaurant.getRating();
            for (int[] range : ratingRanges) {
                if (rating >= range[0] && rating <= range[1]) {
                    String key = range[0] + "-" + range[1];
                    sumRatingsByRange.put(key, sumRatingsByRange.getOrDefault(key, 0) + rating);
                    break;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : sumRatingsByRange.entrySet()) {
            String key = entry.getKey();
            int sum = entry.getValue();
            int count = countByRange.getOrDefault(key, 0);
            averageRatingsByRange.put(key, count == 0 ? 0 : (double) sum / count);
        }

        return averageRatingsByRange;
    }
}