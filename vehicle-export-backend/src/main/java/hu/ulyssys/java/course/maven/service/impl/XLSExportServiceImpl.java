package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.XLSExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class XLSExportServiceImpl implements XLSExportService {

    @Inject
    private CarService carService;

    @Override
    public void processExport() {

        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet slugSheet = wb.createSheet("Car");

        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setCharSet(FontCharset.ARABIC.getValue());
        font.setBold(true);
        style.setFont(font);

        Row headerRow = slugSheet.createRow(0);
        Cell id = headerRow.createCell(0);
        id.setCellValue("ID");
        id.setCellStyle(style);

        Cell name = headerRow.createCell(1);
        name.setCellValue("Név");
        name.setCellStyle(style);

        Cell doorNumbers = headerRow.createCell(2);
        doorNumbers.setCellValue("Ajtók száma");
        doorNumbers.setCellStyle(style);

        Cell type = headerRow.createCell(3);
        type.setCellValue("Jármű típusa");
        type.setCellStyle(style);

        Cell lpn = headerRow.createCell(4);
        lpn.setCellValue("Rendszám");
        lpn.setCellStyle(style);

        int i = 1;
        for (Car car : carService.getAll()) {
            Row row = slugSheet.createRow(i);
            row.createCell(0).setCellValue(car.getId());
            row.createCell(1).setCellValue(car.getName());
            row.createCell(2).setCellValue(car.getDoorNumbers());
            row.createCell(3).setCellValue(car.getType().toString());
            row.createCell(4).setCellValue(car.getLicencePlateNumber());
            i++;
        }

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
