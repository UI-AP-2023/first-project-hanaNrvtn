package model.product;

import model.user.Customer;
import model.user.User;

public class Comment {
    private final User user;
    private String ID;  // ID or product
    private String text;
    private CommentStatus status;
    private boolean isBought;  //

    public Comment(User user, String ID, String text, boolean isBought) {
        this.user=user;
        this.ID = ID;
        this.text = text;
        this.status = CommentStatus.WAITING;
        this.isBought = isBought;   //
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

    public boolean getBought() {
        return isBought;
    }

    public void setBought(boolean isBought) {
        this.isBought = isBought;
    }

    @Override
    public String toString() {
        return "\nuser: " + user.getUserName() + "\nID: " + ID + "\nbought by user: " + isBought + "\nstatus: " + status.toString().toLowerCase() + "\ncomment: " + text;
    }
}
