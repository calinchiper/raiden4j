package client;

import static utils.Unchecked.*;

import dto.ClosedState;
import dto.EthereumAddress;
import dto.IncreasedDeposit;
import dto.NewChannel;
import dto.Channel;
import dto.Payment;
import dto.PaymentResponse;
import http.RaidenService;
import utils.DependencyInjector;
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

  public EthereumAddress getEthAddress() {
    return execute(() -> raidenService.getEthereumAddress().execute().body());
  }

  public List<Channel> getUnsettledChannels() {
    return execute(() -> raidenService.getUnsettledChannels().execute().body());
  }

  public Channel openChannel(NewChannel newChannel) {
    return execute(() -> raidenService.openChannel(newChannel).execute().body());
  }

  public Channel closeChannel(String partnerAddress) {
    return execute(() ->
        raidenService.closeChannel(tokenNetworkAddress, partnerAddress, new ClosedState())
            .execute()
            .body()
    );
  }

  public Channel increaseDeposit(String partnerAddress, long increase) {
    return execute(() ->
        raidenService
            .increaseDeposit(tokenNetworkAddress, partnerAddress, new IncreasedDeposit(increase))
            .execute()
            .body()
    );
  }

  public PaymentResponse makePayment(String targetAddress, long channelIdentifier, long amount) {
    return execute(() ->
        raidenService
            .makePayment(tokenNetworkAddress, targetAddress, new Payment(amount, channelIdentifier))
            .execute()
            .body()
    );
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
      RaidenService raidenService = DependencyInjector
          .getRetrofit("http://" + ip + ":" + port + "/")
          .create(RaidenService.class);
      return new Raiden(this, raidenService);
    }
  }
}
