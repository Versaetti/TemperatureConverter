package obsever;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
   private List<Subscriber> subscribers = new ArrayList<>();

   public void subscribe(Subscriber subscriber) {
      subscribers.add(subscriber);
   }

   public void unSubcriber(Subscriber subscriber) {
      subscribers.remove(subscriber);
   }

   public void notifyChangeCelsius() {
      for (Subscriber subscriber : subscribers) {
         subscriber.updateCelsius();
      }
   }

   public void notifyChangeFahrenheit() {
      for (Subscriber subscriber : subscribers) {
         subscriber.updateFahrenheit();
      }
   }
}
