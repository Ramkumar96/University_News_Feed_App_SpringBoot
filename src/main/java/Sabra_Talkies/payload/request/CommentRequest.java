package Sabra_Talkies.payload.request;


public class CommentRequest {

    private String commentContent;
    private Long commentedPostId;
    private String commentedUserId;
    private String commentedFirstName;


    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Long getCommentedPostId() {
        return commentedPostId;
    }

    public void setCommentedPostId(Long commentedPostId) {
        this.commentedPostId = commentedPostId;
    }

    public String getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(String commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public String getCommentedFirstName() {
        return commentedFirstName;
    }

    public void setCommentedFirstName(String commentedFirstName) {
        this.commentedFirstName = commentedFirstName;
    }
}
