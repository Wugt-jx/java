package com.wgt.string;

/**
 * @author wgt
 * 实现String类型常用的方法
 */
public interface SString {

    /**
     * 获取字符串长度
     * @return
     */
    int length();

    /**
     * 获取字符串指定索引位置的char值
     * @param i
     * @return
     */
    char charAt(int i);

    /**
     * 将当前字符串与传入字符串进行拼接
     * @param str
     * @return
     */
    SString concat(SString str);

    /**
     * 截取指定区间的子字符串
     * @param begin
     * @param end
     * @return
     */
    SString subString(int begin,int end);

    /**
     * 设置指定索引位置的char值
     * @param i
     * @param chart
     */
    void setCharAt(int i,char chart);

    /**
     * 在指定位置插入子字符串
     * @param i
     * @param str
     * @return
     */
    SString insert(int i,SString str);

    /**
     * 删除指定区间的子字符串
     * @param begin
     * @param end
     * @return
     */
    SString delete(int begin,int end);

    /**
     * 返回模版字符串在主字符串中首次匹配的位置
     * @param pattern
     * @return
     */
    int IndexOf(SString pattern);
}
