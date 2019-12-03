/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellular.phone.control.system;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author omar1
 */
public class Cell {
    private int maxNumOfPhone=3;
    private boolean available=false;
    private ArrayList<CellularSystem> phonesOnCell=new ArrayList<>();
    private JFrame window;
    private String IncomingNumber;

    public Cell() {
        maxNumOfPhone=3;
        available=false;
        
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
    
    
    
    
    public boolean addPhone(CellularSystem phone)
    {
        try
        {
            phonesOnCell.add(phone);
            return true;
        }catch(IndexOutOfBoundsException e)
        {
            return false;
        }
      
    }

    public int getMaxNumOfPhone() {
        return maxNumOfPhone;
    }

    public void setMaxNumOfPhone(int maxNumOfPhone) {
        this.maxNumOfPhone = maxNumOfPhone;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<CellularSystem> getPhonesOnCell() {
        return phonesOnCell;
    }

    public void setPhonesOnCell(ArrayList<CellularSystem> phonesOnCell) {
        this.phonesOnCell = phonesOnCell;
    }

    public String getIncomingNumber() {
        return IncomingNumber;
    }

    public void setIncomingNumber(String IncomingNumber) {
        this.IncomingNumber = IncomingNumber;
    }
    
    
}
