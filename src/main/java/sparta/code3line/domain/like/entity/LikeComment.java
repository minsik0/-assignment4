package sparta.code3line.domain.like.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.code3line.common.Timestamp;
import sparta.code3line.domain.comment.entity.Comment;
import sparta.code3line.domain.user.entity.User;

@Getter
@Entity
@NoArgsConstructor
public class LikeComment extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public LikeComment(Long id, User user, Comment comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }

}
