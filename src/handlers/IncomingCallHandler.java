/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import GUI.MainClass;
import cellular.phone.control.system.CellularSystem;
import events.IncomingCall;

/**
 *
 * @author omar1
 */
public class IncomingCallHandler {
    private CellularSystem phone;

    public IncomingCallHandler(CellularSystem phone) {
        this.phone = phone;
    }
    public void update(String recieverNumber, String senderNumber)
    {
        System.out.println("In Ringnig");
        MainClass.phone.getReceiver().ringing(recieverNumber, senderNumber);
        System.out.println("out Ringnig");
    }
    
}
