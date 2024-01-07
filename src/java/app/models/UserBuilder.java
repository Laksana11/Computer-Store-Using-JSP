/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author navar
 */
public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder withUserId(int userId) {
        user.setUserId(userId);
        return this;
    }
    
    public UserBuilder withUsername(String username) {
        user.setUsername(username);
        return this;
    }
    
    public UserBuilder withRole(String role) {
        user.setRole(role);
        return this;
    }


    public UserBuilder withEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder withPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public User build() {
        return user;
    }
}
