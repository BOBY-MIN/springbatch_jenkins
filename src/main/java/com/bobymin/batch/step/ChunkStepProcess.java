package com.bobymin.batch.step;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.bobymin.batch.vo.TestVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChunkStepProcess implements ItemProcessor<List<TestVo>, List<TestVo>> {

	@Override
	public List<TestVo> process(List<TestVo> item) throws Exception {

		log.info("process() 호출" + item.toString());

		return item;
	}
}
