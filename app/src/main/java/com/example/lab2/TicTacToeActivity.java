package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] gameGrid = new Button[3][3]; //2d array of buttons
    private TextView messageTextView;
    private int turn;
    private String message;
    private boolean gameOver;
    private String gameString;
    private Button newGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        //reference to widgets
        gameGrid[0][0] = (Button) findViewById(R.id.square1);
        gameGrid[0][1] = (Button) findViewById(R.id.square2);
        gameGrid[0][2] = (Button) findViewById(R.id.square3);
        gameGrid[1][0] = (Button) findViewById(R.id.square4);
        gameGrid[1][1] = (Button) findViewById(R.id.square5);
        gameGrid[1][2] = (Button) findViewById(R.id.square6);
        gameGrid[2][0] = (Button) findViewById(R.id.square7);
        gameGrid[2][1] = (Button) findViewById(R.id.square8);
        gameGrid[2][2] = (Button) findViewById(R.id.square9);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        //set event handlers
        for (int x = 0; x < gameGrid.length; x++){
            for(int y = 0; y < gameGrid[x].length; y++){
                gameGrid[x][y].setOnClickListener(this);
            }
        }

        newGameButton.setOnClickListener(this);
        //clear grid with the following loop
        for(int x = 0; x < gameGrid.length; x++) {
            for(int y = 0; y < gameGrid[x].length; y++){
                gameGrid[x][y].setText(" ");
            }
        }

        //set starting values
        turn = 1;
        gameOver = false;
        message = getString(R.string.message_label);
        messageTextView.setText(message);
        gameString = "         ";

    }

    public void onClick(View v){
        if(v.getId() == R.id.newGameButton){
            //clear grid
            for (int x = 0; x < gameGrid.length; x++){
                for(int y = 0; y < gameGrid[x].length; y++){
                    gameGrid[x][y].setText(" ");
                }
            }
            //set starting values
            turn = 1;
            gameOver = false;
            message = getString(R.string.message_label);
            messageTextView.setText(message);
            gameString = "         ";
        }else{
            if(!gameOver){
                Button b = (Button) v;

                if(b.getText().equals(" ")){
                    if(turn % 2 != 0){
                        b.setText("X");
                        message = getString(R.string.message_label2);
                    }else{
                        b.setText("O");
                        message = getString(R.string.message_label);
                    }

                    turn++;
                            checkForGameOver();
                }else{
                    message = getString(R.string.taken_square);
                }
            }

            messageTextView.setText(message);
        }
    }

    private void checkForGameOver()
    {
        // Check for a match
        // Rows
        for (int x = 0; x < 3; x++) {
            if (!gameGrid[x][0].getText().equals(" ") &&
                    gameGrid[x][0].getText().equals(gameGrid[x][1].getText()) &&
                    gameGrid[x][1].getText().equals(gameGrid[x][2].getText())
            ) {
                message = gameGrid[x][0].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        // Columns
        for(int y = 0; y < 3; y++) {
            if (!gameGrid[0][y].getText().equals(" ") &&
                    gameGrid[0][y].getText().equals(gameGrid[1][y].getText()) &&
                    gameGrid[1][y].getText().equals(gameGrid[2][y].getText())
            ) {
                message = gameGrid[0][y].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        // Diagonal 1
        if(!gameGrid[0][0].getText().equals(" ") &&
                gameGrid[0][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[1][1].getText().equals(gameGrid[2][2].getText())
        ) {
            message = gameGrid[0][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        // Diagonal 2
        if(!gameGrid[2][0].getText().equals(" ") &&
                gameGrid[2][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[0][2].getText().equals(gameGrid[1][1].getText())
        ) {
            message = gameGrid[2][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        if (turn > 9) {
            message = "It's a tie!";
            gameOver = true;
            return;
        }

        gameOver = false;
    }
}