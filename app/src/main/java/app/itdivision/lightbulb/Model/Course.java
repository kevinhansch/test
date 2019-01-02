package app.itdivision.lightbulb.Model;

public class Course {
    private String courseTitle;
    private String courseCategory;
    private float coursePrice;
    private int thumbnail;

    public Course(String courseTitle, String courseCategory, float coursePrice) {
        this.courseTitle = courseTitle;
        this.courseCategory = courseCategory;
        this.coursePrice = coursePrice;
    }

    public Course(String courseTitle, String courseCategory, float coursePrice, int thumbnail) {
        this.courseTitle = courseTitle;
        this.courseCategory = courseCategory;
        this.coursePrice = coursePrice;
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public float getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(float coursePrice) {
        this.coursePrice = coursePrice;
    }
}
