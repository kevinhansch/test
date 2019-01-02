package app.itdivision.lightbulb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import app.itdivision.lightbulb.CurrentCourse;
import app.itdivision.lightbulb.Model.Course;
import app.itdivision.lightbulb.R;

public class HomepageRecyclerViewAdapter extends RecyclerView.Adapter<HomepageRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Course> mData;

    public HomepageRecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_homepage,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_course_title.setText(mData.get(i).getCourseTitle());
        myViewHolder.tv_course_division.setText(mData.get(i).getCourseCategory());
        //myViewHolder.course_thumb.setImageResource(mData.get(i).getThumbnail());
        myViewHolder.btnGetCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CurrentCourse.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_course_title;
        TextView tv_course_division;
        //ImageView course_thumb;
        Button btnPrevCourse;
        Button btnGetCourse;


        public MyViewHolder(View itemView){
            super(itemView);
            tv_course_title = (TextView) itemView.findViewById(R.id.courseTitle);
            tv_course_division = (TextView) itemView.findViewById(R.id.courseDiv);
            //course_thumb = (ImageView) itemView.findViewById(R.id.courseImg);
            btnPrevCourse = (Button) itemView.findViewById(R.id.btnPreviewLesson);
            btnGetCourse = (Button) itemView.findViewById(R.id.btnGetCourse);
        }
    }

}
