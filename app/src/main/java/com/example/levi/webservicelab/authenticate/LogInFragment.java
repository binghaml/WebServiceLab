package com.example.levi.webservicelab.authenticate;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.levi.webservicelab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment {


    public interface LoginInteractionListener {
        public void login(String userId, String pwd);
    }

    public LogInFragment() {
        // Required empty public constructor
    }


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
                                           // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_log_in, container, false);
        final EditText userIdText = (EditText) v.findViewById(R.id.username_text);
        final EditText pwdText = (EditText) v.findViewById(R.id.password_text);

        userIdText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    userIdText.setHint("");
                else
                    userIdText.setHint("Enter Username");
            }
        });

        pwdText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    pwdText.setHint("");
                else
                    pwdText.setHint("Enter password");
            }
        });

        Button signInButton = (Button) v.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = userIdText.getText().toString();
                String pwd = pwdText.getText().toString();
                if (TextUtils.isEmpty(userId))  {
                    Toast.makeText(v.getContext(), "Enter userid"
                            , Toast.LENGTH_SHORT)
                            .show();
                    userIdText.requestFocus();
                    return;
                }
                if (!userId.contains("@")) {
                    Toast.makeText(v.getContext(), "Enter a valid email address"
                            , Toast.LENGTH_SHORT)
                            .show();
                    userIdText.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(pwd))  {
                    Toast.makeText(v.getContext(), "Enter password"
                            , Toast.LENGTH_SHORT)
                            .show();
                    pwdText.requestFocus();
                    return;
                }
                if (pwd.length() < 6) {
                    Toast.makeText(v.getContext(), "Enter password of at least 6 characters"
                            , Toast.LENGTH_SHORT)
                            .show();
                    pwdText.requestFocus();
                    return;
                }
                ((SignInActivity) getActivity()).login(userId, pwd);
            }
        });
        return v;
    }
}
