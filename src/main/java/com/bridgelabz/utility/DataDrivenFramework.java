package com.bridgelabz.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenFramework {

    XSSFWorkbook wk;
    XSSFSheet sheet;
    int rowNumber;

    public DataDrivenFramework(String excelPath) {
        File file = new File(excelPath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            this.wk = new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getData(int sheetNo, int row, int column ) {
        this.sheet = this.wk.getSheetAt(sheetNo);
        Cell cell = this.sheet.getRow(row).getCell(column);
        String data = cell.getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex){
        rowNumber = this.wk.getSheetAt(sheetIndex).getLastRowNum();
        ++rowNumber;
        return rowNumber;
    }
}
