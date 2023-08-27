package com.example.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example.R;
import com.example.example.api.GithubApiService;
import com.example.example.databinding.ActivityGitBinding;
import com.example.example.model.githubmodel.GithubResponse;
import com.example.example.model.githubmodel.Repo;
import com.example.example.retrofit.RetrofitApiManager;
import com.example.example.util.AppUtil;

import java.io.IOError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GitActivity extends AppCompatActivity {
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @BindView(R.id.rv_repos)
    RecyclerView recyclerView;

    @BindView(R.id.et_username)
    EditText etUsername;

    List<Repo> repoList;
    GithubApiService mGithubApiService;
    GithubRepoAdapter mGithubRepoAdapter;
    Context context;
    ActivityGitBinding binding;
    ItemTouchHelper helper;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ButterKnife.bind(this);
        context = this;

//        setRecyclerView();
//        setItemTouchHelper();
//        setUpRecyclerView();

        test();


        mGithubApiService = RetrofitApiManager.githubBuild().create(GithubApiService.class);

        // et 입력시
        etUsername.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                String username = etUsername.getText().toString();
                requestRepos(username);
                return true;
            }
            return false;
        });

        setUpRecyclerView();
    }

    private void test() {

        recyclerView = findViewById(R.id.rv_repos);
        //RecyclerView의 레이아웃 방식을 지정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        //RecyclerView의 Adapter 세팅
        mGithubRepoAdapter = new GithubRepoAdapter(this);
        recyclerView.setAdapter(mGithubRepoAdapter);

        //ItemTouchHelper 생성
        helper = new ItemTouchHelper(new ItemTouchHelperCallback(mGithubRepoAdapter));
        //RecyclerView에 ItemTouchHelper 붙이기
        helper.attachToRecyclerView(recyclerView);


    }


    private void setRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        mGithubRepoAdapter = new GithubRepoAdapter(context);
        recyclerView.setAdapter(mGithubRepoAdapter);
    }

    private void setUpRecyclerView() {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                helper.onDraw(c, parent, state);
            }
        });
    }

    private void requestRepos(String username) {
        pbLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        repoList = new ArrayList<>();

        mGithubApiService.getGithubData(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<GithubResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<GithubResponse> githubResponses) {
                        for (int i = 0; i < githubResponses.size(); i++) {
                            String name = githubResponses.get(i).getFullName();
                            String description = githubResponses.get(i).getDescription();
                            String url = githubResponses.get(i).getOwner().getAvatarUrl();
                            if (description == null) {
                                description = getString(R.string.description_is_null);
                            }
                            if (url == null) {
                                url = String.valueOf(R.drawable.baseline_android_24);
                            }
                            repoList.add(new Repo(name, description, url));

                        }
                        pbLoading.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        if (repoList != null && !repoList.isEmpty()) {
                            AppUtil.showToast(context, "데이터를 성공적으로 가져왔습니다!");
                            mGithubRepoAdapter = new GithubRepoAdapter(context, repoList, null);
                            recyclerView.setAdapter(mGithubRepoAdapter);
                            mGithubRepoAdapter.notifyDataSetChanged();
                        } else {
                            recyclerView.setVisibility(View.GONE);
                            AppUtil.showToast(context, "찾으시는 데이터가 없습니다.");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        pbLoading.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        AppUtil.showToast(context, "찾으시는 데이터가 없습니다.");
                        Log.e("test", e.getMessage());
                        e.printStackTrace();

                        if (Objects.equals(e.getCause(), IOError.class) || e.getCause() == null) {
                            AppUtil.showToast(context, "데이터 찾기 실패.");
                        }
                    }
                });

    }


}
