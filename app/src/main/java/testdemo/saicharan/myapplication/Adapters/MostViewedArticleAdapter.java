package testdemo.saicharan.myapplication.Adapters;

import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import testdemo.saicharan.myapplication.Activitys.MainActivity;
import testdemo.saicharan.myapplication.Fragments.MostViewedArticleDetailFragment;
import testdemo.saicharan.myapplication.Models.Response;
import testdemo.saicharan.myapplication.R;
import testdemo.saicharan.myapplication.Utils.Constant;
import testdemo.saicharan.myapplication.Utils.Helper;


/**
 * Created by sai on 27-02-2019.
 */

public class MostViewedArticleAdapter extends RecyclerView.Adapter<MostViewedArticleAdapter.ViewHolder> {
    private Response response;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvDate;
        final public ImageView ivImageview;
        public View layout;
        public TextView tvSource;
        public TextView tvSubText;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            ivImageview = (ImageView)v.findViewById(R.id.ivImageview);
            tvDate = (TextView)v.findViewById(R.id.tvDate);
            tvSource = (TextView)v.findViewById(R.id.tvSource);
            tvSubText = (TextView)v.findViewById(R.id.tvSubText);


        }
    }

    public FragmentManager fragmentManager;
    public MainActivity mainActivity;

    public MostViewedArticleAdapter(Response response, MainActivity mainActivity, FragmentManager fragmentManager) {
        this.response = response;
        this.fragmentManager = fragmentManager;
        this.mainActivity = mainActivity;
    }

    @Override
    public MostViewedArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.layout_fragment_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MostViewedArticleDetailFragment mostViewedArticleDetailFragment = new MostViewedArticleDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constant.ARTICLE_URL,response.getResults().get(position).getUrl());
                mostViewedArticleDetailFragment.setArguments(bundle);
                Helper.addAndInitFragmentWithBackStack(mostViewedArticleDetailFragment,R.id.fragment_content_container,fragmentManager);

            }
        });

        final String name = response.getResults().get(position).getTitle();
        holder.tvTitle.setText(name);
        holder.tvDate.setText(response.getResults().get(position).getPublishedDate());

        holder.tvSource.setText(response.getResults().get(position).getSource());
        holder.tvSubText.setText(response.getResults().get(position).getByline());


        Glide.with(mainActivity).load(response.getResults().get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.ivImageview) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mainActivity.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.ivImageview.setImageDrawable(circularBitmapDrawable);
            }
        });

    }

    @Override
    public int getItemCount() {
        return response.getResults().size();
    }

}
