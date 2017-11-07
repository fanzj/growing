package com.jary.daily.grows.java8.stream;

import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/7 下午3:16
 */
public class Article {

    private final String title;
    private final String author;
    private final List<String> tags;

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", tags=" + tags +
            '}';
    }
}
