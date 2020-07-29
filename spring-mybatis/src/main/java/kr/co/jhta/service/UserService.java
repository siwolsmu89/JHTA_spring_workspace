package kr.co.jhta.service;

import java.util.List;

import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;
import kr.co.jhta.vo.User;

/**
 * 사용자에게 제공되는 서비스를 정의하는 인터페이스
 * 
 * @author JHTA
 *
 */
public interface UserService {

	/**
	 * 회원가입 서비스를 제공한다. <br />
	 * 동일한 아이디를 가진 사용자는 등록될 수 없다. <br />
	 * @param user 회원가입 정보가 포함된 User객체
	 */
	void addNewUser(User user);
	
	/**
	 * 아이디와 비밀번호를 검증해서 인증된 사용자인 경우, 사용자 정보를 제공한다.
	 * @param id
	 * @param password
	 * @return User객체, null 이 반환될 수 있음.
	 */
	User login(String id, String password);
	
	List<Blog> getMyBlogs(String userId);
	List<Comment> getMyComments(String userId);
	void updateUserInfo(User user);
	void deleteMyAccount(String userId);
}
