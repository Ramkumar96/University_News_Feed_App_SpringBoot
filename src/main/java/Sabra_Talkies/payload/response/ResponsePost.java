package Sabra_Talkies.payload.response;

public class ResponsePost {
    private String name;
    private String url;
    private String type;
    private long size;
    private String id;
    private String userMail;
    private String userId;
    private String firstname;
    private String postTitle;
    private String content;
    private String createdOn;
    private Boolean PostDeletedByUser;
    private Boolean PostAcceptedByAdmin;
    private Boolean PostDeletedByAdmin;

    public ResponsePost(String name, String url, String type, long size,
                        String id, String userMail, String userId, String firstname,
                        String postTitle, String content, String createdOn,
                        Boolean postDeletedByUser, Boolean postAcceptedByAdmin,
                        Boolean postDeletedByAdmin) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.id = id;
        this.userMail = userMail;
        this.userId = userId;
        this.firstname = firstname;
        this.postTitle = postTitle;
        this.content = content;
        this.createdOn = createdOn;
        PostDeletedByUser = postDeletedByUser;
        PostAcceptedByAdmin = postAcceptedByAdmin;
        PostDeletedByAdmin = postDeletedByAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getPostDeletedByUser() {
        return PostDeletedByUser;
    }

    public void setPostDeletedByUser(Boolean postDeletedByUser) {
        PostDeletedByUser = postDeletedByUser;
    }

    public Boolean getPostAcceptedByAdmin() {
        return PostAcceptedByAdmin;
    }

    public void setPostAcceptedByAdmin(Boolean postAcceptedByAdmin) {
        PostAcceptedByAdmin = postAcceptedByAdmin;
    }

    public Boolean getPostDeletedByAdmin() {
        return PostDeletedByAdmin;
    }

    public void setPostDeletedByAdmin(Boolean postDeletedByAdmin) {
        PostDeletedByAdmin = postDeletedByAdmin;
    }
}
