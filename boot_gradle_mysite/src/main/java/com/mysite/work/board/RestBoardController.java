package com.mysite.work.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.work.board.service.BoardService;
import com.mysite.work.board.vo.ReplyVO;



@RestController
//@RequestMapping(value = "/restBoard")
@RequestMapping(value = "/api/restBoard")
public class RestBoardController {

	private static final Logger logger = LoggerFactory.getLogger(RestBoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getReplyList", method = RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("bid") int bid) throws Exception {
		return boardService.getReplyList(bid);

	}
	
	@RequestMapping(value = "/saveReqly", method = RequestMethod.POST)
	public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			boardService.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}		

		return result;
	}

}