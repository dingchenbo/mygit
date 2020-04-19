package com.example.demo.common.util;

public class DataPool {

    /**
     * 已登录用户
     */
    public static final String SESSION_USER = "currentUser";

    /**
     * 已登录乐高用户
     */
    public static final String SESSION_LEGO_USER = "legoCurrentUser";

    /**
     * 学校用户session存储键
     */
    public static final String SCHOOL_SESSION = "school_session_user";

    /**
     * 当前用户的所属单位
     */
    public static final String SESSION_COMPANY = "currentCompany";

    /**
     * 登录用户权限
     */
    public static final String SESSION_USER_PER = "perList";

    /**
     * 登录的乐高用户权限
     */
    public static final String SESSION_LEGO_USER_PER = "legoPerList";

    /**
     * 已打开菜单ID
     */
    public static final String MENU_ID = "menuId";

    /**
     * 父级菜单名称
     */
    public static final String PERMISSION_FNAME = "permissionFname";

    /**
     * 子级菜单名称
     */
    public static final String PERMISSION_NAME = "permissionName";

    /**
     * 请求超时时间(毫秒)
     */
    public final static long REQUEST_TIME = 40000L;

    /**
     * 字符编码格式 目前支持 utf-8
     */
    public final static String INPUT_CHARSET = "utf-8";

    /**
     * 用户初始密码
     */
    public static final String LOGIN_PASS = MD5.md5("123456", DataPool.INPUT_CHARSET);

    /** 存储智的科目 */
    public static final String[] WISDOM = {"语文","数学","物理","化学","政治","英语","生物","历史","音乐","地理","信息技术"};

    /** 存储体的科目 */
    public static final String[] SPORTS = {"体育"};

    /** 存储美的科目 */
    public static final String[] ART = {"美术"};

    /** 考试成绩查询次数 */
    public static final int NUM = 10;

    /** 数字数组 */
    public static final String[] CHINESE_NUM = {"一","二","三","四","五","六","七","八","九","十","十一","十二","十三","十四","十五","十六","十七","十八","十九","二十"};

    /** 奖励数组 */
    public static final String[] PRIZE_ARRAY = {"见义勇为","拾金不昧","学习优异","好人好事","热心助人","团结同学","成绩进步"};

    /** 惩罚数组 */
    public static final String[] PUNISH_ARRAY= {"早退","成绩退步","打架骂人","不讲卫生","上课睡觉","抽烟","早恋"};

    /** 奖惩查询数量 */
    public static final int REWARDS_NUM = 5;

    /** 未到原因，字可以改，位置不许动 */
    public static final String[] NO_REASON = {"请假","其他"};

    /** 请假的字典取值 */
    public static final String LEAVE_VALUE = "3";

    /** 请假的字典类型 */
    public static final String LEAVE_TYPE = "punishment";


    public static final String ADD_LABEL = "adminPushLabel";
}
