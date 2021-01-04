package ba.ogalic.instagram4j.rx;

import org.junit.jupiter.api.Test;

class RXIGClientTest {

    @Test
    public void login() {

        RXIGClient client = RXIGClientBuilder.build();

        client.login("test", "test").subscribe((clientResponse) -> {

            System.out.println("Login OK");

        }, (e) -> {
            System.out.println("Failed login: " + e.getMessage());

        }).dispose();

    }

}