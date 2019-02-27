package testdemo.saicharan.myapplication.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import javax.inject.Inject;

import testdemo.saicharan.myapplication.Activitys.MainActivity;
import testdemo.saicharan.myapplication.Adapters.MostViewedArticleAdapter;
import testdemo.saicharan.myapplication.Models.Response;
import testdemo.saicharan.myapplication.MyApplication;
import testdemo.saicharan.myapplication.Network.NetworkError;
import testdemo.saicharan.myapplication.Network.Service;
import testdemo.saicharan.myapplication.R;
import testdemo.saicharan.myapplication.Utils.ProgressDialog;


/**
 * Created by sai on 27-02-2019.
 */

public class MostViewecArticlesFragment extends Fragment {

    @Inject
    Service service;
    private ProgressDialog progressDialog;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MyApplication myApplication;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* injecting dependency */
        myApplication = (MyApplication) getActivity().getApplication();
        (myApplication).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.showDialog();

        service.getBaseURL(new Service.ResponseCallback<Response>() {
            @Override
            public void onSuccess(Response response) {
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                mAdapter = new MostViewedArticleAdapter(response, (MainActivity) getActivity(), getFragmentManager());
                recyclerView.setAdapter(mAdapter);
                progressDialog.dismissDialog();
            }

            @Override
            public void onError(NetworkError networkError) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
