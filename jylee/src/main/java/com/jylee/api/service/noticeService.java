package com.jylee.api.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jylee.api.mapper.fileMapper;
import com.jylee.api.mapper.noticeMapper;
import com.jylee.api.vo.fileVO;
import com.jylee.api.vo.noticeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("noticeService")
public class noticeService {

	@Value("${file.upload.path}")
	private String uploadPath;

	private noticeMapper noticemapper;
	private fileMapper filemapper;

	public noticeService(noticeMapper noticemapper, fileMapper filemapper) {
		this.noticemapper = noticemapper;
		this.filemapper = filemapper;
	}

	public List<noticeVO> selectNoticeList(){
		return noticemapper.selectNoticeList();
	}

	public void insertNotice(noticeVO ntc, MultipartFile[] files) throws IOException{

		String ntcId = noticemapper.selectNoticeId();

		if(null != files && files.length > 0) {
			for(int i=0; i < files.length; i++) {
				//String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();

				fileVO file = fileVO.builder()
						.fileId(ntcId)
						.fileSeq(String.valueOf(i))
						.originalName(files[i].getOriginalFilename())
						.savePath(uploadPath)
						.format(StringUtils.getFilenameExtension(files[i].getOriginalFilename().toLowerCase()))
						.size(files[i].getSize())
						.build();

				fileUpload(files[i]);
				filemapper.insertFile(file);
			}
		}
		ntc.setNtcId(ntcId);
		ntc.setNtcFileId(ntcId);
		noticemapper.insertNotice(ntc);
	}

	public void fileUpload(MultipartFile file) throws IOException{
		String fullPath = uploadPath + file.getOriginalFilename();
		file.transferTo(new File(fullPath));
	}
}
