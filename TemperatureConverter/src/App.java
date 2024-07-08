import Model.Model;
import View.View;
import Controller.Controller;
import ControlEnter.ControlEnter;

public class App {
    public static void main(String[] args) {
        // Khởi tạo Model
        Model modelRemote = new Model();

        // Khởi tạo Controller
        Controller controllerRemote = new Controller(null, modelRemote);

        // Khởi tạo ControlEnter
        ControlEnter controlEnterRemote = new ControlEnter(controllerRemote);

        // Khởi tạo View và truyền các đối tượng Model, Controller, ControlEnter vào
        View viewRemote = new View(modelRemote, controllerRemote, controlEnterRemote);

        // Cập nhật lại đối tượng Controller với View được khởi tạo
        controllerRemote.setViewRemote(viewRemote);
    }
}
