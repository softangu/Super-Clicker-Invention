import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;
/**
 * Write a description of class Pets here.
 * 
 * @author Angus Weich 
 * @version (a version number or a date)
 */
public class Pets
{
    // instance variables - replace the example below with your own
    public static boolean DragonBought = false;
    public static boolean FerretBought = false;
    public static boolean OtterBought = false;
    public static boolean CorgiBought = false;
    public static boolean SealBought = false;
    public static int damage = 0;
    public static Timer petTimer = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    Monster.health = Monster.health - damage;
                    if(Monster.health <= 0){
                        Monster.Die();
                    }
                    Monster.refreshMonHealth();
                }
            });

    public static void buyDragon(){
        if ((!DragonBought) && (Player.cash > 50)){
            Player.loseCash(50); 
            damage = damage + 2;
            DragonBought = true;
        }
    }

    
    public static void buySeal(){
        if ((!SealBought) && (Player.cash > 20)){
            Player.loseCash(20); 
            damage = damage + 1;
            SealBought = true;
        }
    }
    
    public static void buyFerret(){
        if ((!FerretBought) && (Player.cash > 20)){
            Player.loseCash(20); 
            damage = damage + 1;
            FerretBought = true;
        }
    }

    public static void buyOtter(){
        if ((!OtterBought) && (Player.cash > 20)){
            Player.loseCash(20); 
            damage = damage + 1;
            OtterBought = true;
        }
    }

    public static void buyCorgi(){
        if ((!CorgiBought) && (Player.cash > 20)){
            Player.loseCash(20); 
            damage = damage + 1;
            CorgiBought = true;
        }
    }
}
