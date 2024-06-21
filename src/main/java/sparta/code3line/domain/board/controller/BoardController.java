package sparta.code3line.domain.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sparta.code3line.common.CommonResponse;
import sparta.code3line.domain.board.dto.BoardRequestDto;
import sparta.code3line.domain.board.dto.BoardResponseDto;
import sparta.code3line.domain.board.service.BoardService;
import sparta.code3line.domain.comment.controller.CommentController;
import sparta.code3line.security.UserPrincipal;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final CommentController commentController;

    // 게시글 추가.
    @PostMapping("/boards")
    public ResponseEntity<CommonResponse<BoardResponseDto>> addBoard(
            @RequestBody BoardRequestDto requestDto,
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        BoardResponseDto responseDto = boardService.addBoard(userPrincipal.getUser(), requestDto);
        CommonResponse<BoardResponseDto> commonResponse = new CommonResponse<>(
                "게시글 등록 성공",
                201,
                responseDto
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(commonResponse);
    }

    // 게시글 전체 조회
    @GetMapping("/boards")
    public ResponseEntity<CommonResponse<List<BoardResponseDto>>> getAllBoards(
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        List<BoardResponseDto> responseDto = boardService.getAllBoards(userPrincipal.getUser());
        CommonResponse<List<BoardResponseDto>> commonResponse = new CommonResponse<>(
                "게시글 조회 완료",
                200,
                responseDto
        );
        return ResponseEntity.status(HttpStatus.OK).body(commonResponse);
    }

    // 게시글 단건 조회
    @GetMapping("/boards/{boardId}")
    public ResponseEntity<CommonResponse<BoardResponseDto>> getOneBoard(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @PathVariable Long boardId) {

        BoardResponseDto responseDto = boardService.getOneBoard(userPrincipal.getUser(), boardId);
        CommonResponse<BoardResponseDto> commonResponse = new CommonResponse<>(
                "게시글 단건 조회 완료.",
                200,
                responseDto
        );
        return ResponseEntity.status(HttpStatus.OK).body(commonResponse);
    }
}

