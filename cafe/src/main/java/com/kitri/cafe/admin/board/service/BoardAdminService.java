package com.kitri.cafe.admin.board.service;

import java.util.List;

import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

public interface BoardAdminService {

	List<BoardListDto> getBoardMenuList(int ccode); //게시판의 이름
	
	List<CategoryDto>getCategoryList();
	void makeCategory(CategoryDto categoryDto);
	
	List<BoardTypeDto> getBoardTypeList(); //게시판의 형식
	void makeBoard(BoardListDto boardListDto);
}
