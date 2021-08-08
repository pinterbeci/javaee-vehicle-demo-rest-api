package hu.ulyssys.java.course.maven.service.impl;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.PDFExportService;


import javax.inject.Inject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class PDFExportServiceImpl implements PDFExportService {

    @Inject
    private CarService carService;


    @Override
    public InputStream processExport() {
        Document document = new Document();
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            for (Car car : carService.getAll()) {
                document.add(new Paragraph("Id: " + car.getId() + ", name:" + car.getName()
                        + ", maufacturer: " + car.getManufacturer()  + ", licence plate number: " + car.getLicencePlateNumber()));
            }

            Chunk chunk = new Chunk("Instagram");
            chunk.setAnchor("https://www.instagram.com/pinterbeci/?hl=hu");
            document.add(chunk);
            document.close();
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
