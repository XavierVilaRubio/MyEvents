package dam.invisere.gtidic.udl.cat.myevents.models;

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

    public String name;
    public String description;
    public Date startDate;
    public Date endDate;

    public Event(){
        this.name = "";
        this.description = "";
        this.startDate = new Date();
        this.endDate = new Date();
    }

    public Event(String name, String description, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int daysToStart(){
        Date now = new Date();
        return DateUtils.getDuration(this.startDate, now);
    }

    public int daysToEnd(){
        Date now = new Date();
        return DateUtils.getDuration(this.endDate, now);
    }

    public int duration(){
        return DateUtils.getDuration(this.startDate, this.endDate);
    }

    public String toString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public EventStatus getStatus(){
        if(this.daysToStart() > 0){
            return EventStatus.NEW;
        }
        if(this.daysToEnd() < 0){
            return EventStatus.FINISHED;
        }
        return EventStatus.ONGOING;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New event created")
                .setMessage(
                        "Title: " + name + '\n' +
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
