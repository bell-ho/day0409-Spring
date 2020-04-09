package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

//	@Test
//	@Deprecated (사용을 금지하는 어노테이션)
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("새로작성하는글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("뉴비");

		mapper.insert(board);
		log.info(board);
	}

//	@Test
	public void testInsertSelectKey() {

		BoardVo board = new BoardVo();
		board.setTitle("새로작성하는글 select key");
		board.setContent("새로작성하는 내용 select key");
		board.setWriter("뉴뷔");

		mapper.insertSelectKey(board);
		log.info(board);
	}
//	@Test
	public void testRead() {
		//존재하는 게시물 번호로 테스트
		BoardVo board = mapper.read(3L);
		
		log.info(board);
	}
//	@Test
	public void testDelete() {
		log.info("delete Count: "+mapper.delete(3L) );
	}
	@Test
	public void testUpdate() {
		BoardVo board = new BoardVo(); //실행전 존재하는 번호인지 확인
		board.setBno(4L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("수정된작가");
		
		int count = mapper.update(board);
		log.info("수정 갯수 "+count);
	}
}
