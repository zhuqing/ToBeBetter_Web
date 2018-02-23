package xyz.tobebetter.entity;


/**
 * Created by zhuleqi on 2018/2/10.
 */

public class UserTask   extends Entity {

    public final static  Integer STATUS_SYS = 0;
    public final static  Integer STATUS_CUSTOM_TIME = 1;
    public final static  Integer STATUS_CUSTOM_TIMEING = 2;

    private String title;
    private Integer minutes;
    private Long userId;


    /**
     * 任务名称
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 分钟数
     */
    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * 任务创建的用户Id
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserTask clone(){
        UserTask userTask = new UserTask();
        userTask.setId(this.getId());
        userTask.setTitle(this.getTitle());
        userTask.setUserId(this.getUserId());
        userTask.setMinutes(this.getMinutes());
        userTask.setStatus(this.getStatus());
        userTask.setCreateDate(this.getCreateDate());
        userTask.setUpdateDate(this.getUpdateDate());
        return userTask;
    }


}
