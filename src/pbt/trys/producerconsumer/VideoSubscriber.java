package pbt.trys.producerconsumer;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import pbt.beautifulobject.Video;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class VideoSubscriber implements Subscriber<Video> {

    private Subscription subscription;
    private int id;

    public VideoSubscriber(int id) {
        this.id = id;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Video v) {
        System.out.println("I " + id + " publish " + v.getTitle()
                + " from " + v.getAuthor());
        v.publish();
        subscription.request(1);
    }

    @Override
    public void onError(Throwable arg0) {
        System.err.printf("Error (%s)\n", arg0.getMessage());
        System.exit(1);
    }

    @Override
    public void onComplete() {
        System.out.printf("Done\n");
    }

}
