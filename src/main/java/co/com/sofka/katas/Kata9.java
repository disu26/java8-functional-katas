package co.com.sofka.katas;

import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    private Kata9(){
        throw new IllegalStateException("Kata 9");
    }

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return  movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(m -> Map.of("id", m.getId(), "title", m.getTitle(),  "time",
                        m.getInterestingMoments().stream().filter(t -> t.getType().equals("Middle")),"url",
                        m.getBoxarts().stream()
                                .reduce((box1, box2) -> Boolean.TRUE.equals(lowerThan(box1.getWidth() * box1.getHeight(),
                                box2.getHeight() * box2.getWidth())) ? box1 : box2).get().getUrl()))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Boolean lowerThan(Integer num1, Integer num2){
        return num1 < num2;
    }
}
