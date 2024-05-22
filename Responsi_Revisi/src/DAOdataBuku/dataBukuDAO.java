/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataBuku;

import DAOimplement.dataBukuImplement;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab Informatika
 */
public class dataBukuDAO implements dataBukuImplement{
    Connection connection;
    
    final String select = "SELECT * from buku";
    final String insert = "INSERT INTO buku (judul, penulis, rating, harga, id) VALUES (?, ?, ?, ?, NULL)";
    final String update = "UPDATE buku SET judul=?, penulis=?, rating=?, harga=? WHERE buku.id=?";
    final String delete = "DELETE from buku WHERE id=?";
    
    
    public dataBukuDAO(){
        connection = Connector.connection();
    }

    @Override
    public void insert(dataBuku b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.setString(2, b.getPenulis());
            statement.setDouble(3, b.getRating());
            statement.setDouble(4, b.getHarga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
//            while(rs.next()){
//                b.setId(rs.getInt(5));
//            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataBuku b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.setString(2, b.getPenulis());
            statement.setDouble(3, b.getRating());
            statement.setDouble(4, b.getHarga());
            statement.setInt(5, b.getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setId(rs.getInt(5));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public List<dataBuku> getAll() {
        List<dataBuku> db = null;
        try{
            db = new ArrayList<dataBuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataBuku buku = new dataBuku();
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setRating(rs.getDouble("rating"));
                buku.setHarga(rs.getDouble("harga"));
                buku.setId(rs.getInt("id"));
                db.add(buku);
            }
        }catch(SQLException ex){
            Logger.getLogger(dataBukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
}
