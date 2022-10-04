package Google;

public class Child {

    private String childName;
    private String childBDay;

    public Child(String childName, String childBDay) {
        this.childName = childName;
        this.childBDay = childBDay;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildBDay() {
        return childBDay;
    }

    public void setChildBDay(String childBDay) {
        this.childBDay = childBDay;
    }

    @Override
    public String toString() {
        return this.childName + " " + this.childBDay;
    }
}
