package iss.nus.edu.sg.sa4106.KebunJio.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.nus.edu.sg.sa4106.KebunJio.DAO.CommentDAO;
import iss.nus.edu.sg.sa4106.KebunJio.Models.Comment;
import iss.nus.edu.sg.sa4106.KebunJio.Repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public boolean createComment(CommentDAO newComment,String PostId,String UserId) {
		boolean result = false;
		
		Comment comment = new Comment();
		comment.setCommentContent(newComment.commentContent);
		comment.setLikeCount(0);
		comment.setDislikeCount(0);
		comment.setPostId(PostId);
		comment.setUserId(UserId);
		comment.setPublishedDateTime(LocalDateTime.now());
		
		try {
			commentRepository.save(comment);
			result=true;
		}catch(Exception e) {
			throw new RuntimeException("Create comment error");
		}
		
		return result;
		
	}
	
	public Comment getCommentByCommentId(String CommentId) {
		Optional<Comment> comment = commentRepository.findById(CommentId);
		if(comment.isPresent()) {
			return comment.get();
		}else {
			return null;
		}
	}
	
	public boolean calculateLikeCount(String CommentId,boolean hasLiked) {
		boolean result = false;
		Optional<Comment> comment = commentRepository.findById(CommentId);
		if(comment.isPresent()) {
			Comment newComment = comment.get();
			// updateLikeCount
			if(!hasLiked) {
				newComment.setLikeCount(newComment.getLikeCount()+1);
			}else {
				newComment.setLikeCount(newComment.getLikeCount()-1);
			}
			try {
				commentRepository.save(newComment);
				result = true;
			}catch(Exception e) {
				throw new RuntimeException("Update Error");
			}
		}
		
		return result;
	}
	
	public boolean calculateDislikeCount(String CommentId,boolean hasLiked) {
		boolean result = false;
		Optional<Comment> comment = commentRepository.findById(CommentId);
		if(comment.isPresent()) {
			Comment newComment = comment.get();
			// updateLikeCount
			if(!hasLiked) {
				newComment.setDislikeCount(newComment.getDislikeCount()+1);
			}else {
				newComment.setDislikeCount(newComment.getDislikeCount()-1);
			}
			try {
				commentRepository.save(newComment);
				result = true;
			}catch(Exception e) {
				throw new RuntimeException("Update Error");
			}
		}
		
		return result;
	}
}
