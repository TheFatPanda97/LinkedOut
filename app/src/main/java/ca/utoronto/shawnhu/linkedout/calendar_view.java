package ca.utoronto.shawnhu.linkedout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class calendar_view extends Fragment {

    CompactCalendarView compactCalendar;
    TextView txtEvent,txtTime,txtName,txtLocation;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMM yyyy", Locale.getDefault());

    public calendar_view() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calendar_view, container, false);
        txtEvent = v.findViewById(R.id.txt_event);
        txtTime = v.findViewById(R.id.txt_time);
        txtName = v.findViewById(R.id.txt_name);
        txtLocation = v.findViewById(R.id.txt_location);
        compactCalendar = v.findViewById(R.id.compactcalendar_view);

        final tutor tutor_ev1 = new tutor("Math Tutoring", "12 - 1 pm", "Simrrat Bains", "UTMSU");
        final tutor tutor_ev2 = new tutor("Economics Tutoring", "1 - 4 am", "Stephen Tran", "York University");


        compactCalendar.setUseThreeLetterAbbreviation(true);

        final Event ev1 = new Event(Color.BLUE, 1550754000000L);
        compactCalendar.addEvent(ev1);
        final Event ev2 = new Event(Color.GREEN, 1550840400000L);
        compactCalendar.addEvent(ev2);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

                if (dateClicked.toString().compareTo("Thu Feb 21 00:00:00 EST 2019") == 0) {
                    String[] temp_data = tutor_ev1.all_info();
                    txtEvent.setText(temp_data[0]);
                    txtTime.setText(temp_data[1]);
                    txtName.setText(temp_data[2]);
                    txtLocation.setText(temp_data[3]);
                } else if (dateClicked.toString().compareTo("Fri Feb 22 00:00:00 EST 2019") == 0) {
                    String[] temp_data = tutor_ev2.all_info();
                    txtEvent.setText(temp_data[0]);
                    txtTime.setText(temp_data[1]);
                    txtName.setText(temp_data[2]);
                    txtLocation.setText(temp_data[3]);
                } else {
                    txtEvent.setText("No Events");
                }


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });

        return v;
    }

}
