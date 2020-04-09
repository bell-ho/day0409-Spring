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
//	@Deprecated (����� �����ϴ� ������̼�)
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("�����ۼ��ϴ±�");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("����");

		mapper.insert(board);
		log.info(board);
	}

//	@Test
	public void testInsertSelectKey() {

		BoardVo board = new BoardVo();
		board.setTitle("�����ۼ��ϴ±� select key");
		board.setContent("�����ۼ��ϴ� ���� select key");
		board.setWriter("����");

		mapper.insertSelectKey(board);
		log.info(board);
	}
//	@Test
	public void testRead() {
		//�����ϴ� �Խù� ��ȣ�� �׽�Ʈ
		BoardVo board = mapper.read(3L);
		
		log.info(board);
	}
//	@Test
	public void testDelete() {
		log.info("delete Count: "+mapper.delete(3L) );
	}
	@Test
	public void testUpdate() {
		BoardVo board = new BoardVo(); //������ �����ϴ� ��ȣ���� Ȯ��
		board.setBno(4L);
		board.setTitle("������ ����");
		board.setContent("������ ����");
		board.setWriter("�������۰�");
		
		int count = mapper.update(board);
		log.info("���� ���� "+count);
	}
}
