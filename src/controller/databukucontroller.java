/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import view.MainView;

/**
 *
 * @author Fikri
 */

public class databukucontroller {
    MainView frame;
    databukuimplement impldatabuku;
    List<databuku> db;
    
    public databukucontroller(MainView frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        db = impldatabuku.getAll();
    }
    
    public void isitabel(){
        db = impldatabuku.getAll();
        modeltabeldatabuku mp = new modeltabeldatabuku(db);
        frame.getTabelDatabuku().setModel(mp);
    }
    
    public void insert(){ 
        databuku db = new databuku();
        db.setJudul(frame.getJTxtjudul().getText());
        db.setGenre(frame.getJTxtgenre().getText());
        db.setPenulis(frame.getJTxtpenulis().getText());
        db.setPenerbit(frame.getJTxtpenerbit().getText());
        db.setLokasi(frame.getJTxtlokasi().getText());
        db.setStok(frame.getJTxtstok().getText());
        impldatabuku.insert(db);
        
    }
    
    public void update(){
        databuku db = new databuku();
        db.setJudul(frame.getJTxtjudul().getText());
        db.setGenre(frame.getJTxtgenre().getText());
        db.setPenulis(frame.getJTxtpenulis().getText());
        db.setPenerbit(frame.getJTxtpenerbit().getText());
        db.setLokasi(frame.getJTxtlokasi().getText());
        db.setStok(frame.getJTxtstok().getText());
        db.setId(Integer.parseInt(frame.getJTxtid().getText()));
        impldatabuku.update(db);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldatabuku.delete(id);
    }
}
