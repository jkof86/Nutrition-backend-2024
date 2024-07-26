package com.revature.dao;

import com.revature.model.*;
import com.revature.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class FoodDAOImp implements FoodDAO {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Food getFood(int id) {
        conn = JDBCConnection.getConnection();

        String sql = "SELECT * FROM foods WHERE f_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return createFood(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Food addFood(Food f) {
        conn = JDBCConnection.getConnection();

        String sql = "INSERT INTO foods VALUES (DEFAULT,?,true,?,?,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, f.getName());
            ps.setInt(2, f.getQuantity());
            ps.setInt(3, f.getCalories());
            ps.setFloat(4, f.getProtein());
            ps.setFloat(5, f.getCarbs());
            ps.setFloat(6, f.getFat());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return createFood(rs);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeFood(int id) {
        conn = JDBCConnection.getConnection();

        String sql = "DELETE FROM foods WHERE f_id = ? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //for testing purposes
                System.out.println("Removed...");

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Food updateFood(Food f) {

        conn = JDBCConnection.getConnection();

        String sql = "UPDATE foods set name=?,quantity=?,calories=?,protein=?,carbs=?,fat=? WHERE f_id=? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, f.getName());
            ps.setInt(2, f.getQuantity());
            ps.setInt(3, f.getCalories());
            ps.setFloat(4, f.getProtein());
            ps.setFloat(5, f.getCarbs());
            ps.setFloat(6, f.getFat());
            ps.setInt(7, f.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return createFood(rs);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        String sql = "SELECT * from foods";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Food> fList = new ArrayList<>();

            while(rs.next()) {
                fList.add(createFood(rs));
            }

            return fList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //-------------------------------------------

    //Helper Method
    private Food createFood(ResultSet rs) throws SQLException {
        Food f = new Food();
        f.setId(rs.getInt("f_id"));
        f.setName(rs.getString("name"));
        f.setQuantity(rs.getInt("quantity"));
        f.setCalories(rs.getInt("calories"));
        f.setProtein(rs.getInt("protein"));
        f.setCarbs(rs.getInt("carbs"));
        f.setFat(rs.getInt("fat"));
        f.setAvailable(rs.getBoolean("available"));

        return f;
    }
}
