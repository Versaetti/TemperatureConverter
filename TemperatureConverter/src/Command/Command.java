package Command;

import Model.Model;

public abstract class Command {
   protected Model modelRemote;

   public Command(Model model) {
      this.modelRemote = model;
   }

   public abstract void execute();
}
