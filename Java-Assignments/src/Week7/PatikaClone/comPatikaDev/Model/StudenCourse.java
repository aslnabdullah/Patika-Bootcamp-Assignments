package Week7.PatikaClone.comPatikaDev.Model;

import Week7.PatikaClone.comPatikaDev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudenCourse {
    private int course_id;
    private static int patika_id;
    private String course_name;
    private String patika_name;

    public StudenCourse(int course_id, int patika_id, String course_name, String patika_name) {
        this.course_id = course_id;
        StudenCourse.patika_id = patika_id;
        this.course_name = course_name;
        this.patika_name = patika_name;
    }

    public static ArrayList<Course> getListFromCourse() {
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patika_course");
            while (rs.next()) {
                int course_id = rs.getInt("course_id");
                int patika_id = rs.getInt("patika_id");
                String course_name = rs.getString("course_name");
                String patika_name = rs.getString("patika_name");

                obj = new Course(course_id,patika_id,course_name,patika_name);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }
    public static boolean addCourse(Course course){
        String query = "INSERT INTO patika_course (course_id,patika_id,course_name,patika_name) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,course.getId());
            pr.setInt(2,course.getPatika_id());
            pr.setString(3,course.getName());
            pr.setString(4,course.getLang());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static Course getFetch(int patika_id){
        Course obj = null;
        String query = "SELECT * FROM course WHERE patika_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,patika_id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Course(rs.getInt("id"),rs.getInt("patika_id"),rs.getString("name") , rs.getString("lang"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getPatika_name() {
        return patika_name;
    }

    public void setPatika_name(String patika_name) {
        this.patika_name = patika_name;
    }
}
