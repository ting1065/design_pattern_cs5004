package stockmarket;

/**
 * The interface for the observers in our observer pattern design.
 */
public interface Observer {

  /**
   * update the new price of stock been observed.
   *
   * @param newPrice the current price of the stock.
   */
  void update(float newPrice);

  /**
   * return the name of the observer.
   *
   * @return the name of the observer.
   */
  String getName();

  /**
   * return the sell threshold of the observer.
   *
   * @return the sell threshold of the observer.
   */
  float getSellThreshold();

  /**
   * return the buy threshold of the observer.
   *
   * @return the buy threshold of the observer.
   */
  float getBuyThreshold();
}
