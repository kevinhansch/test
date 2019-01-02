package app.itdivision.lightbulb.Model;

public class User {
    private String userName;
    private String password;
    private String reward;
    private String dateJoined;
    private String email;

    public User(String userName, String password, String reward, String dateJoined, String email) {
        this.userName = userName;
        this.password = password;
        this.reward = reward;
        this.dateJoined = dateJoined;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
