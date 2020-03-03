package com.mysite.work.board.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysite.work.board.dao.BoardDAO;
import com.mysite.work.board.service.BoardService;
import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.login.controller.RestfulAPISample; 


	@Service

	public class BoardServiceImpl implements BoardService{
		
		Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

		@Inject

		private BoardDAO boardDAO;		

		public List<BoardVO> getBoardList() throws Exception {

			return boardDAO.getBoardList();

		}
		
		public int insertBoard( BoardVO boardVO) throws Exception{
			
			return  boardDAO.insertBoard(boardVO);
		}
		
		public BoardVO getBoardContent( int bid) throws Exception{
			
			BoardVO vo = boardDAO.getBoardContent(bid);
			
			logger.debug("vo :"+vo);
			
			return vo;
		}
	}
