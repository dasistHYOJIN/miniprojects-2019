package com.woowacourse.zzazanstagram.model.like.service;

import com.woowacourse.zzazanstagram.model.article.domain.Article;
import com.woowacourse.zzazanstagram.model.article.service.ArticleService;
import com.woowacourse.zzazanstagram.model.like.domain.Ddabong;
import com.woowacourse.zzazanstagram.model.like.repository.DdabongRepository;
import com.woowacourse.zzazanstagram.model.member.domain.Member;
import com.woowacourse.zzazanstagram.model.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DdabongService {
    private final DdabongRepository ddabongRepository;
    private final ArticleService articleService;
    private final MemberService memberService;

    public DdabongService(DdabongRepository ddabongRepository, ArticleService articleService, MemberService memberService) {
        this.ddabongRepository = ddabongRepository;
        this.articleService = articleService;
        this.memberService = memberService;
    }

    @Transactional
    public String saveOrRemove(Long articleId, String memberEmail) {
        Article article = articleService.findArticleById(articleId);
        Member member = memberService.findMemberByEmail(memberEmail);
        Ddabong ddabong = new Ddabong(article, member);

        if (article.hasDdabong(ddabong)) {
            return delete(article, ddabong);
        }
        return save(article, ddabong);
    }

    private String delete(Article article, Ddabong ddabong) {
        article.deleteDdabong(ddabong);
        ddabongRepository.delete(ddabong);
        return article.getDdabongCount();
    }

    private String save(Article article, Ddabong ddabong) {
        ddabongRepository.save(ddabong);
        article.addDdabong(ddabong);
        return article.getDdabongCount();
    }
}
