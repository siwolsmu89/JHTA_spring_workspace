package kr.co.jhta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.dao.BlogCommentDao;
import kr.co.jhta.dao.BlogDao;
import kr.co.jhta.dao.UserDao;
import kr.co.jhta.exception.DuplicatedUserException;
import kr.co.jhta.exception.UnauthenticatedUserException;
import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;
import kr.co.jhta.vo.User;

/**
 * 사용자에게 제공되는 서비스를 직접 구현하는 구현 클래스
 * @author JHTA
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BlogCommentDao blogCommentDao;
	
	@Override
	public void addNewUser(User user) {
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new DuplicatedUserException("["+user.getId()+"]는 사용할 수 없는 아이디 입니다.");
		}
		
		userDao.insertUser(user);
	}
	
	@Override
	public User login(String id, String password) {
		
		User user = userDao.getUserById(id);
		if (user == null) {
			throw new UnauthenticatedUserException("ID or PASSWORD가 올바르지 않습니다.");
		}
		if (!user.getPassword().equals(password)) {
			throw new UnauthenticatedUserException("ID or PASSWORD가 올바르지 않습니다.");
		}
		return user;
	}

	@Override
	public List<Blog> getMyBlogs(String userId) {
		return blogDao.getBlogsByWriter(userId);
	}

	@Override
	public List<Comment> getMyComments(String userId) {
		return blogCommentDao.getCommentsByWriter(userId);
	}

	@Override
	public void updateUserInfo(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteMyAccount(String userId) {
		// 내가 작성한 댓글 전체 삭제
		blogCommentDao.deleteCommentsByWriter(userId);
		
		// 내가 작성한 글 전체 조회
		List<Blog> myBlogs = blogDao.getBlogsByWriter(userId);
		for (Blog blog : myBlogs) {
			// 내가 작성한 글에 달린 댓글 전체 삭제
			blogCommentDao.deleteCommentsByBlogNo(blog.getNo());
		}
		// 내가 작성한 글 전체 삭제
		blogDao.deleteBlogsByWriter(userId);
		// 사용자 정보 삭제
		userDao.deleteUserById(userId);
	}
}
