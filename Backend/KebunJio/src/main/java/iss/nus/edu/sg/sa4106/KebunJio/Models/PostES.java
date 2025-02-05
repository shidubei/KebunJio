package iss.nus.edu.sg.sa4106.KebunJio.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.validation.constraints.NotNull;

//ElasticSearch Class
//@Document(indexName ="post_index")
public class PostES {
	@Id
	private String id;
	@NotNull(message="Title can not be null")
	private String title;
	@NotNull(message="Content can not be null")
	private String content;
	private String questionStatus;
	private LocalDateTime publishedDateTime;
	private Boolean answerSolved;
	private String userId;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
