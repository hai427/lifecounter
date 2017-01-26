package edu.washington.hai427.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView[] players = new TextView[4];
    TextView[] lifeCounterLabels = new TextView[4];
    TextView loser;
    Button[] buttons = new Button[16];
    int[] counters = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loser = (TextView) (findViewById(R.id.loser));

        for (int i=0; i<4; i++) {
            counters[i] = 20;
        }

        for (int i=0; i<4; i++) {
            String lifeLabelID = "life" + (i + 1);
            int resID = getResources().getIdentifier(lifeLabelID, "id", getPackageName());
            lifeCounterLabels[i] = (TextView) (findViewById(resID));
            lifeCounterLabels[i].setText("Life Counter: " + counters[i] + "");
        }
    }

    public void adjustLifeCounter(View v){

        loser.setText("");

        Button button = (Button) v;
        int playerId = Integer.parseInt(button.getTag().toString()) - 1;
        String text = button.getText().toString();
        if(text.equals("+")){
            counters[playerId]++;
            lifeCounterLabels[playerId].setText("Life Counter: " + counters[playerId]);
        }
        if(text.equals("-")){
            counters[playerId]--;
            lifeCounterLabels[playerId].setText("Life Counter: " + counters[playerId]);
        }
        if(text.equals("+5")){
            counters[playerId]+=5;
            lifeCounterLabels[playerId].setText("Life Counter: " + counters[playerId]);
        }
        if(text.equals("-5")) {
            counters[playerId]-=5;
            lifeCounterLabels[playerId].setText("Life Counter: " + counters[playerId]);
        }

        if(counters[playerId] <= 0) {
            loser.setText("Player " + (playerId + 1) + " LOSES!");
        }
    }
}
