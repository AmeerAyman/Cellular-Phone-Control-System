/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellular.phone.control.system;

import GUI.Calling;
import GUI.CellIdle;
import GUI.CellOption;
import GUI.CellRecievedCall;
import GUI.Idle;
import GUI.MainClass;
import GUI.NoSignal;
import events.OnPressed;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author omar1
 */
public class Transmitter {
    
   
     public void scanForSignal() throws InterruptedException {

        /* if (MainClass.cell.isAvailable()) {
            CellIdle window = new CellIdle();
            MainClass.phone.cellScreen = window;
            window.setVisible(true);
            cellScreen = window;
             currentState = "Idle";
            screen.setVisible(false);

           Idle window2 = new Idle();
            window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window2.setVisible(true);
            screen = window2;
        }
        else
        {
            System.out.println("Ameer Group");
        }*/
        ArrayList<Cell> cells = new ArrayList<>();
        
        cells = System1.getCells();
        int i = 0;
        boolean founded = false;
        while (i < cells.size()) {

            if (MainClass.cell.isAvailable()) {

                if (cells.get(i).addPhone(MainClass.phone)) {
                    System.out.println("Test1");
                    i = cells.size();
                    founded = true;
                    CellIdle window = new CellIdle();
                    MainClass.phone.setCellScreen(window);
                    window.setVisible(true);
                    MainClass.phone.setCellScreen(window);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        if (!founded) {

            System.out.println("No Signal");
            MainClass.phone.setCurrentState("No Signal");
            MainClass.phone.getScreen().setVisible(false);
            NoSignal window = new NoSignal();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            MainClass.phone.setScreen(window);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                @Override
                public void run() {
                    MainClass.engine.getEPRuntime().sendEvent(new OnPressed());
                }
            },
                    10000
            );

            //Thread.sleep(10000);
        } else {
            System.out.println("Test");
            MainClass.phone.setCurrentState("Idle");
            MainClass.phone.getScreen().setVisible(false);

            Idle window = new Idle();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            MainClass.phone.setScreen(window);
        }
    }

    
    public void calling(String dialedNumber) {
        MainClass.phone.setEnteredNumber(dialedNumber);
        MainClass.phone.setCurrentState("Calling");
        MainClass.phone.getScreen().setVisible(false);
        MainClass.phone.getCellScreen().setVisible(false);
        boolean answered = false;
        Calling window = new Calling();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        MainClass.phone.setScreen (window);
        CellRecievedCall window2 = new CellRecievedCall();

        long startTime = System.currentTimeMillis(); //fetch starting time
        while (MainClass.phone.isCallRequestPhone() || (System.currentTimeMillis() - startTime) < 5000) {

            window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window2.setVisible(true);
            MainClass.phone.setCellScreen  (window2);
        }

    }

}
