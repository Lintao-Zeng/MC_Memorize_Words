package com.example.examplemod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.Map;

public class GiveItemCommand {
    private static final WordMeaningLoader wordLoader = new WordMeaningLoader();
    private static Map.Entry<String, String> currentWord = null;
    static String itemName;
    static int index = 1;

    // 初始化加载单词文件
    static {
        wordLoader.loadWordsFromFile("config/words.txt"); // 假设文件位于 config 文件夹中
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("giveitem")
                .then(Commands.argument("item", StringArgumentType.string())
                        .suggests((context, builder) -> {
                            // 获取所有物品，去掉前缀
                            for (Item item : ForgeRegistries.ITEMS) {
                                ResourceLocation key = ForgeRegistries.ITEMS.getKey(item);
                                if (key != null) {
                                    builder.suggest(key.toString().replace("minecraft:", "")); //去除前缀
                                }
                            }
                            return builder.buildFuture();
                        })
                        .then(Commands.argument("quantity", IntegerArgumentType.integer(1))
                                .executes(context -> {
                                    CommandSourceStack source = context.getSource();
                                    ServerPlayer player = source.getPlayerOrException();
                                    itemName = StringArgumentType.getString(context, "item");
                                    int quantity = IntegerArgumentType.getInteger(context, "quantity");

                                    // 获取下一个单词
                                    currentWord = wordLoader.getNextWord();
                                    if (currentWord != null) {
                                        player.sendSystemMessage(Component.literal("请回答这个单词的意思: " + currentWord.getKey()));

                                    // 播放单词声音
                                    Minecraft.getInstance().getSoundManager().play(
                                            SimpleSoundInstance.forLocalAmbience(ExampleMod.getSound(index).get(), 1.0F, 1.0F)
                                    );

                                    // 存储当前单词到状态管理器
                                    PlayerWordState.setCurrentWord(player, currentWord, quantity);
                                    player.sendSystemMessage(Component.literal("输入释义:"));
                                    }
                                    return 1;
                                })
                        )
                )
        );
    }

    // 添加处理聊天输入的事件
    @SubscribeEvent
    public void onServerChat(ServerChatEvent event) {
        ServerPlayer player = event.getPlayer();
        String message = event.getMessage().getString();

        // 获取当前的单词
        Map.Entry<String, String> currentWord = PlayerWordState.getCurrentWord(player);
        if (currentWord != null) {
            // 验证释义
            if (message.equals(currentWord.getValue())) {
                // 获取物品数量
                int quantity = PlayerWordState.getQuantity(player);

                ItemStack itemStack = getItemStack(itemName, quantity); // 获取物品，数量为玩家指定的数量
                if (itemStack != null) {
                    player.addItem(itemStack); // 给玩家物品
                    player.sendSystemMessage(Component.literal("释义正确！已给你 " + quantity + " 个: " + itemName));
                    index++;
                    if(index > 25)//这里的25根据单词数量调整
                        index = 1;
                } else {
                    player.sendSystemMessage(Component.literal("物品不存在: " + itemName));
                }
                // 清除当前单词状态
                PlayerWordState.clearCurrentWord(player);
            } else {
                // player.sendSystemMessage(Component.literal("释义错误，请重新输入！单词：" + currentWord.getValue() + "，释义：" + message));
                player.sendSystemMessage(Component.literal("释义错误，请重新输入！"));
                // 创建并播放声音实例
                Minecraft.getInstance().getSoundManager().play(
                        SimpleSoundInstance.forLocalAmbience(ExampleMod.getSound(index).get(), 1.0F, 1.0F)
                );
            }
            // 取消事件以防止重复消息
            event.setCanceled(true);
        }
    }

    // 动态获取物品，支持 Minecraft 中的所有物品和数量
    private static ItemStack getItemStack(String itemName, int quantity) {
        if (!itemName.contains(":")) {
            itemName = "minecraft:" + itemName;
        }

        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName));

        if (item != null) {
            return new ItemStack(item, quantity);
        } else {
            return null;
        }
    }
}
