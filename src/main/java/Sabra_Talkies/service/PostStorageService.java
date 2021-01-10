package Sabra_Talkies.service;

import java.io.IOException;
import java.util.stream.Stream;
import Sabra_Talkies.models.PostDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import Sabra_Talkies.repository.PostDBRepository;

@Service
public class PostStorageService {

    @Autowired
    private PostDBRepository postDBRepository;

    public PostDB store(MultipartFile file , String userMail, String userId, String firstname,
                        String postTitle, String content, String createdOn,
                        Boolean PostDeletedByUser, Boolean PostAcceptedByAdmin, Boolean PostDeletedByAdmin ) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        PostDB PostDB = new PostDB(fileName, file.getContentType(), file.getBytes() , userMail ,
                userId , firstname ,postTitle ,content , createdOn,
                PostDeletedByUser,PostAcceptedByAdmin,PostDeletedByAdmin);
        return postDBRepository.save(PostDB);
    }

    public PostDB getPost(String id) {
        return postDBRepository.findById(id).get();
    }

    public Stream<PostDB> getAllPosts() {
        return postDBRepository.findAll().stream();
    }

}
