package com.nhnacademy.jsp.counter;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class sessionCounter_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                org.apache.jasper.runtime.JspSourceImports{

    private static final JspFactory _jspFactory = jakarta.servlet.jsp.JspFactory.getDefaultFactory();
    @Override
    public void _jspService(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    }

    @Override
    public Map<String, Long> getDependants() {
        return Map.of();
    }

    @Override
    public Set<String> getPackageImports() {
        return Set.of();
    }

    @Override
    public Set<String> getClassImports() {
        return Set.of();
    }
}
