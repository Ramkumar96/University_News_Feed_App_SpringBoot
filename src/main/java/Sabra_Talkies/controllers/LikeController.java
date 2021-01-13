package Sabra_Talkies.controllers;

import Sabra_Talkies.models.LikesDB;
import Sabra_Talkies.payload.response.MessageResponse;
import Sabra_Talkies.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @PostMapping("/addlike")
    public ResponseEntity<?> createNewLike(@Valid @RequestParam("likedPostId") String likedPostId,
                                              @RequestParam("likedUserId") String likedUserId) {

        // Create new likes
        LikesDB newlike = new LikesDB( likedPostId,likedUserId);
        likeRepository.save(newlike);
        return ResponseEntity.ok(new MessageResponse("New Like Added successfully!"));
    }

    @GetMapping("/alllikes")
    public List<LikesDB> getAllLikes(){
        return likeRepository.findAll();
    }
}
