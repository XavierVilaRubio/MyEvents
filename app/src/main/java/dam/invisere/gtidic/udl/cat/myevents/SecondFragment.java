package dam.invisere.gtidic.udl.cat.myevents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.core.util.Pair;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Date;

import dam.invisere.gtidic.udl.cat.myevents.models.Event;

public class SecondFragment extends Fragment {

    int numEvents_arg;
    Date[] dates = new Date[2];

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
        numEvents_arg = SecondFragmentArgs.fromBundle(getArguments()).getNumEventsArg();

        EditText titleEditText = view.findViewById(R.id.textField_name);
        EditText descriptionEditText = view.findViewById(R.id.textField_description);

        //Move inside onClick function, it's here just for testing
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
        MaterialDatePicker<Pair<Long, Long>> materialDatePicker = builder.build();

        view.findViewById(R.id.textField_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getActivity().getSupportFragmentManager(), materialDatePicker.toString());
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {
                        EditText date = getActivity().findViewById(R.id.textField_date);
                        date.setText(materialDatePicker.getHeaderText());
                        dates[0] = new Date(selection.first * 1000);
                        dates[1] = new Date(selection.second * 1000);
                    }
                });
            }
        });

        view.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragmentDirections.ActionSecondFragmentToFirstFragment action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                action.setNumEventsArg(numEvents_arg);
                Log.d(null, String.valueOf(numEvents_arg));
                Navigation.findNavController(view).navigate(action);
            }
        });

        view.findViewById(R.id.button_create2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event newEvent = new Event(
                        titleEditText.getText().toString(),
                        descriptionEditText.getText().toString(),
                        dates[0],
                        dates[1]
                );
                newEvent.show(getActivity().getSupportFragmentManager(), newEvent.toString());
                SecondFragmentDirections.ActionSecondFragmentToFirstFragment action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                numEvents_arg++;
                action.setNumEventsArg(numEvents_arg);
                Log.d(null, String.valueOf(numEvents_arg));
                Navigation.findNavController(view).navigate(action);
            }
        });


        return view;
    }
}