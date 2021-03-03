package dam.invisere.gtidic.udl.cat.myevents;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Event extends AppCompatDialogFragment {

    public String title;
    public String description;

    public Event(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New event created")
                .setMessage(
                        "Title: " + title + '\n' +
                        "Description: " + description + '\n'+
                        "Duration: "
                )
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
