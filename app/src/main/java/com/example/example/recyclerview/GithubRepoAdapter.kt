package com.example.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.example.R;
import com.example.example.model.githubmodel.Repo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.ViewHolder> implements ItemTouchHelperListener {

    private Context context;
    private List<Repo> list;
    private AdapterCallback mAdapterCallback;

    public GithubRepoAdapter(Context context) {
        this.context = context;
    }

    public GithubRepoAdapter(Context context, List<Repo> list, AdapterCallback mAdapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = mAdapterCallback;
    }

    @NonNull
    @Override
    public GithubRepoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubRepoAdapter.ViewHolder holder, int position) {
        Repo item = list.get(position);

        String name = item.getName();
        String desc = item.getDescription();
        String profileUrl = item.getProfileUrl();

        holder.tvName.setText(name);
        holder.tvDesc.setText(desc);
        Glide.with(context).load(profileUrl).into(holder.ivProfile);

    }

    @Override
    public int getItemCount() {
        if (list != null && !list.isEmpty()) {
            return list.size();
        }
        return 0;
    }


    @Override
    public void onItemSwipe(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    //왼쪽 버튼 누르면 수정할 다이얼로그 띄우기
    @Override
    public void onLeftClick(int position, RecyclerView.ViewHolder viewHolder) {

    }


    //오른쪽 버튼 누르면 아이템 삭제
    @Override
    public void onRightClick(int position, RecyclerView.ViewHolder viewHolder) {
        Toast.makeText(context, "삭제 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_name)
        TextView tvName;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_description)
        TextView tvDesc;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.iv_profile)
        ImageView ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private interface AdapterCallback {
        void onRowClicked(int position);
    }


}
