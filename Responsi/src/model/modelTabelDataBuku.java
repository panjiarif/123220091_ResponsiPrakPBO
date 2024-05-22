/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class modelTabelDataBuku extends AbstractTableModel {
    
    List<dataBuku> db;
    public modelTabelDataBuku(List<dataBuku>db){
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            case 4:
                return "ID Buku";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return db.get(row).getJudul();
            case 1:
                return db.get(row).getPenulis();
            case 2:
                return db.get(row).getRating();
            case 3:
                return db.get(row).getHarga();
            case 4:
                return db.get(row).getId();
            default:
                return null;
        }
    }
    
}
