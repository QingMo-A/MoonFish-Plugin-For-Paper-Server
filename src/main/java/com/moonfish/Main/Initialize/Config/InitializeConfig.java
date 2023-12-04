package com.moonfish.Main.Initialize.Config;

import com.moonfish.Config;

import java.io.File;

public class InitializeConfig {
    public static final String WorkingPath = System.getProperty("user.dir");

    public static final String Status = "true";

    public static final String PluginFolderName = "MoonFish";
    public static final String PluginFolderPath = WorkingPath + File.separator + PluginFolderName;

    public static final String SkillFolderName = "Skill_Data";
    public static final String SkillFolderPath = WorkingPath + File.separator + PluginFolderName + "/" + SkillFolderName;

    public static final String SkillDataFileName = "skill_data.ini";
    public static final String SkillDataFilePath = WorkingPath + "/" + PluginFolderName + "/" + SkillFolderName;

    public static final String WelcomeMessageConfigName = "welcome_message.ini";
    public static final String WelcomeMessageConfigPath = WorkingPath + "/" + PluginFolderName;
    public static final String WelcomeMessageConfigText =
            "# %play为玩家名字  &为颜色符号" + "\n\n" +
            "[玩家进入消息]: &b&k|&r&k|&e欢迎%player加入游戏&r&k|&b&k|" + "\n" +
            "[玩家退出消息]: &b&k|&r&k|&e%player退出了游戏&r&k|&b&k|" + "\n" +
            "[启用玩家进出消息]: true" + "\n\n" +
            "[OP进入消息]: &b&k|&r&k|&e欢迎管理员%player加入游戏&r&k|&b&k|" + "\n" +
            "[OP退出消息]: &b&k|&r&k|&e管理员%player退出了游戏&r&k|&b&k|" + "\n" +
            "[启用OP进出消息]: true";

    public static final String RankFolderName = "Rank_Data";
    public static final String RankFolderPath = WorkingPath + File.separator + PluginFolderName + "/" + RankFolderName;

    public static final String RankDataFileName = "rank_data.ini";
    public static final String RankDataFilePath = WorkingPath + "/" + PluginFolderName + "/" + RankFolderName;

    public static final String RankConfigName = "rank.ini";
    public static final String RankConfigPath = WorkingPath + "/" + PluginFolderName;
    public static final String RankConfigText =
            "[Rank等级2进入消息]: &k||&r &l&o&c欢迎&r&l&oIron Fish玩家&e%player&c进入游戏 &r&k||" + "\n" +
            "[Rank等级3进入消息]: &k||&r &l&o&c欢迎&r&l&o&gGold Fish&f玩家&e%player&c进入游戏 &r&k||" + "\n" +
            "[Rank等级4进入消息]: &k||&r &l&o&c欢迎&r&l&o&bDiamond Fish&f玩家&e%player&c进入游戏 &r&k||" + "\n" +
            "[Rank等级5进入消息]: &k||&r &l&o&c欢迎&r&l&o&bDiamond Fish &5Plus&f玩家&e%player&c进入游戏 &r&k||" + "\n" ;

    public static final String PlayerAttributesFolderName = "Player_Attributes_Data";
    public static final String PlayerAttributesFolderPath = WorkingPath + File.separator + PluginFolderName + "/" + PlayerAttributesFolderName;

    public static final String PlayerAttributesDataFileName = "player_attributes_data.ini";
    public static final String PlayerAttributesDataFilePath = WorkingPath + "/" + PluginFolderName + "/" + PlayerAttributesFolderName;

    public static final String RealWorldConfigName = "real_world.ini";
    public static final String RealWorldConfigPath = WorkingPath + "/" + PluginFolderName;
    public static final String RealWorldConfigText =
            "#药水效果用\",\"间隔(英文的)" + "\n" +
            "#从左到右依次是: 效果-时间(tick)-等级(数+1)" + "\n" +
            "#每 20ticks 为一秒" + "\n" +
            "#加速 SPEED\n" +
            "#缓慢 SLOW\n" +
            "#虚弱 WEAKNESS\n" +
            "#急迫 FAST_DIGGING\n" +
            "#挖掘疲劳 SLOW_DIGGING\n" +
            "#瞬间恢复 HEAL\n" +
            "#瞬间伤害 HARM\n" +
            "#跳跃提升 JUMP\n" +
            "#反胃 CONFUSION\n" +
            "#生命恢复 REGENERATION\n" +
            "#力量 DAMAGE_RESISTANCE\n" +
            "#火焰抗性 FIRE_RESISTANCE\n" +
            "#水下呼吸 WATER_BREATHING\n" +
            "#隐身 INVISIBILITY\n" +
            "#失明 BLINDNESS\n" +
            "#夜视 NIGHT_VISION\n" +
            "#饥饿 HUNGER\n" +
            "#中毒 POISON\n" +
            "#饱和 SATURATION\n" +
            "#发光 GLOWING\n" +
            "#漂浮 LEVITATION\n" +
            "#幸运 LUCK\n" +
            "#诅咒 UNLUCK\n" + "\n" +
            "[骨折设置]" + "\n" +
            "骨折触发效果: SLOW-1800-4, BLINDNESS-40-1" + "\n" +
            "# 20ticks 为一秒(尽量与特点药水效果相等,如骨折就是缓慢)" + "\n" +
            "骨折触发间隔: 1800" + "\n" +
            "骨折触发信息: %player从高处一跃而下摔断了自己的腿" + "\n" +
            "启用骨折: true" + "\n\n" +
            "[跌倒设置]" + "\n" +
            "跌倒触发效果: " + "\n" +
            "#触发几率(x分之一)" + "\n" +
            "跌倒触发几率: 1000" + "\n" +
            "跌倒伤害: 1.0" + "\n" +
            "跌倒触发消息: %player在奔跑时不慎摔倒" + "\n" +
            "启用跌倒: true" + "\n\n" +
            "[尸毒设置]" + "\n" +
            "尸毒触发效果: POISON-200-0" + "\n" +
            "# 20ticks 为一秒(尽量与特点药水效果相等,如尸毒就是中毒)" + "\n" +
            "尸毒触发间隔: 200" + "\n" +
            "尸毒触发信息: %player不慎被僵尸抓伤，感染了尸毒" + "\n" +
            "启用尸毒: true" + "\n\n" +
            "[打胶设置]" + "\n" +
            "打胶触发效果: SPEED-1200-0, CONFUSION-100-0, WEAKNESS-1200-0, SLOW_DIGGING-1200-0" + "\n" +
            "# %t 的范围(从1到x)" + "\n" +
            "触发信息中 %t 的范围: 120" + "\n" +
            "打胶触发信息: %e到底有什么魔力,竟让%player用%t秒冲了一发" + "\n" +
            "#打胶失败的信息(有虚弱状态不能打胶)" + "\n" +
            "打胶失败触发信息: 即使你很想来一发,但是你的弟弟不给力" + "\n" +
            "启用打胶: true" + "\n";
}
