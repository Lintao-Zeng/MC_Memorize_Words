package com.example.examplemod;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;

public class PlayerWordState {
    private static final Map<ServerPlayer, Map.Entry<String, String>> playerWordMap = new HashMap<>();
    private static final Map<ServerPlayer, Integer> playerQuantityMap = new HashMap<>();

    public static void setCurrentWord(ServerPlayer player, Map.Entry<String, String> word, int quantity) {
        playerWordMap.put(player, word);
        playerQuantityMap.put(player, quantity); // 存储数量
    }

    public static Map.Entry<String, String> getCurrentWord(ServerPlayer player) {
        return playerWordMap.get(player);
    }

    public static int getQuantity(ServerPlayer player) {
        return playerQuantityMap.getOrDefault(player, 1); // 默认数量为1
    }

    public static void clearCurrentWord(ServerPlayer player) {
        playerWordMap.remove(player);
        playerQuantityMap.remove(player); // 清除数量
    }
}
