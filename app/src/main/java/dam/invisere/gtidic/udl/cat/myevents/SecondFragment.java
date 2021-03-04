package dam.invisere.gtidic.udl.cat.myevents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.core.util.Pair;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Date;

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
        final Long[] dates = new Long[2];

        view.findViewById(R.id.textField_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
                builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                MaterialDatePicker<Pair<Long, Long>> materialDatePicker = builder.build();
                materialDatePicker.show(getActivity().getSupportFragmentManager(), materialDatePicker.toString());

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {
                        EditText date = getActivity().findViewById(R.id.textField_date);
                        date.setText(materialDatePicker.getHeaderText());
                        dates[0] = selection.first;
                        dates[1] = selection.second;
                    }
                });
            }
        });

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
                Event newEvent = new Event(
                        titleEditText.getText().toString(),
                        descriptionEditText.getText().toString(),
                        dates[0],
                        dates[1]
                );
                newEvent.show(getActivity().getSupportFragmentManager(), newEvent.toString());
                action.setMyArg(true);
                Navigation.findNavController(view).navigate(action);
            }
        });


        return view;
    }
}