package co.com.sofka.katas;

import co.com.sofka.model.BoxArt;
import co.com.sofka.model.Movie;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

    private Kata7(){
        throw new IllegalStateException("Kata 7");
    }

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        Optional<BoxArt> smallestBoxArt = movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(Movie::getBoxarts)
                .flatMap(Collection::stream)
                .reduce((smallest, boxArt) -> {
                    Integer smallestLarge = smallest.getHeight() * smallest.getWidth();
                    Integer boxArtLarge = boxArt.getHeight() * boxArt.getWidth();

                    if(Boolean.TRUE.equals(greaterThan(smallestLarge, boxArtLarge))){
                        smallest = boxArt;
                    }
                    return smallest;
                });

        return movieLists.stream()
                            .map(MovieList::getVideos)
                            .flatMap(Collection::stream)
                            .filter(m -> m.getBoxarts().equals(smallestBoxArt.get()))
                            .map(m -> Map.of("id", m.getId(), "title", m.getTitle(), "boxart", smallestBoxArt.get().getUrl()))
                            .collect(Collectors.toUnmodifiableList());
    }

    public static Boolean greaterThan(Integer num1, Integer num2){
        return num1 < num2;
    }
}
