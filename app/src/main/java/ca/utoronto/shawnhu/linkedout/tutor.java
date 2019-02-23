package ca.utoronto.shawnhu.linkedout;

public class tutor {

    public String event_name, time, tutor_name, location;

    public tutor(String event_name, String time, String tutor_name, String location) {

        this.event_name = event_name;
        this.time = time;
        this.tutor_name = tutor_name;
        this.location = location;

    }

    public String[] all_info() {
        return new String[]{event_name, time, tutor_name, location};
    }
}
