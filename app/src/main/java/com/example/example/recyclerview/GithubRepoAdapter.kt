package com.example.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.databinding.ItemRepoBinding
import com.example.example.model.githubmodel.Repo

class GithubRepoAdapter : RecyclerView.Adapter<GithubRepoAdapter.ViewHolder>,
    ItemTouchHelperListener {
    private var context: Context
    private var list: List<Repo>? = null
    private var mAdapterCallback: AdapterCallback? = null

    constructor(context: Context) {
        this.context = context
    }

    constructor(context: Context, list: List<Repo>?, mAdapterCallback: AdapterCallback?) {
        this.context = context
        this.list = list
        this.mAdapterCallback = mAdapterCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(list!![position])
    }

    override fun getItemCount(): Int {
        return if (list != null && !list!!.isEmpty()) {
            list!!.size
        } else 0
    }

    override fun onItemSwipe(position: Int) {

    }


    //왼쪽 버튼 누르면 수정할 다이얼로그 띄우기
    override fun onLeftClick(position: Int, viewHolder: RecyclerView.ViewHolder?) {}

    //오른쪽 버튼 누르면 아이템 삭제
    override fun onRightClick(position: Int, viewHolder: RecyclerView.ViewHolder?) {
        Toast.makeText(context, "삭제 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show()
    }

    inner class ViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repoItem: Repo) {
            val name = repoItem.name
            val desc = repoItem.description
            val profileUrl = repoItem.profileUrl

            binding.tvName.text = name
            binding.tvDescription.text = desc
            Glide.with(context).load(profileUrl).into(binding.ivProfile)
        }
    }

    interface AdapterCallback {
        fun onRowClicked(position: Int)
    }
}