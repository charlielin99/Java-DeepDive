public class Codec {
    
    /*
    My first solution produces short URLs like http://tinyurl.com/0, http://tinyurl.com/1, etc, in that order.
    
    Using increasing numbers as codes like that is simple but has some disadvantages, which the below solution fixes:

If I'm asked to encode the same long URL several times, it will get several entries. That wastes codes and memory.
People can find out how many URLs have already been encoded. Not sure I want them to know.
People might try to get special numbers by spamming me with repeated requests shortly before their desired number comes up.
Only using digits means the codes can grow unnecessarily large. Only offers a million codes with length 6 (or smaller). Using six digits or lower or upper case letters would offer (10+26*2)6 = 56,800,235,584 codes with length 6.
The following solution doesn't have these problems. It produces short URLs like http://tinyurl.com/KtLa2U, using a random code of six digits or letters. If a long URL is already known, the existing short URL is used and no new entry is generated.

It's possible that a randomly generated code has already been generated before. In that case, another random code is generated instead. Repeat until we have a code that's not already in use. How long can this take? Well, even if we get up to using half of the code space, which is a whopping 626/2 = 28,400,117,792 entries, then each code has a 50% chance of not having appeared yet. So the expected/average number of attempts is 2, and for example only one in a billion URLs takes more than 30 attempts. And if we ever get to an even larger number of entries and this does become a problem, then we can just use length 7. We'd need to anyway, as we'd be running out of available codes.
    */
    

private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String BASE = "http://tinyurl.com/";

    private static Map<String, String> keyToURL = new HashMap<>();
    private static Map<String, String> urlToKey = new HashMap<>();

    public static void main(String[] args) {
        String tinyURL = encode("http://thisislongurl.com/abcd/123");
        String longURL = decode(tinyURL);

        System.out.println("tinyURL = " + tinyURL);
        System.out.println("longURL = " + longURL);
    }

    public static String encode(String longUrl) {
        if (longUrl == null || longUrl.isEmpty()) {
            return null;
        }
        if (urlToKey.containsKey(longUrl)) {
            return BASE + urlToKey.get(longUrl);
        }

        StringBuilder key = null;

        // keep generating keys until a unique one is found
        do {
            key = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int)(Math.random() * SEED.length());
                key.append(SEED.charAt(r));
            }
        } while (keyToURL.containsKey(key));

        keyToURL.put(key.toString(), longUrl);
        urlToKey.put(longUrl, key.toString());

        return BASE + key;
    }

    public static String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.isEmpty()) {
            return "";
        }
        String[] shortUrlSplits = shortUrl.split("/");
        return keyToURL.get(shortUrlSplits[shortUrlSplits.length - 1]);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));