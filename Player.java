
/**
 * Write a description of class Player here.
 * 
 * @author Angus Weich
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    public static int cash = 0;
    public static int level = 1;
    public static int xp = 0;
    public static int maxHealth = 10;
    public static int health = maxHealth;
    public static int maxMana = 10;
    public static int mana = maxMana;
    public static int maxXP = 50+ 2^level;
    

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        
    }

    /**
     * Works out your damage for a single attack
     */
    public static int Attack()
    {
        int damage = 1 + Weapons.damage;
        return damage;
    }
    
    /**
     * Keeps track of player XP and Level
     */
    public static void XP(int xpGained)
    {
        xp = xp + xpGained;
        if (xp >= maxXP)
        {
            level = level + 1;
            xp = xp - maxXP;
            refreshLevel();
            maxXP = 50 + (3^level);
            Monster.Build();
        }
        refreshXP();
    }
    
    public static void refreshCash()
    {
        GUI.CashBar.setText("$" + cash);
    }
    
    public static void refreshXP()
    {
        GUI.XPBar.setText("XP:" + xp + "/" + maxXP);
    }
    
    public static void refreshLevel()
    {
        GUI.LevelBar.setText("Level:" + level);
    }
    
    /**
     * Increases player cash and refreshes the JLabel
     */
    public static void gainCash(int cashGained){
        cash = cash + cashGained;
        refreshCash();
    }
    
    /**
     * Reduces player cash and refreshes the JLabel
     */
    public static void loseCash(int cashLost){
        cash = cash - cashLost;
        refreshCash();
    }
}
