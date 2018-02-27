package xyz.tobebetter.util;

import xyz.tobebetter.entity.Message;

/**
 * Created by zhuqing on 2017/9/23.
 */
public class MessageUtil {

    public static <T> Message createMessage(int status, String msgStr, T data) {
        Message<T> message = new Message<T>();
        message.setMessage(msgStr);
        message.setData(data);
        message.setStatus(status);
        return message;
    }

    public static <T> Message createMessage(String msgStr, T data) {

        Message<T> message = new Message<T>();
        message.setMessage(msgStr);
        message.setData(data);
        if (data == null) {
            message.setStatus(Message.ERROR);
        } else {
            message.setStatus(Message.SUCCESS);
        }

        return message;
    }
    
    public static <T> Message createErrorMessage(T data) {
        return createMessage(Message.ERROR, "error", null);
    }
    
     public static <T> Message createErrorMessage(String message , T data) {
        return createMessage(Message.ERROR, message, null);
    }

    public static <T> Message createSuccessMessage(T data) {
        return createMessage(Message.SUCCESS, "ok", data);
    }
}
