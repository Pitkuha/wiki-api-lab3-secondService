package app;

import app.model.Article;
import app.model.ArticleLikes;
import app.repository.LikesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LikesRepository likesRepository;

    @JmsListener(destination = "demoqueue")
    public void getMessage(String content){
        String[] str = content.split(" ");
        long id = Long.parseLong(str[0]);
        String name = str[1];
        logger.info("Received queue message. Content is " + content);
        System.out.println();
        System.out.println(likesRepository.findArt(id));

        if (likesRepository.findArt(id) != 0){
            if (likesRepository.findArtLikes(id) == 0) {
                ArticleLikes articleLikes = new ArticleLikes();
                articleLikes.setLikesCount(1);
                articleLikes.setArticleID(id);
                likesRepository.save(articleLikes);
            } else {
                likesRepository.updateCountLikes(id);
            }
        } else {
            System.out.println("Неа!");
        }
    }

    //TODO Добавлена система лайков, можно лайкнуть, обновится кол-во лайков, добавить, оповещение сколько лайков за день набрано
}
