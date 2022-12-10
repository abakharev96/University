package org.example;

import models.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriterXLSX {
    public static void writeToExcel(ArrayList<Statistics> statistics, String URL){

        int rowNumber = 0;
        Workbook workbook = new XSSFWorkbook();
        Sheet statisticSheet = workbook.createSheet("Statistic university");
        addHeaderToStatisticExcel(workbook, statisticSheet, rowNumber);
        addFontToHeaderStatisticExcel(workbook);
        fillData(statisticSheet, statistics, rowNumber);

        try (FileOutputStream fos = new FileOutputStream(URL)) {
            workbook.write(fos);
            System.out.println("The excel file was added successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addHeaderToStatisticExcel(Workbook workbook, Sheet statisticSheet, int rowNumber){
        Row row = statisticSheet.createRow(rowNumber);
        row.createCell(0).setCellValue("Main profile");
        row.createCell(1).setCellValue("Average exam score");
        row.createCell(2).setCellValue("Students count by profile");
        row.createCell(3).setCellValue("Universities count by profile");
        row.createCell(4).setCellValue("Average exam score by universities");
        row.createCell(5).setCellValue("Average exam score by profile");
        row.createCell(6).setCellValue("University name");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            row.getCell(i).setCellStyle(headerStyle);
        }
        setAutoSize(statisticSheet, row);

    }

    private static void addFontToHeaderStatisticExcel(Workbook workbook){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
    }
    
    private static void setAutoSize(Sheet statisticSheet, Row row) {
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            statisticSheet.autoSizeColumn(i);
        }
    }

    public static void fillData(Sheet statisticSheet, ArrayList<Statistics> statistics, int rowNumber){
        for (Statistics statistic : statistics){
            rowNumber++;
            Row rowForStatistics = statisticSheet.createRow(rowNumber);
            Cell mainProfile = rowForStatistics.createCell(0);
            Cell avgExamScore = rowForStatistics.createCell(1);
            Cell studentsCountByProfile = rowForStatistics.createCell(2);
            Cell universitiesCountByProfile = rowForStatistics.createCell(3);
            Cell avgExamScoreByUniversities = rowForStatistics.createCell(4);
            Cell avgExamScoreByProfile = rowForStatistics.createCell(5);
            Cell universityName = rowForStatistics.createCell(6);

            mainProfile.setCellValue(statistic.getMainProfile().getProfileName());
            avgExamScore.setCellValue(statistic.getAvgExamScore());
            studentsCountByProfile.setCellValue(statistic.getStudentsCountByProfile());
            universitiesCountByProfile.setCellValue(statistic.getUniversitiesCountByProfile());
            avgExamScoreByUniversities.setCellValue(statistic.getAvgExamScoreByUniversities());
            avgExamScoreByProfile.setCellValue(statistic.getAvgExamScoreByProfile());
            universityName.setCellValue(statistic.getUniversityName());
        }
    }
}
