package com.example.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example.R;
import com.example.example.model.githubmodel.Repo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.ViewHolder> {

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

        holder.tvName.setText(name);
        holder.tvDesc.setText(desc);

    }

    @Override
    public int getItemCount() {
        if (list != null && !list.isEmpty()) {
            return list.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_description)
        TextView tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private interface AdapterCallback {
        void onRowClicked(int position);
    }


}
