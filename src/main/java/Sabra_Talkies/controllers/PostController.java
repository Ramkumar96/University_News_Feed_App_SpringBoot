package Sabra_Talkies.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Sabra_Talkies.models.PostDB;
import Sabra_Talkies.repository.PostDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Sabra_Talkies.payload.response.MessageResponse;
import Sabra_Talkies.payload.response.ResponsePost;
import Sabra_Talkies.service.PostStorageService;

@Controller
@CrossOrigin("http://localhost:8081")
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostStorageService postStorageService;

    @Autowired
    private PostDBRepository postDBRepository;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadPost(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userMail") String userMail,
            @RequestParam("userId") String userId,
            @RequestParam("firstname") String firstname,
            @RequestParam("postTitle") String postTitle,
            @RequestParam("content") String content,
            @RequestParam("createdOn") String createdOn,
            @RequestParam("PostDeletedByUser") Boolean PostDeletedByUser,
            @RequestParam("PostAcceptedByAdmin") Boolean PostAcceptedByAdmin,
            @RequestParam("PostDeletedByAdmin") Boolean PostDeletedByAdmin){
        String message = "";
        try {
            postStorageService.store(file ,userMail ,userId ,firstname, postTitle,content,createdOn,
                    PostDeletedByUser,PostAcceptedByAdmin,PostDeletedByAdmin );

            message = "Uploaded the Post successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the :file " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<List<ResponsePost>> getListPosts() {
        List<ResponsePost> posts = postStorageService.getAllPosts().map(dbPost -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/post/posts/")
                    .path(dbPost.getId())
                    .toUriString();

            return new ResponsePost(
                    dbPost.getName(),
                    fileDownloadUri,
                    dbPost.getType(),
                    dbPost.getData().length,
                    dbPost.getId(),
                    dbPost.getUserMail(),
                    dbPost.getUserId(),
                    dbPost.getFirstname(),
                    dbPost.getPostTitle(),
                    dbPost.getContent(),
                    dbPost.getCreatedOn(),
                    dbPost.getPostDeletedByUser(),
                    dbPost.getPostAcceptedByAdmin(),
                    dbPost.getPostDeletedByAdmin());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    //Download File
    @GetMapping("/posts/{id}")
    public ResponseEntity<byte[]> getPost(@PathVariable String id) {
        PostDB postDB = postStorageService.getPost(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + postDB.getName() + "\"")
                .body(postDB.getData());
    }

    //updatePostDeletedByUser
    @PutMapping("/posts/deletedByUser/{id}")
    ResponseEntity<?> updatePostDeletedByUser( @RequestParam("PostDeletedByUser") Boolean PostDeletedByUser , @PathVariable String id) {
        Optional<PostDB> existingPost = postDBRepository.findById(id);
        existingPost.ifPresent((PostDB post) -> {
            post.setPostDeletedByUser(PostDeletedByUser);
            postDBRepository.save(post);
        });
        return ResponseEntity.ok().build();
    }

    //updatePostAcceptedByAdmin
    @PutMapping("/posts/acceptedByAdmin/{id}")
    ResponseEntity<?> updatePostAcceptedByAdmin( @RequestParam("PostAcceptedByAdmin") Boolean PostAcceptedByAdmin , @PathVariable String id) {
        Optional<PostDB> existingPost = postDBRepository.findById(id);
        existingPost.ifPresent((PostDB post) -> {
            post.setPostAcceptedByAdmin(PostAcceptedByAdmin);
            postDBRepository.save(post);
        });
        return ResponseEntity.ok().build();
    }

    //updatePostDeletedByAdmin
    @PutMapping("/posts/deletedByAdmin/{id}")
    ResponseEntity<?> updatePostDeletedByAdmin( @RequestParam("PostDeletedByAdmin") Boolean PostDeletedByAdmin , @PathVariable String id) {
        Optional<PostDB> existingPost = postDBRepository.findById(id);
        existingPost.ifPresent((PostDB post) -> {
            post.setPostDeletedByAdmin(PostDeletedByAdmin);
            postDBRepository.save(post);
        });
        return ResponseEntity.ok().build();
    }
}
