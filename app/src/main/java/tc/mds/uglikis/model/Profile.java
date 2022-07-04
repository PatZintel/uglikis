package tc.mds.uglikis.model;

public class Profile {
    private int id;
    private String username;
    private String tag;
    private int points;

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
}
