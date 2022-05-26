package co.com.sofka.katas;

import co.com.sofka.model.BoxArt;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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

        return  movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(m -> Map.of("id", m.getId(), "title", m.getTitle(), "url",
                        m.getBoxarts().stream()
                                .reduce((box1, box2) -> Boolean.TRUE.equals(lowerThan(box1.getWidth() * box1.getHeight(),
                                box2.getHeight() * box2.getWidth())) ? box1 : box2)
                                .map(BoxArt::getUrl)))
                .collect(Collectors.toList());
    }

    public static Boolean lowerThan(Integer num1, Integer num2){
        return num1 < num2;
    }
}
