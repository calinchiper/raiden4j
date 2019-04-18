package dto;

import java.util.Objects;

public class PaymentResponse {

  private String initiatorAddress;
  private String targetAddress;
  private String tokenAddress;
  private long amount;
  private long identifier;

  public String getInitiatorAddress() {
    return initiatorAddress;
  }

  public void setInitiatorAddress(String initiatorAddress) {
    this.initiatorAddress = initiatorAddress;
  }

  public String getTargetAddress() {
    return targetAddress;
  }

  public void setTargetAddress(String targetAddress) {
    this.targetAddress = targetAddress;
  }

  public String getTokenAddress() {
    return tokenAddress;
  }

  public void setTokenAddress(String tokenAddress) {
    this.tokenAddress = tokenAddress;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public long getIdentifier() {
    return identifier;
  }

  public void setIdentifier(long identifier) {
    this.identifier = identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentResponse that = (PaymentResponse) o;
    return amount == that.amount &&
        identifier == that.identifier &&
        Objects.equals(initiatorAddress, that.initiatorAddress) &&
        Objects.equals(targetAddress, that.targetAddress) &&
        Objects.equals(tokenAddress, that.tokenAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiatorAddress, targetAddress, tokenAddress, amount, identifier);
  }
}
