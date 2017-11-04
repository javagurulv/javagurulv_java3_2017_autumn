package lv.javaguru.java3.integrations.rest;

import lv.javaguru.java3.common.dtos.ExceptionDTO;
import lv.javaguru.java3.common.dtos.ValidationErrorDTO;
import lv.javaguru.java3.core.api.exceptons.InternalServerException;
import lv.javaguru.java3.core.api.exceptons.ValidationError;
import lv.javaguru.java3.core.api.exceptons.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RESTExceptionHandler.class);

    @Autowired private HttpStatusMapper httpStatusMapper;

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException e, WebRequest request) {
        log.error(e.toString(), e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ExceptionDTO dto = new ExceptionDTO(e.getMessage(), convertErrors(e.getValidationErrors()));
        HttpStatus responseStatus = httpStatusMapper.map(e.getResultStatus());
        return handleExceptionInternal(e, dto, headers, responseStatus, request);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity handleMPWSInternalServerError(InternalServerException e, WebRequest request) {
        log.error(e.toString(), e);
        HttpStatus responseStatus = httpStatusMapper.map(e.getResultStatus());
        return ResponseEntity.status(responseStatus).build();
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleInternalError(Throwable t) {
        log.error(t.toString(), t);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    private List<ValidationErrorDTO> convertErrors(List<ValidationError> errors) {
        return errors.stream()
                .map(e -> new ValidationErrorDTO(e.getField(), e.getErrorCode(), e.getDescription()))
                .collect(toList());
    }

}
