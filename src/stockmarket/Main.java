package stockmarket;

/**
 * try out observer pattern design.
 */
public class Main {

  /**
   * initialize a stock, try adding and moving investors, try changing the prices in different ways
   * watch if the program works as expected.
   *
   * @param args no argument in this case.
   */
  public static void main(String[] args) {

    //initialize a stock.
    Subject stock = new Stock();
    System.out.println("\n\n--------\ncreated a stock\n--------\n\n");

    //add three investors.
    Observer yang = new Investor("Yang Li", 10, 20);
    stock.registerObserver(yang);
    System.out.printf(
        "\n\n--------\nAdded %s, who would sell over %.1f,"
            + " buy under %.1f, otherwise wait and see.\n--------\n\n",
        yang.getName(), yang.getSellThreshold(), yang.getBuyThreshold());
    Observer yunke = new Investor("Yunke Li", 15, 25);
    stock.registerObserver(yunke);
    System.out.printf(
        "\n\n--------\nAdded %s, who would sell over %.1f,"
            + " buy under %.1f, otherwise wait and see.\n--------\n\n",
        yunke.getName(), yunke.getSellThreshold(), yunke.getBuyThreshold());
    Observer ting = new Investor("Fengting Tang", 20, 30);
    stock.registerObserver(ting);
    System.out.printf(
        "\n\n--------\nAdded %s, who would sell over %.1f,"
            + " buy under %.1f, otherwise wait and see.\n--------\n\n",
        ting.getName(), ting.getSellThreshold(), ting.getBuyThreshold());

    //set price at 5.
    System.out.println("\n\n--------\nset stock price at 5\n--------\n\n");
    stock.setPrice(5);

    //set price at 12.
    System.out.println("\n\n--------\nset stock price at 12\n--------\n\n");
    stock.setPrice(12);

    //set price at 18.
    System.out.println("\n\n--------\nset stock price at 18\n--------\n\n");
    stock.setPrice(18);

    //set price at 28.
    System.out.println("\n\n--------\nset stock price at 28\n--------\n\n");
    stock.setPrice(28);

    //set price at 31.
    System.out.println("\n\n--------\nset stock price at 31\n--------\n\n");
    stock.setPrice(31);

    //add another investor.
    Observer yifan = new Investor("Yifan Pan", 25, 35);
    stock.registerObserver(yifan);
    System.out.printf(
        "\n\n--------\nAdded %s, who would sell over %.1f,"
            + " buy under %.1f, otherwise wait and see.\n--------\n\n",
        yifan.getName(), yifan.getSellThreshold(), yifan.getBuyThreshold());

    //set price at 34.
    System.out.println("\n\n--------\nset stock price at 34\n--------\n\n");
    stock.setPrice(34);

    //set price at 40.
    System.out.println("\n\n--------\nset stock price at 50\n--------\n\n");
    stock.setPrice(40);

    //remove an investor.
    stock.removeObserver(ting);
    System.out.printf("\n\n--------\nRemoved %s.\n--------\n\n", ting.getName());

    //set price at 45.
    System.out.println("\n\n--------\nset stock price at 45\n--------\n\n");
    stock.setPrice(45);

    //set price at 22.
    System.out.println("\n\n--------\nset stock price at 22\n--------\n\n");
    stock.setPrice(22);

    //end.
    System.out.println("\n\n--------\nthe end\n--------\n\n");
  }

}