/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaApp;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Post {
    private String postContent;
    private Date time;
    private Users uploader;
    private ArrayList<Users> like = new ArrayList<>();
    private ArrayList<Comment> coms = new ArrayList<>();
    
    //constructor
    public Post(String postContent, Users uploader){
        this.postContent= postContent;
        time= new Date ();
        this.uploader=uploader;
    }
    //like sayısını tutma metodu
    public void like (Users u){
         like.add(u);
        }   
    
    public void upload(){
        this.uploader.addToProfile(this);
    }
    public String getPostContent(){
        return this.postContent;
    }
   public void getUser() {
        for (int i = 0; i < this.like.size(); i++) {
            like.get(i).writeAttributes();
            System.out.println();
        }
    }

    public Users getUploader() {
        return uploader;
    }


    public void addComment(Comment c) {
        coms.add(c);
    }

    public void writeAllComment() {
        for (int i = 0; i < coms.size(); i++) {
            System.out.println(coms.get(i).getCommentContent());
        }
    }

}
