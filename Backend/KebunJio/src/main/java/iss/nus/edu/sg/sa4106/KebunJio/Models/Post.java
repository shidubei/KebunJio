package iss.nus.edu.sg.sa4106.KebunJio.Models;

import java.time.LocalDateTime;

public class Post {
	private int postId;
	private String title;
	private String content;
	private String questionStatus;
	private LocalDateTime publishedDateTime;
	private Boolean answerSolved;
	
	private User user;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}

	public LocalDateTime getPublishedDateTime() {
		return publishedDateTime;
	}

	public void setPublishedDateTime(LocalDateTime publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}

	public Boolean getAnswerSolved() {
		return answerSolved;
	}

	public void setAnswerSolved(Boolean answerSolved) {
		this.answerSolved = answerSolved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
