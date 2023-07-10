//int he name of God

package com.example.salavatshomar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView sayingOfDay;
    private ConstraintLayout myLayout;
    private long salvatCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.MyButton);
        sayingOfDay = findViewById(R.id.sayingOfDay);
        myLayout = findViewById(R.id.myLayout);

        showSayingOfDay();
    }

    private void showSayingOfDay()
    {
        final int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        Log.d("MainActivity", "onCreate: day of week:: " + dayOfWeek);

        switch(dayOfWeek)
        {
            case 1: sayingOfDay.setText(R.string.day2Saying);
                break;
            case 2: sayingOfDay.setText(R.string.day3Saying);
                break;
            case 3: sayingOfDay.setText(R.string.day4Saying);
                break;
            case 4: sayingOfDay.setText(R.string.day5Saying);
                break;
            case 5: sayingOfDay.setText(R.string.day6Saying);
                break;
            case 6: sayingOfDay.setText(R.string.day7Saying);
                break;
            case 7: sayingOfDay.setText(R.string.day1Saying);
                break;
        }
    }

    public void addOneToNum(View view)
    {
        this.salvatCount ++;
        if (salvatCount == 100)
            Toast.makeText(MainActivity.this, R.string.encouraging_text, Toast.LENGTH_SHORT)
                    .show();

        if (salvatCount % 10 == 0)
        {
            myButton.setTextColor(Color.BLACK);
            myButton.setBackgroundColor(ContextCompat.getColor(this,R.color.purple_500));
            myLayout.setBackgroundResource(R.color.purple_200);
        }
        else
        {
            myButton.setTextColor(Color.WHITE);
            myButton.setBackgroundColor(Color.MAGENTA);
            myLayout.setBackgroundResource(com.google.android.material.R.color.design_default_color_on_primary);
        }

        myButton.setText(String.valueOf(salvatCount));
        Log.d("MainActivity", "addOneToNum: adding!" + salvatCount);

    }

    public void showAbout(View view)
    {
        Log.d("MainActivity", "showAbout: showing about!");
        Snackbar.make(myButton, R.string.about_me, Snackbar.LENGTH_LONG)
                .setAction("More", v ->
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aparat.com/v/Uti6u/%D8%A8%D9%88%DB%8C_%DA%AF%D9%84_%D8%B3%D9%88%D8%B3%D9%86_%D9%88_%DB%8C%D8%A7%D8%B3%D9%85%D9%86_%D8%A2%DB%8C%D8%AF"));
                    startActivity(browserIntent);
                })
                .show();
    }

    public void resetCount(View view)
    {
        this.salvatCount = -1;
        addOneToNum(view);
    }
}