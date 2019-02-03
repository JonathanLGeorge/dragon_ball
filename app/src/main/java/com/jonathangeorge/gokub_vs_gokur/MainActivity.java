package com.jonathangeorge.gokub_vs_gokur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 0 and 1 are the blue and red goku's
    int activePlayer = 0;
   // int [][] youWin ={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
   // boolean gameIsOn = true;

    //2 means nothing in the slot
    int gameState[] = {2,2,2,2,2,2,2,2,2};

    public void dropGoKu(View view){

        ImageView counter = (ImageView) view;

        int tapped = Integer.parseInt(counter.getTag().toString());


        if(gameState[tapped] == 2) {
            gameState[tapped] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.bluegoku1);

                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.redgoku1);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(500);

        //    for (int[] winningPosition : youWin) {
          //      if (gameState[winningPosition[0]] == gameState[winningPosition[2]])
           // }

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
