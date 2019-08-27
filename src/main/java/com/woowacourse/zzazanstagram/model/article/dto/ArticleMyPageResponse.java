package com.woowacourse.zzazanstagram.model.article.dto;

public class ArticleMyPageResponse {
    private Long id;
    private String image;
    private long ddabongNumber;
    private long commentNumber;

    public ArticleMyPageResponse(Long id, String image, long ddabongNumber, long commentNumber) {
        this.id = id;
        this.image = image;
        this.ddabongNumber = ddabongNumber;
        this.commentNumber = commentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getDdabongNumber() {
        return ddabongNumber;
    }

    public void setDdabongNumber(long ddabongNumber) {
        this.ddabongNumber = ddabongNumber;
    }

    public long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(long commentNumber) {
        this.commentNumber = commentNumber;
    }
}