package com.lin.common.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.common.VO.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTION".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        if (token==null){
            ResultVO resultVO = new ResultVO(301, "请先登录", null);
            doResponse(response,resultVO);
        }else{
            try{
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("sssss");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            }catch (ExpiredJwtException e){
                ResultVO resultVO=new ResultVO(302,"token已过期",null);
                doResponse(response,resultVO);
            }catch (UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(303, "Token不合法，请自重！", null);
                doResponse(response,resultVO);
            }catch (Exception e){
                ResultVO resultVO = new ResultVO(304, "请先登录", null);
                doResponse(response,resultVO);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers","token,content-type");
        PrintWriter writer = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        writer.print(s);
        writer.flush();
        writer.close();
    }
}
