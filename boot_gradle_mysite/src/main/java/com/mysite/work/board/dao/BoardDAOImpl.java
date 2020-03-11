package com.mysite.work.board.dao;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.common.vo.Pagination;
import com.mysite.work.common.vo.Search;

@Repository

public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return sqlSession.selectList("com.mysite.work.mapper.board.BoardMapper.getBoardList");

	}
	@Override
	public List<BoardVO> getBoardList(Pagination pagination ) throws Exception{
		return sqlSession.selectList("com.mysite.work.mapper.board.BoardMapper.getBoardList",pagination);
		
	}
	@Override
	public List<BoardVO> getBoardList(Search search ) throws Exception{
		return sqlSession.selectList("com.mysite.work.mapper.board.BoardMapper.getBoardList",search);
		
	}
	@Override
	public int getBoardListCnt()  throws Exception {
		return sqlSession.selectOne("com.mysite.work.mapper.board.BoardMapper.getBoardListCnt");

	}
	@Override
	public int getBoardListCnt(Search search)  throws Exception {
		return sqlSession.selectOne("com.mysite.work.mapper.board.BoardMapper.getBoardListCnt",search);

	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		return sqlSession.selectOne("com.mysite.work.mapper.board.BoardMapper.getBoardContent", bid);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("com.mysite.work.mapper.board.BoardMapper.insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("com.mysite.work.mapper.board.BoardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		return sqlSession.insert("com.mysite.work.mapper.board.BoardMapper.deleteBoard", bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		return sqlSession.update("com.mysite.work.mapper.board.BoardMapper.updateViewCnt", bid);
	}
	
}
 