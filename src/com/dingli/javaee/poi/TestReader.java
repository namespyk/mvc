package com.dingli.javaee.poi;

import com.dingli.javaee.util.poi.reader.AbsSAXExcelReader;
import com.dingli.javaee.util.poi.reader.ExcelReader;

import java.util.List;

public class TestReader {
    public static void main(String[] args) throws Exception{
        ExcelReader reader = new AbsSAXExcelReader("D:/dddd.xlsx") {
            @Override
            public void onRowRead(int sheetIndex, int curRow, List<String> rowList) {
                for(String str : rowList){
                    System.out.print(str + "\t");
                }
                System.out.println();
            }
        };
        reader.read(0);
    }
}
