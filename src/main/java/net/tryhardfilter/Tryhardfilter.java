package net.tryhardfilter;

//for the logger
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//for the saycmd
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class Tryhardfilter implements ModInitializer {
	public static final String MOD_ID = "tryhardfilter";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("^_____^ wassup world");


		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("t")
				.then(ClientCommandManager.argument("message", StringArgumentType.greedyString())
						.executes(context -> {
							String message = StringArgumentType.getString(context, "message");
							String modifiedMessage = message.replaceAll("(?i)ryan", "tryhard");

							MinecraftClient.getInstance().getNetworkHandler().sendChatMessage(modifiedMessage);
							return 1;
						}))));
	}
}
