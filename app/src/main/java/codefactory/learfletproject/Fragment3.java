package codefactory.learfletproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jhyoo on 2018-01-04.
 */

public class Fragment3 extends Fragment {

    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id","");


        return rootView;

    }
}
