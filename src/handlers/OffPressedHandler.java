/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import GUI.MainClass;
import cellular.phone.control.system.CellularSystem;
import events.OffPressed;
import events.OnPressed;

/**
 *
 * @author omar1
 */
public class OffPressedHandler {
    private CellularSystem phone;

    public OffPressedHandler(CellularSystem phone) {
        this.phone = phone;
    }
    
     public void update(OffPressed event) throws InterruptedException {
          System.out.println("In OffPressed Handler");
        if(!(MainClass.phone.getCurrentState().equals("Off")))
        {
          
            MainClass.phone.turnOff();
        }
        else
        {
            
        }
        
    }
    
}
