package com.bobymin.batch.service;

import java.util.List;

import com.bobymin.batch.vo.TestVo;

public interface TestService {

	public List<TestVo> selectList();
	public int updateOne(TestVo testVo);
}
