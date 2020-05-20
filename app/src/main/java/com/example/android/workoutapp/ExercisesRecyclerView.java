package com.example.android.workoutapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
//This class makes the recycler view
public class ExercisesRecyclerView extends RecyclerView.Adapter<ExercisesRecyclerView.ViewHolder> {
    private String tag= "Exercises Recycler View";
    private OnItemListerner mOnItemListerner;

    private ArrayList<String>mExerciseName=new ArrayList<>();
    private ArrayList<String>mExerciseIcons=new ArrayList<>();
    private Context mContext;

    public ExercisesRecyclerView(Context mcontext, ArrayList<String>mExerciseName, ArrayList<String>mExerciseIcons, OnItemListerner mOnItemListerner){
        this.mContext=mcontext;
        this.mExerciseName=mExerciseName;
        this.mExerciseIcons=mExerciseIcons;
        this.mOnItemListerner = mOnItemListerner;
    }

    @NonNull
    @Override
    //Not super important same for any recyclerView
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_layouts, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnItemListerner);
        return viewHolder;
    }
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mExerciseIcons.get(position))
                .into(viewHolder.exerciseIcon);
        viewHolder.exerciseName.setText(mExerciseName.get(position));
    }

    @Override
    public int getItemCount() {
        return mExerciseName.size();
    }
    //The view holder holds the widgets the in memory so it can recycle it
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CircleImageView exerciseIcon;
        TextView exerciseName;
        RelativeLayout relativeLayout;
        OnItemListerner onItemListerner;
        public ViewHolder(@NonNull View itemView, OnItemListerner onItemListerner) {
            super(itemView);
            this.exerciseIcon = itemView.findViewById(R.id.Exercise_Image);
            this.exerciseName = itemView.findViewById(R.id.Exercise_Name);
            this.relativeLayout = itemView.findViewById(R.id.RelativeLayout);
            this.onItemListerner=onItemListerner;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            onItemListerner.onClick(getAdapterPosition());

        }
    }
    public interface OnItemListerner{
        void onClick(int position);
    }

}
