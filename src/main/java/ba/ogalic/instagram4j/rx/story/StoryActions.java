package ba.ogalic.instagram4j.rx.story;

import com.github.instagram4j.instagram4j.models.media.reel.item.ReelMetadataItem;
import com.github.instagram4j.instagram4j.responses.feed.FeedReelsTrayResponse;
import com.github.instagram4j.instagram4j.responses.feed.FeedUserStoryResponse;
import com.github.instagram4j.instagram4j.responses.media.MediaResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;
import java.util.List;

public interface StoryActions {

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(byte[] data, List<ReelMetadataItem> metadata);

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(byte[] video, byte[] cover, List<ReelMetadataItem> metadata);

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(File file, List<ReelMetadataItem> metadata);

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(File file);

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(File videoFile, File coverFile, List<ReelMetadataItem> metadata);

    Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(File videoFile, File coverFile);

    Observable<FeedReelsTrayResponse> tray();

    Observable<FeedUserStoryResponse> userStory(long pk);

}
