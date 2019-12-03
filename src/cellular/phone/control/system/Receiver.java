/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellular.phone.control.system;

import GUI.CellIdle;
import GUI.CellOption;
import GUI.CellRinging;
import GUI.Idle;
import GUI.InCall;
import GUI.InCallCell;
import GUI.MainClass;
import GUI.NoSignal;
import GUI.Ringing;
import events.OnPressed;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author omar1
 */
public class Receiver {
 public void lostSignal()
    {
        
       // NoSignal s=new NoSignal();
     // s.setVisible(true);
        MainClass.phone.getScreen().setVisible(false);
        MainClass.phone.getCellScreen().setVisible(false);
       CellOption.screenC.setVisible(false);
        
        
    }
    public void enterCall() {

        MainClass.phone.setCurrentState("In Call");
        MainClass.phone.getScreen().setVisible(false);
        MainClass.phone.getCellScreen().setVisible(false);
        InCall window = new InCall();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        MainClass.phone.setScreen(window);

        InCallCell window2 = new InCallCell();
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setVisible(true);
        MainClass.phone.setCellScreen(window2);
    }
        public void ringing(String recieverNumber, String senderNumber) {
        System.out.println("before checking number");
        if (recieverNumber.equals(MainClass.phone.getNumber())) {
            System.out.println("Correct number0");
            MainClass.phone.setCurrentState("Ringing") ;
            System.out.println("Correct number1");
            MainClass.phone.setEnteredNumber(senderNumber);
            System.out.println("Correct number2");
            MainClass.phone.getScreen().setVisible(false);
            MainClass.phone.getCellScreen().setVisible(false);
            System.out.println("Correct number3");
            Ringing window = new Ringing();
            System.out.println("Correct number4");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CellRinging window2 = new CellRinging();
            System.out.println("Correct number4");
            window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window2.setVisible(true);
            System.out.println("Correct number5");
            window.setVisible(true);
            System.out.println("Correct number6");
            MainClass.phone.setScreen(window);
            MainClass.phone.setCellScreen(window2);
            System.out.println("Correct number7");
        } else {
            System.out.println("Wrong number");
        }

    }
}
