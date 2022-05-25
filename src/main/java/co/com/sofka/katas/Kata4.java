package co.com.sofka.katas;

import co.com.sofka.model.BoxArt;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    private Kata4(){
        throw new IllegalStateException("Kata 4");
    }

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().map(MovieList::getVideos)
                                    .flatMap(Collection::stream)
                                    .map(p -> Map.of("id", p.getId(), "title", p.getTitle(), "boxart",
                                            new BoxArt(150, 200,
                                                    p.getBoxarts().stream().map(BoxArt::getUrl).toString())))
                                    .collect(Collectors.toList());
    }
}
