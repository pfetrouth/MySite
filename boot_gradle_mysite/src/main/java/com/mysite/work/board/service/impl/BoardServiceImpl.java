package com.mysite.work.board.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysite.work.board.dao.BoardDAO;
import com.mysite.work.board.service.BoardService;
import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.common.vo.Pagination;
import com.mysite.work.common.vo.Search; 


	@Service
	public class BoardServiceImpl implements BoardService{
		
		Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

		@Inject

		private BoardDAO boardDAO;		

		public List<BoardVO> getBoardList() throws Exception {

			return boardDAO.getBoardList();

		}
		
		public List<BoardVO> getBoardList(Pagination pagination) throws Exception {

			return boardDAO.getBoardList(pagination);

		}
		
		public List<BoardVO> getBoardList(Search search) throws Exception {
			
			return boardDAO.getBoardList(search);
		}
		
		public int getBoardListCnt() throws Exception{
			
			return boardDAO.getBoardListCnt();
		}
		
		public int getBoardListCnt(Search search) throws Exception{
			
			return boardDAO.getBoardListCnt(search);
		}
		
		public int insertBoard( BoardVO boardVO) throws Exception{
			
			return  boardDAO.insertBoard(boardVO);
		}
		
		public int deleteBoard( int bid ) throws Exception{
			
			return  boardDAO.deleteBoard(bid);
		}

		public int updateBoard( BoardVO boardVO) throws Exception{
			
			return  boardDAO.updateBoard(boardVO);
		}
		
		public BoardVO getBoardContent( int bid) throws Exception{
			
			BoardVO vo = boardDAO.getBoardContent(bid);
			boardDAO.updateViewCnt(bid);
//			
//			vo.setBid(bid);
//			vo.setCate_cd("1111111111111111111111111111111111111");
//			boardDAO.updateBoard(vo);
			
			
			
			return vo;
		}
		 
		public void testInsertBoard() throws Exception {

			BoardVO boardVO = new BoardVO();

			boardVO.setCate_cd("1");

		//	boardVO.setTitle("첫번째 게시물 입니다.");

		//	boardVO.setContent("첫번째 게시물입니다.");

			boardVO.setTag("1");
			boardVO.setReg_id("1");


	   for( int i = 1; i < 1234 ; i++) {

	    boardVO.setTitle(i + " 번째 게시물 입니다.");
	    boardVO.setContent(i + " 번째 게시물 입니다.");
	    int result = boardDAO.insertBoard(boardVO);
			logger.info("\n Insert Board Result " +result);
			if(result == 1) {
				logger.info("\n 게시물 등록 성공 ");
			} else {
				logger.info("\n 게시물 등록 실패");

			}
	   }
		} 
	}
