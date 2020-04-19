package com.sanket.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanket.myproject.dao.CommentDao;
import com.sanket.myproject.model.Comment;

@Service
@Transactional
public class CommentServiceHelper implements CommentService{

	@Autowired 
	private CommentDao commentDao;

	@Override
	@Transactional
	public int saveComment(Comment comment) {
		return commentDao.saveComment(comment);		
	}

	@Override
	@Transactional
	public Comment getComment(int commentId) {
		return commentDao.getComment(commentId);
	}

	@Override
	@Transactional
	public List<Comment> getAllComments() {
		return commentDao.getAllComments();
	}

	@Override
	@Transactional
	public void updateComment(int commentId, Comment comment) {
		commentDao.updateComment(commentId, comment);
		
	}

	@Override
	@Transactional
	public void deleteComment(int commentId) {
		commentDao.deleteComment(commentId);
		
	}
	
}
