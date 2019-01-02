package app.itdivision.lightbulb.Model;

public class Lesson {
    private String lessonName;
    private String courseName;
    private String url;
    private String lessonDescription;

    public Lesson(String lessonName, String courseName, String lessonDescription) {
        this.lessonName = lessonName;
        this.courseName = courseName;
        this.lessonDescription = lessonDescription;
    }

    public Lesson(String lessonName, String courseName, String url, String lessonDescription) {
        this.lessonName = lessonName;
        this.courseName = courseName;
        this.url = url;
        this.lessonDescription = lessonDescription;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }
}
