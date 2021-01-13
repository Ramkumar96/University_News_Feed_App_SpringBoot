package Sabra_Talkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(	name = "post_comment")
public class CommentDB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String commentId;

    private String commentContent;

    private String commentedPostId;

    private String commentedUserId;

    private String commentedFirstName;

    public CommentDB() {
    }

    public CommentDB(String commentContent, String commentedPostId, String commentedUserId, String commentedFirstName) {
        this.commentContent = commentContent;
        this.commentedPostId = commentedPostId;
        this.commentedUserId = commentedUserId;
        this.commentedFirstName = commentedFirstName;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentedPostId() {
        return commentedPostId;
    }

    public void setCommentedPostId(String commentedPostId) {
        this.commentedPostId = commentedPostId;
    }

    public String getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(String commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public String getCommentedFirstName() { return commentedFirstName; }

    public void setCommentedFirstName(String commentedFirstName) { this.commentedFirstName = commentedFirstName; }
}
