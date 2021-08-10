package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.fighters.Fighter;

/**
 * Contains the logic that runs the game. Two fighters fight, by switching between giving and taking damage.
 */
public class GameEngine {

    private Fighter[] fighters;

    private boolean isRunning = true;

    //These integers determine which fighter attacks and which defends.
    private int fighterCounter1 = 0; //The fighter with this variable is always defending.
    private int fighterCounter2 = 1; //The fighter with this variable is always attacking.

    /**
     * Configures the fighters into the GameEngine.
     * @param fighter1 The first fighter in the fight.
     * @param fighter2 The second fighter in the fight.
     */
    public GameEngine(Fighter fighter1, Fighter fighter2){

        fighters = new Fighter[]{fighter1, fighter2};
    }

    /**
     * Runs the fighting logic in the game until a fighter dies, which at that point returns the fighter that won.
     * @return The fighter that won.
     */
    public Fighter run(){

        Fighter result = null;

        while(isRunning){
            //There are two fighters in the array. One takes the damage and the other attacks.
            if (fighters[fighterCounter1].takeDamage(fighters[fighterCounter2].attack()) == FighterState.DEAD){
                //The surviving fighter will always be the attacking one.
                result = fighters[fighterCounter2];
                isRunning = false;
            }
            //the variables switch values after every attack. This way fighters always switch as well.
            switchValues();
        }

        return result;
    }

    /**
     * Switches the values that determine which fighter attacks.
     */
    private void switchValues(){
        int temp = fighterCounter1;
        fighterCounter1 = fighterCounter2;
        fighterCounter2 = temp;
    }
}
