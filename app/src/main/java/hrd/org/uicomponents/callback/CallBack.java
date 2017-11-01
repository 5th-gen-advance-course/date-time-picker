package hrd.org.uicomponents.callback;

import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by RATHANA on 10/31/2017.
 */

public interface CallBack {

    interface DatePickerCallback{
        void pickDate(DatePicker datePicker,int ... values);
    }

    interface TimePickerCallback{
        void pickTime(TimePicker timePicker,int ... values);
    }
}
