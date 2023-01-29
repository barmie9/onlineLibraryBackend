package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.Comment;
import com.bartekOnlineLibrary.onlineLibrary.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

      int getAverageRating(Long bookId){
        List<Comment> comments = commentRepository.findAllByBookId(bookId);
//         List<Comment> comments = getComme
        int sum=0;
        int number=0;

        for(Comment c : comments){
            sum += c.getRating();
            number += 1;
        }
        if(number == 0) return 0;
        else return sum/number;
    }
}
