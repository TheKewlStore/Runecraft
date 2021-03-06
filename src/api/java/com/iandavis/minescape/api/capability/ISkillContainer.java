package com.iandavis.minescape.api.capability;

import com.iandavis.minescape.api.skills.ISkill;

import java.util.Map;

/**
 * Implement the ability to store skill xp data on minecraft players.
 */
public interface ISkillContainer extends ICommonCapability {
    /**
     * Return all skill instances.
     * @return A map of the skill names to their instances.
     */
    Map<String, ISkill> getAllSkills();

    /**
     * Return all skill experiences.
     * @return A map of the skill names to their xp values.
     */
    Map<String, Integer> getAllSkillXP();

    /**
     * Return the given skill instance.
     * @param name The name of the skill.
     * @return The skill instance.
     */
    ISkill getSkill(String name);

    void setAllSkills(Map<String, ISkill> newSkills);
}
