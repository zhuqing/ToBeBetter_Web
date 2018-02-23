package xyz.tobebetter.entity;



/**
 * Created by zhuleqi on 2018/2/23.
 */
public class Message<T> {
    public final static int ERROR = -1;
    public final static int SUCCESS = 0;
    private String message;
    private int status;
    private T data;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 状态　
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
