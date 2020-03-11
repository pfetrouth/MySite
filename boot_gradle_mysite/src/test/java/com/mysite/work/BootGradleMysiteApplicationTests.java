package com.mysite.work;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.work.board.dao.BoardDAO;
import com.mysite.work.board.vo.BoardVO;

@SpringBootTest
class BootGradleMysiteApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(BootGradleMysiteApplicationTests.class);	
	@Inject
	private BoardDAO boardDAO;
	
	@Test 
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