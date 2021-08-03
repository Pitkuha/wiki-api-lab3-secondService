package app;

import app.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Scheduler {
    @Autowired
    private LikesRepository likesRepository;

    @Scheduled(fixedRate = 86400)
    private void setZero(){
        likesRepository.setZero();
        System.out.println("Обнулен");
    }
}
