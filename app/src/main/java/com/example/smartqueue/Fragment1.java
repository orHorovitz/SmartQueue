package com.example.smartqueue;

import androidx.fragment.app.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Fragment1 extends Fragment {
        private FirebaseAuth mAuth;

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public Fragment1() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        public static Fragment1 newInstance(String param1, String param2) {
            Fragment1 fragment = new Fragment1();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

        public void login(View view){

            EditText emailT = view.findViewById(R.id.email);
            EditText passT = view.findViewById(R.id.password);
            String email = emailT.getText().toString();
            String password = passT.getText().toString();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getContext(), "login ok", Toast.LENGTH_LONG).show();
                                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment3);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getContext(), "login failed", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            mAuth = FirebaseAuth.getInstance();
            // Inflate the layout for this fragment
            View view =  inflater.inflate(R.layout.fragment_1, container, false);

            Button loginBtn = view.findViewById(R.id.button1);
            Button reg1Btn = view.findViewById(R.id.button3);

            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login(view);
                    //Navigation.findNavController(v).navigate(R.id.action_fragment1_to_fragment3);
                }
            });
            reg1Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.action_fragment1_to_fragment2);
                }
            });

            return view;

}
    }
}
