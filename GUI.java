import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.*;

/**
 * Clicker Program
 * author: Angus Weich
 * Start date: 21 March 2016
 */
public class GUI extends JFrame{
    static JLabel CashBar = new JLabel();
    static JLabel MonHPBar = new JLabel();
    static JLabel XPBar = new JLabel();
    static JLabel LevelBar = new JLabel();
    static JCheckBox petBuy = new JCheckBox();
    
    //static Image monsterImage = new ImageIcon("Monster.png", "An evil monster");
    static ImageIcon image = new ImageIcon("Monster.png", "An evil monster");
    static JLabel imageLabel = new JLabel(image);

    JPanel cards;
    public GUI(){
        Clicker();
    }

    private void Clicker(){
        //sets up card layout
        cards = new JPanel(new CardLayout());
        final JPanel clickHome = new JPanel();
        cards.add(clickHome, "Click!");
        final JPanel shopHome = new JPanel();
        cards.add(shopHome, "Upgrade Store");
        final JPanel playerHome = new JPanel();
        cards.add(playerHome, "Player Info");
        final JPanel petsHome = new JPanel();
        cards.add(petsHome, "Pets");
        getContentPane().add(cards);


        //declares JPanels showing stats
        Player.refreshCash();
        Player.refreshXP();
        Player.refreshLevel();
        Monster.refreshMonHealth();

        //component.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"doSomething");
        //component.getActionMap().put("doSomething",anAction);
        //JOptionPane.showMessageDialog(null, _Message_, _Title_, JOptionPane.INFORMATION_MESSAGE); 

        /**
         * Sets up home panel
         */
        JButton clickButt = new JButton("Click!");
        clickButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Monster.health = Monster.health - Player.Attack();
                    if (Monster.health <= 0){
                        Monster.Die();
                    }
                    Monster.refreshMonHealth();
                }
            });
        JButton storeButt = new JButton("Store");
        storeButt.setToolTipText("Buy New Upgrades and Pets");
        storeButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Upgrade Store");
                }
            });
        JButton petsButt = new JButton("Pets");
        petsButt.setToolTipText("Manage and Upgrade Your Pets");
        petsButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Pets");
                }
            });
        JButton playerButt = new JButton("Player");
        playerButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Player Info");
                }
            });
        //Button for Clicking
        clickHome.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 4;
        clickHome.add(clickButt, c);
        //Button for store tab
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        clickHome.add(storeButt, c);
        //Monster Image
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 2;
        c.gridy = 2;
        clickHome.add(imageLabel, c);
        //Button for Player info tab
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 0;
        clickHome.add(playerButt, c);
        //Button for pets tab
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        clickHome.add(petsButt, c);
        //Bank Bar
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 20;
        c.gridx = 1;
        c.gridy = 4;
        clickHome.add(CashBar, c);
        //Monster Health Bar
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 4;
        clickHome.add(MonHPBar, c);
        //XP Bar
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 4;
        clickHome.add(XPBar, c);
        //Level Bar
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 4;
        clickHome.add(LevelBar, c);

        /**
         * Sets up Store tab
         */
        JButton upgradeButt = new JButton("Upgrade");
        upgradeButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){

                }
            });
        shopHome.add(upgradeButt);

        JButton StickButt = new JButton("Stick");
        StickButt.setToolTipText("Better than fists.. just. Does 1 damage Costs 10 gold");
        StickButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Weapons.stick();
                }
            });
        shopHome.add(StickButt);
        
        JButton KnifeButt = new JButton("knife");
        KnifeButt.setToolTipText("For things that lack holes Does 2 damage Costs 20 gold");
        KnifeButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Weapons.knife();
                }
            });
        shopHome.add(KnifeButt);
        
        JButton SwordButt = new JButton("Sword");
        SwordButt.setToolTipText("For things that need bigger holes Does 5 damage Costs 30 gold");
        SwordButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Weapons.sword();
                }
            });
        shopHome.add(SwordButt);
        
        JButton BattleAxeButt = new JButton("Battle Axe");
        BattleAxeButt.setToolTipText("When a hole just isn't enough. Does 10 damage Costs 50 gold");
        BattleAxeButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Weapons.battleAxe();
                }
            });
        shopHome.add(BattleAxeButt);
        
        JButton BazookaButt = new JButton("Bazooka");
        BazookaButt.setToolTipText("BOOM! Does 50 damage Costs 100 gold");
        BazookaButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Weapons.Bazooka();
                }
            });
        shopHome.add(BazookaButt);

        JButton backFrmStoreButt = new JButton("Back");
        backFrmStoreButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Click!");
                }
            });
        shopHome.add(backFrmStoreButt);

        /**
         * Sets up Player info tab
         */
        JButton backFrmPlayerButt = new JButton("Back");
        backFrmPlayerButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Click!");
                }
            });
        playerHome.add(backFrmPlayerButt);

        /**
         * Sets up Pets tab
         */
        JButton backFrmPetsButt = new JButton("Back");
        backFrmPetsButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    CardLayout cardLayout = (CardLayout) cards.getLayout();
                    cardLayout.show(cards, "Click!");
                }
            });
        petsHome.add(backFrmPetsButt);

        JButton buyDragonButt = new JButton("Dragon");
        buyDragonButt.setToolTipText("A fierce companion, perfect for any adventurer Performs 2DPS Costs 50 gold");
        buyDragonButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Pets.buyDragon();
                }
            });
        petsHome.add(buyDragonButt);

        JButton buySealButt = new JButton("Seal");
        buySealButt.setToolTipText("This pet has my SEAL of approval Performs 1DPS Costs 20 gold");
        buySealButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Pets.buySeal();
                }
            });
        petsHome.add(buySealButt);

        JButton buyFerretButt = new JButton("Ferret");
        buyFerretButt.setToolTipText("His name is Colin and he has a little hat Performs 1DPS Costs 20 gold");
        buyFerretButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Pets.buyFerret();
                }
            });
        petsHome.add(buyFerretButt);

        JButton buyOtterButt = new JButton("Otter");
        buyOtterButt.setToolTipText("Otters are cute, even when they have a knife! Performs 1DPS Costs 20 gold");
        buyOtterButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Pets.buyOtter();
                }
            });
        petsHome.add(buyOtterButt);

        JButton buyCorgiButt = new JButton("Battle Corgi");
        buyCorgiButt.setToolTipText("His cute appearance hides his bloodlust Performs 1DPS Costs 20 gold");
        buyCorgiButt.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    Pets.buyCorgi();
                }
            });
        petsHome.add(buyCorgiButt);

        petBuy.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                        Pets.petTimer.start();  //start dps damage
                    } else {//checkbox has been deselected
                        Pets.petTimer.stop();  //stop dps damage
                    };
                }
            });
        petsHome.add(petBuy);

        setTitle("Clicker!");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CashBar.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    GUI ex = new GUI();
                    ex.setVisible(true);
                }
            });
    }

}
