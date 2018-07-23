package sms.bai.util;

public final class Constant {

    /**
     * 请求转发标示 forward:
     */
    public static final String FORWARD = "forward:";

    /**
     * 请求重定向标示 redirect:
     */
    public static final String REDIRECT = "redirect:";

    /**
     * 请求重定向隐藏标示 _redirect
     */
    public static final String REDIRECT_HIDDEN = "_redirect";

    /**
     * 标识ID
     */
    public static final String ID = "id";

    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "updateTime";

    /**
     * 执行失败(保存，删除，更新均可使用)
     */
    public static final int EXECUTE_FAIL = Integer.valueOf(-1);

    /**
     * 执行成功(保存，或者其它逻辑),删除和更新逻辑不一定返回该值(它们可能返回处理的数量)
     */
    public final static int EXECUTE_SUCCESS = Integer.valueOf(1);

    /**
     * NOTNULL
     */
    public final static String NOTNULL = "NOTNULL";

    /**
     * NULL
     */
    public final static String NULL = "NULL";

    /**
     * 403错误页面
     */
    public static final String ERROR_403 = "403.html";

    /**
     * 404错误页面
     */
    public static final String ERROR_404 = "404.html";

    /**
     * 500错误页面
     */
    public static final String ERROR_500 = "500.html";

    /**
     * 开发模式
     */
    public static boolean DEV_MODE = true;

    /**
     * 字符串格式的true
     */
    public static final String TRUE = "1";

    /**
     * 字符串格式的false
     */
    public static final String FALSE = "0";

    /**
     * 系统异常时的结果码
     */
    public static final String SYSTEM_ERROR = "SYSTEM_ERROR";

    /**
     * 成功时的结果码
     */
    public static final String SUCCESS = "SUCCESS";

    /**
     * 默认字符类型
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 中文字符类型
     */
    public static final String GBK = "GBK";

    public static final String JSESSIONID = "JSESSIONID";

    public static final String LOGIN_USER = "LOGIN_USER";

    /**
     * 消息标识
     */
    public static final String RESULT_CODE = "resultCode";

    /**
     * 消息标识
     */
    public static final String RESULT_MSG = "resultMsg";

    public static final String ERROR_CODE = "errorCode";

    public static final String ERROR_MSG = "errorMsg";

    public static final String SMS_CODE_MOBILE_PREFIX = "SMS_CODE_MOBILE_";

    public static String CASH_FROST = "cash_frost";

    public static String CASH_SUCCESS = "cash_success";

    public static String RECHARGE = "recharge";

    public static String CAPTCHA = "captcha";
}
