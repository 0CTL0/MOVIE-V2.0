package cn.ccttll.common;

import java.io.UnsupportedEncodingException;

public class SubCEStrUtil {
    /**
     * 截取中英文混合的字符串, 保留前面的共sum个字符 ,抛弃被截断的汉字
     *
     * Unicode编码,一个汉字占2个字节
     *
     * UTF-8编码,一个汉字占3个字节
     *
     * @param chinese_char_len
     *            一个汉字的长度. 可选值为2和3,2表示:Unicode编码, 3表示:UTF-8编码
     * @param str
     *            字符串
     * @param sum
     *            保留字符串前面的共sum个字符, (第sum个字符被包含)
     *
     * @return 截取后的字符串
     * @throws Exception
     *             chinese_char_len不在2和3这间时抛异常
     */
    public static String splitChineseEnglish(final int chinese_char_len, final String str, final int sum) throws Exception
    {
        final int charset = chinese_char_len; //字符集编码
        if (charset < 2 || 3 < charset)
        {
            throw new Exception("chinese_char_len可选值为2和3,2:Unicode编码,一个汉字占2个字节, 3:UTF-8编码,一个汉字占3个字节");
        }
        int index = sum - 1; //下标比总数少一个
        if (null == str || "".equals(str))
        {
            return str;
        }
        if (index <= 0)
        {
            return str;
        }

        byte[] bt = null;
        try
        {
            if (charset == 2)
            {
                bt = str.getBytes();
            }
            else
            {
                bt = str.getBytes("UTF-8");
            }
        }
        catch (final UnsupportedEncodingException e)
        {
            e.getMessage();
        }
        if (null == bt)
        {
            return str;
        }
        if (index > bt.length - 1)
        {
            index = bt.length - 1; //防越界
        }

        //如果当前字节小于0，说明当前截取位置 有可能 将中文字符截断了
        if (bt[index] < 0)
        {
            int jsq = 0;
            int num = index;
            while (num >= 0)
            {
                if (bt[num] < 0)
                {
                    jsq += 1; //计数
                }
                else
                {
                    break; //循环出口
                }
                num -= 1;
            }

            int m = 0;
            if (charset == 2)
            {
                //Unicode编码
                m = jsq % 2;
                index -= m;
                //这里是重点,去掉半个汉字(有可能是半个), m为0表示无一半汉字,
                final String substrx = new String(bt, 0, index + 1); //当前被截断的中文字符整个不取
                return substrx;
            }
            else
            {
                // utf-8 编码
                m = jsq % 3;
                index -= m;
                //这里是重点,去掉半个汉字(有可能是半个), m为0表示无一半汉字,
                String substrx = null;
                try
                {
                    substrx = new String(bt, 0, index + 1, "UTF-8");
                }
                catch (final UnsupportedEncodingException e)
                {
                    e.getMessage();
                } //当前被截断的中文字符整个不取
                return substrx;
            }
        }
        else
        {
            String substrx = null;
            if (charset == 2)
            {
                //Unicode编码
                substrx = new String(bt, 0, index + 1);
                return substrx;
            }
            else
            {
                // utf-8 编码
                try
                {
                    substrx = new String(bt, 0, index + 1, "UTF-8");
                }
                catch (final UnsupportedEncodingException e)
                {
                    e.getMessage();
                }
                return substrx;
            }
        }
    }
}
