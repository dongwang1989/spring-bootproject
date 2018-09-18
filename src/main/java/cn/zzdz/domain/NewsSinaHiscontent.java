package cn.zzdz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the news_sina_hiscontent database table.
 * 
 */
@Entity
@Table(name = "news_sina_hiscontent")
// @NamedQuery(name = "NewsSinaHiscontent.findAll", query = "SELECT n FROM
// NewsSinaHiscontent n")
public class NewsSinaHiscontent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String newsId;

	private int newsCommentNum;

	private String newsContent;

	private String newsEditor;

	private String newsField;

	private String newsKeyWords;

	private String newsMedia;

	private Date newsPaTime;

	private String newsSource;

	private Date newsTime;

	private String newsTitle;

	private String newsUrl;

	public NewsSinaHiscontent() {
	}

	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public int getNewsCommentNum() {
		return this.newsCommentNum;
	}

	public void setNewsCommentNum(int newsCommentNum) {
		this.newsCommentNum = newsCommentNum;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsEditor() {
		return this.newsEditor;
	}

	public void setNewsEditor(String newsEditor) {
		this.newsEditor = newsEditor;
	}

	public String getNewsField() {
		return this.newsField;
	}

	public void setNewsField(String newsField) {
		this.newsField = newsField;
	}

	public String getNewsKeyWords() {
		return this.newsKeyWords;
	}

	public void setNewsKeyWords(String newsKeyWords) {
		this.newsKeyWords = newsKeyWords;
	}

	public String getNewsMedia() {
		return this.newsMedia;
	}

	public void setNewsMedia(String newsMedia) {
		this.newsMedia = newsMedia;
	}

	public Date getNewsPaTime() {
		return this.newsPaTime;
	}

	public void setNewsPaTime(Date newsPaTime) {
		this.newsPaTime = newsPaTime;
	}

	public String getNewsSource() {
		return this.newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public Date getNewsTime() {
		return this.newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsUrl() {
		return this.newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

}