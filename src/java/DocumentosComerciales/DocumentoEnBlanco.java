/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DocumentosComerciales;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

/**
 *
 * @author Usuario
 */
@Named(value = "documentoEnBlanco")
@SessionScoped
public class DocumentoEnBlanco implements Serializable {

    /**
     * Creates a new instance of DocumentoEnBlanco
     */
    public DocumentoEnBlanco() {
    }
    
       public void crearDocumento() {

 

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Carta1");
        sheet.getPrintSetup().setLandscape(false); //false -> vertical, true -> horizontal
        sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LETTER_PAPERSIZE);

        //Margenes
        double leftMarginInches = sheet.getMargin(Sheet.LeftMargin);
        sheet.setMargin(Sheet.LeftMargin, 1.2 /* inches */);
        sheet.setMargin(Sheet.RightMargin, .5 /* inches */);
        sheet.setMargin(Sheet.TopMargin, .4 /* inches */);

        //Estilo título uno
        Font fontTituloUno = workbook.createFont();
        fontTituloUno.setFontName(HSSFFont.FONT_ARIAL);
        fontTituloUno.setFontHeightInPoints((short) 14);

        CellStyle tituloUno = workbook.createCellStyle();
        tituloUno.setFont(fontTituloUno);
        tituloUno.setVerticalAlignment(VerticalAlignment.CENTER);
        tituloUno.setAlignment(HorizontalAlignment.CENTER);

        //Estilo título Dos
        Font fontTituloDos = workbook.createFont();
        fontTituloDos.setFontName(HSSFFont.FONT_ARIAL);
        fontTituloDos.setFontHeightInPoints((short) 9);

        CellStyle tituloDos = workbook.createCellStyle();
        tituloDos.setFont(fontTituloDos);
        tituloDos.setVerticalAlignment(VerticalAlignment.CENTER);
        tituloDos.setAlignment(HorizontalAlignment.CENTER);

        //Estilo  basico
        Font fontUno = workbook.createFont();
        fontUno.setFontName(HSSFFont.FONT_ARIAL);
        fontUno.setFontHeightInPoints((short) 12);

        CellStyle basico = workbook.createCellStyle();
        basico.setFont(fontUno);
        basico.setAlignment(HorizontalAlignment.LEFT);

        //Estilo  parrafo
        Font fontDos = workbook.createFont();
        fontDos.setFontName(HSSFFont.FONT_ARIAL);
        fontDos.setFontHeightInPoints((short) 12);

        CellStyle parrafo = workbook.createCellStyle();
        parrafo.setFont(fontDos);
        basico.setAlignment(HorizontalAlignment.JUSTIFY);

        //Estilo  Tres
        Font fontTres = workbook.createFont();
        fontTres.setFontName(HSSFFont.FONT_ARIAL);
        fontTres.setFontHeightInPoints((short) 9);

        CellStyle estiloTres = workbook.createCellStyle();
        estiloTres.setFont(fontTres);
        estiloTres.setVerticalAlignment(VerticalAlignment.JUSTIFY);

        Row Fila0 = sheet.createRow(0);
        setMerge(sheet, 0, 0, 0, 8, false);
        Fila0.createCell(0).setCellValue("");
        Fila0.getCell(0).setCellStyle(tituloUno);

        // Fila 1
        Row Fila1 = sheet.createRow(1);
        // setMerge(sheet, 1, 1, 0, 8, false);
        Fila1.createCell(0).setCellValue("");
        Fila1.getCell(0).setCellStyle(basico);

        // Fila 2
        Row Fila2 = sheet.createRow(2);
        // setMerge(sheet, 2, 2, 0, 8, false);
        Fila2.createCell(0).setCellValue("");
        Fila2.getCell(0).setCellStyle(basico);

        // Fila 3
        Row Fila3 = sheet.createRow(3);
        // setMerge(sheet, 3, 3, 0, 8, false);
        Fila3.createCell(0).setCellValue("");
        Fila3.getCell(0).setCellStyle(basico);

        // Fila 4
        Row Fila4 = sheet.createRow(4);
        // setMerge(sheet, 4, 4, 0, 8, false);
        Fila4.createCell(0).setCellValue("");
        Fila4.getCell(0).setCellStyle(basico);

