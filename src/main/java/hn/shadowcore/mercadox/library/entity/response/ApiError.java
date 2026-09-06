package hn.shadowcore.mercadox.library.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"pageNumber", "pageSize", "sort"})
public class ApiError extends ApiResponse<Void> {

    private final List<FieldViolation> fieldErrors;

    public ApiError(HttpStatus status,
                    ApiErrorCode code,
                    String message,
                    Instant timestamp,
                    String correlationId) {
        this(status, code, message, timestamp, correlationId, List.of());
    }

    public ApiError(HttpStatus status,
                    ApiErrorCode code,
                    String message,
                    Instant timestamp,
                    String correlationId,
                    List<FieldViolation> fieldErrors) {
        super(status, code.name(), message, timestamp, correlationId, null);
        this.fieldErrors = List.copyOf(fieldErrors);
    }

    public List<FieldViolation> getFieldErrors() {
        return fieldErrors;
    }
}
