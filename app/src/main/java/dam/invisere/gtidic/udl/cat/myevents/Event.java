package dam.invisere.gtidic.udl.cat.myevents;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends AppCompatDialogFragment {

    public String title;
    public String description;
    public Long startDate;
    public Long endDate;

    public Event(String title, String description, Long startDate, Long endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int millisecondsToDays(Long milliseconds) {
        return (int) (milliseconds / (1000*60*60*24));
    }

    public int daysToStart(){
        return millisecondsToDays(this.startDate - System.currentTimeMillis());
    }

    public int duration(){
        return millisecondsToDays((endDate - startDate));
    }

    public String toString(Long date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New event created")
                .setMessage(
                        "Title: " + title + '\n' +
                        "Description: " + description + '\n' +
                        "Start date: " + toString(startDate) + '\n' +
                        "End date: " + toString(endDate) + '\n' +
                        "Days to start: " + daysToStart() + '\n' +
                        "Days to end: " + (daysToStart()+duration()) + '\n' +
                        "Duration: " + duration()

                )
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
