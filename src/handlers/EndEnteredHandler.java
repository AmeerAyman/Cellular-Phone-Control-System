/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import GUI.MainClass;
import cellular.phone.control.system.CellularSystem;
import events.EndEntered;

/**
 *
 * @author omar1
 */
public class EndEnteredHandler {
    private CellularSystem phone;

    public EndEnteredHandler(CellularSystem phone) {
        this.phone = phone;
    }
    
    public void update(EndEntered event)
    {
        MainClass.phone.terminateCall();
    }
}
