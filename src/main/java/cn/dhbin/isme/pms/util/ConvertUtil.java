package cn.dhbin.isme.pms.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertUtil {

  public static byte toByte(boolean b) {
    return (byte) (b ? 1 : 0);
  }

}
