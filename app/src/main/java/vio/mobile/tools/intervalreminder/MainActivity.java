package vio.mobile.tools.intervalreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean blinkOn = false;
    private static final String CHANNEL_ID  = "IntervalReminder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Timer tmrBlink = new Timer(5000, new Runnable() {

            public void run() {
               Toast.makeText(MainActivity.this, "BLINK!", Toast.LENGTH_SHORT).show();


                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Reminder")
                        .setContentText("Bitte trinken")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);

                int notificationId = (int) System.currentTimeMillis();
// notificationId is a unique int for each notification that you must define
                notificationManager.notify(notificationId, builder.build());
            }

        });

        tmrBlink.start();

    }
}
