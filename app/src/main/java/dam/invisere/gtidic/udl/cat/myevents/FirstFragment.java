package dam.invisere.gtidic.udl.cat.myevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    TextView createdEventsTextView;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        createdEventsTextView = view.findViewById(R.id.textView_createdEvents);

        int numEvents_arg = FirstFragmentArgs.fromBundle(getArguments()).getNumEventsArg();

        createdEventsTextView.setText(getString(R.string.textView_createdEvents_text, numEvents_arg));

        view.findViewById(R.id.button_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(numEvents_arg);
                Log.d(null, String.valueOf(numEvents_arg));
                Navigation.findNavController(view).navigate(action);
            }
        });

        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(FirstFragmentDirections.actionFirstFragmentToLoginFragment());
            }
        });

        return view;
    }
}