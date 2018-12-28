package com.mitocode;

import java.io.UnsupportedEncodingException;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPreZuulFilter extends ZuulFilter{

	@Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        
        if (ctx.getRequest().getRequestURI().contains("oauth/token")) {
            byte[] encoded;
            try {
                encoded = Base64.encode("acme:secret".getBytes("UTF-8"));
                ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));
            } catch (UnsupportedEncodingException e) {
                //logger.error("Error occured in pre filter", e);
            }
        }
        return null;
    }
 
    @Override
    public boolean shouldFilter() {
        return true;
    }
 
    @Override
    public int filterOrder() {
        return -2;
    }
 
    @Override
    public String filterType() {
        return "pre";
    }
	
}
