package tc.mds.uglikis.model;

public class Profile {

    private String authUserId;
    private String username;
    private String tag;
    private int points;

    public Profile (){

    }

    public Profile(String username, String tag){
        points = 0;
        this.username = username;
        this.tag = tag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public int addPoints(int add){
        points += add;
        return points;
    }

}
