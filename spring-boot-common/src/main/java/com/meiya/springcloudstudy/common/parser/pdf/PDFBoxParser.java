package com.meiya.springcloudstudy.common.parser.pdf;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class PDFBoxParser {

    private static Logger logger = LoggerFactory.getLogger(PDFBoxParser.class);

    private static final String COLUMN_SEPARATOR = "\t";

    private static final String LINE_SEPARATOR = "\n";

    /**
     * 读PDF文件，使用了pdfbox开源项目
     * @param fileName
     */
    public static void parse(String fileName) {
        File file = new File(fileName);
        // 新建一个PDF解析器对象
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file,"rw"));
            // 对PDF文件进行解析
            parser.parse();
            // 获取解析后得到的PDF文档对象
            PDDocument pdfDocument = parser.getPDDocument();
            // 新建一个PDF文本剥离器
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setWordSeparator(COLUMN_SEPARATOR);
            // 从PDF文档对象中剥离文本
            String result = stripper.getText(pdfDocument);
            logger.info("PDF文件的文本内容如下：");
            logger.info(result);
            logger.info("-------------------------------------------------");
            String[] split = result.split(LINE_SEPARATOR);
            for (String row:split) {
                logger.info(row.split(COLUMN_SEPARATOR).length + "");
            }
        } catch (IOException e) {
            logger.error("读取PDF文件" + file.getAbsolutePath() + "失败失败！", e);
        }

    }

    public static void main(String[] args) {
        parse("D:\\1.pdf");
    }
}
