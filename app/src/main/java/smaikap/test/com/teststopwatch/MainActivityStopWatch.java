package smaikap.test.com.teststopwatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

public class MainActivityStopWatch extends AppCompatActivity {

    private transient boolean running = false;
    private transient int second;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_stop_watch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        runCounter();
    }

    public void onClickStart(View view) {
        running = true;

    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        second = 0;
    }

    private void runCounter() {
        final TextView timer = (TextView)findViewById(R.id.timer);
        final Handler timerHandler = new Handler();
        timerHandler.post(new Runnable() {
            @Override
            public void run () {
                final int hours = second/3600;
                final int minutes = (second%3600)/60;
                final int secs = second%60;

                final String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timer.setText(time);

                if(running) {
                    second++;
                }
                
                timerHandler.postDelayed(this,1000);
            }
        });
    }
}
