/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaApp;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Message {
    private String messageContent;
    private Date time;
    private boolean seen;
    private Users sender;
    private Users receiver;
    
    
    
    public Message(String messageContent,Users sender,Users receiver){
        this.messageContent= messageContent;
        this.sender = sender;
        this.receiver= receiver;
        time= new Date();
        this.seen = false;
    }
public boolean sendMessage(){
    return this.receiver.receiveMessage(this);
}    
public void setSeen(){
    this.seen=true;
    
}

public String getContent(){
    return this.messageContent;
}

}
