package pbt.trys;

import java.util.Optional;
import pbt.beautifulobject.Video;
import pbt.beautifulobject.Videos;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class OptionalTests {

    public static void main(String[] args) {
        //Optional<Video> ov = Optional.ofNullable(Videos.getRandomVideo());

        /*
        if factory fail, create new video
         */
        Optional<Video> ov = Optional
                .of(Videos.getRandomVideo())
                .or(() -> Optional.of(
                new Video("Beautiful Author", "My beautyful video")));

        ov.or(() -> Optional.of(
                new Video("Beautiful Author", "My beautyful video")));

        ov.ifPresent(v -> v.like());
    }

}
