package com.umbrella.project_umbrella.domain.Post;

import com.umbrella.project_umbrella.domain.Comment.Comment;
import com.umbrella.project_umbrella.domain.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    @Column(nullable = true)
    private Long id;

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Post(Long id, String title) {
        this.id = id;
        this.title = title;
    }


    @Builder
    public Post(String writer, String title, String content){
        this.writer = writer;
        this.content = content;
        this.title = title;
    }


    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}