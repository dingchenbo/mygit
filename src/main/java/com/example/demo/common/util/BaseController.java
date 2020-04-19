package com.example.demo.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {

    /**
     * 重定向
     **/
    protected final static String REQUEST_REDIRECT = "redirect:";

    /**
     * 成功页面
     **/
    protected final static String SUCCESS = "success";

    /**
     * 失败页面
     **/
    protected final static String FAILED = "failed";

    /**
     * 404页面
     **/
    protected final static String page_404 = "page_404";

    /**
     * 500页面
     **/
    protected final static String page_500 = "page_500";

    /**
     * 微信错误页面
     **/
    protected final static String WX_FAILED = "wx_util/shopErr";


    /**
     * json获取失败
     **/
    protected final static String JSON_FAIL = "{\"state\":\"failed\"}";

//    @Autowired
//    protected HttpServletRequest request;

    protected HttpServletResponse response;

//    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(/*HttpServletRequest request,*/ HttpServletResponse response) {
//        this.request = request;
        this.response = response;
//        this.session = request.getSession();
    }

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);


    // AJAX输出，返回null
    public String ajax(String content, String type, HttpServletResponse response) {
        try {
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            logger.error("ajax", e);
        }
        return null;
    }

    /**
     * AJAX输出HTML，返回null
     **/
    public String ajaxHtml(String html, HttpServletResponse response) {
        return ajax(html, "text/html", response);
    }

    /**
     * AJAX输出json，返回null
     **/
    public String ajaxJson(String json, HttpServletResponse response) {
        return ajax(json, "application/json", response);
    }


    /**
     * 获取新的Page实例
     *
     * @return
     */
    protected Page newPage(HttpServletRequest request) {
        Page page = new Page();
        String currentPages = request.getParameter("currentPage");
        if (StringUtils.isNotEmpty(currentPages)) {
            page.setCurrentPage(Integer.parseInt(currentPages));
        }
        String showCount = request.getParameter("showCount");
        if (StringUtils.isNotEmpty(showCount)) {
            page.setShowCount(Integer.parseInt(showCount));
        }
        return page;
    }

    public String ajaxResult(boolean result) {
        if (result) {
            return SUCCESS;
        } else {
            return FAILED;
        }
    }

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("Server occur exception handler with ", e);
        return page_500;
    }





}
