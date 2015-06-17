package com.onLineNote.pojo.right;

import java.sql.Timestamp;

/**
 * TNoteInfo entity. @author MyEclipse Persistence Tools
 */

public class TNoteInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer noteId;
	private Timestamp noteDate;
	private String noteKind;
	private String noteLabel;
	private String noteTitle;
	private String noteContent;
	private String noteRemark;

	// Constructors

	/** default constructor */
	public TNoteInfo() {
	}

	/** minimal constructor */
	public TNoteInfo(Timestamp noteDate, String noteKind, String noteLabel,
			String noteTitle, String noteContent) {
		this.noteDate = noteDate;
		this.noteKind = noteKind;
		this.noteLabel = noteLabel;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
	}

	/** full constructor */
	public TNoteInfo(Timestamp noteDate, String noteKind, String noteLabel,
			String noteTitle, String noteContent, String noteRemark) {
		this.noteDate = noteDate;
		this.noteKind = noteKind;
		this.noteLabel = noteLabel;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteRemark = noteRemark;
	}

	// Property accessors

	public Integer getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public Timestamp getNoteDate() {
		return this.noteDate;
	}

	public void setNoteDate(Timestamp noteDate) {
		this.noteDate = noteDate;
	}

	public String getNoteKind() {
		return this.noteKind;
	}

	public void setNoteKind(String noteKind) {
		this.noteKind = noteKind;
	}

	public String getNoteLabel() {
		return this.noteLabel;
	}

	public void setNoteLabel(String noteLabel) {
		this.noteLabel = noteLabel;
	}

	public String getNoteTitle() {
		return this.noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return this.noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteRemark() {
		return this.noteRemark;
	}

	public void setNoteRemark(String noteRemark) {
		this.noteRemark = noteRemark;
	}

}