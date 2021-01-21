package Sabra_Talkies.controllers;

import Sabra_Talkies.models.*;
import Sabra_Talkies.payload.response.MessageResponse;
import Sabra_Talkies.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/addcomment")
    public ResponseEntity<?> createNewComment(@Valid @RequestParam("commentContent") String commentContent,
                                              @RequestParam("commentedPostId") String commentedPostId,
                                              @RequestParam("commentedUserId") String commentedUserId,
                                              @RequestParam("commentedFirstName") String commentedFirstName) {

        // Create new user's account
        CommentDB newcomment = new CommentDB( commentContent,commentedPostId,commentedUserId,commentedFirstName);
        commentRepository.save(newcomment);
        return ResponseEntity.ok(new MessageResponse("New Comment Added successfully!"));
    }

    @GetMapping("/allcomments")
    public List<CommentDB> getAllComments(){
        return commentRepository.findAll();
    }

}
