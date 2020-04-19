package com.sanket.myproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.myproject.model.Comment;
import com.sanket.myproject.model.Project;

@Repository
@Transactional
public class CommentDaoHelper implements CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveComment(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
		return comment.getCommentId();
	}

	@Override
	public Comment getComment(int commentId) {
		return sessionFactory.getCurrentSession().get(Comment.class, commentId);
	}

	@Override
	public List<Comment> getAllComments() {
		List<Comment> commentList = sessionFactory.getCurrentSession().createQuery("from Comment").list();
		return commentList;
	}

	@Override
	public void updateComment(int commentId, Comment comment) {
		Session currentSession = sessionFactory.getCurrentSession();
		Comment oldComment = currentSession.byId(Comment.class).load(commentId);
		oldComment = comment;
		
		currentSession.flush();
		
	}

	@Override
	public void deleteComment(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		Comment delComment= session.byId(Comment.class).load(commentId);
		session.delete(delComment);	
		
	}

}
