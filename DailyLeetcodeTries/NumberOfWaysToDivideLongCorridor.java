package DailyLeetcodeTries;

import java.math.BigInteger;
import java.util.ArrayList;

/*
 Got confused with this line "at most one divider can be installed" lol.
 Also, I got the logic pretty fast, but wasted most of my time in integer overflow issue.
 Using mod after every multiplication solved the overflow problem.
 Everything OG ofc.
 */
public class NumberOfWaysToDivideLongCorridor {
    public static void main(String[] args) {
        String corridor = "SSSSPPPPPSSPSPSSPPPPPPSPSPSSPPPSPSPSPSSPPPSSSSPSSPSPSPSSSSPPSSPSSSSSSPPPSPSSPPSSPSPSPSSPSSSSSSPSSSPSSSPSSPSSPPPSSPSSPPSSSPSSPSPSSSSPSPPSSPSSPPSSPPSPSPPPSPSPPSPPSPSPPPPPPPPSPSSSPPSPSSPSSSSPPSPSPPPPSPPSSPSPSSPSSPSPPPPPPSSPSPPPPSSPSPPPPPSSSSPSSSSSPPSPPPSPSSPPSPSPSSSSPPPSPPSSSPSPPSSSSSSSSPSSSSPSPSSSPSPPPPPSPSPSPPPSSSPSSPSPSSSPPPPSSPSPSSSSPSSSSSPPSPSSSSPSSSSSSPPPSSPPPPPPSPSSSPPSPPSSSPPPSSPPPSPPSSPPSPSSSSSSPPSSSPPSPSPSPPSPSSPPSPSSPSPPSPSPPSSPSSPPSPPSPSPPSPPSSSSPSPPPSSPPSSPPPSPPSSPSPPSPSPSSPSPPSSSPPSSSPSSPSPPSPSPSPSPSPSSPPPSPSSSSSPPSPSSSPSSSPSSSSSSPSPPPPPPPSSPPSPPSPPSPSSSSPSSSPPPPSPSSPSSPSSPPSSSSPPSPSPSPPPSSSPSPSSPPSSSPPSSPSPPPPPSSSPPSSPSPPPSSSPPPPPSPPPPPSPSPSSSPPSPSSPPSPPSSSPSSSPPSSPPSPSSSPSPPSSSSPSPPSSSPSSPSPPPSPPPSPSSPSPPSSSPPSPSSPSPPPPSSSPSSPPSPSPSPSPSSSPSPSPPPPSSSSSSPPPPPPSPPPSPSPPSPSPPSPPPPPSSSPSPPPSPPSPSPPSSSPPSPSSPPPPPSSPPPPPSSPSSPPSPSPSSSPPPSSSSPPPSPPPPSSSPSPPPSPPPSPPSPSSSPPPPPSSSSPPPPSSSSPSPSPSPPSPSPPSPSPSPSSPPPSSPPPPPSSPSPPPPPPSSPSSPSPSSPPSPPSSSPPSPSSSSSSSSSSSPSSPSPSPPPSPSPPPPSPSSSPPPSSPSPSSSSPSPPPSPSPPSPSPPPSPSPPSSSPSPPSSSPPPPPPSPPSSPPPPSPPPPPSPPPPPSPSPSSPPPSPSSSSSPSSSSPPPSSSPPSPPPPPSSPSSSPSPSPSSSPPSSPSPSPPSSPSPSPSPSPPSSSSPPPSSPPPSSSPPSPSPPPPSPSPSPPPSSPSSPSSPPPPSSSPPPPSSSPPPPPPSPSSSPSSPSPSSSSPSPSPSPPSPSSSPPSSSSSPSSPPPPSSSSPPPSPSSPPSPSSPPPPPPPSSPSPPPSSPPPPSSSSSSPSPPPSPPSSSPSPSSSPSSPSSSSSPSSPSPSSPSSPPSSSSPPSPSSPPSSSPSPPSSSPSSPSSSPSPSPPSSPPPPSSPSPSPPSPPPPPSPSSSPPSPPPPSSPPSPSPSSPSPSPSSPPPPPPSSSPPPPSPSPPSSPSPSSSPSSPPPPSPSSSSPPSPPSSSPPSPPPSSPSPSPPPSPSSSSSPPSPSPPPSSPPPSSSPPSSSPPSPSSPPSSSPPSPPPPPPSSSPSSPSSPSPPPSPSPPPSPSSPSSSSSSSSPPPSSSSPPSSSPSSSPSSPPPSSPSPPPPPPPPSSPPSPPPSPPPSSPSSPPPPPSSSSPPSSPPPPSS";
        System.out.println(numOfWaysToDiv(corridor));
    }
    static int numOfWaysToDiv(String corridor) {
        int count = 0, mod = 1_000_000_007;
        ArrayList<Integer> seatIndex = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                count++;
                seatIndex.add(i);
            }
        }
        if (count % 2 != 0 || count == 0) return  0;
        if (count == 2) return 1;
        long ans = 1;
        //The only place you can install a divider is between two pairs of seats.
        for (int i = 1; i < seatIndex.size() - 2; i+= 2) {
            ans *= seatIndex.get(i + 1) - seatIndex.get(i);
            ans %= mod;
        }
        return (int) (ans);
    }
}
/*
  int count = 0, mod = 1_000_000_007;
        ArrayList<Integer> seatIndex = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                count++;
                seatIndex.add(i);
            }
        }
        if (count % 2 != 0 || count == 0) return  0;
        if (count == 2) return 1;
        BigInteger ans = BigInteger.ONE;
        for (int i = 1; i < seatIndex.size() - 2; i+= 2) {
            BigInteger distance = BigInteger.valueOf(seatIndex.get(i + 1) - seatIndex.get(i));
            ans = ans.multiply(distance);
        }
        return ans.mod(BigInteger.valueOf(mod)).intValue();
    }
}
 */