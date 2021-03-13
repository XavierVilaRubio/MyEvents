package dam.invisere.gtidic.udl.cat.myevents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dam.invisere.gtidic.udl.cat.myevents.models.LoginUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LoginUtils loginUtils;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailEditText = view.findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = view.findViewById(R.id.editTextTextPassword);
        loginButton = view.findViewById(R.id.button_login2);
        loginUtils = new LoginUtils();

        loginButton.setOnClickListener(v -> {
            if(loginUtils.isValidEmailAddress(emailEditText) && loginUtils.isValidPassword(passwordEditText)){
                Toast toast = Toast.makeText(getContext(), "Login successfully", Toast.LENGTH_LONG);
                toast.show();
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_firstFragment);
            }
        });

        return view;
    }
}