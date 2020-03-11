package com.mysite.work.board.dao;

import java.util.List;

import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.common.vo.Pagination;
import com.mysite.work.common.vo.Search;

public interface BoardDAO {
	public List<BoardVO> getBoardList() throws Exception;
	public List<BoardVO> getBoardList(Pagination pagination ) throws Exception;
	public List<BoardVO> getBoardList(Search search) throws Exception;
	
	public int getBoardListCnt() throws Exception;
	public int getBoardListCnt(Search search) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int updateViewCnt(int bid) throws Exception; 

}
 