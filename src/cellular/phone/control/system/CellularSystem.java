/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellular.phone.control.system;

import GUI.Calc;
import GUI.Calling;
import GUI.Calling1;
import GUI.CellIdle;
import GUI.CellRecievedCall;
import GUI.CellRinging;
import GUI.Idle;
import GUI.InCall;
import GUI.InCallCell;
import GUI.MainClass;
import GUI.NoSignal;
import GUI.Off;
import GUI.Ringing;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import events.OnPressed;
import java.util.ArrayList;
//import javax.microedition.midlet.MIDletStateChangeException;
import javax.swing.JFrame;

/**
 *
 * @author omar1
 */
public class CellularSystem {

    public class MyRunnable implements Runnable {

        private int var;

        public MyRunnable(int var) {
            this.var = var;
        }

        public void run() {
            MainClass.engine.getEPRuntime().sendEvent(new OnPressed());
        }
    }

    private final Cell cell;
    private Receiver receiver;
    private Transmitter transmitter;
    private EPServiceProvider engine;
    private String enteredNumber;
    private String number;

    private String currentState;
    private JFrame screen;
    private JFrame cellScreen;
    private boolean callRequestPhone;

    public CellularSystem(Cell cell, Receiver receiver, Transmitter transmitter) {
        this.cell = cell;
        this.receiver = receiver;
        this.transmitter = transmitter;
        engine = EPServiceProviderManager.getDefaultProvider();
        currentState = "Off";
        enteredNumber = "";
        screen = new Off();
        System1 s = new System1();
        callRequestPhone = false;
        number = "01023231444";
    }

    public void terminateCall() {
        enteredNumber = "";
        currentState = "Idle";
        screen.setVisible(false);
        cellScreen.setVisible(false);
        Idle window = new Idle();
        CellIdle window2 = new CellIdle();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        screen = window;
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setVisible(true);
        cellScreen = window2;
    }

   
    public void turnOff() throws InterruptedException {

        currentState = "Off";
        screen.setVisible(false);

        Off window = new Off();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        screen = window;

    }


    public JFrame getScreen() {
        return screen;
    }

    public void setScreen(JFrame screen) {
        this.screen = screen;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Transmitter getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public EPServiceProvider getEngine() {
        return engine;
    }

    public void setEngine(EPServiceProvider engine) {
        this.engine = engine;
    }

    public String getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(String enteredNumber) {
        this.enteredNumber = enteredNumber;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isCallRequestPhone() {
        return callRequestPhone;
    }

    public void setCallRequestPhone(boolean callRequestPhone) {
        this.callRequestPhone = callRequestPhone;
    }

    public void setCellScreen(JFrame cellScreen) {
        this.cellScreen = cellScreen;
    }

    public Cell getCell() {
        return cell;
    }

    public JFrame getCellScreen() {
        return cellScreen;
    }

}
