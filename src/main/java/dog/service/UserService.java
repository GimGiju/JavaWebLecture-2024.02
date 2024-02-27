package dog.service;

import java.util.List;

import dog.entity.User;

public interface UserService {

		public static final int CORRECT_LOGIN = 0;		// 제대로 로그인 한 경우
		public static final int WRONG_PASSWORD = 1;		// 패스워드가 틀린 경우
		public static final int USER_NOT_EXIST = 2;
		public static final int COUNT_PER_PAGE = 10;

		User getUserByUserId(int userId);   		// 사용자 조회
		
		
		List<User> getUserList(int page);		// 전체 조회 기능
		
		int getUserCount();						// 
		
		void registerUser(User user);			// 사용자 등록
		
		void updateUser(User user);				// 수정
		
		void deleteUser(String uid);			// 삭제
		
		int login(String uid, String pwd);		// 로그인 기능
		
}


