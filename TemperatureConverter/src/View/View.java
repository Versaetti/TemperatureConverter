package View;

import javax.swing.*;
import obsever.Subscriber;
import Controller.Controller;
import Model.Model;
import ControlEnter.ControlEnter;

public class View extends JFrame implements Subscriber {
    //Khai báo thuộc tính cho thành phần giao diện : Title, Panel,...
    private String title;
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextCelsius, jTextFahrenheit;
    private JMenuBar menuBarRemote = null;
    private Controller controllerRemote; //Khai báo tham chiếu đến các đối tượng
    private Model modelRemote; // instance field
    private ControlEnter controlEnterRemote;

    public View(Model model, Controller controller, ControlEnter controlEnter) {
        this.modelRemote = model;
        this.controllerRemote = controller;
        this.controlEnterRemote = controlEnter;

        // Đăng ký View này làm Subscriber của Model
        model.subscribe(this);

        // Xây dựng menu và giao diện người dùng
        buildMenu();
        build();

        // Thêm JPanel vào JFrame (cửa sổ chính)
        add(jPanel);

        // Đặt tiêu đề và cấu hình cho cửa sổ chính
        title = "Chuyển đổi nhiệt độ";
        setSize(400, 100);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    // phương thức xây dựng giao diện
    public void build() {
        jPanel = new JPanel();
        jLabelCelsius = new JLabel("độ C");
        jTextCelsius = new JTextField(10);
        jLabelFahrenheit = new JLabel("Độ F");
        jTextFahrenheit = new JTextField(10);
        jTextCelsius.setText("0");
        jTextFahrenheit.setText("0");

        // Thêm ActionListener cho sự kiện Enter
        controlEnterRemote.addEnterKeyListener(jTextCelsius, "C-F");
        controlEnterRemote.addEnterKeyListener(jTextFahrenheit, "F-C");

        jPanel.add(jLabelCelsius);
        jPanel.add(jTextCelsius);
        jPanel.add(jLabelFahrenheit);
        jPanel.add(jTextFahrenheit);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        setJMenuBar(menuBarRemote);
        JMenu menu = new JMenu("Command");
        menuBarRemote.add(menu);
        JMenuItem f2c = new JMenuItem("F-C");
        JMenuItem c2f = new JMenuItem("C-F");
        JMenuItem exit = new JMenuItem("Exit");
        f2c.addActionListener(controllerRemote);
        c2f.addActionListener(controllerRemote);
        exit.addActionListener(controllerRemote);
        menu.add(f2c);
        menu.add(c2f);
        menu.add(exit);
    }

    public JTextField getjTextCelsius() {
        return jTextCelsius;
    }

    public JTextField getjTextFahrenheit() {
        return jTextFahrenheit;
    }

    //Phương thức cập nhật từ Subscriber:
    @Override
    public void updateFahrenheit() {
        double fahrenheit = modelRemote.getFahrenheit();
        jTextFahrenheit.setText(String.format("%.2f", fahrenheit));
    }

    @Override
    public void updateCelsius() {
        double celsius = modelRemote.getCelsius();
        jTextCelsius.setText(String.format("%.2f", celsius));
    }
//Phương thức hiển thị lỗi
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
