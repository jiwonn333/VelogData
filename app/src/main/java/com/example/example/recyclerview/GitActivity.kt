package com.example.example.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.example.R
import com.example.example.api.GithubApiService
import com.example.example.databinding.ActivityGitBinding
import com.example.example.model.githubmodel.GithubResponse
import com.example.example.model.githubmodel.Repo
import com.example.example.retrofit.RetrofitApiManager.githubBuild
import com.example.example.util.AppUtil.showToast
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.IOError

class GitActivity : AppCompatActivity() {
    @JvmField
    var repoList: MutableList<Repo>? = null
    private var mGithubApiService: GithubApiService? = null
    private var binding: ActivityGitBinding? = null
    private var mGithubRepoAdapter: GithubRepoAdapter? = null
    private var helper: ItemTouchHelper? = null
    var context: Context? = null


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGitBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        context = this

//        setRecyclerView();
//        setItemTouchHelper();
//        setUpRecyclerView();


        initRecyclerView()

        mGithubApiService = githubBuild()!!.create(
            GithubApiService::class.java
        )

        // et 입력시
        binding!!.etUsername.setOnEditorActionListener { textView: TextView?, actionId: Int, keyEvent: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val username = binding!!.etUsername.text.toString()
                requestRepos(username)
                return@setOnEditorActionListener true
            }
            false
        }
        setUpRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        binding?.rvRepos?.layoutManager = manager
        mGithubRepoAdapter = GithubRepoAdapter(this)
        binding?.rvRepos?.adapter = mGithubRepoAdapter

        initItemTouchHelper()
    }


    private fun initItemTouchHelper() {
        //ItemTouchHelper 생성
        helper = ItemTouchHelper(ItemTouchHelperCallback(mGithubRepoAdapter))
        //RecyclerView에 ItemTouchHelper 붙이기
        helper!!.attachToRecyclerView(binding?.rvRepos)
    }


    private fun setUpRecyclerView() {
        binding?.rvRepos?.addItemDecoration(object : ItemDecoration() {
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                helper!!.onDraw(c, parent, state)
            }
        })
    }

    private fun requestRepos(username: String) {
        binding!!.pbLoading.visibility = View.VISIBLE
        binding?.rvRepos?.visibility = View.GONE
        repoList = ArrayList()
        mGithubApiService!!.getGithubData(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<GithubResponse>> {
                override fun onSubscribe(d: Disposable) {}

                @SuppressLint("NotifyDataSetChanged")
                override fun onSuccess(githubResponses: List<GithubResponse>) {
                    for (i in githubResponses.indices) {
                        val name = githubResponses[i].fullName.toString()
                        var description = githubResponses[i].description.toString()
                        var url = githubResponses[i].owner?.avatarUrl.toString()
                        if (description == null) {
                            description = getString(R.string.description_is_null)
                        }
                        if (url == null) {
                            url = R.drawable.baseline_android_24.toString()
                        }

                        (repoList as ArrayList<Repo>).add(Repo(name, description, url))
                    }

                    binding!!.pbLoading.visibility = View.GONE
                    binding?.rvRepos?.visibility = View.VISIBLE

                    if (repoList != null && (repoList as ArrayList<Repo>).isNotEmpty()) {
                        showToast(context, "데이터를 성공적으로 가져왔습니다!")
                        mGithubRepoAdapter = GithubRepoAdapter(this@GitActivity, repoList, null)
                        binding?.rvRepos?.adapter = mGithubRepoAdapter
                        mGithubRepoAdapter!!.notifyDataSetChanged()
                    } else {
                        binding!!.pbLoading.visibility = View.GONE
                        binding?.rvRepos?.visibility = View.GONE
                        showToast(context, "찾으시는 데이터가 없습니다.")
                    }
                }

                override fun onError(e: Throwable) {
                    binding?.rvRepos?.visibility = View.GONE
                    Log.e("test", e.message!!)
                    e.printStackTrace()
                    if (e.cause == IOError::class.java || e.cause == null) {
                        showToast(context, "데이터 찾기 실패.")
                    }
                }
            })
    }
}