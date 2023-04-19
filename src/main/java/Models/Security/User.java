package Models.Security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
@Id
    private String userName;

    private String password;

    private boolean enabled = true;

    private String apiKey;

    private String email;

/*
Hier komt nog de realtie van user naar role

 */

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
