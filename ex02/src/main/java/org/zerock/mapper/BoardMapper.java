package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVo>getList(); //리스트
	
	public void insert(BoardVo board); //insert 실행후 pk값 알필요 없음
	
	public void insertSelectKey(BoardVo board); //insert 실행후 pk값 알아야함
	
	public BoardVo read(Long bno); //read 처리
	
	public int delete(Long bno);
	
	public int update(BoardVo board);
}
