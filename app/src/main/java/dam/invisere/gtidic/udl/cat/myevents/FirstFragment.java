package dam.invisere.gtidic.udl.cat.myevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    TextView numEventsTextView;
    String numEventsKey = "numEvents";


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

        numEventsTextView = view.findViewById(R.id.textView_numEvents);

        boolean myArg = FirstFragmentArgs.fromBundle(getArguments()).getMyArg();
        if(myArg)
            saveValue(numEventsKey, getValue(numEventsKey) + 1);

            numEventsTextView.setText(String.valueOf(getValue(numEventsKey)));

        view.findViewById(R.id.button_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveValue(numEventsKey, Integer.parseInt(numEventsTextView.getText().toString()));
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });

        return view;
    }

    private void saveValue(String key, int value) {
        SharedPreferences preferences = getActivity().getSharedPreferences(key, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private int getValue(String key) {
        SharedPreferences preferences = this.getActivity().getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }
}