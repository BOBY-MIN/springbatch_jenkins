package com.bobymin.batch.step;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bobymin.batch.service.TestService;
import com.bobymin.batch.vo.TestVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChunkStepRead implements ItemReader<List<TestVo>> {

	public static int cnt = 0;

	@Autowired
	private TestService testService;

	@Override
	public List<TestVo> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		log.info("read() 호출");

		cnt++;

		if(cnt > 8) {
			return null;
		}

		List<TestVo> tempList = testService.selectList();

		log.info("read() 호출" + tempList.toString());

		return tempList;
	}
}
