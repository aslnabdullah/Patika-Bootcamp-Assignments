package Week7.PatikaClone.comPatikaDev.View;

import Week7.PatikaClone.comPatikaDev.Helper.Config;
import Week7.PatikaClone.comPatikaDev.Helper.Helper;
import Week7.PatikaClone.comPatikaDev.Model.Operator;
import Week7.PatikaClone.comPatikaDev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wrapperTop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(500,400);
        setLocation(Helper.screenCenterPoint("x" , getSize()) , Helper.screenCenterPoint("y" , getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)){
                Helper.showMessage("fill");
            }else {
                User u = User.getFetch(fld_user_uname.getText() , fld_user_pass.getText());
                if (u == null){
                    Helper.showMessage("Kullanıcı Bulunamadı");
                }else {
                    switch (u.getType()){
                        case "operator":
                            OperatorGUI opGUI = new OperatorGUI((Operator) u);
                            break;
                        case"educator":
                            EducatorGUI edGUI = new EducatorGUI(u.getId());
                            break;
                        case "student":
                            StudentGUI stGUI = new StudentGUI();
                            break;
                    }
                    dispose();
                }
            }

        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login = new LoginGUI();

    }
}
