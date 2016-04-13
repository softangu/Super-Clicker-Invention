import java.awt.*;
/**
 * Write a description of class Monster here.
 * 
 * @author Angus Weich
 * @version (a version number or a date)
 */
public class Monster
{
    // instance variables - replace the example below with your own
    public static int maxHealth = 20;
    public static int health = maxHealth;
    public static int gold = 3;
    public static int xp = 7;
    
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Image monster = toolkit.getImage("Monster.png");
    static Image BossMonster = toolkit.getImage("BossMonster.png");
    static Image TreasureMonster = toolkit.getImage("TreasureMonster.png");

    /**
     * Constructor for objects of class Monster
     */
    public Monster()
    {
        // initialise instance variables

    }

    /**
     * Returns the stats of a new Monster
     */

    /**
     *  What happens when the monster dies
     */
    public static void Die()
    {
        Player.gainCash(gold);
        Player.XP(xp);
        Build();
    }

    /**
     * Generates the stats for a new monster
     * with a 1/20 chance of generating a boss
     * a 3/10 chance of generating a treasure monster
     * and a 3/5 chance of generating a normal monster
     */
    public static void Build(){
        double rand = Math.random();
        if (rand<0.1){ //has a 1/20 chance of happening
            //Generates a Boss monster
            maxHealth = Monster.maxHealth = 20 + (8^Player.level);
            health = maxHealth;
            gold = (3*maxHealth);
            xp = 10 + (3*Player.level);
            GUI.image.setImage(BossMonster);
        }else if (rand>0.7){ //has a 3/10 chance of happening
            //Generates a Treasure Monster
            maxHealth = Monster.maxHealth = 20 + (6^Player.level);
            health = maxHealth;
            gold = 3 + (Player.level*10);
            xp = 7 + (2*Player.level);
            GUI.image.setImage(TreasureMonster);
        } else{
            //Generates a normal monster
            maxHealth = Monster.maxHealth = 20 + (5^Player.level);
            health = maxHealth;
            gold = Player.level + 3;
            xp = 7 + (2*Player.level);
            GUI.image.setImage(monster);
        }

    }

    public static void refreshMonHealth()
    {
        GUI.MonHPBar.setText("HP:" + health + "/" + maxHealth);
    }
}
