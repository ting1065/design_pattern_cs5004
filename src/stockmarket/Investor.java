package stockmarket;

import java.util.Objects;

/**
 * an investor who want to buy if the observed stock price is lower than his/her buyThreshold, sell
 * if the price is higher than his/her sellThreshold, wait and see if the price is between these two
 * thresholds.
 */
public class Investor implements Observer, DisplayElement {

  private final String name;
  private final float buyThreshold;
  private final float sellThreshold;
  private Strategy strategy;

  /**
   * an investor that has a name, sellThreshold, and buyThreshold.
   *
   * @param name          the name of the investor.
   * @param sellThreshold the price threshold that urges the investor to sell.
   * @param buyThreshold  the price threshold that urges the investor to buy.
   * @throws IllegalArgumentException if passed sellThreshold is lower than the buyThreshold.
   */
  public Investor(String name, float buyThreshold, float sellThreshold)
      throws IllegalArgumentException {
    if (sellThreshold <= buyThreshold) {
      throw new IllegalArgumentException(
          "investor's sellThreshold must be higher than buyThreshold");
    }
    this.name = name;
    this.buyThreshold = buyThreshold;
    this.sellThreshold = sellThreshold;
  }

  @Override public void update(float newPrice) {
    if (newPrice > sellThreshold) {
      this.strategy = Strategy.SELL;
    } else if (newPrice < buyThreshold) {
      this.strategy = Strategy.BUY;
    } else {
      this.strategy = Strategy.WAIT;
    }

    this.display();
  }

  @Override public String getName() {
    return name;
  }

  @Override public float getSellThreshold() {
    return sellThreshold;
  }

  @Override public float getBuyThreshold() {
    return buyThreshold;
  }

  @Override public void display() {
    System.out.println(this.name + ": " + this.strategy);
  }

  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Investor)) {
      return false;
    }
    Observer other = (Observer) o;
    return this.name.equals(other.getName());
  }

  @Override public int hashCode() {
    return Objects.hash(name);
  }
}
