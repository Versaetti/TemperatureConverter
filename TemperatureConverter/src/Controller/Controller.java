package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Command.Command;
import Command.C2FCommand;
import Command.F2CCommand;
import Command.ExitCommand;
import Command.CommandProcessor;

import Model.Model;
import View.View;

public class Controller implements ActionListener {
    private CommandProcessor commandProcessorRemote;
    private Model modelRemote;
    private View viewRemote;// instance field

    public Controller(View view, Model model) {
        this.commandProcessorRemote = CommandProcessor.makeCommandProcessor();
        this.modelRemote = model;
        this.viewRemote = view;
    }

    public void setViewRemote(View view) {
        this.viewRemote = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // chuyển đổi giá trị được nhập từ textfield sang double
            double celsius = Double.parseDouble(viewRemote.getjTextCelsius().getText());
            double fahrenheit = Double.parseDouble(viewRemote.getjTextFahrenheit().getText());
            Command command = null;
            String actionCommand = e.getActionCommand(); //Lấy tên của hành động (command) từ sự kiện (ActionEvent)
                                                        // mà người dùng đã thực hiện (e.getActionCommand()).

            // sử dụng Switch case để phân loại hành động
            switch (actionCommand) {
                case "C-F" -> {
                    // Tạo một đối tượng C2FCommand
                    command = new C2FCommand(modelRemote, celsius);
                    // Thực thi lệnh này bằng cách gọi commandProcessorRemote.execute(command)
                    commandProcessorRemote.execute(command);
                }
                case "F-C" -> {
                    command = new F2CCommand(modelRemote, fahrenheit);
                    commandProcessorRemote.execute(command);
                }
                case "Exit" -> {
                    command = new ExitCommand(modelRemote, viewRemote);
                    commandProcessorRemote.execute(command);
                }
            }
        } catch (NumberFormatException ex) {
            viewRemote.showError("Invalid input. Please enter a number.");
        }
    }
}
