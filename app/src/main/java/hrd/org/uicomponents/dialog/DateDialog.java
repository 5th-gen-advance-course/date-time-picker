package hrd.org.uicomponents.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.DatePicker;
import android.widget.TimePicker;

import hrd.org.uicomponents.callback.CallBack;

/**
 * Created by RATHANA on 10/31/2017.
 */

public class DateDialog extends android.support.v4.app.DialogFragment implements
        DatePickerDialog.OnDateSetListener
{

    CallBack.DatePickerCallback datePickerCallback;
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        datePickerCallback.pickDate(view,year,month,dayOfMonth);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        datePickerCallback= (CallBack.DatePickerCallback) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day_of_month=c.get(Calendar.DAY_OF_MONTH);
        int day_of_week=c.get(Calendar.DAY_OF_WEEK);

        return new DatePickerDialog(getActivity(),this,year,month,day_of_month);
    }
}
