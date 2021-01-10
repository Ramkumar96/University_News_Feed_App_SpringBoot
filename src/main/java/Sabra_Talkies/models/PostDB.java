package Sabra_Talkies.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "post")
public class PostDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    private String userMail;

    private String userId;

    private String firstname;

    private String postTitle;

    private String content;

    private String createdOn;

    private Boolean PostDeletedByUser;

    private Boolean PostAcceptedByAdmin;

    private Boolean PostDeletedByAdmin;

    public PostDB() {
    }

    public PostDB(String name, String type, byte[] data, String userMail,
                  String userId, String firstname, String postTitle, String content,
                  String createdOn, Boolean postDeletedByUser, Boolean postAcceptedByAdmin,
                  Boolean postDeletedByAdmin) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.userMail = userMail;
        this.userId = userId;
        this.firstname = firstname;
        this.postTitle = postTitle;
        this.content = content;
        this.createdOn = createdOn;
        this.PostDeletedByUser = postDeletedByUser;
        this.PostAcceptedByAdmin = postAcceptedByAdmin;
        this.PostDeletedByAdmin = postDeletedByAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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