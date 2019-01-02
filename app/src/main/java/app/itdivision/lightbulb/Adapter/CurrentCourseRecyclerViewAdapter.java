package app.itdivision.lightbulb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import app.itdivision.lightbulb.CurrentLesson;
import app.itdivision.lightbulb.Model.Lesson;
import app.itdivision.lightbulb.R;

public class CurrentCourseRecyclerViewAdapter extends RecyclerView.Adapter<CurrentCourseRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Lesson> mData;

    public CurrentCourseRecyclerViewAdapter(Context mContext, List<Lesson> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public CurrentCourseRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_current_lesson, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentCourseRecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_lesson_name.setText(mData.get(i).getLessonName());
        myViewHolder.tv_lesson_desc.setText(mData.get(i).getLessonDescription());
        myViewHolder.cardLessonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CurrentLesson.class);
                mContext.startActivity(intent);
            }
        });
        myViewHolder.btn_lesson_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CurrentLesson.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_lesson_name;
        TextView tv_lesson_desc;
        CardView cardLessonItem;
        ImageButton btn_lesson_detail;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_lesson_name = (TextView) itemView.findViewById(R.id.tv_lesson_name);
            tv_lesson_desc = (TextView) itemView.findViewById(R.id.tv_lesson_desc);
            cardLessonItem = (CardView) itemView.findViewById(R.id.cardLessonItem);
            btn_lesson_detail = (ImageButton) itemView.findViewById(R.id.btn_lesson_detail);
        }
    }
}
