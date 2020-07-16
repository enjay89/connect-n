package main;

/*
TODO Expand this to Connect N, where N is passed in from the command line arguments
TODO Can we make the size of the board configurable as well?
TODO Make these variables (number of players, which players are human, number of tokens you have to get in a row, number of rows and columns in the board) configurable from the command line before launching the game
"Out of Scope"
TODO God mode bonus points: The Turtle: a player that looks for imminent victories and attempts to stop them **difficult**
 */

import main.player.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    int winCounters;

    public int getWinCounters() {
        return winCounters;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.next();
        System.out.println("How many counters do you want to connect?");
        int winCounters = sc.nextInt();
        List<Player> players = new ArrayList<>();
        players.add(PlayerFactory.getHumanPlayer('H', name));
        players.add(PlayerFactory.getAIPlayer('1', "AI1"));
        players.add(PlayerFactory.getAIPlayer('2', "AI2"));
        Collections.shuffle(players);
        Game game = new Game(players);
        game.play();
    }
}