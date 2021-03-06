package com.iandavis.minescape.commands;

import com.iandavis.minescape.capability.skill.CapabilitySkills;
import com.iandavis.minescape.api.capability.ISkillContainer;
import com.iandavis.minescape.api.skills.ISkill;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;

public class CheckXPCommand extends CommandBase {
    @Override
    @Nonnull
    public String getName() {
        return "checkXP";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "checkXP {skill_name}";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) {
        ISkillContainer skillCapability = (sender.getCommandSenderEntity()).getCapability(
                CapabilitySkills.getSkillCapability(), null);
        ISkill skill = skillCapability.getSkill(args[0]);

        if (skill == null) {
            sender.getCommandSenderEntity().sendMessage(new TextComponentString(String.format("No known skill named %s", args[0])));
        } else {
            sender.getCommandSenderEntity().sendMessage(new TextComponentString(String.valueOf(skillCapability.getSkill(args[0]).getXP())));
        }
    }
}
