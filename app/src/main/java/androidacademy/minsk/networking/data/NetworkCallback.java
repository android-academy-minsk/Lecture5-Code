package androidacademy.minsk.networking.data;

public abstract class NetworkCallback<T> {

    protected int index = -1;

    protected NetworkCallback(int index) {
        this.index = index;
    }

    protected NetworkCallback() {
        this(-1);
    }

    public abstract void onSuccess(T data);

    public abstract void onFailure();

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
