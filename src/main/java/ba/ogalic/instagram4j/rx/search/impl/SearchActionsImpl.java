package ba.ogalic.instagram4j.rx.search.impl;

import ba.ogalic.instagram4j.rx.search.SearchActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.responses.fbsearch.FbsearchPlacesResponse;
import com.github.instagram4j.instagram4j.responses.tags.TagsSearchResponse;
import com.github.instagram4j.instagram4j.responses.users.UsersSearchResponse;
import io.reactivex.rxjava3.core.Observable;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class SearchActionsImpl implements SearchActions {

    private final IGClient client;

    public SearchActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<FbsearchPlacesResponse> searchPlace(String location) {
        return wrapCompletable(() -> client.actions().search().searchPlace(location));
    }

    @Override
    public Observable<FbsearchPlacesResponse> searchPlace(String location, double lat, double lon) {
        return wrapCompletable(() -> client.actions().search().searchPlace(location, lat, lon));
    }

    @Override
    public Observable<TagsSearchResponse> searchTag(String tag) {
        return wrapCompletable(() -> client.actions().search().searchTag(tag));
    }

    @Override
    public Observable<TagsSearchResponse> searchTag(String tag, double lat, double lon) {
        return wrapCompletable(() -> client.actions().search().searchTag(tag, lat, lon));
    }

    @Override
    public Observable<FbsearchPlacesResponse> searchPlace(String location, double lat, double lon, String pageToken, String rankToken) {
        return wrapCompletable(() -> client.actions().search().searchPlace(location, lat, lon, pageToken, rankToken));
    }

    @Override
    public Observable<TagsSearchResponse> searchTag(String location, double lat, double lon, String pageToken, String rankToken) {
        return wrapCompletable(() -> client.actions().search().searchTag(location, lat, lon, pageToken, rankToken));
    }

    @Override
    public Observable<UsersSearchResponse> searchUser(String query) {
        return wrapCompletable(() -> client.actions().search().searchUser(query));
    }

}
