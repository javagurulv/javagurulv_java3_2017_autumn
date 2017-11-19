package lv.javaguru.java3.app.common;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

@Component("ApplicationCorrelationIdHolder")
public class ApplicationCorrelationIdHolder {

    public static final String CORRELATION_ID = UUID.randomUUID().toString();

    private static final Logger log = getLogger(ApplicationCorrelationIdHolder.class);

    @PostConstruct
    private void init() {
        log.info("Application CORRELATION ID is set to : {}", CORRELATION_ID);
    }

}
