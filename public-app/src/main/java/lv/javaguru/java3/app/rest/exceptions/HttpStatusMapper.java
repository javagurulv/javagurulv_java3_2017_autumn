package lv.javaguru.java3.app.rest.exceptions;

import lv.javaguru.java3.core.api.common.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public interface HttpStatusMapper {
    HttpStatus map(ResponseStatus responseStatus);
}

@Component
class HttpStatusMapperImpl implements HttpStatusMapper {

    @Override
    public HttpStatus map(ResponseStatus responseStatus) {
        if (ResponseStatus.SUCCESS == responseStatus) {
            return HttpStatus.OK;
        } else if (ResponseStatus.BAD_REQUEST == responseStatus) {
            return HttpStatus.BAD_REQUEST;
        } else if (ResponseStatus.FORBIDDEN == responseStatus) {
            return HttpStatus.FORBIDDEN;
        } else if (ResponseStatus.NOT_FOUND == responseStatus) {
            return HttpStatus.NOT_FOUND;
        } else if (ResponseStatus.INTERNAL_SERVER_ERROR == responseStatus) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        throw new IllegalStateException("Can not map Response status to Http code");
    }

}
