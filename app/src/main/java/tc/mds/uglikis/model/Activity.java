package tc.mds.uglikis.model;

public class Activity {

    private int id;
    private ActivityType type;
    private String name;
    private String description;
    private int rewardRate;
    private boolean ongoing;

    public Activity(){

    }

    public Activity(int id, ActivityType type, String name, String description, int rewardRate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.rewardRate = rewardRate;
        this.ongoing = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setOngoing(boolean newState) {
        this.ongoing = newState;
    }
    public boolean getOngoing() {
        return this.ongoing;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRewardRate(){
        return rewardRate;
    }

    public String rewardRateString() {
        String unitRate = "";
        switch (type) {
            case Mobility:
                unitRate = "UCs/km";
                break;
            case Waste:
                unitRate = "UCs/kilo";
                break;
            case Nutrition:
                unitRate = "UCs/meal";
                break;
        }
        return String.valueOf(rewardRate) + unitRate;
    }

    public void setRewardRate(int rewardRate) {
        this.rewardRate = rewardRate;
    }
}
