package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		boardMapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = boardMapper.read(5L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT:"+boardMapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = boardMapper.update(board);
		log.info("UPDATE COUNT:"+count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testSearchPaging() {
		Criteria cri = new Criteria();
		//cri.setType("TCW");
		//cri.setKeyword("테스트");
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
