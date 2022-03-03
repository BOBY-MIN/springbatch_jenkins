package com.bobymin.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobymin.batch.persistence.TestMapper;
import com.bobymin.batch.vo.TestVo;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public List<TestVo> selectList() {
		return testMapper.selectList();
	}

	@Override
	public int updateOne(TestVo testVo) {
		return testMapper.updateOne(testVo);
	}

}
