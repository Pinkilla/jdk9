package pbt.trys.producerconsumer;

import java.util.concurrent.SubmissionPublisher;
import pbt.beautifulobject.Video;
import pbt.beautifulobject.Videos;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class Main {

    public static void main(String[] args) {
        SubmissionPublisher<Video> publisher = new SubmissionPublisher<>();        
        VideoSubscriber subscriber = new VideoSubscriber(1);        
        VideoSubscriber subscriber2 = new VideoSubscriber(2);        
        publisher.subscribe(subscriber);        
        publisher.subscribe(subscriber2);        
        
        //publisher.submit(Videos.getRandomVideo());
        //publisher.submit(Videos.getRandomVideo());
        Videos.getRandomVideos(12).stream()
                .forEach(v -> publisher.submit(v));

        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        publisher.close();
    }

}
