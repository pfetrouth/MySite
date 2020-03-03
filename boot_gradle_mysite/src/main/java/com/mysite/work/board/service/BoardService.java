package com.mysite.work.board.service;

import java.util.List;
import com.mysite.work.board.vo.BoardVO;


public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception;
	
	public int insertBoard( BoardVO boardVO) throws Exception;
	
	public BoardVO getBoardContent( int bid) throws Exception;
	

}
