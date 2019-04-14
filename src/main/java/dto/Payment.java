package dto;

public class Payment {
  public final long amount;
  public final long identifier;

  public Payment(long amount, long identifier) {
    this.amount = amount;
    this.identifier = identifier;
  }
}
