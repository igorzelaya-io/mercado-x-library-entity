package hn.shadowcore.mercadoxlibrary.entity.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PaginatedResponse<T> extends Response<List<T>> {

    private List<T> payload;

    private int pageNumber;

    private int pageSize;

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

    public ResponseEntity<PaginatedResponse<T>> buildPaginatedResponse() {
        return new ResponseEntity<>(this, HttpStatus.OK);
    }
}
