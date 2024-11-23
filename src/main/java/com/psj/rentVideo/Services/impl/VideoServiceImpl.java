package com.psj.rentVideo.Services.impl;

import com.psj.rentVideo.Entities.Video;
import com.psj.rentVideo.Repository.UserRepository;
import com.psj.rentVideo.Repository.VideoRepository;
import com.psj.rentVideo.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<Video> getAvailableVideos() {
        return this.videoRepository.findAll();
    }

    @Override
    public Video createVideo(Video video) {
        return this.videoRepository.save(video);
    }

    @Override
    public Video updateVideo(Video video, Long id) {
        Video existingVideo = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        video.setTitle(existingVideo.getTitle());
        video.setDirector(existingVideo.getDirector());
        video.setGenre(existingVideo.getGenre());
        video.setAvailabilityStatus(existingVideo.isAvailabilityStatus());
        return videoRepository.save(video);
    }

    @Override
    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        videoRepository.delete(video);
    }
}
