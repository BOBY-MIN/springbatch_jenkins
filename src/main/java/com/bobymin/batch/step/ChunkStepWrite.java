package com.bobymin.batch.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bobymin.batch.service.TestService;
import com.bobymin.batch.vo.TestVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChunkStepWrite implements ItemWriter<List<TestVo>> {

	@Autowired
	private TestService testService;

	@Override
	public void write(List<? extends List<TestVo>> items) throws Exception {

		log.info("write() 호출" + items.toString());

		for(List<TestVo> argList : items) {
			for(TestVo arg : argList) {


				arg.setContent(ChunkStepRead.cnt + "  test");
				log.info("write ==== " + arg.toString());

				testService.updateOne(arg);

			}
		}

//		if(ChunkStepRead.cnt == 4) {
//			throw new Exception("rollback test");
//		}

		List<TestVo> tempList = testService.selectList();

		log.info("write() 후처리 호출" + tempList.toString());

	}

}
