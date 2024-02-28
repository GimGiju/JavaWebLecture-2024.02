package dog.service;

import java.util.List;

import dog.entity.Board;

public interface BoardService {
	public static final int COUNT_PER_PAGE = 10;

	List<Board> getBoardList(int page, String field, String query);
	
	Board getBoard(int boardId);
	
	int getBoardCount(String field, String query);
	
	void insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(int boardId);
	
	void increaseViewCount(int boardId);		// 조회수 증가
	
	void increaseReplyCount(int boardId);		// 댓글 증가
}