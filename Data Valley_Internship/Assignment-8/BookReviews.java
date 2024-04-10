import java.util.HashMap;
import java.util.Map;

class BookReview {
    String review;
    int rating;

    public BookReview(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }
}

public class BookReviews {

    public static void main(String[] args) {
        BookReview[] bookReviews = new BookReview[10];
        bookReviews[0] = new BookReview("Great book, highly recommend!", 5);
        bookReviews[1] = new BookReview("Very good, worth the read.", 4);
        bookReviews[2] = new BookReview("Not my cup of tea.", 2);
        bookReviews[3] = new BookReview("Meh, could have been better.", 3);
        bookReviews[4] = new BookReview("Worst book ever!", 1);
        bookReviews[5] = new BookReview("Loved it!", 5);
        bookReviews[6] = new BookReview("Very entertaining, highly recommend!", 5);
        bookReviews[7] = new BookReview("Very informative, worth the read.", 4);
        bookReviews[8] = new BookReview("Not as good as I expected.", 3);
        bookReviews[9] = new BookReview("Waste of time and money.", 1);

        Map<Integer, Integer> ratingCounts = new HashMap<>();
        Map<String, Integer> sentimentCounts = new HashMap<>();

        for (BookReview review : bookReviews) {
            if (!ratingCounts.containsKey(review.rating)) {
                ratingCounts.put(review.rating, 0);
            }
            ratingCounts.put(review.rating, ratingCounts.get(review.rating) + 1);

            if (review.rating >= 3) {
                sentimentCounts.put("positive", sentimentCounts.getOrDefault("positive", 0) + 1);
            } else if (review.rating == 3) {
                sentimentCounts.put("neutral", sentimentCounts.getOrDefault("neutral", 0) + 1);
            } else {
                sentimentCounts.put("negative", sentimentCounts.getOrDefault("negative", 0) + 1);
            }
        }

        System.out.println("Number of books reviewed within each rating range:");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%d-star ratings: %d%n", i, ratingCounts.get(i));
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        System.out.printf("Positive: %d%n", sentimentCounts.getOrDefault("positive", 0));
        System.out.printf("Neutral: %d%n", sentimentCounts.getOrDefault("neutral", 0));
        System.out.printf("Negative: %d%n", sentimentCounts.getOrDefault("negative", 0));
    }
}