package com.interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public static void main(String[] args) {
        WindowString obj = new WindowString();
        String A = "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
        String B = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";

        String result = obj.minWindow(A, B);
        System.out.println(result);
    }

    public String minWindow(String A, String B) {
        HashMap<Character, Integer> maps = new HashMap<>();
        for (Character ch : B.toCharArray()) {
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
        }

        int count = maps.size();
        int minStart = -1;
        int minEnd = -1;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (end < A.length()) {
            char ch = A.charAt(end);
            if (maps.containsKey(ch)) {
                maps.put(ch, maps.get(ch) - 1);
                if (maps.get(ch) == 0)
                    count--;
            }

            while (start < A.length() && count == 0) {
                if (maps.containsKey(A.charAt(start))) {
                    maps.put(A.charAt(start), maps.get(A.charAt(start)) + 1);
                    if (maps.get(A.charAt(start)) == 1)
                        count++;
                }
                int diff = end - start + 1;
                if (diff < minLength) {
                    minLength = diff;
                    minStart = start;
                    minEnd = end + 1;
                }
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? "" : A.substring(minStart, minEnd);
    }

    public String minWindows(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : B.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int idx = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        while (idx < A.length()) {
            if (map.containsKey(A.charAt(idx))) {
                map.put(A.charAt(idx), map.get(A.charAt(idx)) - 1);
                if (map.get(A.charAt(idx)) == 0) {
                    count--;
                }
            }

            while (start < A.length() && count == 0) {
                if (minLen > idx - start + 1) {
                    startIdx = start;
                    endIdx = idx + 1;
                    minLen = idx - start + 1;
                }
                if (map.containsKey(A.charAt(start))) {
                    map.put(A.charAt(start), map.get(A.charAt(start)) + 1);
                    if (map.get(A.charAt(start)) == 1) {
                        count++;
                    } else {
                        System.out.println("Hello");
                    }
                }

                start++;
            }

            idx++;
        }
        return minLen == Integer.MAX_VALUE ? "" : A.substring(startIdx, endIdx);
    }
}
