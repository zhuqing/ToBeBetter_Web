/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.entity.english;

import com.fasterxml.jackson.annotation.JsonInclude;
import xyz.tobebetter.entity.Entity;

/**
 *
 * @author zhuqing
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Content extends Entity{
    private String content;
    private String userId;
    private String imagePath;
    private String audioPath;
    private String timePoint;
    private String title;

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the audioPath
     */
    public String getAudioPath() {
        return audioPath;
    }

    /**
     * @param audioPath the audioPath to set
     */
    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    /**
     * @return the timePoint
     */
    public String getTimePoint() {
        return timePoint;
    }

    /**
     * @param timePoint the timePoint to set
     */
    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

   
}
