package org.example;

import models.Statistics;
import models.Student;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriterXLSX {
    public static void writeToExcel(ArrayList<Statistics> statistics, String URL){

        int rowNumber = 0;

        try (FileOutputStream fileOutput = new FileOutputStream(new File(URL))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet statisticSheet = workbook.createSheet("Statistics");
            addFontToHeaderStatisticExcel(workbook);
            addHeaderToStatisticExcel(statisticSheet, rowNumber);
            System.out.println("Excel file was created successfully");
        } catch (IOException e) {
            System.out.println("Some problems occurs with excel file. Please check link.");
            throw new RuntimeException(e);
        }
    }

    private static void addHeaderToStatisticExcel(XSSFSheet statisticSheet, int rowNumber){
        Row row = statisticSheet.createRow(rowNumber);
        row.createCell(0).setCellValue("Main profile");
        row.createCell(1).setCellValue("Average exam score");
        row.createCell(2).setCellValue("Students count by profile");
        row.createCell(3).setCellValue("Universities count by profile");
        row.createCell(4).setCellValue("Average exam score by universities");
        row.createCell(5).setCellValue("Average exam score by profile");
        row.createCell(6).setCellValue("University name");

        XSSFFont font = statisticSheet.getWorkbook().createFont();

    }

    private static void addFontToHeaderStatisticExcel(XSSFWorkbook workbook){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
    }

    public static ArrayList<Statistics> fillData(){
        ArrayList<Statistics> data = new ArrayList<>();

        return data;
    }
}
