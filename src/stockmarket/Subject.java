package stockmarket;

/**
 * The interface for the subject in our observer pattern design.
 */
public interface Subject {

  /**
   * register an Observer object as an observer of this subject.
   *
   * @param o the observer to be registered.
   * @throws IllegalArgumentException if the observer is already in the list.
   */
  void registerObserver(Observer o) throws IllegalArgumentException;

  /**
   * remove an observer from the subject's observer list.
   *
   * @param o the observer to be removed.
   * @throws IllegalArgumentException if there is no such observer in the list.
   */
  void removeObserver(Observer o) throws IllegalArgumentException;

  /**
   * notify the observers when the subject's state has changed.
   */
  void notifyObservers();

  /**
   * operations when the price is changed.
   */
  void priceChanged();

  /**
   * set the new price of the stock.
   *
   * @param newPrice the new price.
   */
  void setPrice(float newPrice);

}
