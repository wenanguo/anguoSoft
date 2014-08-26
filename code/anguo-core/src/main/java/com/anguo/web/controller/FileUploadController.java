package com.anguo.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.anguo.util.AnguoFileUtils;

/**
 * 上传文件
 * @author Andrew.Wen
 *
 */
@Controller
@RequestMapping(value = "/toFileUpload")
public class FileUploadController  {
	
	

	private Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	
	    /**
		 * 文件批量上传
		 */
		@RequestMapping("/toMultiUpload.htm")
		@ResponseBody
		public void FileUploadify(HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException, IOException {
			
			String clientName ="";
			String serverName ="";
			
			/**
			 * 返回json字符串
			 */
			String returnJson="[";
			

			// 设置接收的编码格式
			request.setCharacterEncoding("UTF-8");
			
			//设置文件保存路径
			String path = request.getSession().getServletContext().getRealPath("")+File.separator+"web/images/upload/";
			
			
			try {
				if (request instanceof MultipartHttpServletRequest) {
					MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
					
					
					List<MultipartFile> files = multipartRequest.getFiles("file");
					
					
					
					//遍历文件
					for(MultipartFile multiparfile:files)
					{
						
						
						clientName = multiparfile.getOriginalFilename(); // 获得文件：
						
						if (!clientName.equals("")) {
							
						serverName = AnguoFileUtils.getRandomFileName() + "."+AnguoFileUtils.getFileExt(clientName);
							
						AnguoFileUtils.SaveFileFromInputStream(multiparfile.getInputStream(),serverName, path);


						}
						
						returnJson+="{\"client\":\"" + clientName + "\",\"server\":\""+ serverName + "\"},";
						
					}
					
					if(returnJson.length()>1)returnJson=returnJson.substring(0, returnJson.length()-1);
					
					returnJson+="]";
					
				}
			} catch (Exception e) {
				logger.error("上传文件失败，因为：" + e.getMessage());
				e.printStackTrace();
			}
			response.getWriter().write(returnJson);
			
		}
		

	  
	
}
