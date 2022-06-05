package utils;

import java.util.HashMap;

/**
 * @Created by DAIE
 * @Date 2021/3/8 20:26
 * @Description leek面板TABLE工具类
 */
public class WindowUtils {
    //基金表头
    public static final String FUND_TABLE_HEADER_KEY = "fund_table_header_key";
    public static final String FUND_TABLE_HEADER_VALUE = "编码,基金名称,估算净值,估算涨跌,更新时间,当日净值";
    //股票表头
    public static final String STOCK_TABLE_HEADER_KEY = "stock_table_header_key";
    //public static final String STOCK_TABLE_HEADER_VALUE = "编码,股票名称,当前价,涨跌,涨跌幅,最高价,最低价,更新时间,买一,买二,买三,买四,买五,卖一,卖二,卖三,卖四,卖五";
    public static final String STOCK_TABLE_HEADER_VALUE = "编码,股票名称,当前价,涨跌幅,买一,买二,买三,买四,买五,卖一,卖二,卖三,卖四,卖五";

    public static final String STOCK_TABLE_LIST1 = "换手率,最高价,最低价,买一价,买二价,买三价,卖一价,卖二价,卖三价";
    public static final String STOCK_TABLE_LIST2 = "股票名称,当前价,涨跌幅,买一,买二,买三,卖一,卖二,卖三";


    //货币表头
    public static final String COIN_TABLE_HEADER_KEY = "coin_table_header_key";
    public static final String COIN_TABLE_HEADER_VALUE = "编码,名称,当前价,更新时间";

    private static HashMap<String,String> remapPinYinMap = new HashMap<>();

    static {
        remapPinYinMap.put(PinYinUtils.toPinYin("编码"),"编码");
        remapPinYinMap.put(PinYinUtils.toPinYin("基金名称"),"基金名称");
        remapPinYinMap.put(PinYinUtils.toPinYin("估算净值"),"估算净值");
        remapPinYinMap.put(PinYinUtils.toPinYin("估算涨跌"),"估算涨跌");
        remapPinYinMap.put(PinYinUtils.toPinYin("更新时间"),"更新时间");
        remapPinYinMap.put(PinYinUtils.toPinYin("当日净值"),"当日净值");
        remapPinYinMap.put(PinYinUtils.toPinYin("股票名称"),"股票名称");
        remapPinYinMap.put(PinYinUtils.toPinYin("当前价"),"当前价");
        remapPinYinMap.put(PinYinUtils.toPinYin("涨跌"),"涨跌");
        remapPinYinMap.put(PinYinUtils.toPinYin("涨跌幅"),"涨跌幅");
        remapPinYinMap.put(PinYinUtils.toPinYin("最高价"),"最高价");
        remapPinYinMap.put(PinYinUtils.toPinYin("最低价"),"最低价");
        remapPinYinMap.put("b1","买一");
        remapPinYinMap.put("b2","买二");
        remapPinYinMap.put("b3","买三");
        remapPinYinMap.put("b4","买四");
        remapPinYinMap.put("b5","买五");
        remapPinYinMap.put("s1","卖一");
        remapPinYinMap.put("s2","卖一");
        remapPinYinMap.put("s3","卖二");
        remapPinYinMap.put("s4","卖三");
        remapPinYinMap.put("s5","卖四");

        remapPinYinMap.put("bp1","买一价");
        remapPinYinMap.put("bp2","买二价");
        remapPinYinMap.put("bp3","买三价");
        remapPinYinMap.put("bp4","买四价");
        remapPinYinMap.put("bp5","买五价");
        remapPinYinMap.put("sp1","卖一价");
        remapPinYinMap.put("sp2","卖一价");
        remapPinYinMap.put("sp3","卖二价");
        remapPinYinMap.put("sp4","卖三价");
        remapPinYinMap.put("sp5","卖四价");


    }


    /**
     * 通过列名 获取该TABLE的列的数组下标
     *
     * @param columnNames 列名数组
     * @param columnName  要获取的列名
     * @return 返回给出列名的数组下标 匹配失败返回-1
     */
    public static int getColumnIndexByName(String[] columnNames, String columnName) {
        for (int i = 0; i < columnNames.length; i++) {
            if (columnNames[i].equals(columnName)) {
                return i;
            }
        }
        //考虑拼音编码

        return -1;
    }

    public static String remapPinYin(String pinyin){
        return remapPinYinMap.getOrDefault(pinyin,pinyin);
    }


}
