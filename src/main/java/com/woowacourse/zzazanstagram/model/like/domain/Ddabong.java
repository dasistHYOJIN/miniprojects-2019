package com.woowacourse.zzazanstagram.model.like.domain;

import com.woowacourse.zzazanstagram.model.article.domain.Article;
import com.woowacourse.zzazanstagram.model.common.BaseEntity;
import com.woowacourse.zzazanstagram.model.member.domain.Member;

import javax.persistence.*;

@Entity
public class Ddabong extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", foreignKey = @ForeignKey(name = "fk_like_to_article"), nullable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "fk_like_to_member"), nullable = false)
    private Member member;

    public Ddabong() {
    }

    public Ddabong(Article article, Member member) {
        this.article = article;
        this.member = member;
    }

    public Article getArticle() {
        return article;
    }

    public Member getMember() {
        return member;
    }
}