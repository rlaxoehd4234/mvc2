package com.umbrella.project_umbrella.dto.post;

import com.umbrella.project_umbrella.domain.Post.Post;
import com.umbrella.project_umbrella.domain.User.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostSaveRequestDto {


    private String title;

    private String content;

    private String writer;


    @Builder
    public PostSaveRequestDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Post toEntity(){
        return Post.builder().
                title(title).
                content(content).
                writer(writer).
                build();
    }

}
