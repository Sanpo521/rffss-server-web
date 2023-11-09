package io.renren.common.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ExcelUtil {
    private ExcelUtil(){};
    private static Logger logger= LoggerFactory.getLogger(ExcelUtil.class);
    /**
     * 用户信息导出类
     *  response 响应
     *  fileName 文件名
     *  columnList 每列的标题名
     *  dataList 导出的数据
     */
    public static void uploadExcelAboutUser(HttpServletResponse response,String fileName,List<String> columnList,
                                            List<List<String>> dataList){
        //声明输出流
        OutputStream os = null;
        Workbook wb =null;
                //设置响应头
        setResponseHeader(response,fileName);

        try {
            //获取输出流
            os = response.getOutputStream();
            //内存中保留1000条数据，以免内存溢出，其余写入硬盘
            wb = new HSSFWorkbook();
            //获取该工作区的第一个sheet
            Sheet sheet1 = wb.createSheet("sheet1");
            int excelRow = 0;
            //创建标题行
            Row titleRow = sheet1.createRow(excelRow++);
            for(int i = 0;i<columnList.size();i++){
                //创建该行下的每一列，并写入标题数据
                Cell cell = titleRow.createCell(i);
                cell.setCellValue(columnList.get(i));
            }
            //设置内容行
            if(dataList!=null && !dataList.isEmpty()){
                //序号是从1开始的
                int count = 1;
                //外层for循环创建行
                for(int i = 0;i<dataList.size();i++){
                    Row dataRow = sheet1.createRow(excelRow++);
                    //内层for循环创建每行对应的列，并赋值
                    for(int j = -1;j<dataList.get(0).size();j++){//由于多了一列序号列所以内层循环从-1开始
                        Cell cell = dataRow.createCell(j+1);
                        if(j==-1){//第一列是序号列，不是在数据库中读取的数据，因此手动递增赋值
                            cell.setCellValue(count++);
                        }else{//其余列是数据列，将数据库中读取到的数据依次赋值
                            if(dataList.size()>i && dataList.get(i).size()>j){
                                cell.setCellValue(dataList.get(i).get(j));
                            }
                        }
                    }
                }
            }
            //将整理好的excel数据写入流中
            wb.write(os);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                // 关闭输出流
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            if(wb!=null){
                try {
                    wb.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    /*
        设置浏览器下载响应头
     */
    private static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage());
            }
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }


}
