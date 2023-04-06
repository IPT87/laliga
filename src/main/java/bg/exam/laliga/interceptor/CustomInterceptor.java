package bg.exam.laliga.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    private final Logger LOGS = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGS.info("PreHandle request {}", request.getPathInfo());
        LOGS.info("PreHandle request {}", request.getRequestURI());
        LOGS.info("PreHandle response {}", response.getStatus());
        LOGS.info("PreHandle handler {}", handler.getClass());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        LOGS.info("PostHandle {}", request.getRequestURI());

        if (modelAndView != null && modelAndView.hasView()) {
            LOGS.info("Model view {}", modelAndView.getView());
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

        LOGS.info("AfterCompletion request {}", request.getRequestURI());
        LOGS.info("AfterCompletion response {}", response.getStatus());

    }
}

