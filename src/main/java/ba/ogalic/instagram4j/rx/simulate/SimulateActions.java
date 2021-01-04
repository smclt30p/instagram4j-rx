package ba.ogalic.instagram4j.rx.simulate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SimulateActions {

    List<CompletableFuture<?>> preLoginFlow();

    List<CompletableFuture<?>> postLoginFlow();

}
