package iterator;

public interface Iterator<E> {
    boolean hasMore();
    E getNext();
}
