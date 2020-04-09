package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVo>getList(); //����Ʈ
	
	public void insert(BoardVo board); //insert ������ pk�� ���ʿ� ����
	
	public void insertSelectKey(BoardVo board); //insert ������ pk�� �˾ƾ���
	
	public BoardVo read(Long bno); //read ó��
	
	public int delete(Long bno);
	
	public int update(BoardVo board);
}
