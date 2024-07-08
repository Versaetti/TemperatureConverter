package Command;

import Model.Model;

public class F2CCommand extends Command {
   private double fahrenheit;

   public F2CCommand(Model model, double f) {
      super(model);
      this.fahrenheit = f;
   }

   @Override
   public void execute() {
      modelRemote.f2c(fahrenheit);
   }
}
