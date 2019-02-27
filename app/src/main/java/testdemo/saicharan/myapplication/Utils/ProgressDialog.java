package testdemo.saicharan.myapplication.Utils;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import testdemo.saicharan.myapplication.R;


/**
 * Created by sai on 27-02-2019.
 */

public class ProgressDialog extends Dialog {

    Context mContext;
    Dialog dialog1;

    public Dialog showDialog() {
        dialog1 = new ProgressDialog(mContext);
        ProgressBar progressBar = new ProgressBar(mContext);
        dialog1.addContentView(progressBar, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(mContext.getResources().getColor(R.color.wallet_holo_blue_light), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        try {
            dialog1.show();
        } catch (Exception e) {
            Log.e("Error" , "" + e.getMessage());
        }
        return dialog1;
    }

    public void dismissDialog()
    {
        if(dialog1!=null && dialog1.isShowing())
        {
            dialog1.dismiss();
        }
    }

    public ProgressDialog(@NonNull Context context) {
        super(context, R.style.NewDialog);
        this.mContext = context;
    }
}
