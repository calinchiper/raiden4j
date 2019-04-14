package utils;

@FunctionalInterface
public interface UncheckedWrapped<T> {

  T execute() throws Exception;
}

