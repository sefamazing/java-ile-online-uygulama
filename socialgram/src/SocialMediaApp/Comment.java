/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaApp;

/**
 *
 * @author Lenovo
 */
public class Comment {
    private String commentContent ;
    public Users owner ;
    private Post post;

    public Comment(String commentContent , Users owner ,Post post ){
        this.commentContent = commentContent;
        this.owner = owner ;
        this.post = post;
    }

    public String getCommentContent() {
        return this.commentContent;
    }
    public void makeComment(){
        post.addComment(this);
    }

   
}
