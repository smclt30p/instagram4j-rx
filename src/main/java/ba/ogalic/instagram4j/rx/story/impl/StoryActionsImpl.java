package ba.ogalic.instagram4j.rx.story.impl;

import ba.ogalic.instagram4j.rx.story.StoryActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.models.media.reel.item.ReelMetadataItem;
import com.github.instagram4j.instagram4j.responses.feed.FeedReelsTrayResponse;
import com.github.instagram4j.instagram4j.responses.feed.FeedUserStoryResponse;
import com.github.instagram4j.instagram4j.responses.media.MediaResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;
import java.util.List;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class StoryActionsImpl implements StoryActions {

    private final IGClient client;

    public StoryActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(byte[] data, List<ReelMetadataItem> metadata) {
        return wrapCompletable(() -> client.actions().story().uploadPhoto(data, metadata));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(byte[] video, byte[] cover, List<ReelMetadataItem> metadata) {
        return wrapCompletable(() -> client.actions().story().uploadVideo(video, cover, metadata));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(File file, List<ReelMetadataItem> metadata) {
        return wrapCompletable(() -> client.actions().story().uploadPhoto(file, metadata));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadPhoto(File file) {
        return wrapCompletable(() -> client.actions().story().uploadPhoto(file));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(File videoFile, File coverFile, List<ReelMetadataItem> metadata) {
        return wrapCompletable(() -> client.actions().story().uploadVideo(videoFile, coverFile, metadata));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToStoryResponse> uploadVideo(File videoFile, File coverFile) {
        return wrapCompletable(() -> client.actions().story().uploadVideo(videoFile, coverFile));
    }

    @Override
    public Observable<FeedReelsTrayResponse> tray() {
        return wrapCompletable(() -> client.actions().story().tray());
    }

    @Override
    public Observable<FeedUserStoryResponse> userStory(long pk) {
        return wrapCompletable(() -> client.actions().story().userStory(pk));
    }
}
