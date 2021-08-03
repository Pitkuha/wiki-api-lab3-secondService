package app.model;

import javax.persistence.*;

@Entity
@Table(name = "ArticleLikes")
public class ArticleLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private long articleID;
    private long likesCount;

    public ArticleLikes(long ID, long articleID, long likesCount) {
        this.ID = ID;
        this.articleID = articleID;
        this.likesCount = likesCount;
    }

    public ArticleLikes() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getArticleID() {
        return articleID;
    }

    public void setArticleID(long articleID) {
        this.articleID = articleID;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }
}
