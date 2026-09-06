package hn.shadowcore.mercadox.library.entity.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApiResponseTest {

    private static final Instant TIMESTAMP = Instant.parse("2026-09-02T18:40:00Z");

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    @Test
    void serializesApiMetadataOnTopOfTheSharedResponseEnvelope() throws Exception {
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK,
                "OPERATION_SUCCEEDED",
                "Operation completed.",
                TIMESTAMP,
                "correlation-id",
                "payload");

        JsonNode json = objectMapper.readTree(objectMapper.writeValueAsBytes(response));

        assertThat(json.get("code").asText()).isEqualTo("OPERATION_SUCCEEDED");
        assertThat(json.get("httpStatusCode").asInt()).isEqualTo(200);
        assertThat(json.get("timestamp").asText()).isEqualTo("2026-09-02T18:40:00.000Z");
        assertThat(json.get("correlationId").asText()).isEqualTo("correlation-id");
        assertThat(json.get("payload").asText()).isEqualTo("payload");
        assertThat(json.has("pageNumber")).isFalse();
        assertThat(json.has("pageSize")).isFalse();
        assertThat(json.has("sort")).isFalse();
    }

    @Test
    void serializesStructuredFieldViolationsWithoutAnEmptyPayload() throws Exception {
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ApiErrorCode.INVALID_REQUEST,
                "The request is invalid.",
                TIMESTAMP,
                "correlation-id",
                List.of(new FieldViolation("returnPath", "must not be blank")));

        JsonNode json = objectMapper.readTree(objectMapper.writeValueAsBytes(error));

        assertThat(json.get("code").asText()).isEqualTo("INVALID_REQUEST");
        assertThat(json.get("httpStatusCode").asInt()).isEqualTo(400);
        assertThat(json.get("fieldErrors").get(0).get("field").asText())
                .isEqualTo("returnPath");
        assertThat(json.has("payload")).isFalse();
    }
}
