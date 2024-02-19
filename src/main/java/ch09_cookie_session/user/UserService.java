package ch09_cookie_session.user;

import java.util.List;

public interface UserService {
	public static final int CORRECT_LOGIN = 0;		// 제대로 로그인 한 경우
	public static final int WRONG_PASSWORD = 1;		// 패스워드가 틀린 경우
	public static final int USER_NOT_EXIST = 2;
	public static final int COUNT_PER_PAGE = 10;

	User getUserByUid(String uid);   		// 사용자 조회
	
	List<User> getUserList(int page);		// 전체 조회 기능
	
	void registerUser(User user);			// 사용자 등록
	
	void updateUser(User user);				// 수정
	
	void deleteUser(String uid);			// 삭제
	
	int login(String uid, String pwd);		// 로그인 기능
	
//	void close();							// DB 정리 기능
}
