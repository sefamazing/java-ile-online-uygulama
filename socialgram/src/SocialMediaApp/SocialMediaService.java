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
public class SocialMediaService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // şimdi classın metodunu oluşturucaz
        Users user1 = new Users ("rahmet elibol", "yaralıkalp77", "1234556","12.01.2002","055555555","rahmet@gmail.com",'m', 10);
        System.out.println("");
        Users user2 = new Users ("filiz elibol", "mcisyeşili", "1234556","12.01.2002","055555555","filiz@gmail.com",'m', 100);
        System.out.println("");
      
        user1.login("yaralıkalp77","1234556");
        System.out.println(user1.getIsOnline());
        user2.login("mcisyeşili","1234556");
        System.out.println("");
        
          user1.follow(user2);
          user2.follow(user1);
        System.out.println("");
        
        user1.sendMessage("Ayakkabıların çok güzelmiş nerden aldın. Bana bi link sal.", user2);
        System.out.println("");
        user2.readMessage(0);
        System.out.println("");
        
        
        Post firstpost = new Post("post - 6", user1); 
        firstpost.upload();
        Post s = new Post("post  5 - second user", user2); 
        s.upload();
        System.out.println("");
        
        firstpost.like(user1);
        firstpost.like(user2);
        System.out.println("");

        user1.profile();
        System.out.println("");
        
        user1.timeLine();
    }
    
}
