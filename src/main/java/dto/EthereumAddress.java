package dto;

import java.util.Objects;

public class EthereumAddress {

  private String ourAddress;

  public String getOurAddress() {
    return ourAddress;
  }

  public void setOurAddress(String ourAddress) {
    this.ourAddress = ourAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EthereumAddress that = (EthereumAddress) o;
    return Objects.equals(ourAddress, that.ourAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ourAddress);
  }

  @Override
  public String toString() {
    return "EthereumAddress{" +
        "ourAddress='" + ourAddress + '\'' +
        '}';
  }
}
