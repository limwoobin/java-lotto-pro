package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public final class WinningsStatistics {

    private static final int LOTTO_PRICE = 1_000;

    private final EnumMap<Rank, Integer> result;

    private WinningsStatistics(final EnumMap<Rank, Integer> result) {
        this.result = result;
    }

    public static WinningsStatistics statistics(final Lotto winningLotto, final Lottos lottos)  {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        putMatchCountByRank(result, winningLotto, lottos);

        return new WinningsStatistics(result);
    }

    private static void putMatchCountByRank(final EnumMap<Rank, Integer> result, final Lotto winningLotto, final Lottos lottos) {
        List<Integer> matchingCounts = lottos.getMatchingCounts(winningLotto);
        for(int matchingCount : matchingCounts) {
            Rank findedRank = Rank.findRank(matchingCount);
            result.put(findedRank, result.getOrDefault(findedRank, 0) + 1);
        }
    }

    public double calculatePrizeMoney() {
        int totalPrize = 0;
        int lottoCount = 0;

        for (Rank rank : result.keySet()) {
            totalPrize += rank.totalWinningMoney(result.get(rank));
            lottoCount += result.get(rank);
        }

        return (double) totalPrize / (lottoCount * LOTTO_PRICE);
    }

    public int getRankHitsCount(final Rank rank) {
        return result.get(rank);
    }

}