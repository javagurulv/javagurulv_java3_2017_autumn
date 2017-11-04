package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.exceptons.InternalServerException;
import lv.javaguru.java3.core.exceptons.ValidationException;
import lv.javaguru.java3.integrations.rest.dto.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RESTExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException e, WebRequest request) {
        log.error(e.toString(), e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ExceptionDTO dto = new ExceptionDTO(e.getMessage(), e.getValidationErrors());
        HttpStatus responseStatus = e.getResultStatus().getHttpStatus();
        return handleExceptionInternal(e, dto, headers, responseStatus, request);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity handleMPWSInternalServerError(InternalServerException e, WebRequest request) {
        log.error(e.toString(), e);
        HttpStatus responseStatus = e.getResultStatus().getHttpStatus();
        return ResponseEntity.status(responseStatus).build();
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleInternalError(Throwable t) {
        log.error(t.toString(), t);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
