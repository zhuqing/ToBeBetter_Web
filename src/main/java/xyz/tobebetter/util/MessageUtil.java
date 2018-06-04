package xyz.tobebetter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.entity.Message;

/**
 * Created by zhuqing on 2017/9/23.
 */
public class MessageUtil {

    public static <T> Message createMessage(int status, String msgStr, T data) {
        Message message = new Message();
        message.setMessage(msgStr);
        message.setStatus(status);
        ObjectMapper mapper = new ObjectMapper();
        try {
            message.setData(mapper.writeValueAsString(data));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MessageUtil.class.getName()).log(Level.SEVERE, null, ex);
            message.setStatus(Message.ERROR);
            message.setMessage(ex.getMessage());
        }

        return message;
    }

    public static <T> Message createMessage(String msgStr, T data, int page, int totalPage) {
        Message message = createMessage(msgStr, data);
        message.setTotalPage(totalPage);
        message.setPage(page);
        return message;
    }

    public static <T> Message createMessage(String msgStr, T data) {
        ObjectMapper mapper = new ObjectMapper();
        Message message = new Message();
        if (data == null) {
            message.setStatus(Message.ERROR);
        } else {
            message.setStatus(Message.SUCCESS);
        }
        message.setMessage(msgStr);
        try {
            message.setData(mapper.writeValueAsString(data));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MessageUtil.class.getName()).log(Level.SEVERE, null, ex);
            message.setStatus(Message.ERROR);
            message.setMessage(ex.getMessage());
        }

        return message;
    }

    public static <T> Message createErrorMessage(T data) {
        return createMessage(Message.ERROR, "error", null);
    }

    public static <T> Message createErrorMessage(String message, T data) {
        return createMessage(Message.ERROR, message, null);
    }

    public static <T> Message createErrorMessage(String message) {
        return createMessage(Message.ERROR, message, null);
    }

    public static <T> Message createSuccessMessage() {
        return createMessage(Message.SUCCESS, "ok", null);
    }

    public static <T> Message createSuccessMessage(T data) {
        return createMessage(Message.SUCCESS, "ok", data);
    }
}
