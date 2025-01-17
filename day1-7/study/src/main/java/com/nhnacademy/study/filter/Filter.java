package com.nhnacademy.study.filter;

import com.nhnacademy.study.request.Request;

public interface Filter {
    void doFilter(Request request, CustomFilterChain CustomFilterChain);
}
