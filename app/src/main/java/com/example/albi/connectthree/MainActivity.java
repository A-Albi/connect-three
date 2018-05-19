package com.example.albi.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int turn = 0;
    public boolean hasWon = false;
    public int[] board_data = {2,2,2,2,2,2,2,2,2};
    public int[][] combinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7},
            {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View layout = findViewById(R.id.playAgain);
        layout.setVisibility(View.INVISIBLE);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int val = Integer.parseInt(counter.getTag().toString());
        if (2 == board_data[val - 1] && !hasWon) {
        counter.setTranslationY(-1000f);
        switch (turn % 2) {
            case (0):
                counter.setImageResource(R.drawable.piece_a);
                    board_data[val - 1] = (turn % 2);
                    break;
            case (1):
                counter.setImageResource(R.drawable.piece_b);
                    board_data[val - 1] = (turn % 2);
                    break;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            turn = turn + 1;
        }
        hasWon = isWin();
    }
    public boolean isWin () {
        for (int[] ints: combinations) {
                if (board_data[ints[0]-1] != 2 &&
                        board_data[ints[0]-1] == board_data[ints[1]-1] &&
                        board_data[ints[1]-1] == board_data[ints[2]-1])
            {
                TextView textView = findViewById(R.id.textView);
                if (!hasWon)
                textView.setText(("Player "+Integer.toString(turn % 2 == 0 ? 2 : 1) + " has won!"));
                View layout = findViewById(R.id.playAgain);
                layout.setAlpha(1f);
                layout.setVisibility(View.VISIBLE);
                return true;
            }
        }
        boolean exists_twos = false;
        for (int k: board_data)
            if (k == 2)
                exists_twos = true;
        if (exists_twos == false) {
            TextView textView = findViewById(R.id.textView);
            textView.setText(("Draw: No Winners!"));
            View layout = findViewById(R.id.playAgain);
            layout.setAlpha(1f);
            layout.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }

    public void playAgain(View view) {
        for (int i = 0; i < 9; i++) {
            board_data[i] = 2;
        }
        hasWon = false;
        turn = 0;
        ImageView iv1 = findViewById(R.id.imageView1);
        iv1.setImageResource(0);
        ImageView iv2 = findViewById(R.id.imageView2);
        iv2.setImageResource(0);
        ImageView iv3 = findViewById(R.id.imageView3);
        iv3.setImageResource(0);
        ImageView iv4 = findViewById(R.id.imageView4);
        iv4.setImageResource(0);
        ImageView iv5 = findViewById(R.id.imageView5);
        iv5.setImageResource(0);
        ImageView iv6 = findViewById(R.id.imageView6);
        iv6.setImageResource(0);
        ImageView iv7 = findViewById(R.id.imageView7);
        iv7.setImageResource(0);
        ImageView iv8 = findViewById(R.id.imageView8);
        iv8.setImageResource(0);
        ImageView iv9 = findViewById(R.id.imageView9);
        iv9.setImageResource(0);
        TextView textView = findViewById(R.id.textView);
        View layout = findViewById(R.id.playAgain);
        layout.setVisibility(View.INVISIBLE);
        textView.setText("Connect three to win!");
    }
}