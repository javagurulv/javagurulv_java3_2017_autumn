package lv.javaguru.java3.integrations.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.java3.config.Application;
import lv.javaguru.java3.integrations.rest.api.ClientResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(classes = {Application.class})
public class RESTResourceTest {

    @Value("${local.server.port}")
    private int port;

    protected ClientResource clientResource;


    @Before
    public void init() {
        String url = "http://localhost:" + port;

        clientResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(ClientResource.class, url);
    }

}
