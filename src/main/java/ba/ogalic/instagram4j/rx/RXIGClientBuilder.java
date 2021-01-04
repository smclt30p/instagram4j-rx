package ba.ogalic.instagram4j.rx;

import ba.ogalic.instagram4j.rx.impl.RXIGClientImpl;

public class RXIGClientBuilder {

    public static RXIGClient build() {
        return new RXIGClientImpl();
    }

}
