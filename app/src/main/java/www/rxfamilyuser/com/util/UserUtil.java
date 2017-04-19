package www.rxfamilyuser.com.util;

import com.blankj.utilcode.utils.SPUtils;

/**
 * 用户信息sp工具类
 */
public class UserUtil {
    public static String getUserName() {
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        return spUtils.getString("user_name");
    }

    public static String getUserPhone() {
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        return spUtils.getString("user_phone");
    }

    public static String getUserPassWord() {
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        return spUtils.getString("user_password");
    }

    public static String getUserId() {
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        return spUtils.getString("user_id");
    }

    public static String getUserPhoto() {
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        return spUtils.getString("user_photo");
    }
}
