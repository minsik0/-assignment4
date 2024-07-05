package sparta.code3line.domain.user.dto;

import lombok.Data;
import sparta.code3line.domain.user.entity.User;

import java.util.List;

import static sparta.code3line.domain.board.entity.QBoard.board;

@Data
public class UserResponseDto {

    private String username;
    private String roleName;
    private String nickname;
    private String email;
    private String profileImg;
    private List<User> allUsers;
    private Integer boardLikeCount;
    private Integer commentLikeCount;

    public UserResponseDto(User user){
        this.username = user.getUsername();
        this.roleName = user.getRole().getRoleName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profileImg = user.getProfileImg();
        this.allUsers = null;
    }

    public UserResponseDto(User user, Integer boardLikeCount, Integer commentLikeCount) {
        this.username = user.getUsername();
        this.roleName = user.getRole().getRoleName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profileImg = user.getProfileImg();
        this.boardLikeCount = boardLikeCount;
        this.commentLikeCount = commentLikeCount;
    }

}
