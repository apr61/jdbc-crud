package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    public int addTruck(Truck truck){
        String query = "insert into truck (name, model, capacity, driver_name) values (?, ?, ?, ?)";
        int res = 0;
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, truck.getName());
            ps.setString(2, truck.getModel());
            ps.setInt(3, truck.getCapacity());
            ps.setString(4, truck.getDriverName());

            res = ps.executeUpdate();
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return res;
    }

    public Truck getTruckById(int id){
        Truck t = new Truck();
        String query = "select * from truck where id = ?";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs =  ps.executeQuery();

            while(rs.next()){
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setModel(rs.getString("model"));
                t.setCapacity(rs.getInt("capacity"));
                t.setDriverName(rs.getString("driver_name"));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    public List<Truck> getAllTrucks(){
        String query = "select * from truck";
        List<Truck> trucks = new ArrayList<>();
        try {
            Connection connection = ConnectionDetails.getConnection();
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                Truck t = new Truck();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setModel(rs.getString("model"));
                t.setCapacity(rs.getInt("capacity"));
                t.setDriverName(rs.getString("driver_name"));
                trucks.add(t);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public int deleteTruck(int id){
        int res = 0;
        String query = "delete from truck where id = ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            res = ps.executeUpdate();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public int updateTruck(Truck truck, int id){
        String query = "update truck set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
        int res = 0;
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, truck.getName());
            ps.setString(2, truck.getModel());
            ps.setInt(3, truck.getCapacity());
            ps.setString(4, truck.getDriverName());
            ps.setInt(5, id);

            res = ps.executeUpdate();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
