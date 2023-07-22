package com.example.firstproj02.model.processes;

public class CommentCheckRequest extends Request {
    private Comment comment;

    public CommentCheckRequest(Comment comment) {
        super(RequestType.COMMENT_CHECK_REQUEST);
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String toString1() {
        return super.toString() + "\n# username:   " + comment.getUser().getUserName() + "\n# comment text:\n" + comment.getText();
    }

    @Override
    public String toString() {
        return "COM  ||  " + comment.getUser().getUserName();
    }
}
