package com.bobymin.batch.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestVo {

	private String seqNo;
	private String title;
	private String content;
	private String delYn;
	private Date makeBscDate;
	
}
