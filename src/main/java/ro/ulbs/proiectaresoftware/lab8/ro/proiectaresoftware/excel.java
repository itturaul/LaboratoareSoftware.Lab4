package ro.proiectaresoftware.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelProcessor {

    public static void main(String[] args) {
        String inputPath = "laborator8_input.xlsx";

        System.out.println("--- Conținut laborator8_input.xlsx ---");
        citesteExcel(inputPath);

        genereazaMedieCalculata(inputPath, "laborator8_output2.xlsx");

        genereazaMedieFormula(inputPath, "laborator8_output3.xlsx");
    }

    public static void citesteExcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    printCellValue(cell);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void genereazaMedieCalculata(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int lastCol = row.getLastCellNum();
                double sum = 0;
                int count = 0;

                for (int i = lastCol - 1; i >= 0 && i >= lastCol - 3; i--) {
                    Cell cell = row.getCell(i);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        sum += cell.getNumericCellValue();
                        count++;
                    }
                }

                Cell newCell = row.createCell(lastCol);
                if (count > 0) newCell.setCellValue(sum / count);
                else newCell.setCellValue("N/A");
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
                System.out.println("Creat: " + outputPath);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void genereazaMedieFormula(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int rowNum = row.getRowNum() + 1;
                int lastCol = row.getLastCellNum();
                Cell formulaCell = row.createCell(lastCol);

                String formula = String.format("AVERAGE(D%d:F%d)", rowNum, rowNum);
                formulaCell.setCellFormula(formula);
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
                System.out.println("Creat: " + outputPath);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void printCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING: System.out.print(cell.getStringCellValue() + "\t"); break;
            case NUMERIC: System.out.print(cell.getNumericCellValue() + "\t"); break;
            case FORMULA: System.out.print(cell.getCellFormula() + "\t"); break;
            default: System.out.print(" \t");
        }
    }
}