//package com.meiya.springcloudstudy.common.parser.pdf;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.tika.exception.TikaException;
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.pdf.PDFParser;
//import org.apache.tika.sax.BodyContentHandler;
//import org.xml.sax.SAXException;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
///**
// * 使用 apache tika 解析excel
// */
//public class PDFTikaParser {
//
//    /**
//     * 解析pdf 方法
//     * @param path pdf文件路径
//     * @return 返回pdf内容
//     */
//    public static String parse(String path) throws IOException, SAXException,TikaException {
//        BodyContentHandler handler = new BodyContentHandler();
//        Metadata metadata = new Metadata();
//        FileInputStream inputstream = new FileInputStream(new File(path));
//        ParseContext pcontext = new ParseContext();
//        PDFParser pdfparser = new PDFParser();
//        pdfparser.parse(inputstream, handler, metadata,pcontext);
//        String content = handler.toString();
//        String[] split = content.split("\n");
//        int i = 0;
//        for (String row:split) {
//            if(StringUtils.isNotBlank(row)){
//                i++;
//                System.out.println("index = " + i + "   " + row);
//            };
//        }
//        System.out.println(i);
//        return null;
//    }
//
//    public static void main(String[] args) {
//        try {
//            parse("D:\\1.pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (TikaException e) {
//            e.printStackTrace();
//        }
//    }
//}
