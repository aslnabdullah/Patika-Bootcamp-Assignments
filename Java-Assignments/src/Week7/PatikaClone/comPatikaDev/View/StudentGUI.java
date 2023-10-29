package Week7.PatikaClone.comPatikaDev.View;

import Week7.PatikaClone.comPatikaDev.Helper.Config;
import Week7.PatikaClone.comPatikaDev.Helper.Helper;
import Week7.PatikaClone.comPatikaDev.Model.Course;
import Week7.PatikaClone.comPatikaDev.Model.Patika;
import Week7.PatikaClone.comPatikaDev.Model.StudenCourse;
import Week7.PatikaClone.comPatikaDev.Model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane pnl_student;
    private JPanel scroll_patika;
    private JTable tbl_student_patika;
    private JTable tbl_student_ownpatika;
    private JTextField fld_patika_add;
    private JButton btn_patika_add;
    private JPanel pnl_student_courses;
    private JTable tbl_student_courses;
    private JTextField fld_student_course_add;
    private JButton btn_student_course_add;

    private DefaultTableModel mdl_student_patika;
    private Object[] row_student_patika;

    private DefaultTableModel mdl_student_own_patika;
    private Object[] row_student_own_patika;

    private DefaultTableModel mdl_student_courses;
    private Object[] row_student_courses;

    public StudentGUI(){
        add(wrapper);
        setSize(500,400);
        setLocation(Helper.screenCenterPoint("x" , getSize()) , Helper.screenCenterPoint("y" , getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        mdl_student_patika = new DefaultTableModel();
        Object[] col_student_patika = {"ID" , "Patika Name"};
        mdl_student_patika.setColumnIdentifiers(col_student_patika);
        row_student_patika = new Object[col_student_patika.length];
        tbl_student_patika.setModel(mdl_student_patika);
        tbl_student_patika.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_student_patika.getTableHeader().setReorderingAllowed(false);
        loadStudentPatikaModel();

        mdl_student_own_patika = new DefaultTableModel();
        Object[] col_student_own_patika = {"ID" , "Patika Name"};
        mdl_student_own_patika.setColumnIdentifiers(col_student_own_patika);
        row_student_own_patika = new Object[col_student_own_patika.length];
        tbl_student_ownpatika.setModel(mdl_student_own_patika);
        tbl_student_ownpatika.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_student_ownpatika.getTableHeader().setReorderingAllowed(false);
        loadStudentOwnPatikaModel();

        mdl_student_courses = new DefaultTableModel();
        Object[] col_student_courses = {"Course ID" , "Patika ID" , "Course Name" , "Patika Name"};
        mdl_student_courses.setColumnIdentifiers(col_student_courses);
        row_student_courses = new Object[col_student_courses.length];
        tbl_student_courses.setModel(mdl_student_courses);
        tbl_student_courses.getColumnModel().getColumn(0).setMaxWidth(100);
        tbl_student_courses.getTableHeader().setReorderingAllowed(false);
        loadStudentCourses();


        btn_patika_add.addActionListener(e -> {
            if (fld_patika_add.getText().isEmpty()){
                Helper.showMessage("fill");
            }else {
                int ID = Integer.parseInt(fld_patika_add.getText());
                String name = String.valueOf(Patika.getFetch(ID));
                if (Student.add(ID , name)){
                    Helper.showMessage("done");
                    loadStudentOwnPatikaModel();
                    fld_patika_add.setText(null);
                }
                StudenCourse.addCourse(StudenCourse.getFetch(ID));
                loadStudentCourses();
            }
        });
    }

    private void loadStudentCourses() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_courses.getModel();
        clearModel.setRowCount(0);
        ArrayList<Course> courses = StudenCourse.getListFromCourse();
        if (courses.isEmpty()){
            Helper.showMessage("fill");
        }else {
            for (Course obj : courses){
                int i = 0;
                row_student_courses[i++] = obj.getId();
                row_student_courses[i++] = obj.getPatika_id();
                row_student_courses[i++] = obj.getName();
                row_student_courses[i++] = obj.getLang();
                mdl_student_courses.addRow(row_student_courses);
            }
        }

    }


    private void loadStudentOwnPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_ownpatika.getModel();
        clearModel.setRowCount(0);
        ArrayList<Patika> contentList = Student.getListByPatika();
        if (contentList.isEmpty()){
            //Helper.showMessage("fill");
        }else {
            for (Patika obj : contentList){
                int i = 0;
                row_student_own_patika[i++] = obj.getId();
                row_student_own_patika[i++] = obj.getName();
                mdl_student_own_patika.addRow(row_student_own_patika);
            }
        }
    }

    private void loadStudentPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student_patika.getModel();
        clearModel.setRowCount(0);
        ArrayList<Patika> contentList = Patika.getList();
        if (contentList.isEmpty()){
            Helper.showMessage("fill");
        }else {
            for (Patika obj : contentList){
                int i = 0;
                row_student_patika[i++] = obj.getId();
                row_student_patika[i++] = obj.getName();
                mdl_student_patika.addRow(row_student_patika);
            }
        }
    }
}
