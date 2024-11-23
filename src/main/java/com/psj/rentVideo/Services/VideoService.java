package com.psj.rentVideo.Services;

import com.psj.rentVideo.Entities.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {

    public List<Video> getAvailableVideos();

    public Video createVideo(Video video);

    public Video updateVideo(Video video, Long id);

    public void deleteVideo(Long id);
}
