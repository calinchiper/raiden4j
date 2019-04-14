package http;

import dto.ClosedState;
import dto.EthereumAddress;
import dto.IncreasedDeposit;
import dto.NewChannel;
import dto.Channel;
import dto.Payment;
import dto.PaymentResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface RaidenService {

  @GET("api/v1/address")
  Observable<EthereumAddress> getEthereumAddress();

  @GET("api/v1/channels")
  Observable<List<Channel>> getUnsettledChannels();

  @PUT("api/v1/channels")
  Observable<Channel> openChannel(@Body NewChannel newChannel);

  @PATCH("api/v1/channels/{tokenAddress}/{partnerAddress}")
  Observable<Channel> closeChannel(
      @Path("tokenAddress") String tokenAddress,
      @Path("partnerAddress") String partnerAddress,
      @Body ClosedState closedState
  );

  @PATCH("api/v1/channels/{tokenAddress}/{partnerAddress}")
  Observable<Channel> increaseDeposit(
      @Path("tokenAddress") String tokenAddress,
      @Path("partnerAddress") String partnerAddress,
      @Body IncreasedDeposit increasedDeposit
  );

  @POST("api/v1/payments/{tokenAddress}/{targetAddress}")
  Observable<PaymentResponse> makePayment(
      @Path("tokenAddress") String tokenAddress,
      @Path("targetAddress") String targetAddress,
      @Body Payment payment
  );

}
