package com.jonathangeorge.gokub_vs_gokur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
//for some reason andriod studios isnt letting me commit....:( time to learn command line
public class MainActivity extends AppCompatActivity {

    // 0 and 1 are the blue and red goku's
    int activePlayer = 0;
    int[][] youWin = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
     boolean gameIsOn = true;

    //2 means nothing in the slot
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public void dropGoKu(View view) {

        ImageView counter = (ImageView) view;

        // print the selected tag
        // System.out.println(counter.getTag().toString());

        int tapped = Integer.parseInt(counter.getTag().toString());


        if (gameState[tapped] == 2 && gameIsOn) {
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

            for (int[] yw : youWin) {
                if (gameState[yw[0]] == gameState[yw[1]]
                        && gameState[yw[1]] == gameState[yw[2]]
                        && gameState[yw[0]] != 2) {

                    System.out.println(gameState[yw[0]]);

                    gameIsOn = false;
                    String winnerColor = "Red";
                    if(gameState[yw[0]] == 0){
                        winnerColor = "Blue";
                    }
                    //winner message
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    String goku = " Goku has won!";
                    winnerMessage.setText(winnerColor + goku);

                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLO);

                    layout.setVisibility(View.VISIBLE);
                }
                else {
                    boolean draw = true;
                    for(int turns: gameState){
                        if (turns == 2){
                            draw = false;
                        }
                    }
                    if(draw){
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                       String noWinner = "Draw!";
                        winnerMessage.setText(noWinner);

                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLO);

                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }

        }

    }

    public void playAgain(View view){
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLO);
        layout.setVisibility(View.INVISIBLE);

        gameIsOn = true;
        activePlayer = 0;


        for(int i = 0; i < gameState.length; i++){
                gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLay);

        //childcount is all the stuff in the layout
        for(int i = 0; i < gridLayout.getChildCount(); i++){

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