        // Fila 5
        Row Fila5 = sheet.createRow(5);
        // setMerge(sheet, 5, 5, 0, 8, false);
        Fila5.createCell(0).setCellValue("");
        Fila5.getCell(0).setCellStyle(basico);

        // Fila 6
        Row Fila6 = sheet.createRow(6);
        // setMerge(sheet, 6, 6, 0, 8, false);
        Fila6.createCell(0).setCellValue("");
        Fila6.getCell(0).setCellStyle(basico);

        // Fila 7
        Row Fila7 = sheet.createRow(7);
        // setMerge(sheet, 7, 7, 0, 8, false);
        Fila7.createCell(0).setCellValue("");
        Fila7.getCell(0).setCellStyle(basico);

        // Fila 8
        Row Fila8 = sheet.createRow(8);
        // setMerge(sheet, 8, 8, 0, 8, false);
        Fila8.createCell(0).setCellValue("");
        Fila8.getCell(0).setCellStyle(basico);

        // Fila 9
        Row Fila9 = sheet.createRow(9);
        // setMerge(sheet, 9, 9, 0, 8, false);
        Fila9.createCell(0).setCellValue("");
        Fila9.getCell(0).setCellStyle(basico);

        // Fila 10
        Row Fila10 = sheet.createRow(10);
        // setMerge(sheet, 10, 10, 0, 8, false);
        Fila10.createCell(0).setCellValue("");
        Fila10.getCell(0).setCellStyle(basico);

        // Fila 11
        Row Fila11 = sheet.createRow(11);
        // setMerge(sheet, 11, 11, 0, 8, false);
        Fila11.createCell(0).setCellValue("");
        Fila11.getCell(0).setCellStyle(basico);

        // Fila 12
        Row Fila12 = sheet.createRow(12);
        // setMerge(sheet, 12, 12, 0, 8, false);
        Fila12.createCell(0).setCellValue("");
        Fila12.getCell(0).setCellStyle(basico);

        // Fila 13
        Row Fila13 = sheet.createRow(13);
        // setMerge(sheet, 13, 13, 0, 8, false);
        Fila13.createCell(0).setCellValue("");
        Fila13.getCell(0).setCellStyle(basico);

        // Fila 14
        Row Fila14 = sheet.createRow(14);
        // setMerge(sheet, 14, 14, 0, 8, false);
        Fila14.createCell(0).setCellValue("");
        Fila14.getCell(0).setCellStyle(basico);

        // Fila 15
        Row Fila15 = sheet.createRow(15);
        // setMerge(sheet, 15, 15, 0, 8, false);
        Fila15.createCell(0).setCellValue("");
        Fila15.getCell(0).setCellStyle(basico);

        // Fila 16
        Row Fila16 = sheet.createRow(16);
        // setMerge(sheet, 16, 16, 0, 8, false);
        Fila16.createCell(0).setCellValue("");
        Fila16.getCell(0).setCellStyle(basico);

        // Fila 17
        Row Fila17 = sheet.createRow(17);
        // setMerge(sheet, 17, 17, 0, 8, false);
        Fila17.createCell(0).setCellValue("");
        Fila17.getCell(0).setCellStyle(basico);

        // Fila 18
        Row Fila18 = sheet.createRow(18);
        // setMerge(sheet, 18, 18, 0, 8, false);
        Fila18.createCell(0).setCellValue("");
        Fila18.getCell(0).setCellStyle(basico);

        // Fila 19
        Row Fila19 = sheet.createRow(19);
        // setMerge(sheet, 19, 19, 0, 8, false);
        Fila19.createCell(0).setCellValue("");
        Fila19.getCell(0).setCellStyle(basico);

        // Fila 20
        Row Fila20 = sheet.createRow(20);
        // setMerge(sheet, 20, 20, 0, 8, false);
        Fila20.createCell(0).setCellValue("");
        Fila20.getCell(0).setCellStyle(basico);

        // Fila 21
        Row Fila21 = sheet.createRow(21);
        // setMerge(sheet, 21, 21, 0, 8, false);
        Fila21.createCell(0).setCellValue("");
        Fila21.getCell(0).setCellStyle(basico);

