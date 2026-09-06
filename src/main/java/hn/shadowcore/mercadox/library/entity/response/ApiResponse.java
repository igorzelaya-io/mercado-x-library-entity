package hn.shadowcore.mercadox.library.entity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"pageNumber", "pageSize", "sort"})
public class ApiResponse<T> extends Response<T> {

    private String code;
    private String correlationId;
    private T payload;

    public ApiResponse(HttpStatus status,
                       String code,
                       String message,
                       Instant timestamp,
                       String correlationId,
                       T payload) {
        setHttpStatusCode(status.value());
        setCode(code);
        setMessage(message);
        setTimestamp(LocalDateTime.ofInstant(timestamp, ZoneOffset.UTC));
        setCorrelationId(correlationId);
        setPayload(payload);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Override
    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public T getPayload() {
        return payload;
    }

    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    public LocalDateTime getTimestamp() {
        return super.getTimestamp();
    }
}
