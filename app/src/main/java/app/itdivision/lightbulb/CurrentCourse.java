package app.itdivision.lightbulb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import app.itdivision.lightbulb.Adapter.CurrentCourseRecyclerViewAdapter;
import app.itdivision.lightbulb.Model.Lesson;

public class CurrentCourse extends AppCompatActivity {

    ImageView imgViewCurrentCourse;
    TextView tv_course_name;
    TextView tv_course_category;
    TextView tv_course_creator;
    TextView tv_course_releasedate;
    TextView tv_course_rating;
    TextView tv_course_description;
    RecyclerView recyclerCurrentLesson;
    Button btn_get_this_course;

    List<Lesson> lessonList;
    boolean isBought = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_course);

        imgViewCurrentCourse = (ImageView) findViewById(R.id.imgViewCurrent_course);
        tv_course_name = (TextView) findViewById(R.id.tv_course_name);
        tv_course_category = (TextView) findViewById(R.id.tv_course_category);
        tv_course_creator = (TextView) findViewById(R.id.tv_course_creator);
        tv_course_releasedate = (TextView) findViewById(R.id.tv_course_releasedate);
        tv_course_rating = (TextView)findViewById(R.id.tv_course_rating);
        tv_course_description = (TextView) findViewById(R.id.course_description);
        recyclerCurrentLesson = (RecyclerView) findViewById(R.id.recyclerCurrentLesson);
        btn_get_this_course = (Button) findViewById(R.id.btn_get_this_course);

        lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Lesson 1", "Build Android with Java", "How to Install"));
        lessonList.add(new Lesson("Lesson 2", "Build Android with Java", "Intro to Android Studio"));
        lessonList.add(new Lesson("Lesson 3", "Build Android with Java", "Run Emulator"));
        lessonList.add(new Lesson("Lesson 4", "Build Android with Java", "Workspace"));
        lessonList.add(new Lesson("Lesson 5", "Build Android with Java", "Create Project"));
        lessonList.add(new Lesson("Lesson 6", "Build Android with Java", "View and ViewGroups"));
        lessonList.add(new Lesson("Lesson 7", "Build Android with Java", "LinearLayout"));
        lessonList.add(new Lesson("Lesson 8", "Build Android with Java", "Buttons, Checkbox"));
        lessonList.add(new Lesson("Lesson 9", "Build Android with Java", "Spinners"));
        lessonList.add(new Lesson("Lesson 10", "Build Android with Java", "Navigation Drawer"));


        CurrentCourseRecyclerViewAdapter adapter = new CurrentCourseRecyclerViewAdapter(this, lessonList);
        recyclerCurrentLesson.setLayoutManager(new LinearLayoutManager(this));
        recyclerCurrentLesson.setAdapter(adapter);

        //isBought = true;

        if(isBought){
            btn_get_this_course.setVisibility(View.GONE);
        }else{
            btn_get_this_course.setVisibility(View.VISIBLE);
            btn_get_this_course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CurrentCourse.this, CurrentCoursePayment.class);
                    startActivity(intent);
                }
            });
        }




    }
}
