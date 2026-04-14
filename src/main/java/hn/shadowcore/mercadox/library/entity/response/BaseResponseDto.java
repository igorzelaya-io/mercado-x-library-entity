package hn.shadowcore.mercadox.library.entity.response;

public class BaseResponseDto<T> extends Response<T> {

    private T payload;

    @Override
    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public T getPayload() {
        return this.payload;
    }
}
