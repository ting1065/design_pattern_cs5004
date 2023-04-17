package stockmarket;

/**
 * investment strategy, can be BUY, SELL, or WAIT.
 */
public enum Strategy {
  BUY {
    @Override public String toString() {
      return "I wanna buy more!";
    }
  }, SELL {
    @Override public String toString() {
      return "I wanna sell all!";
    }
  }, WAIT {
    @Override public String toString() {
      return "I wanna wait and see!";
    }
  }
}
