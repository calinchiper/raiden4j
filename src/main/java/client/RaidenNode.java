package client;

import dto.ClosedState;
import dto.EthereumAddress;
import dto.IncreasedDeposit;
import model.Channel;
import dto.Payment;
import dto.PaymentResponse;
import io.reactivex.Observable;
import java.net.URL;
import java.util.List;

public class RaidenNode {

  private final String tokenNetworkAddress;
  private final RaidenService raidenService;

  private RaidenNode(String tokenNetworkAddress, RaidenService raidenService) {
    this.tokenNetworkAddress = tokenNetworkAddress;
    this.raidenService = raidenService;
  }

  public static RaidenNode of(URL url, String tokenNetworkAddress) {
    RaidenService raidenService = ServiceRegistry.raidenService(url.toExternalForm());
    return new RaidenNode(tokenNetworkAddress, raidenService);
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
    newChannel.setTokenAddress(tokenNetworkAddress);
    return raidenService.openChannel(newChannel);
  }

  public Observable<Channel> closeChannel(String partnerAddress) {
    return raidenService.closeChannel(tokenNetworkAddress, partnerAddress, new ClosedState());
  }

  public Observable<Channel> increaseDeposit(String partnerAddress, long increase) {
    final IncreasedDeposit increasedDeposit = new IncreasedDeposit(increase);
    return raidenService.increaseDeposit(tokenNetworkAddress, partnerAddress, increasedDeposit);
  }

  public Observable<PaymentResponse> makePayment(
      String targetAddress,
      long channelIdentifier,
      long amount) {

    final Payment payment = new Payment(amount, channelIdentifier);
    return raidenService.makePayment(tokenNetworkAddress, targetAddress, payment);
  }

}
