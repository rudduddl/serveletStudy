package com.nhnacademy.jsp.beans;

import org.jsoup.Jsoup;

import java.io.Serializable;

public class HtmlBeautifier implements Serializable {
    public HtmlBeautifier() {}

    private String html;

    // Getter: beautify된 HTML 반환
    public String getHtml() {
        return Jsoup.parse(this.html).html();
    }

    // Setter: beautify하려는 HTML 원문 설정
    public void setHtml(String html) {
        this.html = html;
    }
}
