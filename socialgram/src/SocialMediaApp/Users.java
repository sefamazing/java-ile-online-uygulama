/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaApp;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Users {
        private String name;
        private String username;
        private String birthday;
        private String password;
        private String phoneNumber;
        private String email;
        private char gender;
        private boolean isOnline;
        private int maxFollowerCount;
        private int followerIndex = 0;
        private int followedIndex = 0;
        private ArrayList<Users> followers = new ArrayList<Users>();
        private ArrayList<Users> followedPeople = new ArrayList<Users>();
        private int messageCount = 0;
        private ArrayList<Message> inbox = new ArrayList<Message>();
        private ArrayList<Post> posts = new ArrayList<>();
        private static ArrayList<Post> timelinePost = new ArrayList<>();
        
        public Users(String name, String username, String birthday, String password, String phoneNumber, String email, char gender,int maxFollowerCount){
            this.name= name;
            this.username= username;
            this.password= password;
            this.birthday= birthday;
            this.gender= gender;
            this.phoneNumber= phoneNumber;
            this.email= email;
            this.isOnline= true;
            this.maxFollowerCount= maxFollowerCount;
           
            writeAttributes();
        }
        //bütün data fielddeki bilgileri yazdırıcaz
        public void writeAttributes(){
         System.out.println("Name: " + this.name);
         System.out.println("User Name: " + this.username);
         System.out.println("Password: " + this.password);
         System.out.println("Birtday: " + this.birthday);
         System.out.println("Gender: " + this.gender);
         System.out.println("Phone Number: " + this.phoneNumber);
         System.out.println("Email: " + this.email);
         System.out.println("Is Online: " + this.isOnline);

}
        //objeler tarafından ulaşılması için
        public void setName(String name) {
            this.name = name;
}

        public void setUsername(String userName) {
            this.username = userName;
}

        public void setPassword(String password) {
            this.password = password;
}

        public void setBirthday(String birthday) {
            this.birthday = birthday;
}

        public void setGender(char gender) {
            this.gender = gender;
}
        
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
}

        public void setEmail(String email) {
            this.email = email;
}
        
        public void setIsOnline(boolean isOnline) {
            this.isOnline = isOnline;
}

        public String getName() {
            return name;
}

        public String getUserName() {
            return username;
}

        public String getPassword() {
            return password;
}

        public String getBirthday() {
            return birthday;
}
        
        public char getGender() {
            return gender;
}
 
        public String getPhoneNumber() {
            return phoneNumber;
}

        public String getEmail() {
            return email;
}

        public boolean getIsOnline() {
            return isOnline;
}
        
        //log in metodu yazıyoz
        public boolean login (String username, String passsword){
          if(username.equals(this.username)&& password.equals(this.password)){
              this.isOnline = true;
          }  
          else{
              this.isOnline = false;
          }
          return this.isOnline;
        }
        
        
        // kullanıcının takipçilerini tutma metodu
        
        public ArrayList<Users> getFollowers() {
        return this.followers;
    }

        public ArrayList<Users> getFollowedPeople() {
        return this.followedPeople;
    }
    
        public void follow (Users u){
            if(isOnline){
                this.followedIndex++;
                if(this.followedIndex < this.maxFollowerCount){
                    if(u.getFollowed(this)){
                        this.followedPeople.add(u);
                    
                    }
                    else{
                        this.followedIndex--;
                        System.out.println("error");

                    }
                }
                else{
                    System.out.println("error");
                }
            }
            else{
                System.out.println("please login for following...");
            }
        }
        
        
        public boolean getFollowed(Users u){
            this.followerIndex++;
             if(this.followerIndex < this.maxFollowerCount){
                    this.followers.add(u);
                    return true;
                    
                }
                else{
                    this.followerIndex--;
                    System.out.println("error");
             }
                    return false;
                
        }  
        
        public void sendMessage (String messageContent,Users receiver){
            Message m = new Message (messageContent,this,receiver);
            m.sendMessage();
        }
        public boolean receiveMessage(Message m){
            if(this.messageCount<100){
                this.inbox.add(m);
                this.messageCount++;
                return true;
            }
            else{
                return false;
            }
        }
        
        public void readMessage(int index){
            System.out.println(inbox.get(index).getContent());
            inbox.get(index).setSeen();
        }
        
        public ArrayList<Post> getPosts() {
            return this.posts;
        }
        
        
        
       
        
        public void addToProfile(Post p){
           this.posts.add(p);
           timelinePost.add(p);
        }
       
        
        
        public void profile(){
        for (int i = posts.size() -1; i >= 0 + 1; i--) {
            System.out.println(posts.get(i).getPostContent());
            System.out.println();
        }
    }
    
    public void timeLine(){
        for (int i = timelinePost.size() -1; i >= 0; i--) {
              if (followedPeople.contains(timelinePost.get(i).getUploader()) && !(timelinePost.get(i).getUploader() == this)){
                System.out.println(timelinePost.get(i).getPostContent());  
        }
    }
    }
}

