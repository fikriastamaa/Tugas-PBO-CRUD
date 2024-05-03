/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatabuku;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.databukuimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fikri
 */
public class databukuDAO implements databukuimplement {
    Connection connection;
    
    final String select = "select * from databuku;";
    final String insert = "INSERT INTO databuku (judul, genre, penulis, penerbit, lokasi, stok) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "update databuku set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stok=? where id=?";
    final String delete = "delete from databuku where id=?";
    public databukuDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(databuku p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setString(6, p.getStok());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
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
    public void update(databuku p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setString(6, p.getStok());
            statement.setInt(7, p.getId());
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
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
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
    public List<databuku> getAll() {
        List<databuku> db = null;
        try {
            db = new ArrayList<databuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                databuku bk = new databuku();
                bk.setId(rs.getInt("id"));
                bk.setJudul(rs.getString("judul"));
                bk.setGenre(rs.getString("genre"));
                bk.setPenulis(rs.getString("penulis"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setLokasi(rs.getString("lokasi"));
                bk.setStok(rs.getString("stok"));
                db.add(bk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(databukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
}
