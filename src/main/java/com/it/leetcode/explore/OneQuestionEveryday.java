package com.it.leetcode.explore;

public class OneQuestionEveryday {
    public static void main(String[] args) {
//        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int i = numEquivDominoPairs(dominoes);
        System.out.println("pairs= "+i);

    }

    /**
     * 1128. 等价多米诺骨牌对的数量
     * @param dominoes
     * @return
     */
    public static int numEquivDominoPairs(int[][] dominoes) {
        int pairs = 0;
        for (int i = 0; i < dominoes.length-1; i++) {
            for (int j = 0; j < dominoes[i].length; j++) {
                if ((dominoes[i][0]==dominoes[i+1][0]&&dominoes[i][1]==dominoes[i+1][1])
                        ||(dominoes[i][0]==dominoes[i+1][1]&&dominoes[i][1]==dominoes[i+1][0])
                ){
                    pairs++;
                }
            }
        }
        return pairs/2;
    }
}
