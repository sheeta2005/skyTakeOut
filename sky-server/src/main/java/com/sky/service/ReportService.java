package com.sky.service;

import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;


public interface ReportService {

    public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);


    public UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

}
