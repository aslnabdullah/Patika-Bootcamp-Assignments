package Week7.PatikaClone.comPatikaDev.Model;

import Week7.PatikaClone.comPatikaDev.Helper.DBConnector;
import Week7.PatikaClone.comPatikaDev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private String title;
    private String description;
    private String link;
    private String language;

    private int user_id;

    public Content(int id, int user_id, String title, String description, String link, String language ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.language = language;
        this.user_id = User.getFetchId(user_id);
    }
    public Content(){

    }


    public static ArrayList<Content> getListByUser(int user_id) {
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content WHERE user_id = " + user_id);
            while (rs.next()) {
                int id = rs.getInt("id");
                int userID = rs.getInt("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String link = rs.getString("link");
                String language = rs.getString("language");

                obj = new Content(id, user_id,title,description,link,language);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }
    public static boolean add(int id, int user_id, String title, String description, String link, String language ){
        String query = "INSERT INTO content (id,user_id,title,description,link,language) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            pr.setInt(2,user_id);
            pr.setString(3,title);
            pr.setString(4,description);
            pr.setString(5,link);
            pr.setString(6,language);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static Content getFetch(int id){
        Content obj = null;
        String query = "SELECT * FROM content WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setTitle(rs.getString("title"));
                obj.setDescribtion(rs.getString("description"));
                obj.setLink(rs.getString("link"));
                obj.setLanguage(rs.getString("language"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean delete(int id){
        String query = "DELETE FROM content WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribtion() {
        return description;
    }

    public void setDescribtion(String describtion) {
        this.description = describtion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
