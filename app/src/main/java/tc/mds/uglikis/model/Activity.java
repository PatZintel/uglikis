package tc.mds.uglikis.model;

public class Activity {

    private int id;
    private ActivityType type;
    private String name;
    private String description;
    private int rewardRate;

    public Activity(int id, ActivityType type, String name, String description, int rewardRate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.rewardRate = rewardRate;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRewardRate() {
        String unitRate = "";
        switch (type) {
            case Mobility:
                unitRate = "UCs/km";
                break;
            case Waste:
                unitRate = "UCs/item";
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