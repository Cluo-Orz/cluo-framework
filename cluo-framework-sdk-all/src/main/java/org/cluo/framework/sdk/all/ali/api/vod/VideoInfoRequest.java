package org.cluo.framework.sdk.all.ali.api.vod;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.vod
 * Create in 10:32 2019/3/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
public class VideoInfoRequest  implements Serializable {
	@JsonProperty("FileUrl")
	//源文件地址。长度不超过1024个字节，文件名称需要保证全局唯一，添加相同文件名称时，将关联惟一MediaId。
	private String fileUrl;
	@JsonProperty("Title")
	//标题。长度不超过128个字节，UTF8编码。标题值为空时，默认截取文件地址中的文件名称作为标题。
	private String title;
	@JsonProperty("Description")
	//描述。长度不超过1024个字节，UTF8编码。
	private String description;
	@JsonProperty("Tags")
	//标签，多个用逗号分隔。单个标签不超过32字节，最多不超过16个标签。多个用逗号分隔，UTF8编码。
	private String tags;
	@JsonProperty("CoverURL")
	//封面URL。长度不超过1024个字节。
	private String coverURL;
	@JsonProperty("CateId")
	//分类ID。
	private Long cateId;

	public String getFileUrl() {
		return fileUrl;
	}

	public VideoInfoRequest setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public VideoInfoRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public VideoInfoRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTags() {
		return tags;
	}

	public VideoInfoRequest setTags(String tags) {
		this.tags = tags;
		return this;
	}

	public String getCoverURL() {
		return coverURL;
	}

	public VideoInfoRequest setCoverURL(String coverURL) {
		this.coverURL = coverURL;
		return this;
	}

	public Long getCateId() {
		return cateId;
	}

	public VideoInfoRequest setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}
}
