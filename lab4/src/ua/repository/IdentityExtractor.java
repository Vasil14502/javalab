package ua.repository;

@FunctionalInterface
public interface IdentityExtractor<T> {
    String getIdentity(T obj);
}
