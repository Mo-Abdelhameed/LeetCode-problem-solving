from typing import List


class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        total_skill = sum(skill)
        num_teams = len(skill) // 2

        if total_skill % num_teams != 0:
            return -1

        skill = sorted(skill)
        skill_per_team = total_skill / num_teams
        total_score = 0
        for i in range(0, len(skill) // 2):
            j = len(skill) - i - 1

            if skill[i] + skill[j] != skill_per_team:
                return -1

            score = skill[i] * skill[j]

            total_score += score

        return total_score
