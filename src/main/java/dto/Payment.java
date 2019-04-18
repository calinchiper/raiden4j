package dto;

import java.util.Objects;

public class Payment {
  private final long amount;
  private final long identifier;

  public Payment(long amount, long identifier) {
    this.amount = amount;
    this.identifier = identifier;
  }

  public long getAmount() {
    return amount;
  }

  public long getIdentifier() {
    return identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return amount == payment.amount &&
        identifier == payment.identifier;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, identifier);
  }

  @Override
  public String toString() {
    return "Payment{" +
        "amount=" + amount +
        ", identifier=" + identifier +
        '}';
  }
}
