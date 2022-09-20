package string;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/validate-ip-address/
 *
 * @author Albina Gimaletdinova on 07/04/2022
 */
public class ValidateIpAddress {
    private static String ipv4Regex =
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private static String ipv6Regex = "([0-9A-Fa-f]{1,4})";

    public String validIPAddress(String ip) {
        if (isValidIPV4(ip)) {
            return "IPv4";
        }
        if (isValidIPV6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidIPV4(String ip) {
        Pattern ipv4Pattern =
                Pattern.compile("^(" + ipv4Regex + "\\.){3}" + ipv4Regex + "$");
        return ipv4Pattern.matcher(ip).matches();
    }

    private boolean isValidIPV6(String ip) {
        Pattern ipv6Pattern =
                Pattern.compile("^(" + ipv6Regex + "\\:){7}" + ipv6Regex + "$");
        return ipv6Pattern.matcher(ip).matches();
    }
}
