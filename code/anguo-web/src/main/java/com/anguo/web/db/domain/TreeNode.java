package com.anguo.web.db.domain;

import java.util.List;
import java.util.Map;

/**
 * 树节点
 * @author Andrew.Wen
 *
 */
public class TreeNode {
	
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", text=" + text + ", url=" + url
				+ ", title=" + title + ", iconCls=" + iconCls + ", children="
				+ children + ", parentId=" + parentId + "]";
	}
	private int id;
	private String text;
	private String url;
	private String title;
	private String iconCls;
	private Boolean checked;
	
	
	private Map attributes;
	public Map getAttributes() {
		return attributes;
	}
	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}
	private List<TreeNode> children;
	
	private int parentId;
	
	
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
