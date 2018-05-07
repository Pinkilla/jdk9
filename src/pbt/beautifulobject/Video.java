package pbt.beautifulobject;

import java.io.Serializable;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class Video implements Serializable{
    
    protected String author;
    protected String title;
    private boolean publish;
    private int nLikes;

    public Video(String author, String title) {
        this.author = author;
        this.title = title;
        this.publish = false;
        this.nLikes = 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public int getnLikes() {
        return nLikes;
    }

    public void setnLikes(int nLikes) {
        this.nLikes = nLikes;
    }
    
    public int like(){
        return ++this.nLikes;
    }
    
    public void publish(){
        this.publish = true;
    }
    
    public void unPublish(){
        this.publish = false;
    }
    
    @Override
    public String toString() {
        return "« " + title + " » from " + author + " (" + nLikes + ")";
    }
}
