package ba.ogalic.instagram4j.rx.search;

import com.github.instagram4j.instagram4j.responses.fbsearch.FbsearchPlacesResponse;
import com.github.instagram4j.instagram4j.responses.tags.TagsSearchResponse;
import com.github.instagram4j.instagram4j.responses.users.UsersSearchResponse;
import io.reactivex.rxjava3.core.Observable;

public interface SearchActions {

    Observable<FbsearchPlacesResponse> searchPlace(String location);

    Observable<FbsearchPlacesResponse> searchPlace(String location, double lat,
                                                   double lon);

    Observable<TagsSearchResponse> searchTag(String tag);

    Observable<TagsSearchResponse> searchTag(String tag, double lat, double lon);

    Observable<FbsearchPlacesResponse> searchPlace(String location, double lat,
                                                   double lon,
                                                   String pageToken, String rankToken);

    Observable<TagsSearchResponse> searchTag(String location, double lat, double lon,
                                             String pageToken, String rankToken);

    Observable<UsersSearchResponse> searchUser(String query);

}
