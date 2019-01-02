package app.itdivision.lightbulb.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import app.itdivision.lightbulb.Model.MyCourse;
import app.itdivision.lightbulb.R;

public class MyCoursesRecyclerViewAdapter extends RecyclerView.Adapter<MyCoursesRecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<MyCourse> mData;

    public MyCoursesRecyclerViewAdapter(Context mContext, List<MyCourse> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_my_courses, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_course_title.setText(mData.get(i).getCourseName());
        myViewHolder.tv_course_division.setText(mData.get(i).getCourseCategory());
        if(mData.get(i).isCompleted()){
            myViewHolder.tv_completion_status.setText("COMPLETED");
        }else {
            myViewHolder.tv_completion_status.setText("ON GOING");
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_course_title;
        TextView tv_course_division;
        //ImageView course_thumb;
        TextView tv_completion_status;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_course_title = (TextView) itemView.findViewById(R.id.courseTitle);
            tv_course_division = (TextView) itemView.findViewById(R.id.courseDiv);
            //course_thumb = (ImageView) itemView.findViewById(R.id.courseImg);
            tv_completion_status = (TextView) itemView.findViewById(R.id.tv_completion_status);
        }
    }
}
