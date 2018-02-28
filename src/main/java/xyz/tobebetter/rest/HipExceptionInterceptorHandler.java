/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.rest;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;
import xyz.tobebetter.entity.message.LQReceiveMessage;

/**
 *
 * @author duyi
 */
@Provider
@Component
public class HipExceptionInterceptorHandler implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LogManager.getLogger(HipExceptionInterceptorHandler.class);
    private static final BeanCopier beanCopier = BeanCopier.create(Exception.class, Exception.class, false);

    public HipExceptionInterceptorHandler() {
    }

    @Override
    public Response toResponse(Exception exception) {
        LOGGER.error("后台异常错误：", exception);
        LQReceiveMessage hipReceiveMessage = new LQReceiveMessage();
        hipReceiveMessage.setCode("500");
        hipReceiveMessage.setMessage(exception.getMessage());
        Exception ex = new Exception();
        beanCopier.copy(exception, ex, null);
        hipReceiveMessage.setException(ex);
        return Response.status(200).entity(hipReceiveMessage).build();
    }

}
