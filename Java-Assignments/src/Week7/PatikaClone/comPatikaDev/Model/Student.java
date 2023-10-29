package Week7.PatikaClone.comPatikaDev.Model;

import Week7.PatikaClone.comPatikaDev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student extends User {
    public Student(){

    }
    public Student(int id, String name, String uname, String pass, String type) {
        super(id, name, uname, pass, type);
    }

    public static ArrayList<Patika> getListByPatika(){
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ownpatika");
            while (rs.next()){
                obj = new Patika(rs.getInt("patika_id") , rs.getString("name"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return patikaList;
    }
    public static boolean add(int id , String name){
        String query = "INSERT INTO ownpatika (patika_id,name) VALUES (?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            pr.setString(2,name);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}


