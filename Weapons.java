import java.util.*;
/**
 * Write a description of class Weapons here.
 * 
 * @author Angus Weich
 * @version (a version number or a date)
 */
public class Weapons
{
    public static int damage = 0;
    public static boolean battleAxeBought= false;
    public static boolean stickBought = false;
    public static boolean knifeBought = false;
    public static boolean swordBought = false;
    public static boolean bazookaBought= false;
    //public Treemap<String, Integer> Weapons;//Name of weapon, damage of weapon
    //String name = "Stick";
    //int dam = 1;
    //Weapons.put(name, dam);
    
    
    public static void stick(){
        if ((!stickBought) && (Player.cash > 10)){
            Player.loseCash(10); 
            damage = 1;
            stickBought = true;
        }
    }
    
    public static void knife(){
        if ((!knifeBought) && (Player.cash > 20)){
            Player.loseCash(20); 
            damage = 2;
            knifeBought = true;
        }
    }
    
    public static void sword(){
        if ((!swordBought) && (Player.cash > 30)){
            Player.loseCash(30); 
            damage = 5;
            swordBought = true;
        }
    }
    
    public static void battleAxe(){
        if ((!battleAxeBought) && (Player.cash > 50)){
            Player.loseCash(50); 
            damage = 10;
            battleAxeBought = true;
        }
    }
    
    public static void Bazooka(){
        if ((!bazookaBought) && (Player.cash > 100)){
            Player.loseCash(100); 
            damage = 50;
            bazookaBought = true;
        }
    }
}
