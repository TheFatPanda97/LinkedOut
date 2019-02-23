package ca.utoronto.shawnhu.linkedout;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
public class LogInScreen_Activity extends AppCompatActivity {
    private Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen_);

        Button=(Button) findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainScreen_Activity();
            }
        });


    }
    public void openMainScreen_Activity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}