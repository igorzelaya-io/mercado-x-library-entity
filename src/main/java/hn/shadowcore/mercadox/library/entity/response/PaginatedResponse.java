package hn.shadowcore.mercadox.library.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JsonSerialize
public class PaginatedResponse<T> extends Response<List<T>> {

    @JsonProperty
    private List<T> payload;

    @JsonProperty
    private int pageNumber;

    @JsonProperty
    private int pageSize;

    @JsonProperty
    private String[] sort;

    @Override
    public void setPayload(List<T> payload) {
        this.payload = payload;
    }

    @Override
    public List<T> getPayload() {
        return this.payload;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String[] getSort() {
        return this.sort;
    }

    @Override
    public void setSort(String[] sort) {
        this.sort = sort;
    }

    public ResponseEntity<PaginatedResponse<T>> buildPaginatedResponse(HttpStatus status, String message, List<T> payload,
                                                                       int page, int size, String[] sort) {
        this.setHttpStatusCode(status.value());
        this.setMessage(message);
        this.setPayload(payload);
        this.setPageNumber(page);
        this.setPageSize(size);
        this.setSort(sort);
        return new ResponseEntity<>(this, status);
    }
}
