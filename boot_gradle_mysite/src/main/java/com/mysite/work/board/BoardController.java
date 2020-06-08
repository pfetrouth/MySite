package com.mysite.work.board;

import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysite.work.board.service.BoardService;
import com.mysite.work.board.vo.BoardVO;
import com.mysite.work.board.vo.ReplyVO;
import com.mysite.work.common.vo.Search;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService boardService;
	
	
	
//	@Autowired
//    RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "title") String searchType
			, @RequestParam(required = false) String keyword		
			, HttpServletRequest resquest 
			, HttpServletResponse response ) throws Exception {
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		
		//전체 게시글 개수
		int listCnt = boardService.getBoardListCnt(search);
		//Pagination 객체생성
		search.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", search);
		model.addAttribute("boardList", boardService.getBoardList(search));
		return "/board/index";
	}
	
	@RequestMapping(value = "/boardForm")
	public String boardForm(Model model) throws Exception {	 
		model.addAttribute("boardVO", new BoardVO());
		return "/board/boardForm";
	}

	@RequestMapping(value = "/saveBoard_prev", method=RequestMethod.POST)
	public String saveForm(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		boardService.insertBoard(boardVO);
		return "redirect:/board/getBoardList";
	}

	@RequestMapping(value = "/saveBoard", method=RequestMethod.POST)
	public String saveForm(@ModelAttribute("BoardVO") BoardVO boardVO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}
		return "redirect:/board/getBoardList";
	}

	@RequestMapping(value = "/getBoardContent", method=RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent",boardService.getBoardContent(bid));
		//model.addAttribute("replyVO",boardService.getReplyList(bid));
		model.addAttribute("replyVO",new ReplyVO());
		return "/board/boardContent"; 
	}
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "/board/boardForm";
	}
	
	@RequestMapping(value = "/deleteBoard", method=RequestMethod.GET)
	public String delteBoard( @RequestParam("bid") int bid, RedirectAttributes rttr) throws Exception {
		 
			boardService.deleteBoard(bid);
			
		return "redirect:/board/getBoardList";
	}
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String testInsertBoard() throws Exception {
		 
			boardService.testInsertBoard();
			
		return "redirect:/board/getBoardList";
	} 

}	
