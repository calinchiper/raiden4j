package client;

import dto.ClosedState;
import dto.EthereumAddress;
import dto.IncreasedDeposit;
import model.Channel;
import dto.Payment;
import dto.PaymentResponse;
import io.reactivex.Observable;
import java.net.URL;
import di.DIContainer;
import java.util.List;

public class Raiden {

  private final String tokenNetworkAddress;
  private final RaidenService raidenService;

  private Raiden(String tokenNetworkAddress, RaidenService raidenService) {
    this.tokenNetworkAddress = tokenNetworkAddress;
    this.raidenService = raidenService;
  }

  public static Raiden of(URL url, String tokenNetworkAddress) {
    RaidenService raidenService = DIContainer.raidenService(url.toExternalForm());
    return new Raiden(tokenNetworkAddress, raidenService);
  }

  public String getTokenNetworkAddress() {
    return tokenNetworkAddress;
  }

  public Observable<EthereumAddress> getEthereumAddress() {
    return raidenService.getEthereumAddress();
  }

  public Observable<List<Channel>> getUnsettledChannels() {
    return raidenService.getUnsettledChannels();
  }

  public Observable<Channel> getPartnerChannel(String partnerAddress) {
    return raidenService.getPartnerChannel(tokenNetworkAddress, partnerAddress);
  }

  public Observable<Channel> openChannel(Channel newChannel) {
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

}
