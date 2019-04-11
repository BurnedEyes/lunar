import spock.lang.Shared
import spock.lang.Specification

class HandTest extends Specification {

    @Shared
    def _A = CardFactory.of(Rank._A)
    @Shared
    def _2 = CardFactory.of(Rank._2)
    @Shared
    def _3 = CardFactory.of(Rank._3)
    @Shared
    def _4 = CardFactory.of(Rank._4)
    @Shared
    def _5 = CardFactory.of(Rank._5)
    @Shared
    def _6 = CardFactory.of(Rank._6)
    @Shared
    def _7 = CardFactory.of(Rank._7)
    @Shared
    def _8 = CardFactory.of(Rank._8)
    @Shared
    def _9 = CardFactory.of(Rank._9)
    @Shared
    def _T = CardFactory.of(Rank._T)
    @Shared
    def _J = CardFactory.of(Rank._J)
    @Shared
    def _Q = CardFactory.of(Rank._Q)
    @Shared
    def _K = CardFactory.of(Rank._K)


    def "should check proper if straight"() {
        given:
        def hand = new Hand(cards)

        expect:
        result == hand.isStraight()

        where:
        cards                | result
        [_A, _2, _3, _4, _5] | true
        [_T, _J, _Q, _K, _A] | true
        [_T, _T, _T, _T, _A] | false
        [_T, _6, _7, _9, _8] | true
        [_A, _3, _5, _2, _2] | false
        [_4, _5, _6, _7, _8] | true
        [_2, _6, _K, _Q, _5] | false
    }

    def "should check pair"() {
        given:
        def hand = new Hand(cards)

        expect:
        result == hand.hasPair()

        where:
        cards                | result
        [_2, _2, _3, _4, _5] | true
        [_A, _K, _Q, _J, _T] | false
        [_3, _3, _3, _4, _5] | false
        [_5, _6, _7, _6, _7] | true
    }

    def "should check trips"() {
        given:
        def hand = new Hand(cards)

        expect:
        result == hand.hasTrips()

        where:
        cards                | result
        [_2, _2, _3, _4, _5] | false
        [_A, _K, _Q, _J, _T] | false
        [_3, _3, _3, _4, _5] | true
        [_5, _6, _7, _6, _7] | false
    }

    def "should check 4 of a kind"() {
        given:
        def hand = new Hand(cards)

        expect:
        result == hand.hasFourOfAKind()

        where:
        cards                | result
        [_2, _2, _3, _4, _5] | false
        [_A, _K, _Q, _J, _T] | false
        [_3, _3, _3, _4, _5] | false
        [_5, _6, _7, _6, _7] | false
        [_T, _T, _T, _7, _T] | true
    }

    def "should check full house"() {
        given:
        def hand = new Hand(cards)

        expect:
        result == hand.isFull()

        where:
        cards                | result
        [_2, _2, _3, _4, _5] | false
        [_A, _K, _Q, _J, _T] | false
        [_3, _3, _3, _4, _5] | false
        [_5, _6, _7, _6, _7] | false
        [_T, _T, _T, _7, _T] | false
        [_2, _5, _2, _2, _5] | true
        [_A, _A, _Q, _Q, _Q] | true
    }
}

