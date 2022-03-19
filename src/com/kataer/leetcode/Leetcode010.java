package com.kataer.leetcode;

/**
 * @ClassName Leetcode010
 * @Description: https://leetcode-cn.com/problems/find-the-difference/
 * @Author kataer
 * @Date 2020/12/18 21:41
 * @Version V1.0
 **/
public class Leetcode010 {
    public static void main(String[] args) {
        String a = "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor";
        String b = "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj";
        System.out.println(findTheDifference3(a, b));
    }

    //自己想的排序
    public static char findTheDifference(String s, String t) {
        char[] charsa = s.toCharArray();
        char[] charsb = t.toCharArray();
        quick_sort(charsa, 0, charsa.length - 1);
        quick_sort(charsb, 0, charsb.length - 1);
        System.out.println(new String(charsa));
        System.out.println(new String(charsb));
        for (int i = 0; i < charsa.length; i++) {
            if (charsa[i] != charsb[i]) {
                return charsb[i];
            }
        }
        return charsb[charsb.length - 1];

    }

    //计数(通用解法，不论添加多个都没问题)
    public static char findTheDifference2(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 97]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] < 0) {
                return (char) (97 + i);
            }
        }
        return 0;
    }

    //异或运算(两个字符串整合，添加的char为奇数，其余为偶数)
    public static char findTheDifference3(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
           res ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return (char) res;
    }


    public static void quick_sort(char[] chars, int begin, int end) {
        if (begin < end) {
            int i = begin, j = end;
            char temp = chars[i];
            while (i < j) {
                while (i < j && chars[j] >= temp) {
                    j--;
                }
                if (i < j) {
                    chars[i++] = chars[j];
                }

                while (i < j && chars[i] <= temp) {
                    i++;
                }

                if (i < j) {
                    chars[j--] = chars[i];
                }
            }
            chars[i] = temp;
            quick_sort(chars, begin, i - 1);
            quick_sort(chars, i + 1, end);
        }
    }


}
