package com.example.tennisscorekeeper;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private Player player1 = new Player("Player", "One");
    final private Player player2 = new Player("Player", "Two");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("mainActivityCheck", "Before create players...");

        TextView playerOne = findViewById(R.id.name_of_player_one);
        playerOne.setText(player1.getFullName());

        TextView playerTwo = findViewById(R.id.name_of_player_two);
        playerTwo.setText(player2.getFullName());

        Button button_player_one = findViewById(R.id.button_of_add_point_one);
        button_player_one.setOnClickListener(this);

        Button button_player_two = findViewById(R.id.button_of_add_point_two);
        button_player_two.setOnClickListener(this);

        Log.i("mainActivityCheck", "After created players.");
    }

    @Override
    public void onClick(View view) {
        Log.i("onClickCheck", "Get into Bug selection!");
        switch (view.getId()) {
            case R.id.button_of_add_point_one:
                player1.addOnePoint(player2);
                break;
            case R.id.button_of_add_point_two:
                player2.addOnePoint(player1);
                break;
            default:
                break;
        }

        updateBoard(Arrays.asList(new TextView[]{
                findViewById(R.id.point_of_player_one),
                findViewById(R.id.game_of_player_one),
                findViewById(R.id.set_of_player_one)}
                ), player1);

        updateBoard(Arrays.asList(new TextView[]{
                findViewById(R.id.point_of_player_two),
                findViewById(R.id.game_of_player_two),
                findViewById(R.id.set_of_player_two)}
                ), player2);

    }

    private void updateBoard(List<TextView> viewList, Player player) {
        int[] values = new int[]{player.getPoint(), player.getGame(), player.getSet()};
        for(int i = 0; i < viewList.size(); i++) {
            viewList.get(i).setText(Integer.toString(values[i]));
        }
    }

}