package com.jylee.api.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class fileVO {

	private String fileId;
	private String fileSeq;
	private String savePath;
	private String originalName;
	private String format;
	private String regDate;
	private long size;
}
