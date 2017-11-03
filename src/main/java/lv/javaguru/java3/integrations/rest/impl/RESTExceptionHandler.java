package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.exceptons.InternalServerError;
import lv.javaguru.java3.core.exceptons.ValidationError;
import lv.javaguru.java3.integrations.rest.dto.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RESTExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RESTExceptionHandler.class);


    @ExceptionHandler(value = {Throwable.class, InternalServerError.class})
    public ResponseEntity<ExceptionDTO> handleInternalError(Throwable t) {
        log.error("Internal Server Error:", t);
        ExceptionDTO dto = new ExceptionDTO();
        dto.setDescription(t.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(dto);
    }

    @ExceptionHandler(ValidationError.class)
    public ResponseEntity<ValidationError> handleIllegalArgumentException(ValidationError e) {
        log.error("Validation Exception:", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e);
    }

}
