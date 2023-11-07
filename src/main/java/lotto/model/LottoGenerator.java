package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.Bound;
import lotto.utils.LottoValidator;

public class LottoGenerator {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public List<Lotto> generateLottoTickets(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoTickets.add(lotto);
        }
        return Collections.unmodifiableList(lottoTickets);
    }

    private List<Integer> generateLottoNumbers() {
        int lowerBound = Bound.LOWER_BOUND.getValue();
        int upperBound = Bound.UPPER_BOUND.getValue();
        int maxLottoSize = Bound.MAX_LOTTO_SIZE.getValue();

        List<Integer> lottoNumbers = Randoms
                .pickUniqueNumbersInRange(lowerBound, upperBound, maxLottoSize);
        LottoValidator.validateUniqueness(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }
}
