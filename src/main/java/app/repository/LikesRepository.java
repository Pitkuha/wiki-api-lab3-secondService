package app.repository;

import app.model.ArticleLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface LikesRepository extends JpaRepository<ArticleLikes, Long> {
    @Transactional
    @Modifying
    @Query("update ArticleLikes a set a.likesCount = a.likesCount + 1 where a.articleID = :artID")
    void updateCountLikes(@Param("artID") long artID);

    @Query("select count(a.articleId) from Article a where a.articleId = :id")
    long findArt(@Param("id") long id);

    @Query("select count(a.articleID) from ArticleLikes a where a.articleID = :id")
    long findArtLikes(@Param("id") long id);

    @Transactional
    @Modifying
    @Query("update ArticleLikes a set a.likesCount = 0")
    void setZero();

}
