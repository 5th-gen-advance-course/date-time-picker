package hrd.org.uicomponents.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import hrd.org.uicomponents.callback.CallBack;

/**
 * Created by RATHANA on 10/31/2017.
 */

public class TimeDialog extends android.support.v4.app.DialogFragment implements TimePickerDialog.OnTimeSetListener{

    CallBack.TimePickerCallback timePickerCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        timePickerCallback= (CallBack.TimePickerCallback) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c= Calendar.getInstance();
        int h=c.get(Calendar.HOUR);
        int m=c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,h,m,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        timePickerCallback.pickTime(view,hourOfDay,minute);
    }



}
