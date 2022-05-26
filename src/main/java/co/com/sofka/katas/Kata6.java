package co.com.sofka.katas;

import co.com.sofka.model.BoxArt;
import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    private Kata6(){
        throw new IllegalStateException("Kata 6");
    }

    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<BoxArt> largestBoxArt = movies.stream()
                                            .map(Movie::getBoxarts)
                                            .flatMap(Collection::stream)
                                            .reduce((largest, boxArt) -> {
                                                Integer largestLarge = largest.getHeight() * largest.getWidth();
                                                Integer boxArtLarge = boxArt.getHeight() * boxArt.getWidth();

                                                if(Boolean.TRUE.equals(lowerThan(largestLarge, boxArtLarge))){
                                                    largest = boxArt;
                                                }
                                                return largest;
                                            });
        return largestBoxArt.map(BoxArt::getUrl).orElse(null);
    }

    public static Boolean lowerThan(Integer num1, Integer num2){
        return num1 < num2;
    }
}
