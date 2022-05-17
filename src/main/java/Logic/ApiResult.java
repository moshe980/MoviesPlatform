package Logic;

public interface ApiResult<T,E> {
    void onResult(T data,E exception);
}
