package com.chs.tool.csv;

import com.csvreader.CsvReader;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/6 19:07
 */
public class CsvParser {

    public static void main(String[] args) {
        List<User> users = readCSVFile("d:/user.csv", User.class);
        users.stream().forEach((x)-> System.out.println(x.getId()+","+x.getName()));
    }


    public static <T> List<T> readCSVFile(String filePath, Class<T> bean){


        Map<String, Field> fieldMap = new HashMap<>();
        Field[] fields = bean.getDeclaredFields();
        for(Field field: fields){
            CSVField anno = field.getAnnotation(CSVField.class);
            if (anno != null && !StringUtils.isEmpty(anno.name())){
                fieldMap.put(anno.name(),field);
            }
        }

        List<T> list = new ArrayList<>();

        List<String[]> dataList = getDataList(filePath);
        String[] titles = dataList.remove(0);

        try {
            for (String[] data: dataList ){
                T t = bean.newInstance();

                for (int i=0; i< data.length; i++){

                    Field field = fieldMap.get(titles[i]);
                    Class<?> valType = field.getType();
                    Object value = getType(data[i], valType);

                    String fieldName = field.getName();
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method method = ReflectionUtils.findMethod(bean, methodName, valType);
                    if (method != null) {
                        ReflectionUtils.invokeMethod(method, t, value);
                    }
                }

                list.add(t);
            }
        }catch (Exception e){

        }
        return list;


    }
    private static List<String[]> getDataList(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        CsvReader reader = null;
        InputStream is = null;
        try {
            String charset = codeString(filePath);
            is = new FileInputStream(filePath);

            // 因为Windows环境下Excel转UTF-8编码的csv会带bom头，导致第一列数据读不到，这里识别utf-8处理下
            if ("UTF-8".equals(charset)) {
                is = getInputStream(is);
            }

            //StandardCharsets.UTF_8
            reader = new CsvReader(is, ',', Charset.forName(charset));
            if (reader != null) {
                while (reader.readRecord()) {
                    dataList.add(reader.getValues());
                }
                if (!dataList.isEmpty()) {
                    return dataList;
                }
            }

        } catch (Exception e) {

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Collections.emptyList();
    }


    /**
     * 获取文件编码
     * @param fileName
     * @return
     * @throws Exception
     */
    private static String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        bin.close();
        String code;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

    /**
     *  因为Windows环境下Excel转UTF-8编码的csv会带bom头，导致第一列数据读不到。被这玩意坑哭了
     *
     *  这里读取流中前面的字符，看是否有bom，如果有bom，将bom头丢弃
     */
    private static InputStream getInputStream(InputStream in) throws IOException {

        PushbackInputStream stream = new PushbackInputStream(in);
        int ch = stream.read();
        if (ch != 0xEF) {
            stream.unread(ch);
        } else if ((ch = stream.read()) != 0xBB) {
            stream.unread(ch);
            stream.unread(0xef);
        } else if ((ch = stream.read()) != 0xBF) {
            throw new IOException("错误的UTF-8格式文件");
        }
        return stream;
    }

    /**
     * 转换成实体属性对应的类型
     *
     * @param value 每一格的数值
     * @param valType 实体属性类型
     * @return Object 转换为对应类型以obj返回
     */
    private static <T> Object getType(String value, Class<T> valType) {
        try {
            if (valType == String.class) {
                return value;
            } else if (valType == Date.class) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
            } else if (valType == Float.class) {
                return Float.parseFloat(value);
            } else if (valType == Double.class) {
                return Double.parseDouble(value);
            } else if (valType == BigDecimal.class) {
                return new BigDecimal(value);
            } else if (valType == Integer.class) {
                return Integer.parseInt(value);
            } else if (valType == Long.class) {
                return Long.parseLong(value);
            } else if (valType == Boolean.class) {
                return Boolean.parseBoolean(value);
            }
        } catch (Exception e) {
            return null;
        }
        return value;
    }

}
