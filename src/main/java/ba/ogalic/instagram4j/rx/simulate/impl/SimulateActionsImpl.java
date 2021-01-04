package ba.ogalic.instagram4j.rx.simulate.impl;

import ba.ogalic.instagram4j.rx.simulate.SimulateActions;
import com.github.instagram4j.instagram4j.IGClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SimulateActionsImpl implements SimulateActions {

    private final IGClient client;

    public SimulateActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public List<CompletableFuture<?>> preLoginFlow() {
        return client.actions().simulate().preLoginFlow();
    }

    @Override
    public List<CompletableFuture<?>> postLoginFlow() {
        return client.actions().simulate().postLoginFlow();
    }

}
