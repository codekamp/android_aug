package in.codekamp.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cerebro on 29/08/17.
 */

public class ProfileFragment extends Fragment {

    TextView profileIdTv;
    int profileId;


    public static ProfileFragment createInstance(int profileId) {
        ProfileFragment f = new ProfileFragment();
        Bundle b = new Bundle();
        b.putInt("profile_id", profileId);
        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            profileId = args.getInt("profile_id");
        } else {
            throw new RuntimeException("You need to set arguments with profile_id in it to use ProfileFragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileIdTv = (TextView)view.findViewById(R.id.profile_id_tv);
        profileIdTv.setText(Integer.toString(profileId));
    }
}
