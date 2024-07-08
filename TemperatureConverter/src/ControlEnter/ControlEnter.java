package ControlEnter;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller; //khai báo tham chiếu đến tối tượng Con


public class ControlEnter {
    private Controller controllerRemote;

    public ControlEnter(Controller controller) {
        this.controllerRemote = controller;
    }

    public void addEnterKeyListener(JTextField textField, String command) {

        textField.addActionListener(new ActionListener() {
            @Override
            // tạo mới actionEvent gửi tới controller gồm 
            public void actionPerformed(ActionEvent e) {
                controllerRemote.actionPerformed(new ActionEvent(textField, ActionEvent.ACTION_PERFORMED, command));
            }
        });
    }
}
