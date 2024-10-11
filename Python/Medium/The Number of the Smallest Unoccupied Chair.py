import heapq
from typing import List


class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        q = []

        for chair in range(len(times)):
            heapq.heappush(q, chair)

        target_friend_arrival = times[targetFriend][0]
        times = sorted(times, key=lambda x: x[0])

        arrival_map = {}
        leave_map = {}
        people_to_chairs = {}

        for i, time in enumerate(times):
            arrival_map[time[0]] = i

            if time[1] not in leave_map:
                leave_map[time[1]] = [i]
            else:
                leave_map[time[1]].append(i)

        step = 0

        while True:

            if step in leave_map:
                people_to_leave = leave_map[step]
                for p in people_to_leave:
                    cleared_chair = people_to_chairs.pop(p)
                    heapq.heappush(q, cleared_chair)

            if step == target_friend_arrival:
                if len(q) != 0:
                    return heapq.heappop(q)
                else:
                    continue

            if step in arrival_map:
                arrived_person = arrival_map[step]
                people_to_chairs[arrived_person] = heapq.heappop(q)

            step += 1
