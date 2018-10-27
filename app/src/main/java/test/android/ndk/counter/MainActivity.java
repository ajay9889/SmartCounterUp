package test.android.ndk.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
// Cleass created by Ajay to test the JNI communication with Android activity class.
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    TickerView tickerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tickerView = findViewById(R.id.displayNumber);
        tickerView.setText(String.valueOf(counterFromJNI()));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int counterFromJNI();
    public native int resetFromJNI();


    public void inCrement(View view){
        tickerView.setText(String.valueOf(counterFromJNI()));
    }
    public void resetNumber(View view){
        tickerView.setText(String.valueOf(resetFromJNI()));

    }

}
