/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import GUI.MainClass;
import cellular.phone.control.system.CellularSystem;
import events.PositiveResponseRecieved;

/**
 *
 * @author omar1
 */
public class PositiveResponseRecievedHandler {
    private CellularSystem phone;

    public PositiveResponseRecievedHandler(CellularSystem phone) {
        this.phone = phone;
    }
    
    public void update(PositiveResponseRecieved event)
    {
        MainClass.phone.getReceiver().enterCall();
    }
    
}