        // Fila 22
        Row Fila22 = sheet.createRow(22);
        // setMerge(sheet, 22, 22, 0, 8, false);
        Fila22.createCell(0).setCellValue("");
        Fila22.getCell(0).setCellStyle(basico);

        // Fila 23
        Row Fila23 = sheet.createRow(23);
        // setMerge(sheet, 23, 23, 0, 8, false);
        Fila23.createCell(0).setCellValue("");
        Fila23.getCell(0).setCellStyle(basico);

        // Fila 24
        Row Fila24 = sheet.createRow(24);
        // setMerge(sheet, 24, 24, 0, 8, false);
        Fila24.createCell(0).setCellValue("");
        Fila24.getCell(0).setCellStyle(basico);

        // Fila 25
        Row Fila25 = sheet.createRow(25);
        // setMerge(sheet, 25, 25, 0, 8, false);
        Fila25.createCell(0).setCellValue("");
        Fila25.getCell(0).setCellStyle(basico);

        // Fila 26
        Row Fila26 = sheet.createRow(26);
        // setMerge(sheet, 26, 26, 0, 8, false);
        Fila26.createCell(0).setCellValue("");
        Fila26.getCell(0).setCellStyle(basico);

        // Fila 27
        Row Fila27 = sheet.createRow(27);
        // setMerge(sheet, 27, 27, 0, 8, false);
        Fila27.createCell(0).setCellValue("");
        Fila27.getCell(0).setCellStyle(basico);

        // Fila 28
        Row Fila28 = sheet.createRow(28);
        // setMerge(sheet, 28, 28, 0, 8, false);
        Fila28.createCell(0).setCellValue("");
        Fila28.getCell(0).setCellStyle(basico);

        // Fila 29
        Row Fila29 = sheet.createRow(29);
        // setMerge(sheet, 29, 29, 0, 8, false);
        Fila29.createCell(0).setCellValue("");
        Fila29.getCell(0).setCellStyle(basico);

        // Fila 30
        Row Fila30 = sheet.createRow(30);
        // setMerge(sheet, 30, 30, 0, 8, false);
        Fila30.createCell(0).setCellValue("");
        Fila30.getCell(0).setCellStyle(basico);

        // Fila 31
        Row Fila31 = sheet.createRow(31);
        // setMerge(sheet, 31, 31, 0, 8, false);
        Fila31.createCell(0).setCellValue("");
        Fila31.getCell(0).setCellStyle(basico);

        // Fila 32
        Row Fila32 = sheet.createRow(32);
        // setMerge(sheet, 32, 32, 0, 8, false);
        Fila32.createCell(0).setCellValue("");
        Fila32.getCell(0).setCellStyle(basico);

        // Fila 33
        Row Fila33 = sheet.createRow(33);
        // setMerge(sheet, 33, 33, 0, 8, false);
        Fila33.createCell(0).setCellValue("");
        Fila33.getCell(0).setCellStyle(basico);

        // Fila 34
        Row Fila34 = sheet.createRow(34);
        // setMerge(sheet, 34, 34, 0, 8, false);
        Fila34.createCell(0).setCellValue("");
        Fila34.getCell(0).setCellStyle(basico);

        // Fila 35
        Row Fila35 = sheet.createRow(35);
        // setMerge(sheet, 35, 35, 0, 8, false);
        Fila35.createCell(0).setCellValue("");
        Fila35.getCell(0).setCellStyle(basico);

        // Fila 36
        Row Fila36 = sheet.createRow(36);
        // setMerge(sheet, 36, 36, 0, 8, false);
        Fila36.createCell(0).setCellValue("");
        Fila36.getCell(0).setCellStyle(basico);

        // Fila 37
        Row Fila37 = sheet.createRow(37);
        // setMerge(sheet, 37, 37, 0, 8, false);
        Fila37.createCell(0).setCellValue("");
        Fila37.getCell(0).setCellStyle(basico);

        // Fila 38
        Row Fila38 = sheet.createRow(38);
        // setMerge(sheet, 38, 38, 0, 8, false);
        Fila38.createCell(0).setCellValue("");
        Fila38.getCell(0).setCellStyle(basico);

