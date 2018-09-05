package app.service;

public interface ModelConverter<M, V> {

    V toView(M model);
}
