package com.comb.commons.utils.number;

import com.comb.commons.utils.collection.CollectionsTools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public final class NumberUtil {
    private static final DecimalFormat myformat = new DecimalFormat("0.00");
    private static final Random r = new Random();

    public static int randomInt(int i) {
        return r.nextInt(i);
    }

    /**
     * 将字符串转化为字节数组
     *
     * @param str
     * @return
     * @throws RuntimeException
     */
    public static byte[] toBytes(String str) throws RuntimeException {
        if (str.length() > 0 && (str.length() + 1) % 3 == 0) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream((str.length() + 1) / 3);
            int length = str.length() - 1;
            for (int i = 0; i < length; i += 3) {
                char c1 = Character.toUpperCase(str.charAt(i));
                char c2 = Character.toUpperCase(str.charAt(i + 1));
                if (validHexChar(c1) && validHexChar(c2)) {
                    byte b = parseByte4Hex(c2);
                    b = (byte) (b | (parseByte4Hex(c1) << 4));
                    baos.write(b);
                } else {
                    throw new RuntimeException("数据格式不正确!要求为00 01 02的格式");
                }
            }
            byte[] bytes = baos.toByteArray();
            try {
                baos.close();
            } catch (IOException e) {
            }
            return bytes;
        } else {
            throw new RuntimeException("数据长度格式不正确!要求为00 01 02的格式");
        }
    }

    /**
     * 验证是否是合法16进制字符
     *
     * @param c
     * @return
     */
    private static boolean validHexChar(char c) {
        return (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    /**
     * 将字节数组转化为16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 3);
        if (bytes.length > 0) {
            builder.append(toHexString(bytes[0]));
            for (int i = 1; i < bytes.length; i++) {
                builder.append(" ").append(toHexString(bytes[i]));
            }
        }
        return builder.toString();
    }

    /**
     * 将16进制字符转化为数值
     *
     * @param c1
     * @return
     */
    public static byte parseByte4Hex(char c1) {
        byte b = 0;
        if (c1 >= 'A' && c1 <= 'F') {
            b = (byte) (c1 - 'F' + 15);
        } else if (c1 >= '0' && c1 <= '9') {
            b = (byte) (c1 - '0');
        }
        return b;
    }

    /**
     * 将一个字节转化为16进制字符串
     *
     * @param b
     * @return
     */
    public static String toHexString(byte b) {
        char c[] = {'0', '0'};
        byte temp = (byte) (b & 0x0f);
        if (temp > 9) {
            c[1] = (char) ('A' + temp - 10);
        } else {
            c[1] = (char) ('0' + temp);
        }
        temp = (byte) (b >> 4 & 0x0f);
        if (temp > 9) {
            c[0] = (char) ('A' + temp - 10);
        } else {
            c[0] = (char) ('0' + temp);
        }
        return new String(c);
    }

    /**
     * 计算和
     *
     * @param number
     * @return
     */
    public static double sum(Number... number) {
        double result = 0;
        if (number != null) {
            for (Number num : number) {
                if (num != null) {
                    result += num.doubleValue();
                }
            }
        }
        return result;
    }

    /**
     * 计算和
     *
     * @param number
     * @return
     */
    public static double sum(List<? extends Number> number) {
        double result = 0;
        if (number != null) {
            for (Number num : number) {
                if (num != null) {
                    result += num.doubleValue();
                }
            }
        }
        return result;
    }

    /**
     * 如果是null 则返回0
     *
     * @param value
     * @return
     */
    public static boolean isNull(Long value) {
        return value == null;
    }

    /**
     * Description: 如果null 返回0.0
     *
     * @param value
     * @return
     * @Version1.0 2015-9-9 上午9:45:51 by 杨利鹏（lpyang@10101111.com）创建
     */
    public static Double isNull(Double value) {
        return value == null ? 0.0 : value;
    }

    /**
     * 将数字格式化成2位小数
     *
     * @param number
     * @return
     */
    public static String fmt2p(Number number) {
        return myformat.format(number);
    }

    public static boolean anyEquals(Number obj, Number... param) {
        if (CollectionsTools.isNotEmpty(param)) {
            for (Number o : param) {
                if (NumberUtil.isEquals(obj, o)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断数值o1 和数值o2是否相等
     *
     * @param o1
     * @param o2
     * @return
     */
    public static boolean isEquals(Number o1, Number o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        } else if (o1 instanceof Double || o1 instanceof Float || o2 instanceof Double || o2 instanceof Float) {
            return o1.doubleValue() == o2.doubleValue();
        } else {
            return o1.longValue() == o2.longValue();
        }
    }

    public static boolean isNotEquals(Number o1, Number o2) {
        return !isEquals(o1, o2);
    }

    public static Short parseShort(Object o) {
        if (o instanceof Number) {
            return ((Number) o).shortValue();
        } else if (o instanceof String) {
            try {
                return Short.parseShort((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.shortValue();
            }
        }
        return null;
    }

    public static Byte parseByte(Object o) {
        if (o instanceof Number) {
            return ((Number) o).byteValue();
        } else if (o instanceof String) {
            try {
                return Byte.parseByte((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.byteValue();
            }
        }
        return null;
    }


    public static Integer parseInt(Object o) {
        if (o instanceof Number) {
            return ((Number) o).intValue();
        } else if (o instanceof String) {
            try {
                return Integer.parseInt((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.intValue();
            }
        }
        return null;
    }

    public static Long parseLong(Object o) {
        if (o instanceof Number) {
            return ((Number) o).longValue();
        } else if (o instanceof String) {
            try {
                return Long.parseLong((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.longValue();
            }
        }
        return null;
    }

    /**
     * 如果是null 则返回0
     *
     * @param value
     * @return
     */
    public static int isNull0(Integer value) {
        return isNull(value, 0);
    }

    /**
     * 如果是null 则返回newValue
     *
     * @param value
     * @return
     */
    public static int isNull(Integer value, int newValue) {
        return value == null ? newValue : value;
    }

    /**
     * 如果是null
     *
     * @param value
     * @return
     */
    public static boolean isNull(Integer value) {
        return value == null;
    }

    public static Float parseFloat(Object o) {
        if (o instanceof Number) {
            return ((Number) o).floatValue();
        } else if (o instanceof String) {
            try {
                return Float.parseFloat((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.floatValue();
            }
        }
        return null;
    }

    public static Double parseDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        } else if (o instanceof String) {
            try {
                return Double.parseDouble((String) o);
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    /**
     * Description: 四舍五入
     *
     * @param enDouble 被四舍五入值
     * @param rountNum 精确到的位数：如：0,保留整数；1，保留一位小数
     * @return
     * @Version1.0 2015-7-31 下午12:03:05 by 陈永旺（yw.chen02@10101111.com）创建
     */
    public static Double roundDouble(Double enDouble, int rountNum) {
        if (enDouble == null) {
            return null;
        }

        BigDecimal bd = new BigDecimal(enDouble);
        return bd.setScale(rountNum, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 将一个long类型数字转化为字节数组 低字节在前 高字节在后
     *
     * @param value
     * @return
     */
    public static byte[] toBytes(long value) {
        byte[] bytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (value & 0xff);
            value = value >> 8;
        }
        int len;
        for (len = bytes.length - 1; len > 0; len--) {
            if (bytes[len] != 0) {
                break;
            }
        }
        byte[] result = new byte[len + 1];
        System.arraycopy(bytes, 0, result, 0, len + 1);
        return result;
    }

    /**
     * 将字节数组转化为long数组 当bytes是空或者数据大于8字节则返回null 数组 低字节在前
     *
     * @param bytes
     * @return
     */
    public static Long parseFromBytes(byte[] bytes) {
        if (bytes != null && bytes.length > 0 && bytes.length < 9) {
            long value = 0;
            for (int i = bytes.length - 1; i > 0; i--) {
                value += (bytes[i] & 0xff);
                value = value << 8;
            }
            value += (bytes[0] & 0xff);
            return value;
        }
        return null;
    }

    private NumberUtil() {

    }
}