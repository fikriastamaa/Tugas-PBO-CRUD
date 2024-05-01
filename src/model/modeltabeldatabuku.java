/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fikri
 */
public class modeltabeldatabuku extends AbstractTableModel {
    
    List<databuku> db;
    public modeltabeldatabuku(List<databuku>db){
        this.db = db;
    }
    
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "GENRE";
            case 3:
                return "PENULIS";
            case 4:
                return "PENERBIT";
            case 5:
                return "LOKASI";
            case 6:
                return "STOK";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return db.get(row).getId();
            case 1:
                return db.get(row).getJudul();
            case 2:
                return db.get(row).getGenre();
            case 3:
                return db.get(row).getPenulis();
            case 4:
                return db.get(row).getPenerbit();
            case 5:
                return db.get(row).getLokasi();
            case 6:
                return db.get(row).getStok();
            default:
                return null;
        }
    }
    
}
