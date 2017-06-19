/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class MComboBox extends DefaultComboBoxModel {

    private ArrayList linhas = null;

    public MComboBox(ArrayList lin) {
        setLinhas(lin);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    @Override
    public Object getSelectedItem() {
        return super.getSelectedItem();
    }

    @Override
    public int getSize() {
        return this.linhas.size();
    }

    @Override
    public void addElement(Object anObject) {
        this.linhas.add(anObject);
        //notifica o combo que o modelo foi alterado.  
        this.fireIntervalAdded(this, 0, 0);
    }

    @Override
    public Object getElementAt(int index) {
        return this.linhas.get(index);
    }
}
