package model.product;

import model.user.User;

public class Comment {
    private final User user;
    private String ID;  // ID or product
    private String text;
    private CommentStatus status;
    private boolean isBoughtByUser;  //

    public Comment(User user, String ID, String text, boolean isBoughtByUser) {
        this.user = user;
        this.ID = ID;
        this.text = text;
        this.status = CommentStatus.WAITING;
        this.isBoughtByUser = isBoughtByUser;   //
    }

    public User getUser() {
        return user;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    public boolean getBoughtByUser() {
        return isBoughtByUser;
    }

    public void setBoughtByUser(boolean isBoughtByUser) {
        this.isBoughtByUser = isBoughtByUser;
    }

    @Override
    public String toString() {
        return "\nuser: " + user.getUserName() + "\nID: " + ID + "\nbought by user: " + isBoughtByUser + "\nstatus: " + status.toString().toLowerCase() + "\ncomment: " + text;
    }
}
