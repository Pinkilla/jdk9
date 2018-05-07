package pbt.beautifulobject;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class Videos {

    private final static Random R = new Random();
    private final static Lorem L = LoremIpsum.getInstance();

    /**
     * Get videos with random name, title and nlikes. All videos are published.
     * Return 200 videos.
     *
     * @return videos
     */
    public static List<Video> getRandomVideos() {
        return getRandomVideos(R.nextInt(200));
    }

    /**
     * Get videos with random name, title and nlikes. All videos are published.
     *
     * @param n number of randoms videos
     * @return videos
     */
    public static List<Video> getRandomVideos(int n) {
        List<Video> videos = new ArrayList<>();
        /*
        Si je mets i++, il me retourne i++, c'est à dire la valeur de i avant 
        l'incrémentation c'est bien "return i++" et pas "i++". C'est une boucle
        infinie.
        Stream.iterate(0, i -> i<n, i -> i++)
         */
        Stream.iterate(0, i -> i < n, i -> ++i)
        //Stream.iterate(0, i -> i < n, i -> i + 1)
                .forEach(i -> videos.add(getRandomVideo()));
        return videos;
    }

    /**
     * Create one published video random title, name and nLikes.
     *
     * @return video
     */
    public static Video getRandomVideo() {
        Video video = new Video(L.getName(), L.getTitle(2, 6));
        video.setnLikes(R.nextInt(1000));
        video.publish();
        return video;
    }
}
