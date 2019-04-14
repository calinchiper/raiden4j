import client.Raiden;

public class Main {

  public static void main(String[] args) {
    Raiden raiden = new Raiden.Builder()
        .ip("192.168.100.39")
        .port(5001)
        .tokenNetworkAddress("0x2DaFcbeA14407A2382cb3d75536d1c51804f6f39")
        .build();

    raiden.getEthAddress().subscribe(addr -> System.out.println(addr.ourAddress));

  }
}
