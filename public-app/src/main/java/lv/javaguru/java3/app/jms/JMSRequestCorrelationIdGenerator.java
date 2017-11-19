package lv.javaguru.java3.app.jms;

import org.springframework.stereotype.Component;

import java.util.UUID;

public interface JMSRequestCorrelationIdGenerator {
    String generate();
}

@Component
class JMSRequestCorrelationIdGeneratorImpl implements JMSRequestCorrelationIdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

}

