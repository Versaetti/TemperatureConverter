package Command;

import Model.Model;
import javax.swing.JFrame;

public class ExitCommand extends Command {
   private JFrame frameRemote;

   public ExitCommand(Model model, JFrame jFrame) {
      super(model);
      this.frameRemote = jFrame;
   }

   @Override
   public void execute() {
      frameRemote.dispose();
   }
}
