package in.codekamp.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by cerebro on 24/08/17.
 */

public class NumberInput extends Fragment {



    private String text;
    public String message = "Ram Rahim ji Insa";

    private static final String TEXT_KEY = "my_text";
    private static final String MESSAGE_KEY = "my_message";

    private TextListner listner;

    public static NumberInput createInstace(String message, int age) {
        NumberInput n = new NumberInput();
        Bundle arg = new Bundle();
        arg.putString(MESSAGE_KEY, message);
        arg.putInt("dfsdfsd", age);
        n.setArguments(arg);

        return n;
    }

    public static NumberInput createInstace(String message) {
        return NumberInput.createInstace(message, 50);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("codekamp", "NumberInput fragment onCreate called");

        message = getArguments().getString(MESSAGE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            text = savedInstanceState.getString(TEXT_KEY);
        } else {
            Random r = new Random();
            int i = r.nextInt(100);
            text = i + "_" + i;
        }

        View view = inflater.inflate(R.layout.fragment_number_input, container, false);

        TextView tv = (TextView) view.findViewById(R.id.my_text_view);
        tv.setText(text + " and message is " + message);

        Button sendButton = (Button)view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listner != null) {
                    listner.onTextSet(text);
                }
            }
        });

        Log.d("codekamp", text);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof TextListner) {
            listner = (TextListner) context;
        } else {
            throw new RuntimeException("Please implement TextListner interface in your activity " +
                    "if you want to use NumberInput fragment");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXT_KEY, text);
    }

    public interface TextListner {
        public void onTextSet(String text);
    }
}
