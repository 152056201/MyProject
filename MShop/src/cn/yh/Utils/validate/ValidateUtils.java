package cn.yh.Utils.validate;

/**
 * 专属验证类
 */

public class ValidateUtils {
    /**
     * 验证输入的数据是否为空
     * @param data
     * @return 如果是空返回true否则返回false
     */
    public static boolean validateEmpty(String data){
        if(data==null||"".equals(data)){
            return false;
        }
        return true;
    }

    /**
     * 正则操作验证
     * @param data 要验证的数据
     * @param regex验证正则表达式
     * @return
     */
    public static boolean validateRegex(String data,String regex){
        if(validateEmpty(data)){
            return data.matches(regex);
        }
        return false;

    }

    /**
     * 验证两个数据是否相同，不区分大小写
     * @param dataa
     * @param datab
     * @return
     */
    public static boolean validateSame(String dataa,String datab){
        if(validateEmpty(dataa)&&validateEmpty(datab)){
                return dataa.equalsIgnoreCase(datab);
        }
        return  false;
    }
}
