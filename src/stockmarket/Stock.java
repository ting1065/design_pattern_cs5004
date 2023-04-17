package stockmarket;

import java.util.ArrayList;

/**
 * a stock subject that can be observed by investors.
 */
public class Stock implements Subject {

  private ArrayList<Observer> observers;
  private float price;

  /**
   * a stock with a list of observers which is initially empty.
   */
  public Stock() {
    this.observers = new ArrayList<Observer>();
  }

  @Override public void registerObserver(Observer o) throws IllegalArgumentException {
    if (this.observers.contains(o)) {
      throw new IllegalArgumentException("this investor is already in the observer list");
    }
    observers.add(o);
  }

  @Override public void removeObserver(Observer o) throws IllegalArgumentException {
    if (!this.observers.contains(o)) {
      throw new IllegalArgumentException("no such investor in the list");
    }
    observers.remove(o);
  }

  @Override public void notifyObservers() {
    for (Observer o : observers) {
      o.update(this.price);
    }
  }

  @Override public void priceChanged() {
    notifyObservers();
  }

  @Override public void setPrice(float newPrice) {
    this.price = newPrice;
    priceChanged();
  }

}