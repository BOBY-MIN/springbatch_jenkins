package com.bobymin.batch.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bobymin.batch.vo.TestVo;

@Mapper
public interface TestMapper {

	@Select("SELECT SEQ_NO, TITLE, CONTENT, DEL_YN, MAKE_BSC_DATE FROM CRUD_TEST_TABLE")
	public List<TestVo> selectList();
	
	@Update("UPDATE CRUD_TEST_TABLE SET CONTENT = #{content} WHERE SEQ_NO = #{seqNo}")
	public int updateOne(TestVo testVo);
}
