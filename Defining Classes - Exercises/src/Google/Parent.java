package Google;

public class Parent {


    private String parentName;
    private String parentBDay;


    public Parent(String parentName, String parentBDay) {
        this.parentName = parentName;
        this.parentBDay = parentBDay;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentBDay() {
        return parentBDay;
    }

    public void setParentBDay(String parentBDay) {
        this.parentBDay = parentBDay;
    }

    @Override
    public String toString() {
        return this.parentName + " " + this.parentBDay;
    }
}
