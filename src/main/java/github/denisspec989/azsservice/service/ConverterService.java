package github.denisspec989.azsservice.service;

public interface ConverterService<T> {
    public <V> T convert(V input);
}
