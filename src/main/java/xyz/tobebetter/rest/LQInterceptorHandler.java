///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package xyz.tobebetter.rest;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.jboss.resteasy.specimpl.BuiltResponse;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import xyz.tobebetter.entity.message.LQReceiveMessage;
//
//public class LQInterceptorHandler implements HandlerInterceptor {
//
//    private static final Logger LOGGER = LogManager.getLogger(LQInterceptorHandler.class);
//
//    public HipInterceptorHandler() {
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws RuntimeException {
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws RuntimeException {
//        ModelMap modelMap = modelAndView.getModelMap();
//        for (Map.Entry<String, Object> entry : modelMap.entrySet()) {
//            Object value = entry.getValue();
//            if (!(value instanceof BuiltResponse)) {
//                continue;
//            }
//            BuiltResponse builtResponse = ((BuiltResponse) value);
//            if (!builtResponse.hasEntity()) {
//                builtResponse.setEntityClass(LQReceiveMessage.class);
//                LQReceiveMessage hipReceiveMessage = new LQReceiveMessage();
//                hipReceiveMessage.setCode("200");
//                builtResponse.setEntity(hipReceiveMessage);
//                continue;
//            }
//            Object obj = builtResponse.getEntity();
//            builtResponse.setEntityClass(LQReceiveMessage.class);
//            LQReceiveMessage lqReceiveMessage = new LQReceiveMessage();
//            lqReceiveMessage.setCode("200");
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//                String entitys = mapper.writeValueAsString(obj);
//                lqReceiveMessage.setEntitys(entitys);
//                builtResponse.setEntity(lqReceiveMessage);
//            } catch (Exception ex) {
//                throw new RuntimeException(ex.getMessage(), ex);
//            }
//
//        }
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws RuntimeException {
//    }
//
//}
