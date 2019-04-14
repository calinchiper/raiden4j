package dto;

public class Channel {

  public String tokenNetworkIdentifier;
  public long channelIdentifier;
  public String partnerAddress;
  public String tokenAddress;
  public long balance;
  public long totalDeposit;
  public ChannelState state;
  public long settleTimeout;
  public long revealTimeout;
}
