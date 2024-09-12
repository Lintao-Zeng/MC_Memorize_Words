package com.example.examplemod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mojang.text2speech.Narrator.LOGGER;

@Mod("examplemod")  // 替换为你的模组ID
public class ExampleMod {

    // 创建声音事件的注册器
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "examplemod");

    // 注册声音事件，确保使用唯一的声音名称
    public static final RegistryObject<SoundEvent> one_sound = SOUND_EVENTS.register("1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "1")));

    public static final RegistryObject<SoundEvent> two_sound = SOUND_EVENTS.register("2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "2")));

    public static final RegistryObject<SoundEvent> three_sound = SOUND_EVENTS.register("3",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "3")));

    public static final RegistryObject<SoundEvent> four_sound = SOUND_EVENTS.register("4",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "4")));

    public static final RegistryObject<SoundEvent> five_sound = SOUND_EVENTS.register("5",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "5")));

    public static final RegistryObject<SoundEvent> six_sound = SOUND_EVENTS.register("6",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "6")));

    public static final RegistryObject<SoundEvent> seven_sound = SOUND_EVENTS.register("7",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "7")));

    public static final RegistryObject<SoundEvent> eight_sound = SOUND_EVENTS.register("8",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "8")));

    public static final RegistryObject<SoundEvent> nine_sound = SOUND_EVENTS.register("9",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "9")));

    public static final RegistryObject<SoundEvent> ten_sound = SOUND_EVENTS.register("10",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "10")));

    public static final RegistryObject<SoundEvent> eleven_sound = SOUND_EVENTS.register("11",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "11")));

    public static final RegistryObject<SoundEvent> twelve_sound = SOUND_EVENTS.register("12",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "12")));

    public static final RegistryObject<SoundEvent> thirteen_sound = SOUND_EVENTS.register("13",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "13")));

    public static final RegistryObject<SoundEvent> fourteen_sound = SOUND_EVENTS.register("14",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "14")));

    public static final RegistryObject<SoundEvent> fifteen_sound = SOUND_EVENTS.register("15",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "15")));

    public static final RegistryObject<SoundEvent> sixteen_sound = SOUND_EVENTS.register("16",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "16")));

    public static final RegistryObject<SoundEvent> seventeen_sound = SOUND_EVENTS.register("17",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "17")));

    public static final RegistryObject<SoundEvent> eighteen_sound = SOUND_EVENTS.register("18",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "18")));

    public static final RegistryObject<SoundEvent> nineteen_sound = SOUND_EVENTS.register("19",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "19")));

    public static final RegistryObject<SoundEvent> twenty_sound = SOUND_EVENTS.register("20",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "20")));

    public static final RegistryObject<SoundEvent> twenty_one_sound = SOUND_EVENTS.register("21",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "21")));

    public static final RegistryObject<SoundEvent> twenty_two_sound = SOUND_EVENTS.register("22",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "22")));

    public static final RegistryObject<SoundEvent> twenty_three_sound = SOUND_EVENTS.register("23",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "23")));

    public static final RegistryObject<SoundEvent> twenty_four_sound = SOUND_EVENTS.register("24",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "24")));

    public static final RegistryObject<SoundEvent> twenty_five_sound = SOUND_EVENTS.register("25",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("examplemod", "25")));

    public ExampleMod() {
        // 确保事件总线注册
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new GiveItemCommand()); // 注册命令和事件
        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());// 注册声音事件到事件总线
    }

    public static RegistryObject<SoundEvent> getSound(int index) {
        return switch (index) {
            case 1 -> one_sound;
            case 2 -> two_sound;
            case 3 -> three_sound;
            case 4 -> four_sound;
            case 5 -> five_sound;
            case 6 -> six_sound;
            case 7 -> seven_sound;
            case 8 -> eight_sound;
            case 9 -> nine_sound;
            case 10 -> ten_sound;
            case 11 -> eleven_sound;
            case 12 -> twelve_sound;
            case 13 -> thirteen_sound;
            case 14 -> fourteen_sound;
            case 15 -> fifteen_sound;
            case 16 -> sixteen_sound;
            case 17 -> seventeen_sound;
            case 18 -> eighteen_sound;
            case 19 -> nineteen_sound;
            case 20 -> twenty_sound;
            case 21 -> twenty_one_sound;
            case 22 -> twenty_two_sound;
            case 23 -> twenty_three_sound;
            case 24 -> twenty_four_sound;
            case 25 -> twenty_five_sound;
            default -> {
                LOGGER.info("没有匹配值");
                yield one_sound;//没有匹配值时默认为one_sound
            }
        };
    }

    // 订阅 RegisterCommandsEvent 事件，注册命令
    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        GiveItemCommand.register(event.getDispatcher());
    }

}
