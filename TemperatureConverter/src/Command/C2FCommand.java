package Command;

import Model.Model;

public class C2FCommand extends Command {
   private double celsius;

   public C2FCommand(Model model, double c) {
      super(model);
      this.celsius = c;
   }

   @Override
   public void execute() {
      modelRemote.c2f(celsius);
   }
}
