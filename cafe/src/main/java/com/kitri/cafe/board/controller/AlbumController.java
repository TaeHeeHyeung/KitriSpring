package com.kitri.cafe.board.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kitri.cafe.board.model.AlbumDto;
import com.kitri.cafe.board.service.AlbumService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;

@Controller
@RequestMapping("/album")
public class AlbumController {
	Logger logger = LoggerFactory.getLogger(AlbumController.class);

	//내장객체
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value ="/write", method= RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter ,Model model) {
		logger.debug("write");
		model.addAttribute("parameter",parameter);
	}
	
	@RequestMapping(value ="/write", method= RequestMethod.POST)
	public String write(AlbumDto albumDto, @RequestParam Map<String, String> parameter ,Model model
			,HttpSession session, @RequestParam(name = "picture") MultipartFile multipartFile) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");

		
		if(memberDto!=null) {
			int seq = commonService.getNextSeq();
			logger.debug("ReboardController getNextSeq: "+"seq");
			System.out.println("ReboardController getNextSeq: "+"seq");
			albumDto.setSeq(seq);
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
			albumDto.setEmail(memberDto.getEmail());
			
			// 인풋이 존재한다,파일을 올렸다
			if(multipartFile!= null && !multipartFile.isEmpty()) {
				String orignPicture = multipartFile.getOriginalFilename();
				String realPath = servletContext.getRealPath("/upload/album");
//				String savePicture = multipartFile.get
				DateFormat df = new SimpleDateFormat("yyMMdd");
				String saveFolder = df.format(new Date());
				String realSaveFolder = realPath +java.io.File.separator+ saveFolder;
				java.io.File dir = new java.io.File(realSaveFolder);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				String savePicture = UUID.randomUUID().toString() + orignPicture.substring(orignPicture.lastIndexOf('.'));
				
				java.io.File file = new java.io.File(realSaveFolder, savePicture);
				System.out.println(realSaveFolder+"/"+savePicture);
				try {
					multipartFile.transferTo(file);
					System.out.println( "파일 업로드가 된다.");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				albumDto.setOrignPicture(orignPicture);
				albumDto.setSavePicture(savePicture);
				albumDto.setSaveFolder(saveFolder);
			}
			//TODO: 
			//1. imagefile검사
			//2. thumbnail image
			//3. 
			seq = albumService.writeArticle(albumDto);
			
			if(seq !=0) {
				model.addAttribute("seq", seq);
			}else {
				model.addAttribute("errorMsg", "서버문제로 글작성 실패!!!");
			}
			logger.debug(">>"+seq);
			logger.debug(albumDto.toString());
			System.out.println(">>"+seq);
			model.addAttribute("parameter", parameter);
		}else {
			model.addAttribute("errorMsg", "로그인 후 글작성 하시오!!!");
		}
		return "album/writeOk";	
	}//end write
}
