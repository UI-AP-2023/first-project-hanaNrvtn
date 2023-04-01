package model.user;

import model.product.Comment;

public class CommentCheckRequest extends Request{
    private Comment comment;

    public CommentCheckRequest(Comment comment){
        super(RequestType.COMMENT_CHECK_REQUEST);
        this.comment=comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return comment.toString() + super.toString();
    }
}
