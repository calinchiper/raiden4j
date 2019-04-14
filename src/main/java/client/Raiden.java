package client;

import dto.ClosedState;
import dto.EthereumAddress;
import dto.IncreasedDeposit;
import dto.NewChannel;
import dto.Channel;
import dto.Payment;
import dto.PaymentResponse;
import http.RaidenService;
import rx.Observable;
import utils.DIContainer;
import java.util.List;

public class Raiden {

  private final String ip;
  private final int port;
  private final String tokenNetworkAddress;

  private final RaidenService raidenService;

  private Raiden(Builder builder, RaidenService raidenService) {
    this.ip = builder.ip;
    this.port = builder.port;
    this.tokenNetworkAddress = builder.tokenNetworkAddress;
    this.raidenService = raidenService;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  public String getTokenNetworkAddress() {
    return tokenNetworkAddress;
  }

  public Observable<EthereumAddress> getEthAddress() {
    return raidenService.getEthereumAddress();
  }

  public Observable<List<Channel>> getUnsettledChannels() {
    return raidenService.getUnsettledChannels();
  }

  public Observable<Channel> openChannel(NewChannel newChannel) {
    return raidenService.openChannel(newChannel);
  }

  public Observable<Channel> closeChannel(String partnerAddress) {
    return raidenService.closeChannel(tokenNetworkAddress, partnerAddress, new ClosedState());
  }

  public Observable<Channel> increaseDeposit(String partnerAddress, long increase) {
    IncreasedDeposit increasedDeposit = new IncreasedDeposit(increase);
    return raidenService.increaseDeposit(tokenNetworkAddress, partnerAddress, increasedDeposit);
  }

  public Observable<PaymentResponse> makePayment(
      String targetAddress,
      long channelIdentifier,
      long amount) {

    Payment payment = new Payment(amount, channelIdentifier);
    return raidenService.makePayment(tokenNetworkAddress, targetAddress, payment);
  }

  public static final class Builder {

    private String ip;
    private int port;
    private String tokenNetworkAddress;

    public Builder ip(String ip) {
      this.ip = ip;
      return this;
    }

    public Builder port(int port) {
      this.port = port;
      return this;
    }

    public Builder tokenNetworkAddress(String tokenNetworkAddress) {
      this.tokenNetworkAddress = tokenNetworkAddress;
      return this;
    }

    public Raiden build() {
      String baseUrl = "http://" + ip + ":" + port + "/";
      return new Raiden(this, DIContainer.raidenService(baseUrl));
    }
  }
}
