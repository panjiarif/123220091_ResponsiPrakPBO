/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdataBuku.dataBukuDAO;
import DAOimplement.dataBukuImplement;
import model.*;
import view.mainView;

/**
 *
 * @author Lab Informatika
 */
public class dataBukuController {
    mainView frame;
    dataBukuImplement implDataBuku;
    List<dataBuku> db;
    
    public dataBukuController(mainView frame){
        this.frame = frame;
        implDataBuku = new dataBukuDAO();
        db = implDataBuku.getAll();
    }
    
    public void isiTable(){
        db = implDataBuku.getAll();
        modelTabelDataBuku mb = new modelTabelDataBuku(db);
        frame.getjTable1().setModel(mb);
    }
    
    public void insert(){
        dataBuku db = new dataBuku();
        db.setJudul(frame.getJtJudu().getText());
        db.setPenulis(frame.getJtPenulis().getText());
        Double rating = Double.parseDouble(frame.getJtRating().getText());
        db.setRating(rating);
        Double harga = Double.parseDouble(frame.getJtHarga().getText());
        Double hargaAkhir = harga + 500 + (rating * 100);
        db.setHarga(hargaAkhir);
        Integer id = Integer.parseInt(frame.getJtId().getText());
        db.setId(id);
        implDataBuku.insert(db);
    }
    
    public void update(){
        dataBuku db = new dataBuku();
        db.setJudul(frame.getJtJudu().getText());
        db.setPenulis(frame.getJtPenulis().getText());
        Double rating = Double.parseDouble(frame.getJtRating().getText());
        db.setRating(rating);
        Double harga = Double.parseDouble(frame.getJtHarga().getText());
        Double hargaAkhir = harga + 500 + (rating * 100);
        db.setHarga(hargaAkhir);
        Integer id = Integer.parseInt(frame.getJtId().getText());
        db.setId(id);
        implDataBuku.update(db);
    }
    
    public void delete(){
        Integer id = Integer.parseInt(frame.getJtId().getText());
        implDataBuku.delete(id);
        
    }
}
