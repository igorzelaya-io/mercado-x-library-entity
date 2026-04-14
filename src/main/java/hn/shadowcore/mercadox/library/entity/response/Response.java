package hn.shadowcore.mercadox.library.entity.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Response<T> {

    private String message;

    private LocalDateTime timestamp;

    private int httpStatusCode;

    private int pageNumber = -1;

    private int pageSize = -1;

    private String[] sort;

    public abstract void setPayload(T payload);
    public abstract T getPayload();

    public ResponseEntity<? extends Response<T>> buildResponseEntity
            (HttpStatus httpStatus, String message, T payload) {
        setMessage(message);
        setTimestamp(LocalDateTime.now());
        setHttpStatusCode(httpStatus.value());
        setPayload(payload);
        return new ResponseEntity<>(this, httpStatus);
    }
}
