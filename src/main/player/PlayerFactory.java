package main.player;

import java.util.Random;

public class PlayerFactory {

    public static Player getAIPlayer(char counter, String name){
        Random rand = new Random();
        int number = rand.nextInt(5);
        switch(number){
            case 0 :
                return new BuilderPlayer(counter, name);
            case 1 :
                return new CleverBuilderPlayer(counter, name);
            case 2 :
                return new CopycatPlayer(counter, name);
            case 3 :
                return new PlumberPlayer(counter, name);
            default :
                return new JokerPlayer(counter, name);
        }
    }

    public static Player getHumanPlayer(char counter, String name){
        return new HumanPlayer(counter, name);
    }
}
