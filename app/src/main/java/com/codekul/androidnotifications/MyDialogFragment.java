package com.codekul.androidnotifications;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
  1 . Alert,
  2. Date and Time Picker,
  3. Progress Dialog and
  4. Custom Dialog

 */
public class MyDialogFragment extends DialogFragment {

    public static final String TAG_ALERT = "alertDialog";
    public static final String TAG_DATE_PICKER = "datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT)){

            DialogClick click =
                    new DialogClick();

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getActivity())
                    .setTitle("Title")
                    .setMessage("Message")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("+ve",click)
                    .setNeutralButton("==",click)
                    .setNegativeButton("-ve",click);

            dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
        }
        else if(getTag().equals(TAG_DATE_PICKER)){

            DatePickerDialog datePicker  =
                    new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            mt(""+ dayOfMonth +" - "+(monthOfYear+1)+" - "+ year);
                        }
                    }, 2016, 4, 17);

            dialog = datePicker;
        } else if (getTag().equals(TAG_TIME_PICKER)) {

            TimePickerDialog timePicker =
                    new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            mt(""+ hourOfDay +" : "+minute);
                        }
                    }, 11, 41, false);

            dialog = timePicker;
        }

        else if(getTag().equals(TAG_PROGRESS)){

            ProgressDialog dialogProgress =
                    new ProgressDialog(getActivity());
            dialogProgress.setTitle("Title");
            dialogProgress.setMessage("Message");
            dialogProgress.setIcon(R.mipmap.ic_launcher);
            //dialogProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialogProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            dialog = dialogProgress;
        }

        else {

            LayoutInflater inflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View dialogView = inflater.inflate(R.layout.fragment_my_dialog,null,false);

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getActivity());
            builder.setView(dialogView);
            dialog = builder.create();
        }

        return dialog;
    }

    private final class DialogClick
            implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if(which == DialogInterface.BUTTON_POSITIVE){

                mt("+ve");
            }
            else if(which == DialogInterface.BUTTON_NEGATIVE){

                mt("-ve");
            }
            else {
                mt("==");
            }
        }
    }

    private final void mt(String msg){

        Toast.makeText( getActivity(),
                msg,
                Toast.LENGTH_SHORT).show();
        }
}
