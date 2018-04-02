package api;


/**
 * Created by sq719 on 2018/3/5.
 *
 */

public class Api {
    /**
     * release模式是否输出日记
     */
    public static boolean RELEASE_DEBUG = false;
    public static final String RELEASE_ROOT_URL = "https://test.hjs360.cn";//演示环境根路径
    public static final String DEBUG_ROOT_URL = "https://test.hjs360.cn";//演示环境根路径
    public static final String TEST_ROOT_URL = "https://test.hjs360.cn";//演示环境根路径
    public static final String APP_SERVICES = "/app/services";
    /**
     * https://api.douban.com/v2 /book/search ?q=西游记&tag=&start=0&count=1
     */
    public static final String APP_TEST = "https://api.douban.com/v2";

    public enum Mode {
        DEBUG, TEST, RELEASE
    }

    /**
     * 测试环境
     **/
    public static final String DES_KEY = "NByFN0dIQv1RyKoa";
    public static final String MD5_KEY = "S74SEPCVm2BFZ10e";

    /**
     * 上传头像路径
     */
    public static final String UPDATE_HEAD_URL = "/common/appImagesUpload";
    public static final String UPDATE_HEAD_URLS = "/leaveword/appLeaveWordImagesUpload";

    /**
     * 版本更新路径
     **/
    public static final String UPGRADE_ROOT_URL = "http://pre-d.eims.com.cn/download/sp2p";
    public static final String UPGRADE_TEST = "/sp2p9-test.apk";
    public static final String UPGRADE_RELEASE = "/sp2p9.apk";
//
//
//    static {
//        SERVICE_MODE = Enum.valueOf(Mode.class,
//                AppUtils.getMetaValue(BaseApplication.getInstance(), "server_mode"));
//        if (RELEASE_DEBUG) L.IS_DEBUG = true;
//        else {
//            L.IS_DEBUG = SERVICE_MODE != Mode.RELEASE; //release模式默认不输出日记
//        }
//    }

    public static Mode SERVICE_MODE = Mode.DEBUG;

    public static String getServicesRootUrl() {
        return getRootUrl() + APP_SERVICES;
    }

    public static String getRootUrl() {
        switch (SERVICE_MODE) {
            case DEBUG:
                return DEBUG_ROOT_URL;
            case TEST:
                return TEST_ROOT_URL;
            case RELEASE:
                return RELEASE_ROOT_URL;
            default:
                break;
        }
        return null;
    }

    //是否为debug模式
    public static boolean isDebugMode() {
        switch (SERVICE_MODE) {
            case DEBUG:
                return true;
            case TEST:
                return false;
            case RELEASE:
                return false;
        }
        return false;
    }
}