        // Fila 39
        Row Fila39 = sheet.createRow(39);
        // setMerge(sheet, 39, 39, 0, 8, false);
        Fila39.createCell(0).setCellValue("");
        Fila39.getCell(0).setCellStyle(basico);

        // Fila 40
        Row Fila40 = sheet.createRow(40);
        // setMerge(sheet, 40, 40, 0, 8, false);
        Fila40.createCell(0).setCellValue("");
        Fila40.getCell(0).setCellStyle(basico);

        // Fila 41
        Row Fila41 = sheet.createRow(41);
        // setMerge(sheet, 41, 41, 0, 8, false);
        Fila41.createCell(0).setCellValue("");
        Fila41.getCell(0).setCellStyle(basico);

        // Fila 42
        Row Fila42 = sheet.createRow(42);
        // setMerge(sheet, 42, 42, 0, 8, false);
        Fila42.createCell(0).setCellValue("");
        Fila42.getCell(0).setCellStyle(basico);

        // Fila 43
        Row Fila43 = sheet.createRow(43);
        // setMerge(sheet, 43, 43, 0, 8, false);
        Fila43.createCell(0).setCellValue("");
        Fila43.getCell(0).setCellStyle(basico);

        // Fila 44
        Row Fila44 = sheet.createRow(44);
        // setMerge(sheet, 44, 44, 0, 8, false);
        Fila44.createCell(0).setCellValue("");
        Fila44.getCell(0).setCellStyle(basico);

        // Fila 45
        Row Fila45 = sheet.createRow(45);
        // setMerge(sheet, 45, 45, 0, 8, false);
        Fila45.createCell(0).setCellValue("");
        Fila45.getCell(0).setCellStyle(basico);

        // Fila 46
        Row Fila46 = sheet.createRow(46);
        // setMerge(sheet, 46, 46, 0, 8, false);
        Fila46.createCell(0).setCellValue("");
        Fila46.getCell(0).setCellStyle(basico);

        try {
            // save excel
            String nombreArchivo = convertirFechaHoraString();
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Usuario\\Downloads\\" + nombreArchivo + ".xls"));
            workbook.write(out);
            out.close();
        } catch (IOException ex) {
        }
    }

    public String convertirFechaString() {
        String fecha = "";
        Format dia = new SimpleDateFormat("dd");
        Format mes = new SimpleDateFormat("MMMM");
        Format anio = new SimpleDateFormat("yyyy");
        fecha = dia.format(new Date()) + " de " + mes.format(new Date()) + " de " + anio.format(new Date());
        return fecha;
    }

    public String convertirFechaHoraString() {
        String fecha = "";
        Format dia = new SimpleDateFormat("dd");
        Format mes = new SimpleDateFormat("MM");
        Format anio = new SimpleDateFormat("yyyy");
        Format hora = new SimpleDateFormat("HH");
        Format minutos = new SimpleDateFormat("mm");
        Format segundos = new SimpleDateFormat("ss");

        fecha = dia.format(new Date()) + mes.format(new Date()) + anio.format(new Date()) + hora.format(new Date()) + minutos.format(new Date()) + segundos.format(new Date());

        return fecha;
    }
    
      public void setMerge(Sheet sheet, int numRow, int untilRow, int numCol, int untilCol, boolean border) {
        CellRangeAddress cellMerge = new CellRangeAddress(numRow, untilRow, numCol, untilCol);
        sheet.addMergedRegion(cellMerge);
        if (border) {
            setBordersToMergedCells(sheet, cellMerge);
        }
    }

    public void setBordersToMergedCells(Sheet sheet, CellRangeAddress rangeAddress) {
        RegionUtil.setBorderTop(BorderStyle.MEDIUM, rangeAddress, sheet);
        RegionUtil.setBorderLeft(BorderStyle.MEDIUM, rangeAddress, sheet);
        RegionUtil.setBorderRight(BorderStyle.MEDIUM, rangeAddress, sheet);
        RegionUtil.setBorderBottom(BorderStyle.MEDIUM, rangeAddress, sheet);
    }
    
}
