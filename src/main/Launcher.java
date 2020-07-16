package main;

/*
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

    static int winCounters;
    static int rows;
    static int cols;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.next();
        while(true) {
            printOptions();
            int choice = getUserChoice(sc);
            if (choice == 1) {
                defaultConfig();
                break;
            } else if (choice == 2) {
                customise(sc);
                break;
            } else {
                System.out.println("Not a valid choice");
            }
        }
        List<Player> players = getPlayers(name);
        Collections.shuffle(players);
        Game game = new Game(players, winCounters, rows, cols);
        game.play();
    }

    private static List<Player> getPlayers(String name) {
        List<Player> players = new ArrayList<>();
        players.add(PlayerFactory.getHumanPlayer('H', name));
        players.add(PlayerFactory.getAIPlayer('1', "AI1"));
        players.add(PlayerFactory.getAIPlayer('2', "AI2"));
        return players;
    }

    public static void defaultConfig(){
        winCounters = 4;
        rows = 6;
        cols = 7;
    }

    public static void customise(Scanner sc){
        System.out.println("How many counters do you want to connect?");
        winCounters = sc.nextInt();
        System.out.println("How many rows?");
        rows = sc.nextInt();
        System.out.println("How many columns?");
        cols = sc.nextInt();
    }

    private static void printOptions() {
        System.out.println();
        System.out.println("Press 1 to play Connect Four");
        System.out.println("Press 2 to customise your own Connect N game");
    }

    private static int getUserChoice(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println();
            sc.next();
        }
        return sc.nextInt();
    }
}
