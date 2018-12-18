package com.muaedu.basis.customtimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.muaedu.basis.customtimepicker.data.Type;
import com.muaedu.basis.customtimepicker.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnDateSetListener {
    private TextView tv;
    private TimePickerDialog mDialogYearMonthDay;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        long endYears = 1000 * 60 * 60 * 24L;
        mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(-115200000l+endYears)
                .setMaxMillseconds(4133865600000l)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.YEAR_MONTH_DAY)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(16)
                .build();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogYearMonthDay.show(getSupportFragmentManager(), "");
            }
        });


    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        tv.setText(text);
    }
    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
}
