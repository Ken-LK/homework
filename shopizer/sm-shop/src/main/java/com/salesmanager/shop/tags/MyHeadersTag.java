package com.salesmanager.shop.tags;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author ken
 * @className MyHeadersTag
 * @description 自定义标签
 * @date 2021/7/5 9:12 上午
 */
public class MyHeadersTag extends SimpleTagSupport {

    private String cacheControl = null;
    private String pragma = null;
    private Long expires = null;

    @Override
    public void doTag() throws JspException, IOException {

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
//        System.out.println("cacheControl:" + cacheControl);
//        System.out.println("pragma:" + pragma);
        response.setHeader("Cache-Control", cacheControl);
        response.setHeader("Pragma", pragma);
        response.setDateHeader("Expires", expires);
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getPragma() {
        return pragma;
    }

    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
