package dto;

import java.util.Objects;

public class IncreasedDeposit {

  private final long totalDeposit;

  public IncreasedDeposit(long totalDeposit) {
    this.totalDeposit = totalDeposit;
  }

  public long getTotalDeposit() {
    return totalDeposit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncreasedDeposit that = (IncreasedDeposit) o;
    return totalDeposit == that.totalDeposit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalDeposit);
  }

  @Override
  public String toString() {
    return "IncreasedDeposit{" +
        "totalDeposit=" + totalDeposit +
        '}';
  }
}
