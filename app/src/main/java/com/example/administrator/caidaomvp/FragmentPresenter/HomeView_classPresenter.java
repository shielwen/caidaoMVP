package com.example.administrator.caidaomvp.FragmentPresenter;

import com.example.administrator.caidaomvp.FragmentView.HomeView_class;
import com.example.administrator.caidaomvp.Model.NameModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/15 0015.
 */

public class HomeView_classPresenter {
    String[] name0 = new String[]{"川菜", "湘菜", "粤菜", "鲁菜", "东北菜", "西北菜", "浙菜", "苏菜", "上海菜", "京菜", "闽菜", "徽菜", "晋菜", "淮扬菜", "清真客家菜", "新疆菜", "贵州菜", "豫菜", "云南菜", "鄂菜", "赣菜", "台湾美食", "香港美食",
            "煎", "炒", "炸红烧", "煮", "蒸", "烧烤", "焖炖", "拌", "烙", "腌", "焗", "卤", "榨汁", "烤烩", "煲", "免烤", "干煸", "熏", "酱", "砂锅", "干锅", "煨", "焯", "涮",
            "酸", "甜", "辣", "咸", "香", "苦", "鲜", "咖喱", "麻辣", "孜然", "清淡", "酸", "辣", "香辣", "酸甜", "香酥", "奶香", "鱼香", "蒜香", "五香", "变态辣", "椒盐", "怪味", "甜辣爽口", "微辣", "酱香", "糟香", "葱香", "原味", "蚝香", "剁椒", "超辣", "中辣", "芝士味", "抹茶味", "泡椒", "烧烤味", "咸鲜", "蜜汁", "蒜蓉", "姜汁味", "黑椒茄汁味", "红油味", "糖醋香草味", "番茄味果味", "芥末味", "麻酱味", "豆瓣味", "家常味",
            "下饭菜", "甜品", "肉类", "主食", "私家菜", "凉菜", "烘焙", "豆制品", "煲汤", "酒", "海鲜水产禽类", "蛋类", "冰品", "饮品", "创意菜", "下酒菜", "冰激凌", "小吃", "零食", "酱汁佐料", "果酱", "火锅", "麻辣烫",
            "炒饭", "煲仔饭", "盖浇饭", "焗饭", "烩饭", "焖饭", "粥寿司饼", "炒饼", "意大利面", "披萨面条", "炒面", "焖面", "凉面", "拌面", "包子", "馒头", "饺子", "馄饨", "便当", "油条", "花卷", "锅贴", "窝头", "盒子", "发糕", "三明治", "汉堡", "馕锅盔", "玉米饼", "卷饼", "河粉", "米粉", "米线", "肉夹馍",
            "奇", "吐司", "海绵蛋糕", "慕斯蛋糕", "奶油蛋糕", "磅蛋糕", "小蛋糕", "翻糖蛋糕", "欧式蛋糕派挞", "蛋挞", "马卡龙中式", "糕点", "月饼",
            "炸锅", "原汁机", "塔吉锅", "乐葵料理盒", "蒸箱", "电压力锅",
            "早餐", "午餐", "下午茶", "晚餐", "宵夜", "单身", "二人世界", "朋友", "聚餐", "户外", "野炊", "生日聚会", "一家三口",
            "婴儿 6- 8个月", "婴儿 8-10个月", "婴儿 10-12个月", "幼儿", "学龄", "前儿童", "青少年", "孕妇", "产妇", "月子餐", "更年期", "老年", "懒人", "经期", "素食主义", "高考考生", "重体力", "应酬", "人群", "白领", "教师", "司机",
            "减肥", "美白", "食谱", "排毒养颜", "紧致肌肤", "丰胸", "祛痘", "祛斑", "延缓", "衰老健康",
            "补硒", "补钙", "补锌", "补铁", "补碘", "对抗雾霾", "防辐射", "润肠通便", "明目", "润肺", "止咳", "痛经", "祛湿", "保肝补血", "抗癌", "滋阴壮阳", "调节内分泌", "补肾", "秋冬进补", "驱寒暖身", "消暑解渴", "清热去火", "养发", "消食", "健脾养胃", "增进食欲", "提高免疫", "减压", "养心", "催乳回奶", "增重", "增肌", "增强记忆力",
            "降血压", "降血脂", "降血糖", "骨质疏松", "便秘腹泻", "贫血", "失", "眠口腔溃疡", "感冒", "发烧", "脂肪肝痛", "风皮炎", "夜盲症", "干眼症",
            "年夜饭", "腊八元宵节", "清明", "端午节", "七夕", "中秋节", "立秋", "情人节", "圣诞节", "感恩节", "万圣节"};
    private HomeView_class homeView_class;
    private List<NameModel> list;
    private List<NameModel> list2;

    public HomeView_classPresenter(HomeView_class homeView_class) {
        this.homeView_class = homeView_class;
        list = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    //初始化全局
    public void initData() {
        for (int i = 0; i < name0.length; i++) {
            NameModel nameModel = new NameModel();
            nameModel.setName(name0[i]);
            list.add(nameModel);
        }
        homeView_class.initData(list);
    }

    //初始化完成输入框
    public void initDataEdittext() {
        String[] aa = new String[0];
        homeView_class.initDataEdittext(aa);
    }

    //动态刷新
    public void refreshEdittext(String s) {
        list2.clear();
        if (s == null || s.equals("")) {
            homeView_class.initData(list);
        } else {

            for (int i = 0; i < name0.length; i++) {
                if (name0[i].indexOf(s) != -1) {
                    NameModel nameModel = new NameModel(name0[i]);
                    list2.add(nameModel);
                } else {

                }
            }
            if (list2.size() != 0) {
                homeView_class.initData(list2);
            } else {
                NameModel nameModel = new NameModel("暂时无此分类");
                list2.add(nameModel);
                homeView_class.initData(list2);
            }
        }

    }


}
