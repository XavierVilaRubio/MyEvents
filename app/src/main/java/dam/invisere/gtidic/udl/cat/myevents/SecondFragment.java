package dam.invisere.gtidic.udl.cat.myevents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SecondFragment extends Fragment {


    public SecondFragment() {
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
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        SecondFragmentDirections.ActionSecondFragmentToFirstFragment action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();

        EditText titleEditText = view.findViewById(R.id.textField_name);
        EditText descriptionEditText = view.findViewById(R.id.textField_description);

        view.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setMyArg(false);
                Navigation.findNavController(view).navigate(action);
            }
        });

        view.findViewById(R.id.button_create2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event newEvent = new Event(titleEditText.getText().toString(), descriptionEditText.getText().toString());
                newEvent.show(getActivity().getSupportFragmentManager(), newEvent.toString());
                action.setMyArg(true);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }
}