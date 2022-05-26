package co.com.sofka.katas;

import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

    private Kata5(){
        throw new IllegalStateException("Kata 5");
    }

    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<Movie> maxRating = movies.stream()
                .reduce((max, rating) -> {
                    if(max.getRating() < rating.getRating()){
                        max = rating;
                    }
                    return max;
                });

        return maxRating.map(Movie::getRating).orElse(null);

    }
}
