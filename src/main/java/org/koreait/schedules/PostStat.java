package org.koreait.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PostStat {

    @Scheduled
    public void process() {
        System.out.println("게시글 통계 수행..");
    }
}
