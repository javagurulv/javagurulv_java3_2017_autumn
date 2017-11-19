package lv.javaguru.java3.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultBuilder {
    DeferredResult<ResponseEntity> build();
}

@Component
class DeferredResultBuilderImpl implements DeferredResultBuilder {

    private static final Long JMS_REQUEST_TIMEOUT = 5000L; // milliseconds

    @Override
    public DeferredResult<ResponseEntity> build() {
        DeferredResult<ResponseEntity> response = new DeferredResult<>(JMS_REQUEST_TIMEOUT);
        response.onTimeout(() ->
                response.setErrorResult(
                        ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout occurred.")
                )
        );
        return response;
    }
}
