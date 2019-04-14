package utils;

public class Unchecked {

  public static <T> T execute(UncheckedWrapped<T> uncheckedWrapped) {
    try {
      return uncheckedWrapped.execute();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
