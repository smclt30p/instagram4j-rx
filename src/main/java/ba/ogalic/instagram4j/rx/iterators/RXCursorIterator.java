package ba.ogalic.instagram4j.rx.iterators;

import com.github.instagram4j.instagram4j.actions.feed.CursorIterator;
import com.github.instagram4j.instagram4j.requests.IGRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;

import java.util.function.BiConsumer;
import java.util.function.Function;

import ba.ogalic.instagram4j.rx.IRXIGClient;
import ba.ogalic.instagram4j.rx.RXIGClient;

/**
 * This iterator just wraps around the IRXIGClient object
 * @param <R> the type of the request object
 * @param <T> the type of the response object
 */
public class RXCursorIterator<R extends IGRequest<T>, T extends IGResponse> extends CursorIterator<R, T> {

    public RXCursorIterator(IRXIGClient client, R request, BiConsumer<R, String> set_cursor,
                            Function<T, String> get_next_cursor, Function<T, Boolean> has_next) {
        super(((RXIGClient) client).getClient(), request, set_cursor, get_next_cursor, has_next);
    }

}
