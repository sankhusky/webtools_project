package com.sanket.myproject.dao;

import java.util.List;

import com.sanket.myproject.model.Comment;

public interface CommentDao {

	int saveComment(Comment comment);
	
	Comment getComment(int commentId);
	
	List<Comment> getAllComments();
	
	void updateComment(int commentId, Comment comment);
	
	void deleteComment(int commentId);
}
