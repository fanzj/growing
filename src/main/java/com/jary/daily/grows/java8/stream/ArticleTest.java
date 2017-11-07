package com.jary.daily.grows.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/7 下午3:18
 */
public class ArticleTest {

    public static final String TAG = "Java";

    public static Article getFirstJavaArticle(List<Article> articles){
        for(Article article : articles){
            if(article.getTags().contains(TAG)){
                return article;
            }
        }
        return null;
    }

    public static Optional<Article> getFirstJavaArticle2(List<Article> articles){
        return articles.stream().filter(article -> article.getTags().contains(TAG)).findFirst();
    }

    public static List<Article> getAllJavaArticles(List<Article> articles) {

        List<Article> result = new ArrayList<>();

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }

        return result;
    }

    public static List<Article> getAllJavaArticles2(List<Article> articles){
        return articles.stream().filter(article -> article.getTags().contains("Java")).collect(Collectors.toList());
    }


    public static Map<String,List<Article>> groupByAuthor(List<Article> articles){
        return articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
    }


    public static void main(String[] args){
        List<Article> articles = new ArrayList<>();

        List<String> tags = Arrays.asList("Thinking in Java","C++","Web");
        Article article = new Article("AAA","Jack", tags);
        articles.add(article);

        List<String> tags1 = Arrays.asList("RPC","Linux");
        articles.add(new Article("BBB","Rose",tags1));

        articles.add(new Article("CCC","Jack",Arrays.asList("Java","C","JS")));

        articles.add(new Article("DDD","Rose",Arrays.asList("IOS","PHP","Java")));

        articles.add(new Article("EEE", "Jerry", Arrays.asList("Scala","Java","Python")));

       // System.out.println(getFirstJavaArticle(articles));
       // System.out.println(getFirstJavaArticle2(articles));

       // System.out.println(getAllJavaArticles(articles));
       // System.out.println(getAllJavaArticles2(articles));
        System.out.println(groupByAuthor(articles));
    }

}
