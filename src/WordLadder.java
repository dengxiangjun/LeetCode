import java.util.*;

public class WordLadder {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String beginWord = sc.nextLine(), endWord = new StringBuilder(beginWord).reverse().toString();
//        String s = sc.nextLine();
//        List<String> list = Arrays.asList(s.split(" "));
//        int res = ladderLength(beginWord, endWord, list);
//        System.out.println(res);
//    }

        public static void main(String[] args) {
        String beginWord = "hot", endWord = "toh";
        List<String> list = new ArrayList<String>();
        list.add("doh");
        list.add("got");
        list.add("dot");
        list.add("god");
        list.add("tod");
        list.add("dog");
        list.add("lot");
        list.add("log");
        int res = ladderLength(beginWord, endWord, list);
        System.out.println(res);
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);
        set.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            String sb = new StringBuilder(s).reverse().toString();
            int curLevel = map.get(s);
            for (int i = 0; i < s.length(); i++) {
                char[] arr = sb.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String tmp = String.valueOf(arr);
                    if (set.contains(tmp)) {
                        map.put(tmp, curLevel + 1);
                        if (tmp.equals(endWord)) return map.get(tmp);
                        set.remove(tmp);
                        queue.offer(tmp);
                    }
                }
            }
        }
        return 0;
    }
}
//    public static void main(String[] args) {
//        String beginWord = "hot", endWord = "toh";
//        List<String> list = new ArrayList<String>();
//        list.add("doh");
//        list.add("got");
//        list.add("dot");
//        list.add("god");
//        list.add("tod");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        int res = ladderLength(beginWord, endWord, list);
//        System.out.println(res);
//    }
//    /**
//     * hot
//     * doh got dot god tod dog lot log
//     *
//     * @param args
//     */

//    /**
//     * BFS
//     *
//     * @param beginWord
//     * @param endWord
//     * @param wordList
//     * @return
//     */
//    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<String>(wordList);
//        if (!set.contains(endWord)) return 0;
//        Queue<String> queue = new LinkedList<String>();
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put(beginWord, 1);
//        queue.offer(beginWord);
//        while (!queue.isEmpty()) {
//            String s = queue.poll();
//            int curLevel = map.get(s);
//            for (int i = 0; i < s.length(); i++) {
//                char[] arr = s.toCharArray();
//                for (char j = 'a'; j <= 'z'; j++) {
//                    arr[i] = j;
//                    String tmp = String.valueOf(arr);
//                    if (set.contains(tmp)) {
//                        map.put(tmp, curLevel + 1);
//                        if (tmp.equals(endWord)) return map.get(tmp);
//                        set.remove(tmp);
//                        queue.offer(tmp);
//                    }
//                }
//            }
//        }
//        return 0;
//    }




