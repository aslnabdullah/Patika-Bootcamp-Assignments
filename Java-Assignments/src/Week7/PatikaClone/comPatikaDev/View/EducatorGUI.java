package Week7.PatikaClone.comPatikaDev.View;

import Week7.PatikaClone.comPatikaDev.Helper.Config;
import Week7.PatikaClone.comPatikaDev.Helper.Helper;
import Week7.PatikaClone.comPatikaDev.Helper.Item;
import Week7.PatikaClone.comPatikaDev.Model.Content;
import Week7.PatikaClone.comPatikaDev.Model.Course;
import Week7.PatikaClone.comPatikaDev.Model.Patika;
import Week7.PatikaClone.comPatikaDev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wrapper_top;
    private JButton exitButton;
    private JTabbedPane Educator_pane;
    private JPanel pnl_educator_courses;
    private JPanel pnl_educator_contents;
    private JPanel pnl_educator_quiz;
    private JTable tbl_educator_courses;
    private JTable tbl_content_list;
    private JTextField fld_content_title_add;
    private JLabel tbl_content_title_add;
    private JTextField fld_content_desc_add;
    private JLabel tbl_content_desc_add;
    private JTextField fld_content_link_add;
    private JLabel tbl_content_link_add;
    private JComboBox cmb_content_lang;
    private JLabel tbl_content_lang_add;
    private JButton submitButton;
    private DefaultTableModel mdl_educator_list;
    private Object[] row_educator_list;
    private int user_id;
    private int id;

    private DefaultTableModel mdl_content_list;

    private Object[] row_content;

    public EducatorGUI(int user_id){
        this.user_id = user_id;
        add(wrapper);
        setSize(1100,500);
        setLocation(Helper.screenCenterPoint("x" , getSize()) , Helper.screenCenterPoint("y" , getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        exitButton.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });

        mdl_educator_list = new DefaultTableModel();
        Object[] col_coursesInfo = {"ID", "Course Name" , "Course Language"};
        mdl_educator_list.setColumnIdentifiers(col_coursesInfo);
        row_educator_list = new Object[col_coursesInfo.length];
        tbl_educator_courses.setModel(mdl_educator_list);
        tbl_educator_courses.getColumnModel().getColumn(0).setMaxWidth(200);
        tbl_educator_courses.getTableHeader().setReorderingAllowed(false);
        loadCourseModel();


        mdl_content_list = new DefaultTableModel();
        Object[] col_content = {"ID", "Content Language" , "Content Title" , "Content Description" , "Content Link"};
        mdl_content_list.setColumnIdentifiers(col_content);
        row_content = new Object[col_content.length];
        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.getColumnModel().getColumn(0).setMaxWidth(60);
        tbl_content_list.getColumnModel().getColumn(1).setMaxWidth(150);
        tbl_content_list.getColumnModel().getColumn(2).setMaxWidth(150);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);
        loadContentModel();
        loadContentCombo();

        submitButton.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_content_desc_add) || Helper.isFieldEmpty(fld_content_link_add) || Helper.isFieldEmpty(fld_content_title_add)){
                Helper.showMessage("fill");
            }else {
                String title = fld_content_title_add.getText();
                String description = fld_content_desc_add.getText();
                String link = fld_content_link_add.getText();
                String language = cmb_content_lang.getSelectedItem().toString();
                if (Content.add(id,user_id,title,description,link,language)){
                    Helper.showMessage("done");
                    loadContentCombo();
                    loadContentModel();
                    fld_content_title_add.setText(null);
                    fld_content_desc_add.setText(null);
                    fld_content_link_add.setText(null);
                }
            }
        });
    }

    private void loadContentCombo() {
        cmb_content_lang.removeAllItems();
        for (Course obj : Course.getListByUser(user_id)){
            cmb_content_lang.addItem(new Item(obj.getId() , obj.getLang()));
        }
    }

    private void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Content obj : Content.getListByUser(user_id)){
            i = 0;
            row_content[i++] = obj.getId();
            row_content[i++] = obj.getLanguage();
            row_content[i++] = obj.getTitle();
            row_content[i++] = obj.getDescribtion();
            row_content[i++] = obj.getLink();
            mdl_content_list.addRow(row_content);
        }
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_courses.getModel();
        clearModel.setRowCount(0);

        int i = 0;
        for (Course obj : Course.getListByUser(user_id)){
            i = 0;
            row_educator_list[i++] = obj.getId();
            row_educator_list[i++] = obj.getName();
            row_educator_list[i++] = obj.getLang();
            mdl_educator_list.addRow(row_educator_list);
        }
    }
}
