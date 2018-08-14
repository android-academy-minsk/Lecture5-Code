package androidacademy.minsk.networking.data;

public class SimpleNetworkCallback<T> extends NetworkCallback<T> {

    protected SimpleNetworkCallback() {
        this(-1);
    }

    protected SimpleNetworkCallback(int index) {
        super(index);
    }

    @Override
    public void onSuccess(final T data) {
    }

    @Override
    public void onFailure() {
    }
}
