package hrd.org.uicomponents;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hrd.org.uicomponents.callback.CallBack;
import hrd.org.uicomponents.dialog.DateDialog;
import hrd.org.uicomponents.dialog.TimeDialog;

public class MainActivity extends AppCompatActivity implements
        CallBack.TimePickerCallback,
        CallBack.DatePickerCallback
{

    @Nullable @BindView(R.id.tv_meanig_1)TextView tvBookMeaning1;
    @Nullable @BindView(R.id.tv_meanig_2)TextView tvBookMeaning2;
    @BindView(R.id.show_more) ToggleButton tgShowMore;
    @BindView(R.id.php) CheckBox chPhp;
    @BindView(R.id.java) CheckBox chJava;
    @BindView(R.id.female) RadioButton rdFemale;
    @BindView(R.id.male) RadioButton rdMale;

    @Nullable @BindView(R.id.tv_time)TextView tvTime;
    @Nullable @BindView(R.id.tv_date)TextView tvDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        ButterKnife.setDebug(true);

        tvBookMeaning1.setText(R.string.book_meaning_1);
        tvBookMeaning2.setText(R.string.book_meaning_2);

        tgShowMore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tgShowMore.setBackgroundColor(Color.parseColor("#E91E63"));
                }else{
                    tgShowMore.setBackgroundColor(Color.parseColor("#F8BBD0"));
                }
            }
        });

        chJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Java is Checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Java is Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        chPhp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Php is Checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Php is Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rdMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        rdFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.btn_time)
    public void onPickTime(View view){
        new TimeDialog().show(getSupportFragmentManager(),"TIME_PICKER");
    }
    @OnClick(R.id.btn_date)
    public void onPickDate(View view){
        new DateDialog().show(getSupportFragmentManager(),"DATE_PICKER");
    }

    @Override
    public void pickDate(DatePicker datePicker, int... values) {
        String s="";
        for (int val : values){
            s=s+"/"+ val;
        }
        if(null!=tvDate) tvDate.setText(s);
    }

    @Override
    public void pickTime(TimePicker timePicker, int... values) {
        String s="";
        for (int val : values){
            s=s+ ":"+ val;
        }
        if (null!=tvTime) tvTime.setText(s);
    }
}
