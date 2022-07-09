package tc.mds.uglikis.model;

import java.util.List;

public class Article {

    private int ArticleId;
    private String heading;
    private String author;
    private String summary;
    private List<ArticleCategory> categories;

    private String content;

    public Article(String heading, String author, String summary, List<ArticleCategory> categories, String content) {
        this.heading = heading;
        this.author = author;
        this.summary = summary;
        this.categories = categories;
        this.content = content;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<ArticleCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ArticleCategory> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
