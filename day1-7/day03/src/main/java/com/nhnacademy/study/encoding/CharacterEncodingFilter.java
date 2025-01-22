package com.nhnacademy.study.encoding;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    private String encoding = "UTF-8"; // 기본 인코딩 설정

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String configEncoding = filterConfig.getInitParameter("encoding");
        if (configEncoding != null) {
            encoding = configEncoding; // web.xml 설정이 있으면 적용
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        // 요청과 응답의 문자 인코딩 설정
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        // 다음 필터 또는 서블릿 실행
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 리소스 정리가 필요한 경우 사용 (여기서는 필요 없음)
    }
}
