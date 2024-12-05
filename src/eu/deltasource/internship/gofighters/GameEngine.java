package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.fighters.Fighter;

/**
 * Contains the logic that runs the game. Two fighters fight, by switching between giving and taking damage.
 */
public class GameEngine {

    private Fighter[] fighters;

    private boolean isRunning = true;

    //These integers determine which fighter attacks and which defends.
    private int defenderIndex  = 0; //The fighter with this variable is always defending.
    private int attackerIndex = 1; //The fighter with this variable is always attacking.

    private int roundCount;


    /**
     * Sets up fighters and runs the fighting logic in the game until a fighter dies,
     * which at that point returns the fighter that won.
     *
     * @return The fighter that won.
     *
     * @param fighter1 The first fighter.
     * @param fighter2 The second fighter.
     */
    public Fighter run(Fighter fighter1, Fighter fighter2){

        roundCount = 0;
        isRunning = true;
        fighters = new Fighter[]{fighter1, fighter2};
        Fighter winner = null;

        while(isRunning){
            //There are two fighters in the array. One takes the damage and the other attacks.
            int attackDmg = fighters[attackerIndex].attack();
            int damageTaken = fighters[defenderIndex].takeDamage(attackDmg);

            System.out.println("ROUND: " + roundCount);
            System.out.println(fighters[attackerIndex].getName() + " attacks for: " + attackDmg);
            System.out.println(fighters[defenderIndex].getName() + " takes: " + damageTaken + " damage");
            System.out.println(fighters[defenderIndex].getName() + " health is: " + fighters[defenderIndex].getHealth());
            System.out.println("----------------------------------------");

            if (fighters[defenderIndex].isDead()){
                winner = fighters[attackerIndex];
                isRunning = false;
            }
            //the variables switch values after every attack. This way fighters always switch as well.
            switchFighterRoles();
            roundCount++;
        }
        return winner;
    }

    /**
     * Switches the values that determine which fighter attacks.
     */
    private void switchFighterRoles(){
        int temp = defenderIndex;
        defenderIndex = attackerIndex;
        attackerIndex = temp;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
