package cn.ccttll.main.entity;

public class Comment {
    private int movieId;
    private String userName;
    private String comment;
    private String commentDataTime;
    private String userPhoto=null;

    public Comment(){};

    public Comment(int movieId, String userName, String comment, String commentDataTime, String userPhoto) {
        this.movieId = movieId;
        this.userName = userName;
        this.comment = comment;
        this.commentDataTime = commentDataTime;
        this.userPhoto = userPhoto;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDataTime() {
        return commentDataTime;
    }

    public void setCommentDataTime(String commentDataTime) {
        this.commentDataTime = commentDataTime;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
