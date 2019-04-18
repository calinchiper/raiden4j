package model;

import java.util.Objects;

public class Channel {

  private String tokenNetworkIdentifier;
  private int channelIdentifier;
  private String partnerAddress;
  private String tokenAddress;
  private long balance;
  private long totalDeposit;
  private ChannelState state;
  private int settleTimeout;
  private int revealTimeout;

  public Channel() {
  }

  public Channel(String partnerAddress, String tokenAddress, long totalDeposit, int settleTimeout) {
    this.partnerAddress = partnerAddress;
    this.tokenAddress = tokenAddress;
    this.totalDeposit = totalDeposit;
    this.settleTimeout = settleTimeout;
  }

  public String getTokenNetworkIdentifier() {
    return tokenNetworkIdentifier;
  }

  public void setTokenNetworkIdentifier(String tokenNetworkIdentifier) {
    this.tokenNetworkIdentifier = tokenNetworkIdentifier;
  }

  public int getChannelIdentifier() {
    return channelIdentifier;
  }

  public void setChannelIdentifier(int channelIdentifier) {
    this.channelIdentifier = channelIdentifier;
  }

  public String getPartnerAddress() {
    return partnerAddress;
  }

  public void setPartnerAddress(String partnerAddress) {
    this.partnerAddress = partnerAddress;
  }

  public String getTokenAddress() {
    return tokenAddress;
  }

  public void setTokenAddress(String tokenAddress) {
    this.tokenAddress = tokenAddress;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  public long getTotalDeposit() {
    return totalDeposit;
  }

  public void setTotalDeposit(long totalDeposit) {
    this.totalDeposit = totalDeposit;
  }

  public ChannelState getState() {
    return state;
  }

  public void setState(ChannelState state) {
    this.state = state;
  }

  public int getSettleTimeout() {
    return settleTimeout;
  }

  public void setSettleTimeout(int settleTimeout) {
    this.settleTimeout = settleTimeout;
  }

  public int getRevealTimeout() {
    return revealTimeout;
  }

  public void setRevealTimeout(int revealTimeout) {
    this.revealTimeout = revealTimeout;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Channel channel = (Channel) o;
    return channelIdentifier == channel.channelIdentifier &&
        balance == channel.balance &&
        totalDeposit == channel.totalDeposit &&
        settleTimeout == channel.settleTimeout &&
        revealTimeout == channel.revealTimeout &&
        Objects.equals(tokenNetworkIdentifier, channel.tokenNetworkIdentifier) &&
        Objects.equals(partnerAddress, channel.partnerAddress) &&
        Objects.equals(tokenAddress, channel.tokenAddress) &&
        state == channel.state;
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(tokenNetworkIdentifier, channelIdentifier, partnerAddress, tokenAddress, balance,
            totalDeposit, state, settleTimeout, revealTimeout);
  }

  @Override
  public String toString() {
    return "Channel{" +
        "tokenNetworkIdentifier='" + tokenNetworkIdentifier + '\'' +
        ", channelIdentifier=" + channelIdentifier +
        ", partnerAddress='" + partnerAddress + '\'' +
        ", tokenAddress='" + tokenAddress + '\'' +
        ", balance=" + balance +
        ", totalDeposit=" + totalDeposit +
        ", state=" + state +
        ", settleTimeout=" + settleTimeout +
        ", revealTimeout=" + revealTimeout +
        '}';
  }
}
