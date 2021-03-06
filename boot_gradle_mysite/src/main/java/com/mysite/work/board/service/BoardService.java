package com.mysite.work.board.service;

import java.util.List;

import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.board.vo.ReplyVO;
import com.mysite.work.common.vo.Pagination;
import com.mysite.work.common.vo.Search;


public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception;
	
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception ;
	public int getBoardListCnt() throws Exception;
	
	public int getBoardListCnt(Search search) throws Exception;
	
	public int insertBoard( BoardVO boardVO) throws Exception;
	
	public int updateBoard( BoardVO boardVO) throws Exception;
	
	public int deleteBoard(int bid) throws Exception;
	
	public BoardVO getBoardContent( int bid) throws Exception;
	
	public void testInsertBoard() throws Exception ;
	// 댓글 리스트
	public List<ReplyVO> getReplyList(int bid) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;
}
