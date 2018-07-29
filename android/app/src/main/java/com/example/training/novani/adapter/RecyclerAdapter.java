package com.example.training.novani.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.training.novani.R;
import com.example.training.novani.data.Child;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {

    private ArrayList<Child> mList=new ArrayList<>();
    private Context mContext;
    private AdapterInterface mInterface;



    public interface AdapterInterface{
        void handleClicks(String status);
    }

    public RecyclerAdapter(ArrayList<Child> mList,Context context,AdapterInterface callback) {
        this.mInterface=callback;
        this.mList = mList;
        mContext=context;
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.recycler_content;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);

        return new RecyclerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterViewHolder holder, int position) {
        holder.nameTv.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.name)
        TextView nameTv;
        @BindView(R.id.status)
        TextView statusTv;
        public RecyclerAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mInterface.handleClicks(mList.get(getAdapterPosition()).getName());
        }
    }
}
